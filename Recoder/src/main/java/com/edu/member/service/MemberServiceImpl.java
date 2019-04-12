package com.edu.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.member.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	public MemberDao memberDao;
}
