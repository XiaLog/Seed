package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.MessageService;

/**
 * Servlet implementation class SendmessageDelete
 */
@WebServlet("/files/senddelete.do")
public class SendmessageDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageService service=new MessageService();
		if(request.getParameterValues("delid")[0]!=null){
		String[] delid=request.getParameterValues("delid");
		Integer[] sendids=new Integer[delid.length];
		   for(int i=0;i<sendids.length;i++) {
			   sendids[i]=Integer.valueOf(delid[i]);
		    }
		   service.sendDeletes(sendids);
		}
		if(request.getParameter("sendid")!=null) {
			Integer sendid=Integer.valueOf(request.getParameter("sendid"));	
			service.sendDelete(sendid);
		}
		response.sendRedirect("sendlist.do");
	}

}
