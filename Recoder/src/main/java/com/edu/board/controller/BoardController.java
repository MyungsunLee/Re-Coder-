package com.edu.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.edu.board.service.BoardService;


@Controller
public class BoardController {

	private final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
}
