package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.service.EmpService;
import web.vo.Emp;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/files/emp.do")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService service=new EmpService();
		List<Emp> list=service.getallEmp();
		ObjectMapper om=new ObjectMapper();
		String json=om.writeValueAsString(list);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().println(json);
		//request.getRequestDispatcher("sendmesssage.jsp").forward(request, response);
	}

}
