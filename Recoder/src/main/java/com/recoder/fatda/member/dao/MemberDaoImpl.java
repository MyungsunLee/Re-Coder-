
package com.recoder.fatda.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recoder.fatda.member.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	String namespace = "com.recoder.fatda.member.";


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

	@Override
	public List<MemberVo> memberSelectList(String searchOption, String keyword, int start, int end, String order) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + "memberSelectList", map);
	}

	@Override
	public int memberCountTotal(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberSelectTotalCount", map);
	}

	@Override
	public int memberDeleteOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+"memberDeleteOne", no);
	}

	@Override
	public MemberVo memberExistCheck(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberExistCheck", memberVo);
	}


}
