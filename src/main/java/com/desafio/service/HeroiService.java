package com.desafio.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.desafio.model.Heroi;
import com.desafio.repository.HeroiRepository;

@Service
public class HeroiService {
	
	@Autowired
	private HeroiRepository heroiRepository;
	
	public Heroi atualizar(Integer idheroi, Heroi heroi) {
		Heroi heroiSalvo = buscarHeroiPeloId(idheroi);
		
		BeanUtils.copyProperties(heroi, heroiSalvo, "idheroi");
		return heroiRepository.save(heroiSalvo);
	}

	public void atualizarPropriedadeFlagFavorito(Integer idheroi, Boolean flagfavorito) {
		Heroi heroiSalvo = buscarHeroiPeloId(idheroi);
		heroiSalvo.setFlagfavorito(flagfavorito);
		heroiRepository.save(heroiSalvo);
	}

	private Heroi buscarHeroiPeloId(Integer idheroi) {
		Heroi heroiSalvo = heroiRepository.findOne(idheroi);
		if(heroiSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return heroiSalvo;
	}

}
