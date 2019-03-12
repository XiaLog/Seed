package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.MessageService;
import web.vo.Emp;
import web.vo.PagedoSR;
import web.vo.Sendmessage;

/**
 * Servlet implementation class ReceivemessageList
 */
@WebServlet("/files/receivelist.do")
public class ReceivemessageList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Emp emp=(Emp) request.getSession().getAttribute("emp");
		MessageService service=new MessageService();
		//List<Sendmessage> list=service.getReceive(emp.getEmpid());
		PagedoSR pagedosr=new PagedoSR(request);
		List<Sendmessage> list=service.getreceivePage(pagedosr,emp.getEmpid());
		request.setAttribute("list", list);
		request.getRequestDispatcher("receivemessagelist.jsp").forward(request, response);
	}

}
