package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.EmpService;
import web.vo.Emp;

/**
 * Servlet implementation class JobListServlet
 */
@WebServlet("/files/joblist.do")
public class JobListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService service=new EmpService();
		List<Emp> list=service.getallEmp();
		request.setAttribute("list", list);
		request.getRequestDispatcher("joblist.jsp").forward(request, response);
	}

}
