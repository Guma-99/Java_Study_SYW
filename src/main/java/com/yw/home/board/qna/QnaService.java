package com.yw.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yw.home.board.impl.BoardDTO;
import com.yw.home.board.impl.BoardService;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;

	// 글목록
	@Override
	public List<BoardDTO> getList() throws Exception {
		return qnaDAO.getList();
	}

	// 상세보기
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}
	
	// 글쓰기
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setAdd(boardDTO);
	}

	// 글 수정
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	// 글 삭제
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}
	
	// 댓글
	public int setReply(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setReply(boardDTO);
	}
}
