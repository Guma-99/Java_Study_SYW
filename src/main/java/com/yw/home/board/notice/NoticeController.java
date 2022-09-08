package com.yw.home.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yw.home.BankMembers.BankMembersDTO;
import com.yw.home.board.impl.BoardDTO;
import com.yw.home.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@ModelAttribute("board")
	public String getBoard() {

		return "notice";
	}

	// 글목록
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getPage());

		System.out.println("1: " + pager.getKind());
		System.out.println("2: " + pager.getSearch());
		// System.out.println(pager.get);
//		List<BoardDTO> ar = noticeService.getList(page);
//		System.out.println("page: " + page);

		List<BoardDTO> ar = noticeService.getList(pager);

		mv.addObject("list", ar);
		mv.addObject("pager", pager);
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
	public String setAdd(HttpSession session) throws Exception {
		BankMembersDTO bankMembersDTO =  (BankMembersDTO)session.getAttribute("member");
		
		if(bankMembersDTO != null) {
			return "board/add";
		} else {
			return "../member/login.do";
		}

		

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		System.out.println("noticeUpload 파일명: " + files);
		
		int result = noticeService.setAdd(boardDTO, files, session.getServletContext());
		
		String message = "등록 실패!";
		if(result > 0) {
			message = "등록 성공!";
		}
		
		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", "list");
		
		mv.setViewName("common/result");

		//mv.setViewName("redirect:./list");

		return mv;

	}

	// 글 수정
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);

		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/update");

		return mv;

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setUpdate(boardDTO);

		return "redirect:./detail?num=" + boardDTO.getNum();
		
	}

	// 글 삭제
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setDelete(boardDTO);

		return "redirect:./list";

	}
	
}
