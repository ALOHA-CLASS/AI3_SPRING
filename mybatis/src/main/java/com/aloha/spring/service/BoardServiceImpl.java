package com.aloha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.dto.Board;
import com.aloha.spring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<Board> list() throws Exception {
		List<Board> list = boardMapper.list();
		return list;
	}

	@Override
	public Board select(int no) throws Exception {
		Board board = boardMapper.select(no);
		return board;
	}

	@Override
	public boolean insert(Board board) throws Exception {
		int result = boardMapper.insert(board);
		if( result > 0 ) 
			return true;
		return false;
	}

	@Override
	public boolean update(Board board) throws Exception {
		int result = boardMapper.update(board);
		if( result > 0 ) 
			return true;
		return false;
	}

	@Override
	public boolean delete(int no) throws Exception {
		int result = boardMapper.delete(no);
		if( result > 0 ) 
			return true;
		return false;
	}

}
