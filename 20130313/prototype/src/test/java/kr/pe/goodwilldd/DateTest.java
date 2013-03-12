package kr.pe.goodwilldd;

import kr.pe.goodwilldd.core.util.UtilFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class DateTest {

	private static final Log log = LogFactory.getLog(DateTest.class);

	private UtilFactory util = new UtilFactory();

	@Test
	public void currentDate() {
		log.info(util.getDateUtil().now());
	}
}
