package com.websystique.springmvc.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DealObjects {

	@NotEmpty
	@Size(min=3, max=5)
	private String dealName;
	
	
	@Override
	public String toString() {
		return "DealObjects [dealName=" + dealName.toString() + ", refNo=" + refNo.toString() + "]";
	}


	@NotNull
	@Min(0L)
	@Max(999999999L)
	private Long refNo;


	public String getDealName() {
		return dealName;
	}


	public void setDealName(String dealName) {
		this.dealName = dealName;
	}


	public Long getRefNo() {
		return refNo;
	}


	public void setRefNo(Long refNo) {
		this.refNo = refNo;
	}
}
