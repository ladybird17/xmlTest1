package com.bitc.xml.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.xml.dto.MemberDto;
import com.bitc.xml.service.XmlService;

@Controller
public class XmlController {
	
	@Autowired
	private XmlService xmlService;
	
	/*
	jaxb : 자바에서 xml 데이터를 파싱하도록 도와주는 라이브러리
	Marshal : 자바 클래스를 XML 데이터로 변경
	UnMarsharl : XML 데이터를 자바 클래스로 변경
	
	자바는 기본적으로 XML을 인식 못하기 때문에 표시해줘야함.
	
	@XmlRootElement : xml 데이터에서 부모가 되는 태그
	@XmlElement : xml 데이터에서 실제 데이터가 들어가있는 태그
	@XmlAttribute : xml 데이터에서 지정한 태그의 속성
	 */
	@RequestMapping(value="/file/xmlFile1", method=RequestMethod.GET)
	public ModelAndView xmlFile1() throws Exception{
		
		ModelAndView mv = new ModelAndView("/file/xmlFile1");
		
		List<MemberDto> list = xmlService.getMemberList();
		mv.addObject("xmlDatas", list);
		
		//XML파일을 parsing하기 실습 첫번째
		return mv;
		
	}
	
	//ajax쓸때 ResponseBody를 꼭 써줘야 원하는 값을 return 할 수 있음.
	//안쓰면 return값이라는 이름의 html파일을 찾는다.
	@ResponseBody
	@RequestMapping(value="/file/xmlFile2",method=RequestMethod.POST)
	public Object xmlFile2() throws Exception{
		List<MemberDto> list = xmlService.getMemberList();
		return list;
	}
}
