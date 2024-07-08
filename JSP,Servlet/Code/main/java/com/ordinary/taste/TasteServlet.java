package com.ordinary.taste;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TasteServlet
 */
@WebServlet("/TasteServlet")
public class TasteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TasteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String pet = request.getParameter("pet");
		String[] foods = request.getParameterValues("foods");
		
			
		Map<String, String> colorMap = new HashMap<String, String>();
		colorMap.put("red", "빨강");
		colorMap.put("blue", "파랑");
		colorMap.put("yellow", "노랑");
		colorMap.put("green", "초록");
		
		
		
		
		Map<String, String> petMap = new HashMap<String, String>();
		petMap.put("dog", "강아지");
		petMap.put("cat", "고양이");
		petMap.put("panda", "팬더");
		petMap.put("tiger", "호랑이");
		
		Map<String, String> foodMap = new HashMap<String, String>();
		foodMap.put("짜장면", "김짜장");
		foodMap.put("짬뽕", "김짬뽕");
		foodMap.put("탕수육", "김탕수");
		foodMap.put("팔보채", "김보채");
		foodMap.put("마파두부", "김마파");
		
		
		
		int i = 1;
		String foodStr = "";
		for(String f : foods) {
			if(i == foods.length) {
				foodStr += foodMap.get(f);
			}else {
				foodStr += foodMap.get(f) + ", ";
			}
			i++;
		}
		
		// request를 이용해 jsp로 정보 전달
		request.setAttribute("userName", name);
		request.setAttribute("color", colorMap.get(color));
		request.setAttribute("colorStyle", color);
		request.setAttribute("pet", petMap.get(pet));
		request.setAttribute("foodStr", foodStr);
		request.getRequestDispatcher("/taste/tasteResult.jsp").forward(request, response);
		
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println
//		("<html>"
//				+ "<head></head>"
//				+ "<title></title>"
//				+ "<body>"
//				+ "<h1>결과보기</h1>"
//				+ "<h2>좋아하는 이름 : "+name +"</h2>");
		
//		System.out.println(foods.length);
//		out.print("<h2>좋아하는 색 : " +<span style="color:color">colorMap.get(color)</span> +"</h2>"
//				+ "<h2>좋아하는 동물 : "+petMap.get(pet) +"</h2>"
//				+ "<h2>좋아하는 음식들 : " + foodStr	+"</h2>"
//				+ "</body></html>"
//				);
	
	}

	

}
