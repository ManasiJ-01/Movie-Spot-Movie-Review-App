package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reviews")

@Data

@AllArgsConstructor

@NoArgsConstructor


public class Review 
{
	@Id
	private ObjectId id;
	
	private String body;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Review(ObjectId id, String body) {
		super();
		this.id = id;
		this.body = body;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", body=" + body + "]";
	}

	public Review(String body) {
		super();
		this.body = body;
	}
	
	
	
}
