package com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.model.Heroi;
import com.desafio.repository.heroi.HeroiRepositoryQuery;

public interface HeroiRepository extends JpaRepository<Heroi, Integer>, HeroiRepositoryQuery {

}
