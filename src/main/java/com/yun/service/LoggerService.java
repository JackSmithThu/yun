package com.yun.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LoggerService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	public void run() {
		logger.debug("This is a debug message");  
        logger.info("This is an info message");  
        logger.warn("This is a warn message");  
        logger.error("This is an error message"); 
	}
}
