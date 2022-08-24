package com.yw.home.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yw.home.board.impl.BoardDTO;
import com.yw.home.board.impl.BoardService;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;

	// 글목록
	@Override
	public List<BoardDTO> getList(Long page) throws Exception {
		System.out.println("Service page: " + page);

		Long perPage = 10L; // 한페이지에 출력할 목록의 갯수
		// 페이지에 10개씩 출력 기준
		// page startRow lastRow
		// 1 1 10
		// 2 11 20
		// 3 21 30
		Long startRow = (page - 1) * perPage + 1;
		Long lastRow = page * perPage;

		System.out.println("StartRow: " + startRow);
		System.out.println("lastRow: " + lastRow);

		Map<String, Long> map = new HashMap<String, Long>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);

		/****************************
		 * 
		 * 글의 갯수가 총 80개 
		 * 1 - 10 
		 * 2 - 10
		 * 
		 *
		 *
		 */

		return noticeDAO.getList(map);
	}

	// 상세보기
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	// 글쓰기
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setAdd(boardDTO);
	}

	// 글 수정
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	// 글 삭제
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}

}
