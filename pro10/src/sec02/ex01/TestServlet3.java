package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet2
 */
//@WebServlet("/*")
/* @WebServlet("*.do") */
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		
		String context= request.getContextPath();
		String url= request.getRequestURL().toString();
		String mapping= request.getServletPath();
		String uri= request.getRequestURI();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Test Servlet</title>");
		out.print("</head>");
		out.print("<body bgcolor ='red'>");
		out.print("<b>TestServlet3입니다</b><br>");
		out.println("<b>컨텍스트 명: "+ context + "</b><br>");
		out.println("<b>전체 경로 : "+ url +"<b><br>");
		out.println("<b>매핑명: "+mapping+"<b><br>");
		out.println("<b>URI : " + uri + "<b>");	
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
