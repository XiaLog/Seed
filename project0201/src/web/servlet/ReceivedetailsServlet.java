package web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.MessageService;
import web.vo.Emp;

/**
 * Servlet implementation class ReceivedetailsServlet
 */
@WebServlet("/files/receivedetails.do")
public class ReceivedetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integer receiveid=Integer.valueOf(request.getParameter("receiveid"));
		MessageService service=new MessageService();
		Map<String,Object> map=service.getreceiveDetails(receiveid);
		request.setAttribute("messagetitle", map.get("MessageTitle"));
		request.setAttribute("opendate", map.get("OpenDate"));
		request.setAttribute("messagecontent", map.get("MessageContent"));	
		request.setAttribute("s_empname", map.get("s_empname"));
		request.getRequestDispatcher("receivemessagedetails.jsp").forward(request, response);
	}

}
