package com.silence.ssm.quartz.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskJob {

	private static final Logger LOGGER = LoggerFactory.getLogger(TaskJob.class);
	
	public void run(){
		LOGGER.info("the task Job is running!");
	}
}
