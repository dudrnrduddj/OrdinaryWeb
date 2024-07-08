package com.ordinary.calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String operator = request.getParameter("operator");
		
		int result = 0;
		switch (operator) {
		case "+":
			result = Integer.parseInt(num1) + Integer.parseInt(num2);
			break;
		case "-":
			result = Integer.parseInt(num1) - Integer.parseInt(num2);
			break;
		case "*":
			result = Integer.parseInt(num1) * Integer.parseInt(num2);
			break;
		case "/":
			result = Integer.parseInt(num1) / Integer.parseInt(num2);
			break;
		case "%":
			result = Integer.parseInt(num1) % Integer.parseInt(num2);
			break;
		default:
			break;
		}
		
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		request.setAttribute("operator", operator);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/calculator/resultCalc.jsp").forward(request, response);
		
		
		
		
	}


}
