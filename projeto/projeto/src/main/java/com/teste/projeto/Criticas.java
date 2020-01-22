package com.teste.projeto;

import java.time.LocalDateTime;
import java.util.Map;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Criticas {

	@Id
	public ObjectId _id;

	public String name;
	public String conteudo;
	public LocalDateTime dataInsert;
	public String genero;
	public String image;
	public float geral;
	public Map<String,String> nota;

	// Constructors
	public Criticas() {
	}


	public Criticas(ObjectId _id, String name, String image, Map<String, String> nota,String conteudo) {
		super();
		this._id = _id;
		this.name = name;
		this.genero = image;
		this.nota = nota;
		this.conteudo = conteudo;
	}
	
	
	public String getConteudo() {
		return conteudo;
	}


	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


	public float getGeral() {
		return geral;
	}


	public void setGeral(float geral) {
		this.geral = geral;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	// ObjectId needs to be converted to string
	public String get_id() {
		return _id.toHexString();
	}

	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Map<String, String> getNota() {
		return nota;
	}


	public void setNota(Map<String, String> nota) {
		this.nota = nota;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}


	
	public LocalDateTime getDataInsert() {
		return dataInsert;
	}


	public void setDataInsert(LocalDateTime dataInsert) {
		this.dataInsert = dataInsert;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

	
}

	
	

