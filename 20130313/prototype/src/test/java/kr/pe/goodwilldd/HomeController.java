package kr.pe.goodwilldd;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class HomeController {

	private static final Log log = LogFactory.getLog(HomeController.class);
	
	@Autowired
	private ReloadableResourceBundleMessageSource messageSource;
	
	@Test
	public void doTestHome() {
		log.info(messageSource.getMessage("myName", null, Locale.KOREA));
		log.info(messageSource.getMessage("myName", null, Locale.ENGLISH));
	}
}
