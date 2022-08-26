package com.yw.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yw.home.board.impl.BoardDTO;
import com.yw.home.board.impl.BoardService;
import com.yw.home.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;

	// 글목록
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();

		return qnaDAO.getList(pager);
	}

	// 상세보기
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	// 글쓰기
	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		System.out.println("Insert 전: ");
		int result = qnaDAO.setAdd(boardDTO, files);
		System.out.println("Insert 후: ");

		return result;
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
	public int setReply(QnaDTO qnaDTO) throws Exception {

		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		QnaDTO parnet = (QnaDTO) boardDTO;

		qnaDTO.setRef(parnet.getRef());
		qnaDTO.setStep(parnet.getStep() + 1);
		qnaDTO.setDepth(parnet.getDepth() + 1);
		
		qnaDAO.setStepUpdate(parnet);
		int result = qnaDAO.setReplyAdd(qnaDTO);

		return result; 
	}

}
