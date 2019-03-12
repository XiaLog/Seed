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
import web.vo.PageInfo;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/files/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService service=new EmpService();
		PageInfo pageinfo=new PageInfo(request);
		//List<Emp> list=service.getallEmp();
		List<Emp> list=service.getPageEmp(pageinfo);
		request.setAttribute("list", list);
		request.getRequestDispatcher("emplist.jsp").forward(request, response);
	}

}
