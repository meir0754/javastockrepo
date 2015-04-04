package com.sawdayee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletNumber2 extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		//calc01
		float radius = 50;
		double resultCalc1 = Math.PI * Math.pow(radius, 2);
		//calc02
		float hypotenuse = 50;
		float angle_B = 30;
		double opposite = Math.sin(Math.toRadians(angle_B)) * hypotenuse;
		//calc03
		int base = 20;
		int exp = 13; 
		long resultCalc2 = (long) Math.pow(base, exp);
		
		String line1 = new String("calculation 1: Area of circle with radius "+radius+" is "+resultCalc1+" square-cm");
		String line2 = new String("calculation 2: Length of opposite where angle B is "+angle_B+" degrees and Hypotenuse length is "+hypotenuse+" cm is: "+opposite+" cm");
		String line3 = new String("calculation 3: Power of "+base+" with exp of "+exp+" is "+resultCalc2);
		String resultStr = line1 + "<br>" + line2 + "<br>" + line3; 
		resp.getWriter().println(resultStr);
	}
}
