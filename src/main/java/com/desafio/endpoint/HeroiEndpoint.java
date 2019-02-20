package com.desafio.endpoint;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List ;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.desafio.event.RecursoCriadoEvent;
import com.desafio.model.Heroi;
import com.desafio.service.HeroiService;

@RestController
@RequestMapping("/herois")
public class HeroiEndpoint {
	
	@Autowired
	private HeroiService heroiService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping("/upload")
	public String uploadFoto(@RequestParam MultipartFile anexo) throws IOException {
		
		// TODO implementar upload de foto
		OutputStream out = new FileOutputStream("c:/upload/" + anexo.getOriginalFilename());
		out.write(anexo.getBytes());
		out.close();
		return "OK";
	}

	@GetMapping
	public List<Heroi> listar() {
		return heroiService.findAll();
	}
	
	@GetMapping("/favoritos")
	public List<Heroi> buscaFavoritos() {
		return heroiService.findByFlagfavoritoTrue();
	}
	
	@GetMapping("/buscaNome")
	public List<Heroi> buscaPorNome(@RequestParam String nome) {
		return heroiService.findByNomeContains(nome);
	}
	
	@PostMapping
	public ResponseEntity<Heroi> criar(@Valid @RequestBody Heroi heroi, HttpServletResponse response) {
		Heroi heroiSalvo = heroiService.save(heroi);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, heroiSalvo.getIdheroi()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(heroiSalvo);
	}
	
	@DeleteMapping("/{idheroi}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer idheroi) {
		heroiService.delete(idheroi);
	}
	
	@PutMapping("/{idheroi}")
	public ResponseEntity<Heroi> atualizar(@PathVariable Integer idheroi, @Valid @RequestBody Heroi heroi) {
		Heroi heroiSalvo = heroiService.atualizar(idheroi, heroi);
		
		return ResponseEntity.ok(heroiSalvo);
	}
}
