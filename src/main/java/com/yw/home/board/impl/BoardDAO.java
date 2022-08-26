package com.yw.home.board.impl;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yw.home.util.Pager;

public interface BoardDAO {

	// 글목록
	public List<BoardDTO> getList(Pager pager) throws Exception;

	// 상세보기
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

	// 글쓰기
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files) throws Exception; 
	
	// 글수정
	public int setUpdate(BoardDTO boardDTO) throws Exception; 
	
	// 글삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	// 글 갯수
	public Long getCount(Pager pager) throws Exception;
	
}
