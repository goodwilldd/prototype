package kr.pe.goodwilldd.core.util.hide;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 날짜와 관련된 유틸 함수
 * 
 * @author sylee
 * 
 */
public class DateUtil {

	private static final Log log = LogFactory.getLog(DateUtil.class);

	public Date now() {
		GregorianCalendar calendar = new GregorianCalendar(Locale.KOREA);
		return calendar.getTime();
	}

	public String getFormattedDate(String pattern) {
		return "";
	}
}
