package web.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.EmpService;
import web.vo.Emp;
import web.vo.PageInfo;

/**
 * Servlet implementation class MessagelistServlet
 */
@WebServlet("/files/messagelist.do")
public class MessagelistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Emp emp=(Emp) request.getSession().getAttribute("emp");
		EmpService service=new EmpService();
		//List<Map<String,Object>> list=service.getMessage(emp.getEmpid());
		PageInfo pageinfo=new PageInfo(request);
		List<Map<String,Object>> list=service.getPage(pageinfo,emp.getEmpid());
		
		List<String> messagetitle=new ArrayList<String>();
		List<String> rempname=new ArrayList<String>();
		List<String> sempname=new ArrayList<String>();
		List<Date> createdate=new ArrayList<Date>();
		List<Integer> sendid=new ArrayList<Integer>();
		List<Integer> receiveid=new ArrayList<Integer>();
		for(Map i:list) {
			messagetitle.add((String) i.get("MessageTitle"));
			rempname.add((String) i.get("r_empname"));
			sempname.add((String) i.get("s_empname"));
			createdate.add((Date)i.get("createdate"));
			sendid.add((Integer) i.get("s_sendid"));
			receiveid.add((Integer) i.get("r_receiveid"));
		}
		request.setAttribute("messagetitle", messagetitle);
		request.setAttribute("rempname", rempname);
		request.setAttribute("sempname", sempname);
		request.setAttribute("createdate", createdate);
		request.setAttribute("sendid", sendid);
		request.setAttribute("receiveid", receiveid);
		
		request.getRequestDispatcher("messagelist.jsp").forward(request, response);
	}

}
