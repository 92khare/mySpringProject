package com.websystique.springmvc.domain;

import java.io.Serializable;
import java.util.Arrays;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


//@XmlRootElement(name = "player")
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	String name;

	@NotNull
	@Min(0L)
	@Max(999999999L)
	Long text;

	@NotEmpty
	@Pattern(regexp = "SWITCH|AWLS")
	private String deal;
	
	@Valid
	@NotNull
	private DealObjects[] dealObj;

	public Message() {
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setText(Long text) {
		this.text = text;
	}

	public DealObjects[] getDealObj() {
		return dealObj;
	}

	public void setDealObj(DealObjects[] dealObj) {
		this.dealObj = dealObj;
	}

	public Message(String name, Long text) {
		this.name = name;
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [name=" + name + ", text=" + text + ", deal=" + deal 
				+ ", getDealObj()=" + Arrays.toString(getDealObj()) +  "]";
	}

	public String getName() {
		return name;
	}

	public Long getText() {
		return text;
	}

	public String getDeal() {
		return deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}

}
