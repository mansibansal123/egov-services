package org.egov.egf.master.persistence.entity;

import org.egov.egf.master.domain.model.AccountEntity;
import org.egov.egf.master.domain.model.AccountEntitySearch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AccountEntitySearchEntity extends AccountEntityEntity {
	private Integer pageSize;
	private Integer offset;

	@Override
	public AccountEntity toDomain() {
		AccountEntity accountEntity = new AccountEntity();
		super.toDomain(accountEntity);
		return accountEntity;
	}

	public AccountEntitySearchEntity toEntity(AccountEntitySearch accountEntitySearch) {
		super.toEntity((AccountEntity) accountEntitySearch);
		this.pageSize = accountEntitySearch.getPageSize();
		this.offset = accountEntitySearch.getOffset();
		return this;
	}

}