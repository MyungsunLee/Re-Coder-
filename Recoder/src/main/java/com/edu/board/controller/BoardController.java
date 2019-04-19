package com.edu.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.board.service.BoardService;
import com.edu.board.vo.BoardVo;
import com.edu.util.Paging;


@Controller
public class BoardController {

	private final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/list.do"
				, method= {RequestMethod.GET, RequestMethod.POST})
	public String boardList(
		@RequestParam(defaultValue="1")int curPage,
		@RequestParam(defaultValue="")String searchOption,
		@RequestParam(defaultValue="") String keyword,
		Model model){
		
		log.debug("Welcome BoardController boarList! : {}", curPage);
		log.debug("searchOption : {}",searchOption);
		log.debug("keyword : {}",keyword);
		
		int totalCount = 0;
		
		totalCount = boardService.boardCountTotal(searchOption, keyword);
		
		Paging boardPaging = new Paging(totalCount, curPage);
		int start = boardPaging.getPageBegin();
		int end = boardPaging.getPageEnd();
		
		List<BoardVo> boardList = boardService.boardSelectList(searchOption, keyword, start, end);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("boardPaging", boardPaging);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("paging", pagingMap);
		model.addAttribute("keyword", keyword);
		model.addAttribute("searchOption", searchOption);
		
		return "board/boardListView";
	}
	
	
	@RequestMapping(value="board/listOne.do",
			method= {RequestMethod.GET})
	public String boardSelectOne(int no, Model model) {
		
		BoardVo selectedBoard = boardService.boardSelectOne(no);
		
		model.addAttribute("selectedBoard",	 selectedBoard);
		
		
		
		return "board/boardListOneView";
	}
	
	@RequestMapping(value="board/addOne.do",method= {RequestMethod.GET})
	public String boardInsertOne(int memberNo, Model model) {
		
//		boardService.boardInsertOne(boardVo);
		model.addAttribute("memberNo", memberNo);
		
		return "board/boardForm";
	}
	
	
	
	
	
	
	
	
}
