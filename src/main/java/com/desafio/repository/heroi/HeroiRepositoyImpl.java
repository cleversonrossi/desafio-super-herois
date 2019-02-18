package com.desafio.repository.heroi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.desafio.model.Heroi;
import com.desafio.model.Heroi_;
import com.desafio.repository.filter.HeroiFilter;

public class HeroiRepositoyImpl implements HeroiRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Heroi> filtrar(HeroiFilter heroiFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Heroi> criteria = builder.createQuery(Heroi.class);
		Root<Heroi> root = criteria.from(Heroi.class);
		
		Predicate[] predicates = criarRestricoes(heroiFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Heroi> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(HeroiFilter heroiFilter, CriteriaBuilder builder, Root<Heroi> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(heroiFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Heroi_.nome)), "%" + heroiFilter.getNome().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
