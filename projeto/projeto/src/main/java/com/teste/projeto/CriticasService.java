package com.teste.projeto;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriticasService {
	
	@Autowired
	private Utils utilidade;
	@Autowired
	private CriticasRepository repository;

	
	public List<Criticas> getAllFilmes() {
		List<Criticas> list = repository.findAll();
		return list;
	}
	
	public Criticas getFilmeById(ObjectId id) {
		return repository.findBy_id(id);
	}
	
	
	public Criticas modifyFilmebyId(ObjectId id, Criticas filme) {
		filme.set_id(id);

		float media = calcularNotas(filme);
		
		filme.setGeral(utilidade.formatarFloat(media));
		filme.setDataInsert(LocalDateTime.now());
		
		return repository.save(filme);
	}
	
//	public Pets deletePetById(ObjectId id) {
//		return repository.deleteById(id);
//		
//	}
	
	public Criticas createFilme(Criticas filme) {
		filme.set_id(ObjectId.get());

		float media = calcularNotas(filme);
		
		filme.setGeral(utilidade.formatarFloat(media));
		filme.setDataInsert(LocalDateTime.now());
		
		repository.save(filme);
				
		return filme;
}
	
	
	private float calcularNotas(Criticas filme) {
		
		float nota = 0;

		String[] chaves = { "direcao", "fotografia", "atuacao", "roteiro" };

		for (int i = 0; i < filme.getNota().size(); i++) {

			nota += Float.parseFloat(filme.getNota().get(chaves[i]));
		}

		float result = ((nota / 4) * 5) / 10;

		return result;
	}


}
