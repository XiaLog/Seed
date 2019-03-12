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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String empname=request.getParameter("empname");
		String password=request.getParameter("password");
		EmpService service=new EmpService();
		Emp emp=service.getoneEmp(empname, password);
		String picString = (String) request.getSession().getAttribute("piccode");
        String checkCode = request.getParameter("checkCode");
//		System.out.println(emp);
		if(emp!=null&&(picString.toUpperCase().equals(checkCode.toUpperCase()))) {
			request.getSession().setAttribute("emp", emp);
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
