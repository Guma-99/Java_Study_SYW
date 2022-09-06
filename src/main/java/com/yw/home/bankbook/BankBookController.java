package com.yw.home.bankbook;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yw.home.util.CommentPager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;

	// ------------------------ Comment ------------------------

//	@RequestMapping(value = "commentList", method = RequestMethod.GET)
//	public ModelAndView getcommentList(CommentPager commentPager) throws Exception {
//		ModelAndView mv = new ModelAndView();
//
//		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
//		System.out.println("CommentList");
//		System.out.println(ar.size());
//
//		mv.addObject("commentList", ar);
//		mv.setViewName("common/commentList");
//
//		return mv;
//
//	}

	@RequestMapping(value = "commentList", method = RequestMethod.GET)
	@ResponseBody
	public List<BankBookCommentDTO> commentList(CommentPager commentPager) throws Exception {
		ModelAndView mv = new ModelAndView();

		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
		System.out.println("CommentList");
		System.out.println(ar.size());
		
		// json
		// DTO == {}
		// num = 1 == {"num":1, "bookNum":123, "writer":"name"}
		//[{}]


		return ar;

	}

	@RequestMapping(value = "commentAdd", method = RequestMethod.POST)
	@ResponseBody // jsp를 안거치고 body에 바로 담아 응답으로 내보내겠다.
	public String commentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {

		ModelAndView mv = new ModelAndView();

		System.out.println("booknum=" + bankBookCommentDTO.getBookNum());
		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
		if (result > 0) {
			System.out.println("뱅크북 커멘드 성공!");
		} else {
			System.out.println("뱅크북 커멘드 실패!");
		}

		String jsonResult = "{\"result\":\"" + result + "\"}";
		// mv.addObject("result", result);
		// mv.setViewName("common/ajaxResult");
		return jsonResult;

	}

	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		System.out.println("List");
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar);
	}

	@RequestMapping(value = "detail.do", method = RequestMethod.GET)
	public ModelAndView getDetail(BankBookDTO bankBookDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Detail");
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		session.setAttribute("one", bankBookDTO);
		mv.setViewName("bankbook/detail");
		return mv;
	}

	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public void addBook() {
		System.out.println("add GET");
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public ModelAndView addBook(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("add POST");
		Calendar cal = Calendar.getInstance();
		bankBookDTO.setBookNum((Long) cal.getTimeInMillis());
		int result = bankBookService.setBook(bankBookDTO);
		if (result == 1) {
			System.out.println("계좌 추가 성공");
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list.do");
		return mv;
	}

	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception {
		System.out.println("update GET");
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBookNum());
		model.addAttribute("update", bankBookDTO);
	}

	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("update POST");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:./update.do");
		int result = bankBookService.setUpdate(bankBookDTO);
		if (result > 0) {
			System.out.println("성공");
			modelAndView.setViewName("redirect:./detail.do?bookNum=" + bankBookDTO.getBookNum());
		}
		return modelAndView;
	}

	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("delete");
		ModelAndView modelAndView = new ModelAndView();
		int result = bankBookService.deleteBook(bankBookDTO);
		System.out.println(result);
		if (result > 0) {
			System.out.println("성공");
			modelAndView.setViewName("redirect:./list.do");
		}
		return modelAndView;

	}

}
