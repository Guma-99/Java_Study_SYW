package com.yw.home.board.notice;

import com.yw.home.BankMembers.BankMembersFileDTO;
import com.yw.home.board.impl.BoardDTO;

public class NoticeDTO extends BoardDTO {
	private BankMembersFileDTO bankMembersFileDTO;

	public BankMembersFileDTO getBankMembersFileDTO() {
		return bankMembersFileDTO;
	}

	public void setBankMembersFileDTO(BankMembersFileDTO bankMembersFileDTO) {
		this.bankMembersFileDTO = bankMembersFileDTO;
	}
}
