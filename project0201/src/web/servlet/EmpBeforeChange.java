package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.EmpService;
import web.vo.Emp;

/**
 * Servlet implementation class EmpBeforeChange
 */
@WebServlet("/files/beforechange.do")
public class EmpBeforeChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   Integer empid=Integer.valueOf(request.getParameter("empid"));
		   EmpService service=new EmpService();
		   Emp emp=service.getEmpdetails(empid);
		   request.setAttribute("emp", emp);
		   request.getRequestDispatcher("empchange.jsp").forward(request, response);
	}

}