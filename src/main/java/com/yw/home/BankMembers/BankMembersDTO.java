package com.yw.home.BankMembers;

import java.util.List;

import com.yw.home.bankaccount.BankAccountDTO;
import com.yw.home.file.FileDTO;

public class BankMembersDTO {
	private String userName;
	private String password;
	private String name;
	private String email;
	private String phone;
	private List<BankAccountDTO> bankAccountDTO;
	private BankMembersFileDTO bankMembersFileDTO;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<BankAccountDTO> getBankAccountDTO() {
		return bankAccountDTO;
	}
	public void setBankAccountDTO(List<BankAccountDTO> bankAccountDTO) {
		this.bankAccountDTO = bankAccountDTO;
	}
	public BankMembersFileDTO getBankMembersFileDTO() {
		return bankMembersFileDTO;
	}
	public void setBankMembersFileDTO(BankMembersFileDTO bankMembersFileDTO) {
		this.bankMembersFileDTO = bankMembersFileDTO;
	}
	
}
