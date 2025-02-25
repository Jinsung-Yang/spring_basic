package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemServlet
 */
@WebServlet("/member2")
public class MemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out= response.getWriter();
		MemberDAO dao= new MemberDAO();
		List<MemberVO>list= dao.listMembers();
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor ='lightgreen'>");
		   out.print("<td>id</td><td>password</td><td>name</td><td>e-mail</td><td>join date</td></tr>");
		
		for(int i=0; i<list.size(); i++) {
			MemberVO memberVO=(MemberVO)list.get(i);
			String id= memberVO.getId();
			String pwd= memberVO.getPwd();
			String name= memberVO.getName();
			String email= memberVO.getEmail();
			Date joinDate= memberVO.getJoinDate();
			
			out.print("<tr><td>"+id+"</td><td>"+
								pwd+"</td><td>"+
								name+"</td><td>"+
								email+"</td><td>"+
								joinDate+"</td></tr>");
		}
		out.print("</table></body></html>");
	
	}

}
