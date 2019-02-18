package com.desafio.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.event.RecursoCriadoEvent;
import com.desafio.model.Heroi;
import com.desafio.repository.HeroiRepository;
import com.desafio.repository.filter.HeroiFilter;
import com.desafio.service.HeroiService;

@RestController
@RequestMapping("/herois")
public class HeroiResource {
	
	@Autowired
	private HeroiRepository heroiRepository;
	
	@Autowired
	private HeroiService heroiService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Heroi> listar() {
		return heroiRepository.findAll();
	}

	@GetMapping
	public List<Heroi> buscaNome(HeroiFilter heroiFilter) {
		return heroiRepository.filtrar(heroiFilter);
	}
	
	@PostMapping
	public ResponseEntity<Heroi> criar(@Valid @RequestBody Heroi heroi, HttpServletResponse response) {
		Heroi heroiSalvo = heroiRepository.save(heroi);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, heroiSalvo.getIdheroi()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(heroiSalvo);
	}
	
	@DeleteMapping("/{idheroi}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer idheroi) {
		heroiRepository.delete(idheroi);
	}
	
	@PutMapping("/{idheroi}")
	public ResponseEntity<Heroi> atualizar(@PathVariable Integer idheroi, @Valid @RequestBody Heroi heroi) {
		Heroi heroiSalvo = heroiService.atualizar(idheroi, heroi);
		
		return ResponseEntity.ok(heroiSalvo);
	}
	
	@PutMapping("/{idheroi}/flagfavorito")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeFlagFavorito(@PathVariable Integer idheroi,@RequestBody Boolean flagfavorito) {
		heroiService.atualizarPropriedadeFlagFavorito(idheroi, flagfavorito);
	}
}
