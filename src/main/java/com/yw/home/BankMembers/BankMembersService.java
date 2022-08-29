package com.yw.home.BankMembers;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yw.home.bankaccount.BankAccountDTO;
import com.yw.home.util.FileManger;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;

	@Autowired
	private FileManger fileManger;

//	@Autowired
//	private ServletContext servletContext;
//	@Autowired
//	private BankAccountDAO bankAccountDAO;

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getLogin(bankMembersDTO);
	}

	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, ServletContext servletContext)
			throws Exception {

		int result = bankMembersDAO.setJoin(bankMembersDTO);
		// 1. HDD에 파일을 저장
		// 파일 저장 시에 경로는 Tomcat기준이 아니라 OS의 기준으로 설정
		// 1) 파일저장 위치
		// /resoures/upload/member

//		// 2) 저장할 폴더의 실제경로 반환(OS 기준)
//		String realPath = servletContext.getRealPath("resources/upload/member");
//		System.out.println(realPath);
//
//		// 3) 저장할 폴더의 정보를 가지는 자바 객체 생성
//		File file = new File(realPath);
//
//		// *** File 첨부가 없을 때 구분
//		// if(photo.getSize() != 0) {}
//		if (!photo.isEmpty()) {
//
//			if (!file.exists()) {
//				file.mkdirs();
//			}
//
//			// 4) 중복되지 않는 파일명 생성
//			// -- 시간, java api, ...
//			String fileName = UUID.randomUUID().toString();
//
//			System.out.println(fileName);
//
//			Calendar ca = Calendar.getInstance();
//			Long time = ca.getTimeInMillis();
//
//			fileName = fileName + "_" + photo.getOriginalFilename();
//			System.out.println(fileName);
//
//			// 5. HDD에 파일 저장
//			// 어느 폴더에 어떤 이름을 저장할 File 객체 생성
//			file = new File(file, fileName);
//
//			// 1) MultipartFile 클래스의 transferTo 메서드 사용
//			photo.transferTo(file);
		// 2) File CopyUtils 클래스의 copy 메서드 사용

		// 2. 저장된 파일정보를 DB에 저장

		String path = "resources/upload/member";
		String fileName = fileManger.saveFile(servletContext, path, photo);
		if (!photo.isEmpty()) {
			BankMembersFileDTO bankmembersFileDTO = new BankMembersFileDTO();
			bankmembersFileDTO.setFileName(fileName);
			bankmembersFileDTO.setOriName(photo.getOriginalFilename());
			bankmembersFileDTO.setUserName(bankMembersDTO.getUserName());

			bankMembersDAO.setAddFile(bankmembersFileDTO);

		} // isEmpty 끝
		return result; // bankMembersDAO.setJoin(bankMembersDTO);
	}

	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		return bankMembersDAO.getSearchByID(search);
	}

	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}

//	public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//		map.put("list", ar);
//		map.put("dto", bankMembersDTO);
//
//		return map;
//	}

}
