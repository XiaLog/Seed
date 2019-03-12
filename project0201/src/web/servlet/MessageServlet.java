package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.MessageService;
import web.vo.Emp;
import web.vo.Sendmessage;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/files/message.do")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//String sendid=request.getParameter("sendid");
//		String semp=request.getParameter("empid");
//		String[] emp=semp.split(",");
		String[] emp=request.getParameterValues("eid");
		String messagetitle=request.getParameter("messagetitle");
		String messagecontent=request.getParameter("messagecontent");
		String priority=request.getParameter("priority");
		int[] empid=new int[emp.length];
		for(int i=0;i<emp.length;i++) {
			empid[i]=Integer.valueOf(emp[i]);
		}
		Sendmessage sm=new Sendmessage();
		Emp e=(Emp) request.getSession().getAttribute("emp");
		sm.setEmpid(e.getEmpid());
		sm.setMessagetitle(messagetitle);
		sm.setMessagecontent(messagecontent);
		sm.setPriority(Integer.valueOf(priority));
		MessageService service=new MessageService();
		service.messageSend(sm, empid);
		response.sendRedirect("sendmessage.jsp");
	}

}
