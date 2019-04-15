package com.edu.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.vo.MemberVo;

public interface MemberService {

	
	
	
	public MemberVo memberExist(Map<String, Object> paramMap);
	public void memberInsertOne(MemberVo memberVo);
	public Map<String, Object> memberSelectOne(int no);
	public int memberUpdateOne(MemberVo memberVo);
	
}
