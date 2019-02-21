package com.desafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "heroi")
public class Heroi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idheroi;
	
	@NotNull
	private String nome;
	
	private String foto;
	
	private String descricao;
	
	private Boolean flagfavorito;
	

	public Integer getIdheroi() {
		return idheroi;
	}

	public void setIdheroi(Integer idheroi) {
		this.idheroi = idheroi;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getFlagfavorito() {
		return flagfavorito;
	}

	public void setFlagfavorito(Boolean flagfavorito) {
		this.flagfavorito = flagfavorito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((flagfavorito == null) ? 0 : flagfavorito.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((idheroi == null) ? 0 : idheroi.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Heroi other = (Heroi) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (flagfavorito == null) {
			if (other.flagfavorito != null)
				return false;
		} else if (!flagfavorito.equals(other.flagfavorito))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (idheroi == null) {
			if (other.idheroi != null)
				return false;
		} else if (!idheroi.equals(other.idheroi))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	
}
