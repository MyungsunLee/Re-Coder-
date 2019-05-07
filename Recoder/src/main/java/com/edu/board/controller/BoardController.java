package com.edu.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.board.service.BoardService;
import com.edu.board.vo.BoardVo;
import com.edu.board.vo.CommentVo;
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
      
//      List<Integer> commentTotCount = new ArrayList<Integer>();
		
//      	log.debug("boardList" + boardList.get(0).getBoardNo() + " , " + boardList.get(1).getBoardNo());
      for (int i = 0; i < boardList.size(); i++) {
    	  
    	  int commentTotCount = boardService.commentTotalList(boardList.get(i).getBoardNo());
    	  
    	  boardList.get(i).setCommentTotCount(commentTotCount);
    	  
    	  
	}
      
      
      
      
      model.addAttribute("boardList", boardList);
      model.addAttribute("paging", pagingMap);
      model.addAttribute("keyword", keyword);
      model.addAttribute("searchOption", searchOption);
      
      return "board/boardListView";
   }
   
   
   @RequestMapping(value="board/listOne.do",
         method= {RequestMethod.GET})
   public String boardSelectOne(int boardNo, Model model) {
      
	  Map<String, Object> map = boardService.boardSelectOne(boardNo);
	  List<CommentVo> commentList = boardService.commentSelectList(boardNo);
	  
	  BoardVo boardVo = (BoardVo)map.get("selectedBoard");
	  
	  @SuppressWarnings("unchecked")
	  List<Map<String,Object>> fileList = (List<Map<String, Object>>)map.get("fileList");
	  
	  int commentTotalCount = boardService.commentTotalList(boardNo);
	  
	  model.addAttribute("selectedBoard", boardVo);
	  model.addAttribute("fileList", fileList);
	  model.addAttribute("commentList",commentList);
	  model.addAttribute("commentTotCount", commentTotalCount);
//      BoardVo selectedBoard = boardService.boardSelectOne(boardNo);

      
      try {
//    	 selectedBoard.getRowNum()
    	  log.debug("selectedBoard.getRowNum : : {}", boardVo.getRowNum()); 
         BoardVo prevBoard = boardService.boardSelectOneSub((boardVo.getRowNum()+1));
         BoardVo nextBoard = boardService.boardSelectOneSub((boardVo.getRowNum()-1));
         
         model.addAttribute("prevBoard",   prevBoard);
         model.addAttribute("nextBoard",   nextBoard);
      } catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
      }
      
      
      
      
      
      
      return "board/boardListOneView";
   }
   
   @RequestMapping(value="board/addOne.do",method= {RequestMethod.GET})
   public String boardInsertOne(int memberNo, Model model) {
      
//      boardService.boardInsertOne(boardVo);
      model.addAttribute("memberNo", memberNo);
      
      return "board/boardAddForm";
   }
   
   @RequestMapping(value="board/addOneCtr.do",method= {RequestMethod.POST})
   public String boardInsertOneCtr(BoardVo boardVo,
		   			MultipartHttpServletRequest multipartHttpServletRequest,
		   			Model model) {
      
      log.debug("Welcome BoardController addOneCtr! added board number : {}", boardVo.getBoardNo());
      
      
      String content = boardVo.getBoardContent();
      
      content = content.replaceAll("\r\n", "<br>");
      
      boardVo.setBoardContent(content);
      
      try {
    	  boardService.boardInsertOne(boardVo, multipartHttpServletRequest);
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("오류처리");
		e.printStackTrace();
	}
      
      
      return "redirect:/board/list.do";
   }
   
   @SuppressWarnings("unchecked")
   @RequestMapping(value="board/updateOne.do"
//   ,method = {RequestMethod.GET}
   )
   public String boardUpdateOne(int boardNo, Model model) {
      log.debug("Welcome BoardController updateOne! ");
      
      Map<String, Object>map = boardService.boardSelectOne(boardNo); 
      
      BoardVo boardVo = (BoardVo)map.get("selectedBoard");
      List<Map<String, Object>> fileList = 
    		  (List<Map<String,Object>>)map.get("fileList");
      
      String content = boardVo.getBoardContent();
      content = content.replaceAll( "<br>","\r\n");
      boardVo.setBoardContent(content);
      
      model.addAttribute("selectedBoard", boardVo);
      model.addAttribute("fileList", fileList);
      
      return "board/boardUpdateView";
   }
   
   
   
   @RequestMapping(value="board/updateCtr.do", method= {RequestMethod.POST})
   public String boardUpdateCtr(HttpSession session, BoardVo boardVo,
		   					    @RequestParam(value="fileIdx", defaultValue="-1")int fileIdx,
		   					    MultipartHttpServletRequest multipartHttpServletRequest, Model model) {
      log.debug("Welcome BoardController updateOneCtr! boardNo : {} {}",boardVo,fileIdx);
      log.debug("                여백의 미");
      log.debug("updl 값 : {}", boardVo.getUpdl());
//      int resultNum = 0;

      String content = boardVo.getBoardContent();
      
      content = content.replaceAll("\r\n",  "<br>");
      boardVo.setBoardContent(content);
      
      try {
		boardService.boardUpdateOne(boardVo, multipartHttpServletRequest, fileIdx);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
      
      
     //데이터베이스에서 회원정보가 수정되었는지 여부 test
//      if (resultNum > 0) {
//		BoardVo sessionBoardVo = (BoardVo)session.getAttribute("_boardVo_");
		//세션에 객체가 존재하는지 여부
//		if (sessionBoardVo != null) {
			//세션의 값과 새로운 값이 일치하는지 여부. 
			//인데 수업했던 member의 경우엔 login session을 바꿔야 해서 이렇게 했지만
			//사실 board는 바꿀 게 없는 것 같음.
			//success 페이지로 갔다가 바로 list.do로 db 새로 불러오니 문제가 생기진 않을듯?
//		if (sessionBoardVo.getBoardNo() == boardVo.getBoardNo()) {
//			BoardVo newBoardVo = new BoardVo();
//			
//			newBoardVo.setBoardNo(boardVo.getBoardNo());
//			newBoardVo.setBoardTitle(boardVo.getBoardTitle());
//			newBoardVo.setBoardContent(boardVo.getBoardContent());
//			
//			session.removeAttribute("_boardVo_");
//			session.setAttribute("_boardVo_", boardVo);
//		}
//      }
//      }
      return "board/boardUpdateSuccess";
   }
   
   
   @RequestMapping(value = "/board/delete.do", method = RequestMethod.GET)
   public String boardDelete(int boardNo, Model model) {
      log.debug("Welcome boardController boardDelete ����! ");

      try {
         boardService.boardDeleteOne(boardNo);
      } catch (Exception e) {
         e.printStackTrace();
         
//        String viewUrl = 실패페이지
      }

      String viewUrl = "redirect:/board/list.do";

      return viewUrl;
   }
   
   @RequestMapping(value="/board/commentInsertOne.do", method=RequestMethod.POST)
   public String commentInsertOne(CommentVo commentVo, Model model) {
	   
	   
	   boardService.commentInsertOne(commentVo);
	   
	   int boardNo = commentVo.getBoardNo();
	   
	   Map<String, Object> map = boardService.boardSelectOne(boardNo);
		  List<CommentVo> commentList = boardService.commentSelectList(boardNo);
		  
		  BoardVo boardVo = (BoardVo)map.get("selectedBoard");
		  
		  @SuppressWarnings("unchecked")
		  List<Map<String,Object>> fileList = (List<Map<String, Object>>)map.get("fileList");
		  
		  int commentTotalCount = boardService.commentTotalList(boardNo);
		  
		  model.addAttribute("selectedBoard", boardVo);
		  model.addAttribute("fileList", fileList);
		  model.addAttribute("commentList",commentList);
		  model.addAttribute("commentTotCount", commentTotalCount);
	   
	   
	   
	   return "board/boardListOneView";
   }
   
   
   
   
   //미구현
   @RequestMapping(value="/board/commentDeleteOne.do", method=RequestMethod.GET)
   public String commentDeleteOne(int commentNo, int boardNo, Model model) {
	   
	   boardService.commentDeleteOne(commentNo);
	   
	      model.addAttribute(boardNo);
	   
		  return "redirect:/board/listOne.do?boardNo=" + boardNo;
   }
   
   @RequestMapping(value="/board/commentUpdateOne.do", method=RequestMethod.GET)
   public String commentUpdateOne(int commentNo, Model model) {
	   		
	   
	   
	   return "board/boardUpdateOne";
   }
   
   
   
}