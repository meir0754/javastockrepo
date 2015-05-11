package com.sawdayee.service;

import java.util.Calendar;
import java.util.Date;

import com.sawdayee.model.Portfolio;
import com.sawdayee.model.Stock;
import com.sawdayee.model.Portfolio.ALGO_RECOMMENDATION;


/**
 * Portfolio controller. responsible to create and update the portfolio details
 * @author      Meirs
 * @version     1.0                
 * @since       05-05-2015         
 */
public class PortfolioManager {

	/**
	* Create and returns a new portfolio with 3 stocks
	* @return new Portfolio instance with stocks
	*/
	public Portfolio getPortfolio() {
		
		Portfolio portfolio = new Portfolio ("Exercise 7 portfolio");
		Stock s1, s2, s3;
		
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2014, 11, 15);
		Date date1 = cal1.getTime();
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2014, 11, 15);
		Date date2 = cal2.getTime();
		
		Calendar cal3 = Calendar.getInstance();
		cal3.set(2014, 11, 15);
		Date date3 = cal3.getTime();
		
		s1 = new Stock("PIH", 10.0f, 8.5f, date1, ALGO_RECOMMENDATION.BUY, 20);
		s2 = new Stock("AAL", 30.0f, 25.5f, date2,  ALGO_RECOMMENDATION.BUY, 30);
		s3 = new Stock("CAAS", 20.0f, 15.5f, date3,  ALGO_RECOMMENDATION.BUY, 40);
		
		portfolio.addStock(s1);
		portfolio.addStock(s2);
		portfolio.addStock(s3);
		
		portfolio.updateBalance(10000f);
	
		portfolio.buyStock(s1, 20);		
		portfolio.buyStock(s2, 30);		
		portfolio.buyStock(s3, 40);
		
		portfolio.sellStock("AAL", -1);
		portfolio.removeStock("CAAS");
		
		return portfolio;
	}
}


