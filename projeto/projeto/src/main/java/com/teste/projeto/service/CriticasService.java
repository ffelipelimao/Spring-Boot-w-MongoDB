package com.teste.projeto.service;

import java.time.LocalDateTime;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import com.teste.projeto.config.Utils;
import com.teste.projeto.entity.Criticas;
import com.teste.projeto.repository.CriticasRepository;

@Service
public class CriticasService {
	
	@Autowired
	private Utils utilidade;
	@Autowired
	private CriticasRepository repository;

	
	public List<Criticas> getAllFilmes() {
		List<Criticas> list = repository.findAll();
	
		list.forEach(f -> f.setDiferenca(utilidade.DiferencaEntreDatas(f.getDataInsert())));
		
		return inverter(list);
	}
	
	public Criticas getFilmeById(ObjectId id) {
		return repository.findBy_id(id);
	}
	
	
	public void modifyFilmebyId(ObjectId id, Criticas filme) {
		filme.set_id(id);

		float media = calcularNotas(filme);
		
		filme.setGeral(utilidade.formatarFloat(media));
		filme.setDataInsert(LocalDateTime.now());
		
		 repository.save(filme);
	}
	
	public void deleteFilmeById(ObjectId id) {
		
		String _id = id.toString();
		
		repository.deleteById(_id);
	}
	
	public void createFilme(Criticas filme) {
		filme.set_id(ObjectId.get());

		float media = calcularNotas(filme);
		
		filme.setGeral(utilidade.formatarFloat(media));
		filme.setDataInsert(LocalDateTime.now());
		
		repository.save(filme);
				
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
	
	private List<Criticas> inverter(List<Criticas> arr) {

		ArrayList<Criticas> result = new ArrayList<>();
		for (int i = arr.size() - 1; i >= 0; i--) {
			result.add((Criticas) arr.get(i));
		}
		
		return result;
	}


}
