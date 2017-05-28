package org.egov.asset.service;

import java.util.ArrayList;
import java.util.List;

import org.egov.asset.config.ApplicationProperties;
import org.egov.asset.contract.RevaluationRequest;
import org.egov.asset.contract.RevaluationResponse;
import org.egov.asset.model.Revaluation;
import org.egov.asset.producers.AssetProducer;
import org.egov.asset.repository.RevaluationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RevaluationService {
	
	@Autowired
	private RevaluationRepository revaluationRepository;
	
	@Autowired
	private AssetProducer assetProducer;
	
	@Autowired
	private ApplicationProperties applicationProperties;
	
	private static final Logger logger = LoggerFactory.getLogger(RevaluationService.class);
	
	public RevaluationResponse createAsync(RevaluationRequest revaluationRequest) {
		
		logger.info("RevaluationService createAsync revaluationRequest:"+revaluationRequest);
		Revaluation revaluation= revaluationRequest.getRevaluation();
		revaluation.setId(Long.valueOf(revaluationRepository.getNextRevaluationId().longValue()));
		revaluationRequest.setRevaluation(revaluation);
		
		ObjectMapper objectMapper = new ObjectMapper(); 
		String json = null;
		
		try {
			json = objectMapper.writeValueAsString(revaluationRequest);
		} catch (JsonProcessingException ex) {
			logger.info("RevaluationService createAsync catch block:"+ex.getMessage());
		}
		
		//Send data to kafka for persist into db
		try{
			if(json!=null)
			assetProducer.sendMessage(applicationProperties.getCreateAssetRevaluationTopicName(),"save-revaluation", json);
		} catch (Exception ex){
			logger.info("RevaluationService send kafka createAsync:"+ex.getMessage());
		}
		
		List<Revaluation> revaluations = new ArrayList<Revaluation>();
		revaluations.add(revaluation);
		return getRevaluationResponse(revaluations);
	}
	
	public void create(RevaluationRequest revaluationRequest) {
		revaluationRepository.create(revaluationRequest);
	}
	
	private RevaluationResponse getRevaluationResponse(List<Revaluation> revaluations) {
		RevaluationResponse revaluationResponse = new RevaluationResponse();
		revaluationResponse.setRevaluations(revaluations);
		return revaluationResponse;
	}
	

}