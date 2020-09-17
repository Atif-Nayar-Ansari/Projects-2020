package com.nt.test;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Log4jBasisConfiguration {

	//to enable the logging for the specific class
	private static Logger logger = Logger.getLogger(Log4jBasisConfiguration.class);

	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		logger.debug("Main method is started..");
		
		Calendar c = Calendar.getInstance();
		logger.info("Calender object is created...");
		int hour = c.get(Calendar.HOUR_OF_DAY);
		logger.info("Related message is printed..");
		if(hour>6 && hour<12) {
			System.out.println("Good Morning...");
		}else if(hour>12 && hour<16) {
			System.out.println("Good Afternoon...");
		}if(hour>16 && hour<23) {
			System.out.println("Good Night...");
		}
		
		
		logger.debug("Main method is ended..");
		
	}

}
