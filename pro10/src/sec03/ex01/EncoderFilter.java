package sec03.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
//@WebFilter("/*")
public class EncoderFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncoderFilter() {
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
		System.out.println("doFilter호출");
		request.setCharacterEncoding("utf-8");
		 
		String context=((HttpServletRequest) request).getContextPath();
		String pathinfo=((HttpServletRequest)request).getRequestURI();
		String realPath= request.getRealPath(pathinfo);
		String mesg="Context 정보:"+ context+ "\n URL정보:"+pathinfo+"\n 물리적경로"+realPath;
		System.out.println(mesg);
		 long begin= System.currentTimeMillis();
		chain.doFilter(request, response);
		long end= System.currentTimeMillis();
		System.out.println("작업시간:"+(end-begin)+"ms");
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
