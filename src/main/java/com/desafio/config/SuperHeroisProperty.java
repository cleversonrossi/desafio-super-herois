package com.desafio.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("superHeroi")
public class SuperHeroisProperty {
	
	private String origemErmitida = "http://localhost:8000";
	
	public String getOrigemErmitida() {
		return origemErmitida;
	}

	public void setOrigemErmitida(String origemErmitida) {
		this.origemErmitida = origemErmitida;
	}

	private final Seguranca seguranca = new Seguranca();

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public static class Seguranca {
		
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
		
	}
}
