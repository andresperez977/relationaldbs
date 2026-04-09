package relationaldbs;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

import ch.qos.logback.classic.Logger;

public class LoggingTest {

	/*
	 * 
	 * static members of a class have only one copy in the memory no matter
	 * 
	 * how many objects of the class we have created
	 * 
	 * a final variable's value can not be modified
	 */

	private final static Logger logger = (Logger) LoggerFactory.getLogger(LoggingTest.class);

	public static void main(String[] args) {

		logger.setLevel(Level.TRACE);

//		logger.trace(null);

//		logger.debug(null);

//		logger.info("");

//		logger.warn(null);

//		logger.error(null);

//		

		division(20, 0);

	}

	private static void division(int i, int j) {

		// this level of information

		logger.trace("trace info-vey detailed info: you have entered the method division");

		// we use this level of information for test

		logger.debug("test info: division method test");

		// we use this level of log for normal and general information

		logger.info("main general info to show our app is running normally");

		// we use this level of log for potential problems

		logger.warn("unexpected problems but not vital");

		// this is for errors

		logger.error("serious problem that should be resolved");

		if (j == 0) {

			logger.info("the user has passed a zero as a dividend");

			return;

		}

		try {

			int result = i / j;

			logger.info("the result is : " + result);

		} catch (Exception e) {

			logger.error(e.getMessage());

			e.printStackTrace();

		}

	}

}