
package com.edu.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	String namespace = "com.edu.member.";


	@Override
	public MemberVo memberExist(MemberVo memberVo) {
		// TODO Auto-generated method stub

		return sqlSession.selectOne(namespace + "memberExist", memberVo);
	}

	@Override
	public int memberInsertOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "memberInsertOne", memberVo);
	}

	@Override
	public MemberVo memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberSelectOne", no);
	}

	@Override
	public int memberUpdateOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "memberUpdateOne", memberVo);
	}


}
