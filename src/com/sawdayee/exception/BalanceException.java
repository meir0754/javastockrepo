package com.sawdayee.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
/**
 * Elert when there is not enough balance in the portfolio
 * @author      Meirs
 * @version     1.0                
 * @since       11-06-2015         
 */
public class BalanceException extends PortfolioException {
	
	public BalanceException (float amount) {
		super("The balance cant be negative, The amount " + amount + " is too big");
	}
}
