package web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.vo.Emp;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
	List<String> list=new ArrayList<String>();
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest req=(HttpServletRequest) request;
//		HttpSession session=req.getSession();
//		Emp emp=(Emp) session.getAttribute("emp");
//		if(list.contains(req.getServletPath())) {
//			chain.doFilter(request, response);
//		}else  if(emp!=null) {
//			chain.doFilter(request, response);
//		}else {
//			String context=req.getServletContext().getContextPath();
//			HttpServletResponse resp=(HttpServletResponse) response;
//			resp.sendRedirect(context+"/login.jsp");
//		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		list.add("/login.jsp");
		list.add("/login.do");
		list.add("/login.html");
		list.add("/login.html.bak");
	}

}
