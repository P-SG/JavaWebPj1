package p201211;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*") 
//필터를 지정하여 매핑뒤에 필터를 붙이면 인코딩이나 서비스 시간을 측정할 수 있다
public class EncoderFilter implements Filter {
	ServletContext context;
    public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 인코딩............");
		context = fConfig.getServletContext();
    }

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) 
			throws ServletException, IOException {
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8");
		String context = ((HttpServletRequest)request).getContextPath(); //Context의 주소를 받아온다
		String pathinfo = ((HttpServletRequest)request).getRequestURI(); //Context하위 파일명까지 받아온다
		String realPath = request.getRealPath(pathinfo); 
		String mesg = " Context 정보:"+ context + "\n URI 정보 : "
				+ pathinfo + "\n 물리적 경로: " + realPath;
		System.out.println(mesg);
		
		long begin = System.currentTimeMillis();
		//요청필터에서 요청처리 전의 시각을 구합니다
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		//응답필터에서 요청처리 후의 시각을 구합니다
		System.out.println("작업시간: "+(end - begin)+"ms");
	}
	public void destroy() {
		System.out.println("destroy 호출");
	}

}

