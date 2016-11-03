package com.silence.ssm.quartz.schedule;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskJob {

	private static final Logger LOGGER = LoggerFactory.getLogger(TaskJob.class);
	
	public void run(){
		LOGGER.debug("this is quartz schedule,the task Job is running! today is " + new Date());
		LOGGER.info("this is test information");
	}
}
