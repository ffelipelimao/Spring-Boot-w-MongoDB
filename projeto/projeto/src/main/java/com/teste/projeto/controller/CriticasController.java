package com.teste.projeto.controller;

import java.util.List;



import javax.validation.Valid;

import org.bson.types.ObjectId;
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

import com.teste.projeto.config.ResourceNotFoundException;
import com.teste.projeto.entity.Criticas;
import com.teste.projeto.service.CriticasService;

@CrossOrigin
@RestController
@RequestMapping("/critica")
public class CriticasController {
	
	@Autowired
	private CriticasService service;
	
	@GetMapping(value = ("/"))
	public List<Criticas> findAll() {
		return service.getAllFilmes();
	}

	@GetMapping(value = ("/{id}"))
	public ResponseEntity<?> findById(@PathVariable("id") ObjectId id) {
		verifyFilmeById(id);
		return new ResponseEntity<>(service.getFilmeById(id),HttpStatus.OK);

	}
	
	@PutMapping(value = ("/{id}"))
	public ResponseEntity<?> update(@PathVariable("id") ObjectId id, @RequestBody Criticas filme) {
		verifyFilmeById(id);
		service.modifyFilmebyId(id,filme);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = ("/{id}"))
	public ResponseEntity<?> delete(@PathVariable("id") ObjectId id) {
		verifyFilmeById(id);
		service.deleteFilmeById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@PostMapping(value = ("/"))
	public ResponseEntity<?> create(@Valid @RequestBody Criticas filme) {
		 service.createFilme(filme);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void verifyFilmeById(ObjectId id){
		if (service.getFilmeById(id) == null)
			throw new ResourceNotFoundException("Picture not found for this id");
	}
}
