package com.yw.home.BankMembers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class BankMembersController {

	@Autowired
	private BankMembersService bankMembersService;
	
	@GetMapping("agree")
	public String getAgree() throws Exception {
		
		return "member/agree";
	}

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		System.out.println("Login Get 실행");

		return "member/login";
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, BankMembersDTO bankMembersDTO, Model model) throws Exception {
		System.out.println("Login Post 실행");

		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);

		HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);

		return "redirect:../";
	}

	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();

		return "redirect:../";
	}

	@RequestMapping(value = "join.do", method = RequestMethod.GET)
	public String join() {
		System.out.println("Join Get 실행");

		return "member/join";
	}

	// Post
	@RequestMapping(value = "join.do", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception {
		System.out.println("Join Post 실행");
		System.out.println(photo);
		
		System.out.println("upload 파일명: " + photo.getOriginalFilename());
		System.out.println("upload 파라미터명: " + photo.getName());
		System.out.println("upload 파일 크기: " + photo.getSize());
		
		int result = bankMembersService.setJoin(bankMembersDTO, photo, session.getServletContext());
		//System.out.println(result == 1);

		return "redirect:../member/login.do";
	}

	@RequestMapping(value = "search.do", method = RequestMethod.GET)
	public String getSearchByID() {
		System.out.println("Search Get 실행");

		return "member/search";
	}

	@RequestMapping(value = "search.do", method = RequestMethod.POST)
	public ModelAndView getSearchByID(String search) throws Exception {
		System.out.println("Search Post 실행");
		List<BankMembersDTO> ar = bankMembersService.getSearchByID(search);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/list");
		mv.addObject("list", ar);

		return mv;
	}

	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public String list() {
		System.out.println("List Get 실행");

		return "member/list";
	}

	@RequestMapping(value = "myPage.do", method = RequestMethod.GET)
	public ModelAndView myPage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();

		System.out.println("MyPage Get 실행");

		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
//		Map<String, Object> map = bankMembersService.getMyPage(bankMembersDTO);
//		mv.addObject("map", map);
		
		bankMembersDTO = bankMembersService.getMyPage(bankMembersDTO);
		System.out.println(bankMembersDTO.getBankMembersFileDTO().getFileName());
		
		mv.addObject("dto", bankMembersDTO);
		
		mv.setViewName("member/myPage");

		return mv;
	}
}
