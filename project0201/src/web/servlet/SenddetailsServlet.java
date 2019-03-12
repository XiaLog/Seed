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
 * Servlet implementation class SenddetailsServlet
 */
@WebServlet("/files/senddetails.do")
public class SenddetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Emp emp=(Emp) request.getSession().getAttribute("emp");
		Integer sendid=Integer.valueOf(request.getParameter("sendid"));
		MessageService service=new MessageService();
		List<Map<String,Object>> list=service.getsendDetails(sendid, emp.getEmpid());
		List<String> r_empname=new ArrayList<String>();
		request.setAttribute("messagetitle", list.get(0).get("MessageTitle"));
		request.setAttribute("s_empname", list.get(0).get("s_empname"));
		request.setAttribute("createdate", list.get(0).get("createdate"));
		request.setAttribute("messagecontent", list.get(0).get("messagecontent"));
		for(Map<String,Object> i:list) {
			r_empname.add((String) i.get("r_empname"));
		}	
		request.setAttribute("rempname", r_empname);
		request.getRequestDispatcher("sendmessagedetails.jsp").forward(request, response);
	}

}
