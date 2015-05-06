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
		Portfolio portfolio2 = new Portfolio (portfolio);
		portfolio2.setTitle("Portfolio #2");
		resp.getWriter().println(portfolio.getHtmlString() + "</br>");
		resp.getWriter().println(portfolio2.getHtmlString() + "</br>");
		portfolio.removeStock("PIH");
		resp.getWriter().println(portfolio.getHtmlString() + "</br>");
		resp.getWriter().println(portfolio2.getHtmlString() + "</br>");
		portfolio2.getStocks()[portfolio2.getPortfolioSize()- 1].setBid(55.55f);
		resp.getWriter().println(portfolio.getHtmlString() + "</br>");
		resp.getWriter().println(portfolio2.getHtmlString() + "</br>");
	}
}