package com.topshare.airshuttle;

import org.apache.log4j.Logger;
import org.junit.Test;

public class CommonTest {
	private Logger logger = Logger.getLogger(this.getClass());

	@Test
	public void testStrMatch() {
		String xx = "*.jpg, *.gif, *.png, *.js,*.css";
		logger.info(""+xx.matches("jpg"));
	}
}
