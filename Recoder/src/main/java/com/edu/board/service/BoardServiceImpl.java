package com.edu.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.board.dao.BoardDao;
import com.edu.board.vo.BoardVo;
import com.edu.board.vo.CommentVo;
import com.edu.util.FileUtils;

@Service
public class BoardServiceImpl implements BoardService {

	private final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	public BoardDao boardDao;

	@Resource(name = "fileUtils")
	private FileUtils fileUtils;

	@Override
	public List<BoardVo> boardSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return boardDao.boardSelectList(searchOption, keyword, start, end);
	}

	@Override
	public Map<String, Object> boardSelectOne(int no) {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();

		BoardVo boardVo = boardDao.boardSelectOne(no);
		resultMap.put("selectedBoard", boardVo);

		List<Map<String, Object>> fileList = boardDao.fileSelectList(no);
		resultMap.put("fileList", fileList);

		return resultMap;
	}

//   @Override
//   public int boardInsertOne(BoardVo boardVo) {
//      // TODO Auto-generated method stub
//      return boardDao.boardInsertOne(boardVo);
//   }

	@Transactional
	@Override
	public void boardInsertOne(BoardVo boardVo, MultipartHttpServletRequest multipartHttpServletRequest)
			throws Exception {
		// TODO Auto-generated method stub
		boardDao.boardInsertOne(boardVo);

		int parentSeq = boardVo.getBoardNo();
		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(parentSeq, multipartHttpServletRequest);

		log.debug("BoardServiceImpl boardInsertOne enter!! {}", list);

		for (int i = 0; i < list.size(); i++) { // 한번만 돎
			boardDao.insertFile(list.get(i)); // db에 넣음
		}
	}
	@Transactional
	@Override
	public int boardUpdateOne(BoardVo boardVo, MultipartHttpServletRequest multipartHttpServletRequest, int fileIdx)
			throws Exception {
		// TODO Auto-generated method stub
		int resultNum = 0;
		try {
			
			//게시글 먼저 update
			resultNum = boardDao.boardUpdateOne(boardVo);

			//게시글 번호 뽑아내기
			int parentSeq = boardVo.getBoardNo();
			
			//업데이트 시
			if (boardVo.getUpdl().equals("update")) {
				
				
				//게시글 번호로 있는 이미지 있는거 담음(없으면 안담음)
				Map<String, Object> tempFileMap = boardDao.fileSelectStoredFileName(parentSeq);
				
				
				List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(parentSeq, multipartHttpServletRequest);
				
				// 1. 게시글에 이미 파일이 있을경우
				if (tempFileMap != null) {
					
					fileUtils.parseUpdateFileInfo(tempFileMap);
					boardDao.fileDelete(parentSeq);
				}
				
				
				
				for (int i = 0; i < list.size(); i++) { // 한번만 돎
					boardDao.insertFile(list.get(i));
				}
				
			//삭제 시
			} else if (boardVo.getUpdl().equals("delete")) {
				Map<String, Object> tempFileMap = boardDao.fileSelectStoredFileName(parentSeq);
				
				List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(parentSeq, multipartHttpServletRequest);
				
					boardDao.fileDelete(parentSeq);
					fileUtils.parseUpdateFileInfo(tempFileMap);
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("=================================");
			e.printStackTrace();
 			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		}

		return resultNum;
	}

	@Override
	public int boardCountTotal(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);

		return boardDao.boardCountTotal(map);
	}

	@Override
	public void boardDeleteOne(int boardNo) {
		

		try {
			boardDao.commentDeleteList(boardNo);
			boardDao.boardDeleteOne(boardNo);

		} catch (Exception e) {
			//try-catch 통해 sql 하나라도 수행이 안될 시 롤백
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	@Override
	public BoardVo boardSelectOneSub(int rNum) {
		// TODO Auto-generated method stub
		return boardDao.boardSelectOneSub(rNum);
	}

	@Override
	public List<CommentVo> commentSelectList(int boardNo) {
		// TODO Auto-generated method stub
		return boardDao.commentSelectList(boardNo);
	}

	@Override
	public int commentInsertOne(CommentVo commentVo) {
		// TODO Auto-generated method stub
		return boardDao.commentInsertOne(commentVo);
	}

	@Override
	public int commentUpdateOne(CommentVo commentVo) {
		// TODO Auto-generated method stub
		return boardDao.commentUpdateOne(commentVo);
	}

	@Override
	public int commentDeleteOne(int commentNo) {
		// TODO Auto-generated method stub

		return boardDao.commentDeleteOne(commentNo);
	}

	@Override
	public int commentTotalList(int boardNo) {
		// TODO Auto-generated method stub
		return boardDao.commentTotalList(boardNo);
	}
}