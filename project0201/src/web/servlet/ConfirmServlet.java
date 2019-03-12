package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/confirm.do")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        String picString = (String) request.getSession().getAttribute("piccode");
        String checkCode = request.getParameter("checkCode");
        response.setContentType("text/html;charset=gbk");
        PrintWriter out = response.getWriter();
        if (picString.toUpperCase().equals(checkCode.toUpperCase()))
            out.println("验证码正确");
        else
            out.print("验证码错误！");
        
        out.flush();
        out.close();
	}

}
