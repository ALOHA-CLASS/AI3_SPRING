package com.aloha.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDAO;

	/**
	 * 생성자 주입
	 * @param boardDAO
	 */
	@Autowired		// 의존성 자동 주입
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public void test() {
		boardDAO.test();
	}

	/**
	 * 세터 주입
	 */
	@Autowired		// 의존성 자동 주입
	@Override
	public void setDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

}
