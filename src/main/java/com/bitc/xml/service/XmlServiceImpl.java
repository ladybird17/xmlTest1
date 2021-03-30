package com.bitc.xml.service;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.bitc.xml.dto.MemberDto;
import com.bitc.xml.dto.MemberListDto;

@Service
public class XmlServiceImpl implements XmlService {

	@Override
	public List<MemberDto> getMemberList() throws Exception {
		
		//JAXB 라이브러리 사용 선언
		JAXBContext jc = JAXBContext.newInstance(MemberListDto.class);
		
		/*
		JAXB 라이브러리를 사용하여 XML 데이터를 자바 클래스 형태로 변환하는 언마샬 클래스 사용
		*/
		Unmarshaller um = jc.createUnmarshaller();
		
		/*
		기존에 제공된 xml 데이터를 기반으로 
		MemberListDto 클래스를 생성했으므로
		xml 파일을 파싱하여 가지고 온 데이터를
		MemberListDto 클래스 타입으로 형변환하여 사용
		
		-Jaxb라이브러리의 언마샬은 기본적으로 Object 타입으로 데이터를 반환하기때문에 형변환해야함
		*/
		MemberListDto memberList = (MemberListDto)um.unmarshal(new File("C://java102//memberlist.xml"));
		
		List<MemberDto> list = memberList.getMemberList();
		
		/*
		//데이터확인용
		for(MemberDto member : list) {
			System.out.println("ID : "+member.getId());
			System.out.println("NO : "+member.getNo());
			System.out.println("Name : "+member.getName());
			System.out.println("Gender : "+member.getGender());
			System.out.println("Job : "+member.getJob());
			System.out.println("---------------------------------");
		}
		*/
		
		return list;
	}

}
