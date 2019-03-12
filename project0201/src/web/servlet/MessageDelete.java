package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.EmpService;

/**
 * Servlet implementation class MessageDelete
 */
@WebServlet("/files/messagedelete.do")
public class MessageDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		EmpService service=new EmpService();
		if(request.getParameterValues("delid")[0]!=null){
			String[] delids=request.getParameterValues("delid");
			Integer[] sendids=new Integer[delids.length];
			Integer[] receiveids=new Integer[delids.length];
			for(int i=0;i<delids.length;i++) {
				System.out.println(delids[i]);
				String[] s=delids[i].split("_");
				sendids[i]=Integer.valueOf(s[0]);
				receiveids[i]=Integer.valueOf(s[1]);
			}
			if(sendids[0]!=null&&receiveids[0]!=null) {
				service.deletes(sendids, receiveids);
			}
		}
		
		if(request.getParameter("sendid")!=null&&request.getParameter("receiveid")!=null) {
			Integer sendid=Integer.valueOf(request.getParameter("sendid"));
			Integer receiveid=Integer.valueOf(request.getParameter("receiveid"));
			service.delete(sendid, receiveid);
		}
		
		response.sendRedirect("messagelist.do");
	}

}
