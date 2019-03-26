package org.home.prac.design.strategy;

public class VisaStrategy extends ValidationStrategy {

	static Long FIFETEENTHTH_PLACE = 1000000000000000L;
	
	@Override
	public boolean isValid(CreditCard creditCard) {
		return creditCard.getNumber() / FIFETEENTHTH_PLACE == 4;
	}

}
