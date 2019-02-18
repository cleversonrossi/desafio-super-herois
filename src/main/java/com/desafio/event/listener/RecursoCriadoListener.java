package com.desafio.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.event.RecursoCriadoEvent;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

	@Override
	public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
		HttpServletResponse response = recursoCriadoEvent.getResponse();
		Integer idheroi = recursoCriadoEvent.getIdheroi();
		
		adicionarHanderLocation(response, idheroi);
	}

	private void adicionarHanderLocation(HttpServletResponse response, Integer idheroi) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idheroi}")
				.buildAndExpand(idheroi).toUri();
			response.setHeader("location", uri.toASCIIString());
	}

}
