package kr.pe.goodwilldd.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class InsoftLoginSuccessHandler implements AuthenticationSuccessHandler {

	/**
	 * 로그인 이후
	 * 	> 일반적으로 메인 페이지로 이동(xml에서 지정할 수도 있다)
	 *  > 로그인 관련 로그 및 계정작업 등등등을 수행한다.
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth) throws IOException,
			ServletException {
		response.sendRedirect(request.getContextPath() + "/index");
	}

}
