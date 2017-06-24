package com.yun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ScopeService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SingletonService singletonService;
	
	@Autowired 
	private SessionService sessionService;
	
	@Autowired
	private RequestService requestService;
	

	
	public String getScopeId() {
		logger.info("=========================================");
		logger.info("requestService id is:" + requestService.getId());
		logger.info("sessionService id is:" + sessionService.getId());
		logger.info("singletonService id is:" + singletonService.getId());
		return "request id is : " + requestService.getId() + " | " + 
			   "session id is : " + sessionService.getId() + " | " +
			   "singleton id is : " + singletonService.getId();
	}
	
	public void setScopeId(Integer id) {
		requestService.setId(id);
		sessionService.setId(id);
		singletonService.setId(id);
		logger.info("=========================================");
		logger.info("requestService id set:" + id);
		logger.info("sessionService id set:" + id);
		logger.info("singletonService id set:" + id);
	}

}
