package org.home.prac.design.strategy;

public class AmexStrategy extends ValidationStrategy {

	static Long FOURTEENTH_PLACE = 100000000000000L;
	
	@Override
	public boolean isValid(CreditCard creditCard) {
		return (creditCard.getNumber() / FOURTEENTH_PLACE == 34) ||
				(creditCard.getNumber() / FOURTEENTH_PLACE == 37);
	}


}
