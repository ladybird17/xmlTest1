package com.bitc.xml.service;

import java.util.List;

import com.bitc.xml.dto.MemberDto;

public interface XmlService {
	List<MemberDto> getMemberList() throws Exception;
}
