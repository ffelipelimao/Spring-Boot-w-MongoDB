package com.teste.projeto.entity;

import java.time.LocalDateTime;

import java.util.Map;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Criticas {

	@Id
	private ObjectId _id;
	
	private String name;
	private String conteudo;
	private LocalDateTime dataInsert;
	private String diferenca;
	private String genero;
	private String image;
	private float geral;
	private Map<String,String> nota;
	
	// ObjectId precisa ser convertido pra string, para conseguir retornar seu valor
	public String get_id() {
		return _id.toString();
	}

	
}

	
	

