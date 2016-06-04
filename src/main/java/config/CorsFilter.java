package config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
class CorsFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		response.setHeader("Access-Control-Allow-Origin", "*"); // CHANGE
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, AUTHORIZATION, Content-Type");
		response.setHeader("Access-Control-Max-Age", "3600");
		if (!request.getMethod().equals("OPTIONS")) {
			chain.doFilter(req, res);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
		}
  }

  @Override
  public void init(FilterConfig filterConfig) {}

  
  public void destroy() {}

}