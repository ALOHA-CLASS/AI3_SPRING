package com.aloha.spring.dto;

import org.springframework.stereotype.Component;

// 빈 등록
@Component			// 클래스를 빈으로 등록하는 어노테이션
public class Board {
	
	private String title;
	private String witer;
	private String content;
	
	public Board() {
		this.title = "제목없음";
		this.title = "작성자없음";
		this.title = "내용없음";
	}

	public Board(String title, String witer, String content) {
		this.title = title;
		this.witer = witer;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWiter() {
		return witer;
	}

	public void setWiter(String witer) {
		this.witer = witer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [title=" + title + ", witer=" + witer + ", content=" + content + "]";
	}
	
	
	
	
}
