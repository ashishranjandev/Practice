package org.home.prac.design.strategy;

public class StrategyDemo {

	public static void main(String[] args) {
		CreditCard amexCard = new CreditCard(new AmexStrategy());
		amexCard.setNumber(348380958473898L);
		
		System.out.println("Is Amex Valid :"+amexCard.isValid());
		
		CreditCard visaCard = new CreditCard(new VisaStrategy());
		visaCard.setNumber(548380958473898L);
		
		System.out.println("Is Visa Valid :"+visaCard.isValid());
	}
}
