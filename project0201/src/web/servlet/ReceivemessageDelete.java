package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.MessageService;

/**
 * Servlet implementation class ReceivemessageDelete
 */
@WebServlet("/files/receivedelete.do")
public class ReceivemessageDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageService service=new MessageService();
		if(request.getParameterValues("delid")[0]!=null){
			String[] delid=request.getParameterValues("delid");
			Integer[] receiveids=new Integer[delid.length];
			   for(int i=0;i<delid.length;i++) {
				   System.out.println(delid[i]);
				  receiveids[i]=Integer.valueOf(delid[i]);
				  System.out.println(delid[i]);
			    }
			   service.receiveDeletes(receiveids);
			}
		if(request.getParameter("receiveid")!=null) {
			Integer receiveid=Integer.valueOf(request.getParameter("receiveid"));
			service.receiveDelete(receiveid);
		}
		
		response.sendRedirect("receivelist.do");
	}

}
