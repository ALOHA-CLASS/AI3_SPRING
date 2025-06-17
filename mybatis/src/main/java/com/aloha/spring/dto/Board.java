package com.aloha.spring.dto;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class Board {
	
	private int no;
	private String id;
	private String title;
	private String writer;
	private String content;
	private Date createdAt;
	private Date updatedAt;

	public Board() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Board(String title, String writer, String content) {
		this.id = UUID.randomUUID().toString();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

}








