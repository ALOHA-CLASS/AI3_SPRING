package com.aloha.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.spring.dto.Board;

@Mapper
public interface BoardMapper {
	
	// ✅ 메소드명은 Mapper.xml 매핑 파일의 SQL 태그 id 값과 일치해야한다.
	// 목록 
	public List<Board> list() throws Exception;
	// 조회
	public Board select(int no) throws Exception;
	// 등록
	public int insert(Board board) throws Exception;
	// 수정
	public int update(Board board) throws Exception;
	// 삭제
	public int delete(int no) throws Exception;

}










