package com.teste.projeto;

import java.util.List;


import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/critica")
public class CriticasController {
	
	@Autowired
	private CriticasService Service;
	
	@GetMapping(value = ("/"))
	public List<Criticas> findAll() {
		return Service.getAllFilmes();
	}

	@GetMapping(value = ("/{id}"))
	public Criticas findById(@PathVariable("id") ObjectId id) {
		return Service.getFilmeById(id);

	}
	
	@PutMapping(value = ("/{id}"))
	public Criticas update(@PathVariable("id") ObjectId id, @RequestBody Criticas filme) {
		return Service.modifyFilmebyId(id,filme);
	}
	
	
//	@DeleteMapping(value = ("/{id}"))
//	public Pets delete(@PathVariable("id") ObjectId id) {
//		return Service.deletePetById(id);
//	}


	@PostMapping(value = ("/"))
	public Criticas create(@Valid @RequestBody Criticas filme) {
		return Service.createFilme(filme);
	}

}
