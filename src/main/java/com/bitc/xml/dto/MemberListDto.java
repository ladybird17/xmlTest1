package com.bitc.xml.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="memberlist")
public class MemberListDto {
	private List<MemberDto> memberList;
	
	@XmlElement(name="member")
	public List<MemberDto> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberDto> memberList) {
		this.memberList = memberList;
	}
	
	
}
