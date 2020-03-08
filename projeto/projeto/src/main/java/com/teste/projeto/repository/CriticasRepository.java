package com.teste.projeto.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teste.projeto.entity.Criticas;

@Repository
public interface CriticasRepository  extends MongoRepository<Criticas, String> {

	 Criticas findBy_id(ObjectId _id);
		
	 
	 void deleteById(String _id);
	
}
