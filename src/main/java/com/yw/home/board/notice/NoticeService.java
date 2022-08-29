package com.yw.home.board.notice;

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
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManger fileManger;

	// 글목록
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
//		System.out.println("Service page: " + page);
//
//		Long perPage = 10L; // 한페이지에 출력할 목록의 갯수
//		// 페이지에 10개씩 출력 기준
//		// page startRow lastRow
//		// 1 1 10
//		// 2 11 20
//		// 3 21 30
//		Long startRow = (page - 1) * perPage + 1;
//		Long lastRow = page * perPage;
//
//		System.out.println("StartRow: " + startRow);
//		System.out.println("lastRow: " + lastRow);
//
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//
//		/****************************
//		 * JSP에 페이지번호를 출력 1 - ?
//		 * 1. 글의 총갯수
//		 * 2. 글의 총갯수를 이용해서 총 페이지 수 구하기
//		 * 3. 
//		 *
//		***********************************/
//		/************************************
//		 * 1. 글의 총갯수
//		 *************************************/
//		Long totalCount = noticeDAO.getCount();
//		
//		/************************************
//		 * 2. 글의 총 페이지 수
//		 *************************************/
//		Long totalPage = totalCount / perPage;
//		if (totalCount%perPage != 0) {
//			totalPage++;
//		}
//		
//		/*************************************
//		 * 3. totalBlock 갯수 구하기
//		 * Block      :  
//		 * perBlock : 합페이지에 출력할 번호의 수
//		 ***********************************/
//		Long perBlock = 5L;
//		Long totalBlock = totalPage/perBlock;
//		if(totalPage%perBlock != 0) {
//			totalBlock++;
//		}
//		
//		/*************************************
//		 * 4. page로 현재 Block 번호 찾기
//		 * page				curBlock
//		 * 1					1
//		 * 2					1
//		 * 3					1
//		 * 4					1
//		 * 5					1
//		 * 6					2
//		 * ~ 10				2
//		 * 11					3
//		 ***********************************/
//		Long curBlock = page/perBlock;
//		if(page%perBlock != 0) {
//			curBlock++;
//		}
//		
//		/*************************************
//		 * 5. curBlock로 시작번호와 끝번호 알아오기
//		 * 
//		 * curBlock		startNum			lastNum
//		 * 1					1						5
//		 * 2					6						10
//		 * 3					11						15
//		 * 	4					16						20
//		 ***********************************/
//		Long startNum = (curBlock - 1) * perBlock + 1;
//		Long lastNum = curBlock * perBlock; 
//		
//		System.out.println("총 페이지 : " + totalPage);

		return noticeDAO.getList(pager);
	}

	// 상세보기
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	// 글쓰기
	@Override
public int setAdd(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception {
		
		int result = noticeDAO.setAdd(boardDTO);
		String path = "resources/upload/notice";
		
		for(MultipartFile multipartFile: files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
		String fileName = 	fileManger.saveFile(servletContext, path, multipartFile);
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOriName(multipartFile.getOriginalFilename());
		boardFileDTO.setNum(boardDTO.getNum());
		noticeDAO.setAddFile(boardFileDTO);
		}
		
		return result;//
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
