package com.aloha.spring.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aloha.spring.dto.Board;
import com.aloha.spring.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
//@RequestMapping("/response")
public class ResponseController {
	
	private static final Logger logger 
			= LoggerFactory.getLogger(ResponseController.class);
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * 요청 경로 : /response/index
	 * 응답 	   : /response/index.jsp 
	 */
	@RequestMapping("/response/index")
	public void response() {
		logger.info("void 타입 - /response/index");
		logger.info("/response/index.jsp 뷰를 응답");
	}
	
	/**
	 * 요청 경로 : /response/view
	 * 응답 	   : /response/index.jsp 
	 * @return
	 */
	@RequestMapping("/response/view")
	public String responseView() {
		logger.info("String 타입 - /response/index");
		logger.info("/response/index.jsp 뷰를 응답");
		logger.info("view 이름을 반환값으로 지정");
		return "response/index";
	}
	
	/**
	 * 요청 경로  : /response/model/view
	 * 응답 	   : /response/index.jsp 
	 * @return
	 */
	@RequestMapping("/response/model/view")
	public ModelAndView responseModeAndView(ModelAndView mv) {
		// ModelAndView 
		// 뷰와 모델 데이터를 지정하여 함께 응답 처리할 수 있는 스프링프레임워크 클래스
		logger.info("ModelAndView 타입 - /response/model/view");
		logger.info("/response/index.jsp 뷰를 응답");
		logger.info("모델과 뷰를 ModelAndView 객체에 지정하여 응답");
		
		// ModelAndView mv = new ModelAndView();
		// 뷰이름 지정
		mv.setViewName("/response/index");			// view : /response/index.jsp
		
		// 모델 등록
		Board board = new Board("b01","제목","작성자","내용");
		mv.addObject("board", board);
		mv.addObject("message", "ModelAndView 컨트롤러 응답...");
													// model : board, message
		return mv;
	}
	
	
	/**
	 * 요청 경로  : /response/data/board
	 * 응답 	   : board (JSON/XML)
	 * @ResponseBody : 응답하는 데이터를 응답 메시지의 body(본문) 에 지정하는 어노테이션
	 * @return
	 */
	@ResponseBody
	// Accept 가 기본이 html, xml 이라서 XML 로 응답
	@RequestMapping(value = "/response/data/board")
	// JSON 형식으로 응답
	// @RequestMapping(value = "/response/data/board",produces = "application/json")
	public Board responseBoard() {
		Board board = new Board("b01","제목","작성자","내용");
		return board;
	}
	
	/**
	 * JSON 으로 직접 데이터를 세팅하여 응답하기
	 * Board -> JSON
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/response/data/board/json")
	public void responseJSONBoard(HttpServletResponse response) throws IOException {
		Board board = new Board("b01","제목","작성자","내용");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(board);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}
	
	
	/**
	 * 브라우저에서 Accept 헤더의 값이 우선순위
	 * - text/html
	 * - application/xhtml+xml
	 * - application/xml
	 * - ...
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	// @RequestMapping("/response/data/board/list")
	@RequestMapping(value = "/response/data/board/list", produces = "application/json")
	public List<Board> responseBoardList() throws Exception {
		// produces = "application/json"
		// - Accept:application/xml 으로 요청이 와도, json 으로 응답할 수 있다.
		List<Board> boardList = boardService.list();
		return boardList;
	}
	
	
	@ResponseBody
	// @RequestMapping(value = "/resopnse/data/map")
	@RequestMapping(value = "/response/data/map", produces = "application/json")
	public Map<String, Board> responseMap() throws Exception {
		
		Map<String, Board> map = new HashMap<String, Board>();
		map.put("board1", new Board("b1", "제목1","작성자1","내용1"));
		map.put("board2", new Board("b2", "제목2","작성자2","내용2"));
		map.put("board3", new Board("b3", "제목3","작성자3","내용3"));
		
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping("/response/data/entity/void")
	public ResponseEntity<Void> responseEntityVoid() {
		// ResponseEntity
		// : 스프링 프레임워크에서 응답 헤더,본문,상태코드 등을 캡슐화하는 객체
		// ResponseEntity<Void>
		// : 헤더정보, 상태코드를 지정하여 사용할 수 있다.
		// HttpStatus 열거타입
		// : 상태코드를 가지고 있는 스프링프레임웤의 열거타입
		// - OK 						: 200
		// - NOT_FOUND 					: 404
		// - INTERNAL_SERVER_ERROR		: 500
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@ResponseBody
	@RequestMapping("/response/data/entity/string")
	public ResponseEntity<String> responseEntityString() {
		
		// new ResponseEntity<반환타입>(응답메시지, 상태코드);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	
	@ResponseBody
	@RequestMapping("/response/data/entity/board")
	public ResponseEntity<Board> responseEntityBoard() {
		Board board = new Board("b01","제목","작성자","내용");
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	
	@ResponseBody
	@RequestMapping("/response/data/entity/board/list")
	public ResponseEntity<List<Board>> responseEntityBoardList() throws Exception {
		List<Board> boardList = boardService.list();
		// return new ResponseEntity<>(boardList, HttpStatus.OK);		// <> 생략가능
		return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
	}
	
	
	@ResponseBody
	@RequestMapping("/response/data/entity/map")
	public ResponseEntity<Map<String, Board>> responseEntityBoardMap() throws Exception {
		
		List<Board> boardList = boardService.list();
		Map<String, Board> map = new HashMap<String, Board>();
		
		int i = 1;
		for (Board board : boardList) {
			map.put("board" + i++, board);
		}
				
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	
	/**
	 * 파일 다운로드
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/response/data/file")
	public ResponseEntity<byte[]> responseFile(HttpServletRequest request) throws Exception {
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/test.png");
		logger.info("path : " + path);
		
		// 파일 경로
		// String filePath = "E:\\TJE\\UPLOAD\\test.jpg";
		String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/test.png");
		String fileName = "test.png";
		// 헤더정보
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType( MediaType.IMAGE_JPEG );						// 이미지로 응답
		// headers.setContentType( MediaType.APPLICATION_OCTET_STREAM);		// 일반 프로그램 응답
		
		// headers.add("헤더명", "값")
		// Content-Disposition
		// - inline			: 웹페이지에서 출력(기본값)
		// - attachment		: 첨부파일 (다운로드)
		headers.add("Content-Disposition", "attachment; filename=" + fileName);	// 다운로드 여부, 파일명 지정
		
		byte[] fileData = null;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			// commons-io 라이브러리
			// toByteArray() : 파일을 바이트코드로 변환
			fileData = IOUtils.toByteArray(fis);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// new ResponseEntity<반환타입>(응답메시지, 헤더,상태코드);
		return new ResponseEntity<byte[]>(fileData, headers, HttpStatus.OK);
	}
}










