package com.desafio.repository.heroi;

import java.util.List;

import com.desafio.model.Heroi;
import com.desafio.repository.filter.HeroiFilter;

public interface HeroiRepositoryQuery {

	public List<Heroi> filtrar(HeroiFilter heroiFilter);
}
