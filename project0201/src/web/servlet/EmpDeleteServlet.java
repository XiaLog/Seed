package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet("/files/empdelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] empids=request.getParameterValues("delid");
		Integer[] empid=new Integer[empids.length];
		for(int i=0;i<empids.length;i++) {
			empid[i]=Integer.valueOf(empids[i]);
		}
		EmpService service=new EmpService();
		service.deleteEmp(empid);
		response.sendRedirect("emplist.do");
	}

}

