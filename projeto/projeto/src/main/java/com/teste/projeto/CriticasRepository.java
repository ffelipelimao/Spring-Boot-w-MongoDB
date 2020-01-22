package com.teste.projeto;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriticasRepository  extends MongoRepository<Criticas, String> {

	 Criticas findBy_id(ObjectId _id);
		
	 
	 //Criticas deleteById(ObjectId _id);
	
}
