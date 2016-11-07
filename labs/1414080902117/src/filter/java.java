package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java implements Filter {

	private String encoding = null;


	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*���������*/

		encoding = getEncoding();
		if(encoding == null)
		{
			encoding = "utf-8";
		}
		request.setCharacterEncoding(encoding);
		
		/*�û���ݷ���Ȩ��*/
		HttpServletRequest rq = (HttpServletRequest)request;
		HttpServletResponse rp = (HttpServletResponse)response;
		HttpSession session = rq.getSession();
		if(session.getAttribute("account")!="")
		{
			chain.doFilter(request, response);
		}
		else
		{ 
			rp.sendRedirect("failure.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		/*���ڳ�ʼ����ҳ��ֻ�ܵ���һ��*/
		this.encoding = fConfig.getInitParameter("encoding");
	}
	public String getEncoding()
	{
		return this.encoding;
	}

}
