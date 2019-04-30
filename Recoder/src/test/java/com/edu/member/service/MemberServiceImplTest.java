package com.edu.member.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.member.dao.MemberDao;
import com.edu.member.vo.MemberVo;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class MemberServiceImplTest {

//	private final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	public MemberDao memberDao;
	@Autowired
	public MemberServiceImpl memberServiceImple;


//	@Override
//	public MemberVo memberExist(MemberVo memberVo) {
//		// TODO Auto-generated method stub
//		return memberDao.memberExist(memberVo);
//	}
//
//	@Override
//	public void memberInsertOne(MemberVo memberVo) {
//		// TODO Auto-generated method stub
//
//		memberDao.memberInsertOne(memberVo);
//	}
//
//	@Override
//	public Map<String, Object> memberSelectOne(int no) {
//		// TODO Auto-generated method stub
//
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//
//		MemberVo memberVo = memberDao.memberSelectOne(no);
//		resultMap.put("memberVo", memberVo);
//
//		return resultMap;
//	}
//
//	@Test
//	public void testMemberUpdateOne() {
//		// TODO Auto-generated method stub
//		//106	U 	11	11	11	19/04/29
//		MemberVo memberVo = new MemberVo(106, 'U', "11", "11", null);
//		int resultNum = 0;
//
//		resultNum = memberDao.memberUpdateOne(memberVo);
//		
//		Assert.assertEquals("실패하면 사용될 메시지: ", "FAIL", resultNum);
////		106 U 이메일 수정후 이름 19/04/29
//
//	}
	
	@Test
	public void memberSelectOne() {
		// TODO Auto-generated method stub
		//101	U 	76	76	76	19/04/24
		int no = 101;

		MemberVo memberVo = memberServiceImple.memberSelectOne(no);
		Assert.assertEquals(memberVo.getMemberNo(), 101);
		Assert.assertEquals(memberVo.getMemberName(), "76");
		Assert.assertEquals(memberVo.getMemberEmail(), "76");
//		MEMBER_NO, MEMBER_NAME, MEMBER_EMAIL, MEMBER_DATE
//		101 가져와
	}

}
