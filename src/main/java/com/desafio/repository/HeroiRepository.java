package com.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.model.Heroi;

public interface HeroiRepository extends JpaRepository<Heroi, Integer> {

	List<Heroi> findByFlagfavoritoTrue();
	
	List<Heroi> findByNomeContains(String nome);
	
}
