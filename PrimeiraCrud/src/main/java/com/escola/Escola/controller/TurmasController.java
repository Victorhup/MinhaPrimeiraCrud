package com.escola.Escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.Escola.model.Turmas;
import com.escola.Escola.repository.TurmasRepository;

@RestController 
@RequestMapping ("/turma")
@CrossOrigin ("*")
public class TurmasController {
	
	@Autowired
	private TurmasRepository repository; 
	
	@GetMapping
	public ResponseEntity<List<Turmas>> GetAll(){ 
		return ResponseEntity.ok(repository.findAll());
	} 
	
	@GetMapping ("/{id}") 
	public ResponseEntity<Turmas> GetById(@PathVariable long id) { 
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping ("/turma/{turma}")
	public ResponseEntity<List<Turmas>> GetByTurma (@PathVariable String turma) {
		return ResponseEntity.ok(repository.findAllByTurmaContainingIgnoreCase(turma));
	}
	
	@PostMapping 
	public ResponseEntity<Turmas> post (@RequestBody Turmas turma) { 
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turma));
		
	}
	@PutMapping 
	public ResponseEntity<Turmas> put (@RequestBody Turmas turma) { 
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(turma));
	}
    
	@DeleteMapping ("/{id}") 
	public void delete (@PathVariable long id) { 
		repository.deleteById(id);
  }

}