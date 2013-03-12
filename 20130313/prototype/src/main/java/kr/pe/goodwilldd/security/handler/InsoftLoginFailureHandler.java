package kr.pe.goodwilldd.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class InsoftLoginFailureHandler implements AuthenticationFailureHandler {

	/**
	 * 로그인 실패에 대한 로그 기록 및 작업
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException auth)
			throws IOException, ServletException {
		response.sendRedirect(request.getContextPath() + "/login");
	}

}
