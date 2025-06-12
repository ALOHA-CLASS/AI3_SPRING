package com.aloha.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aloha.spring.dao.BoardDAO;
import com.aloha.spring.dto.Board;
import com.aloha.spring.service.BoardService;
import com.aloha.spring.service.BoardServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller			// 컨트롤러 역할을 하는 스프링 빈으로 등록
public class HomeController {
	
	// 로거
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private BoardService boardService;
	
	// 빈으로 등록된 BoardServiceImpl 을 HomeController 에 자동 주입
	@Autowired
	public HomeController(BoardService boardService, BoardDAO boardDAO) {
		this.boardService = boardService;
	}

	// 요청 경로 매핑 : "/" ---> home() 컨트롤러 메소드로 연결
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		// 뷰에 데이터를 전달
		model.addAttribute("serverTime", formattedDate );
		
		// 게시글 목록 조회 요청
		List<Board> boardList = boardService.list();
		model.addAttribute("boardList", boardList);
		
		if( boardList != null ) {
			for (Board board : boardList) {
				logger.info("board - " + board);
			}
		}
		
		// home.jsp 를 지정
		return "home";
	}
	
}
