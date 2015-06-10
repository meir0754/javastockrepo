package com.sawdayee.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class BalanceException extends PortfolioException {
	
	public BalanceException (float amount) {
		super("The balance cant be negative, The amount " + amount + " is too big");
	}
}
