package org.egov.inv.persistence.entity;

import java.math.BigDecimal;

import io.swagger.model.AuditDetails;
import io.swagger.model.CommonEnum;
import io.swagger.model.MaterialReceiptHeader;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
 @Getter
 @Setter
 
public class ReceiptNoteApiEntity {

	public static final String TABLE_NAME = "materialReceiptHeader";
	public static final String SEQUENCE_NAME = "seq_materialReceiptHeader";
	public static final String ALIAS = "materialReceiptHeader";

	private String id = null;

	private String mrnNumber = null;

	private Long receiptDate = null;

	private String receiptType = null;

	private String receivingStore = null;

	private String supplierCode = null;

	private String supplierBillNo = null;

	private Long supplierBillDate = null;

	private Boolean challanNo = false;

	private Long challanDate = null;

	private String description = null;

	private String receivedBy = null;

	private String designation = null;

	private String mrnStatus = null;

	private String inspectedBy = null;

	private Long inspectionDate = null;

	private String inspectionRemarks = null;

	private Long totalReceiptValue = null;

	private String fileStoreId = null;

	private String createdBy = null;

	private Long createdTime = null;

	private String lastmodifiedBy = null;

	private Long lastmodifiedTime = null;

	private String tenantId;

	public Object toEntity(MaterialReceiptHeader materialReceiptHeader) {
		this.id = materialReceiptHeader.getId();
		this.mrnNumber = materialReceiptHeader.getMrnNumber();
		this.mrnStatus = materialReceiptHeader.getMrnStatus().name();
		this.receiptDate = materialReceiptHeader.getReceiptDate();
		this.receivingStore = materialReceiptHeader.getReceivingStore();
		this.supplierCode = materialReceiptHeader.getSupplierCode();
		this.receiptType = materialReceiptHeader.getReceiptType().name();
		this.supplierBillNo = materialReceiptHeader.getSupplierBillNo();
		this.supplierBillDate = materialReceiptHeader.getSupplierBillDate();
		this.challanNo = materialReceiptHeader.isChallanNo();
		this.challanDate = materialReceiptHeader.getChallanDate();
		this.description = materialReceiptHeader.getDescription();
		this.receivedBy = materialReceiptHeader.getReceivedBy();
		this.designation = materialReceiptHeader.getDesignation();
		this.inspectedBy = materialReceiptHeader.getInspectedBy();
		this.inspectionDate = materialReceiptHeader.getInspectionDate();
		this.inspectionRemarks = materialReceiptHeader.getInspectionRemarks();
		this.totalReceiptValue = materialReceiptHeader.getTotalReceiptValue().longValue();
		this.fileStoreId = materialReceiptHeader.getFileStoreId();
		this.createdBy = materialReceiptHeader.getAuditDetails().getCreatedBy();
		this.createdTime = materialReceiptHeader.getAuditDetails().getCreatedTime();
		this.lastmodifiedBy = materialReceiptHeader.getAuditDetails().getLastModifiedBy();
		this.lastmodifiedTime = materialReceiptHeader.getAuditDetails().getLastModifiedTime();
		this.tenantId = materialReceiptHeader.getAuditDetails().getTenantId();

		return this;
	}

	public MaterialReceiptHeader toDomain() {
		MaterialReceiptHeader materialReceiptHeader = new MaterialReceiptHeader();
		materialReceiptHeader.setId(id);
		materialReceiptHeader.setMrnNumber(mrnNumber);
		materialReceiptHeader.setTenantId(tenantId);
		
		CommonEnum mrnType = new CommonEnum();
		mrnType.setName(mrnStatus);
		
		materialReceiptHeader.setReceiptDate(receiptDate);
		materialReceiptHeader.setReceivingStore(receivingStore);
		materialReceiptHeader.setSupplierCode(supplierCode);
		
		CommonEnum receiptTypes = new CommonEnum();
		receiptTypes.setName(receiptType);
		
		materialReceiptHeader.setSupplierBillNo(supplierBillNo);
		materialReceiptHeader.setSupplierBillDate(supplierBillDate);
		materialReceiptHeader.setChallanNo(challanNo);
		materialReceiptHeader.setChallanDate(challanDate);
		materialReceiptHeader.setDescription(description);
		materialReceiptHeader.setReceivedBy(receivedBy);
		materialReceiptHeader.setDesignation(designation);
		materialReceiptHeader.setInspectedBy(inspectedBy);
		materialReceiptHeader.setInspectionDate(inspectionDate);
		materialReceiptHeader.setInspectionRemarks(inspectionRemarks);
		if(materialReceiptHeader.getTotalReceiptValue() != null)
		{		
		materialReceiptHeader.setTotalReceiptValue(BigDecimal.valueOf(totalReceiptValue));
		}
		materialReceiptHeader.setFileStoreId(fileStoreId);
		AuditDetails auditDetails = new AuditDetails();
		auditDetails.setCreatedBy(createdBy);
		auditDetails.setCreatedTime(createdTime);
		auditDetails.setLastModifiedBy(lastmodifiedBy);
		auditDetails.setLastModifiedTime(lastmodifiedTime);
		materialReceiptHeader.setAuditDetails(auditDetails);
		return materialReceiptHeader;

	}

}
