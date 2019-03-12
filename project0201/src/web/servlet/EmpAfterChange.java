package web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.EmpService;
import web.vo.Emp;

/**
 * Servlet implementation class EmpAfterChange
 */
@WebServlet("/files/afterchange.do")
public class EmpAfterChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SimpleDateFormat sdate=new SimpleDateFormat("yyyy-MM-dd");
		try {	
			EmpService service=new EmpService();
			Integer empid=Integer.valueOf(request.getParameter("empid"));
			String  empno=request.getParameter("empno");
			String password=request.getParameter("password");
			String empname=request.getParameter("empname");
			String sex=request.getParameter("sex");
			String date=request.getParameter("birth");
			java.util.Date dbirth = (Date) sdate.parse(date);
			java.sql.Date birth=new java.sql.Date(dbirth.getTime());
			String idcard=request.getParameter("idcard");
			String email=request.getParameter("email");
			String tel=request.getParameter("tel");
			String address=request.getParameter("address");
			String emptype=request.getParameter("emptype");
			String bankname=request.getParameter("bankname");
			String bankno=request.getParameter("bankno");
			Integer sal=Integer.valueOf(request.getParameter("sal"));
			Integer comm=Integer.valueOf(request.getParameter("comm"));
			Integer subsidy=Integer.valueOf(request.getParameter("subsidy"));
			String hdate=request.getParameter("hiredate");
			java.util.Date dhiredate=(Date) sdate.parse(hdate);
			java.sql.Date hiredate=new java.sql.Date(dhiredate.getTime());
			String descript=request.getParameter("descript");
			Emp emp=new Emp(null, empno, password, empname, sex, birth, idcard, email, tel, address, emptype, bankname,bankno, sal, comm, subsidy, hiredate, descript);
			if(emp!=null) {
				service.changeEmp(emp, empid);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		response.sendRedirect("emplist.do");
	}

}
