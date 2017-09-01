package org.egov.marriagefee.model;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
public class ApprovalDetails {
	@NotNull
	private Long department;

	@NotNull
	private Long designation;

	@NotNull
	private Long assignee;

	private String action;

	private String status;

	@NotNull
	private String comments;
}