package com.yw.home.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yw.home.board.impl.BoardDTO;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board ")
	public String getBoard() {
		
		return "Notice";
	}

	// 글목록
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(@RequestParam(defaultValue = "1") Long page) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList(page);
		System.out.println("page: " + page);
		
		mv.addObject("list", ar);
		mv.addObject("board", "Notice");
		mv.setViewName("board/list");
		
		
		return mv;
		
	}
	
	// 상세보기
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);
		
		model.addAttribute("boardDTO", boardDTO);
		
		return "board/detail";
				
	}
	
	// 글쓰기
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setAdd() throws Exception {
		
		return "board/add";
		
	}
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
	
		int result = noticeService.setAdd(boardDTO);
		
		mv.setViewName("redirect:./list");
		
		return mv;
		
	}
	
	// 글 수정
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/update");
		
		return mv;
		
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		
		return "redirect:./detail?num="+boardDTO.getNum();
		
	}
	
	// 글 삭제
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setDelete(boardDTO);
		
		return "redirect:./list";
		
	}
}
