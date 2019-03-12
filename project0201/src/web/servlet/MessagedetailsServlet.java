package web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.EmpService;

/**
 * Servlet implementation class MessagedetailsServlet
 */
@WebServlet("/files/messagedetails.do")
public class MessagedetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer sendid=Integer.valueOf(request.getParameter("sendid"));
		Integer receiveid=Integer.valueOf(request.getParameter("receiveid"));
		EmpService service=new EmpService();
		Map<String,Object> map=service.getDetails(sendid, receiveid);
		request.setAttribute("messagetitle", map.get("MessageTitle"));
		request.setAttribute("messagecontent",map.get("MessageContent"));
		request.setAttribute("sempname", map.get("s_empname"));
		request.setAttribute("createdate", map.get("createdate"));
		request.setAttribute("rempname", map.get("r_empname"));
		
		request.getRequestDispatcher("messagedetails.jsp").forward(request, response);
	}

}
