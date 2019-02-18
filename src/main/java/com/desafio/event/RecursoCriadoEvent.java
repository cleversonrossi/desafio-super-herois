package com.desafio.event;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private Integer idheroi;

	public RecursoCriadoEvent(Object source, HttpServletResponse response, Integer idheroi) {
		super(source);
		this.response = response;
		this.idheroi = idheroi;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Integer getIdheroi() {
		return idheroi;
	}
}
