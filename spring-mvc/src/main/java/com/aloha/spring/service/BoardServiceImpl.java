package com.aloha.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.dao.BoardDAO;
import com.aloha.spring.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	// 로거
	private static final Logger logger 
			= LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<Board> list() throws Exception {
		List<Board> list = boardDAO.list();
		int count = list.size();
		logger.info("게시글 목록을 조회합니다... ");
		logger.info("게시글 개수 : " + count);
		return list;
	}

	@Override
	public Board select(int no) throws Exception {
		Board board = boardDAO.select(no);
		logger.info("게시글을 조회합니다... ");
		int test = 10 / 0;
		return board;
	}

	@Override
	public boolean insert(Board board) throws Exception {
		int result = boardDAO.insert(board);
		logger.info("게시글 등록... ");
		return result > 0;
	}

	@Override
	public boolean update(Board board) throws Exception {
		int result = boardDAO.update(board);
		logger.info("게시글 수정... ");
		return result > 0;
	}

	@Override
	public boolean delete(int no) throws Exception {
		int result = boardDAO.delete(no);
		logger.info("게시글 삭제... ");
		return result > 0;
	}

}

