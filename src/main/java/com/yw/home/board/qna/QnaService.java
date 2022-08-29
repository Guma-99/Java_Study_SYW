package com.yw.home.board.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yw.home.board.impl.BoardDTO;
import com.yw.home.board.impl.BoardFileDTO;
import com.yw.home.board.impl.BoardService;
import com.yw.home.util.FileManger;
import com.yw.home.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManger fileManger;

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
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception {
		System.out.println("Insert 전: " + boardDTO.getNum());
		int result = qnaDAO.setAdd(boardDTO);
		System.out.println("Insert 후: " + boardDTO.getNum());
		
		String path = " resources/upload/qna";
		
		for(MultipartFile multipartFile: files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManger.saveFile(servletContext, path, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
		}

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
