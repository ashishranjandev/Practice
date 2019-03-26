package org.home.prac.design.strategy;

import java.util.Date;

public class CreditCard {

	private Long number;
	private Date expirationDate;
	private Integer cvv;
	ValidationStrategy validationStrategy;
	
	public CreditCard(ValidationStrategy validationStrategy) {
		this.validationStrategy = validationStrategy;
	}
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Integer getCvv() {
		return cvv;
	}
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	
	public boolean isValid() {
		return validationStrategy.isValid(this);
	}
}
