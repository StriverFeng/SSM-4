package com.silence.ssm.quartz.schedule;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyPrintTask {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyPrintTask.class);
	
	public void execute(){
		LOGGER.debug("There is quartz schedule,every 60 seconds executing one time，today is " + new Date());
	}
}
