package kr.pe.goodwilldd.core.util;

import kr.pe.goodwilldd.core.util.hide.DateUtil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilFactory {

	/**
	 * Util class를 singleton으로 사용함. Util class 추가시 아래와 같은 형식으로 추가하도록함.
	 * 
	 * @return
	 */
	@Bean
	public DateUtil getDateUtil() {
		return new DateUtil();
	}

}
