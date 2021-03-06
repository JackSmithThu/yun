package com.yun.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(
	value=WebApplicationContext.SCOPE_SESSION,
	proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SessionService {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
