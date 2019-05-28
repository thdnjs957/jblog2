package com.cafe24.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.PostVo;

@Repository
public class PostDao {
	
	@Autowired
	private SqlSession sqlSession;

	public List<PostVo> getList(Long categoryNo) {
		List<PostVo> result = sqlSession.selectList("post.getList");
		return result;
	}

	public PostVo getByNo() {
		PostVo result = sqlSession.selectOne("post.getByNo");
		return result;
	}

}
