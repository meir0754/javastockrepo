package com.sawdayee.service;

import com.sawdayee.model.Portfolio;
import com.sawdayee.Stock;

public class PortfolioManager {

	@SuppressWarnings("deprecation")
	public Portfolio getPortfolio() {
		
		Portfolio portfolio = new Portfolio();
		portfolio.setTitle("Meir's Portfolio"); 
		Stock s1, s2, s3;
		
		s1 = new Stock("PIH", 13.1f, 12.4f, new java.util.Date(2014,11,15));
		portfolio.addStock(s1);
		
		s2 = new Stock("AAL", 5.78f, 5.5f, new java.util.Date(2014,11,15));
		portfolio.addStock(s2);
		
		s3 = new Stock("CAAS", 32.2f, 31.5f, new java.util.Date(2014,11,15));
		portfolio.addStock(s3);
	
		return portfolio;
	}
}
