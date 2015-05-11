package com.sawdayee.stock.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sawdayee.model.Portfolio;
import com.sawdayee.service.PortfolioManager;

@SuppressWarnings("serial")

/**
 * Portfolio display. Responsible for the portfolio view and HTML
 * @author      Meirs
 * @version     1.0                
 * @since       05-05-2015         
 */
public class PortfolioServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");

		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio portfolio = portfolioManager.getPortfolio();
		resp.getWriter().println(portfolio.getHtmlString() + "</br>");
	}
}