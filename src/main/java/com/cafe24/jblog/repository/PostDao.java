package com.cafe24.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.PostVo;

@Repository
public class PostDao {
	
	@Autowired
	private SqlSession sqlSession;

	public List<PostVo> getList(Long categoryNo) {
		List<PostVo> result = sqlSession.selectList("post.getList",categoryNo);
		return result;
	}
	
	public List<PostVo> getListDefault() {
		List<PostVo> result = sqlSession.selectList("post.getListDefault");
		return result;
	}

	public PostVo getByNo() {
		PostVo result = sqlSession.selectOne("post.getByNo");
		return result;
	}

	public boolean insert(PostVo postVo) {
		int count = sqlSession.insert("post.insert",postVo);
		return 1 == count;
	}
	
	public PostVo getCategoryPost(Map<String, Object> map) {
		PostVo postvo = sqlSession.selectOne("post.getCategoryPost",map);
		return postvo;
		
	}

	public PostVo getCategoryPostDefault(String id) {
		PostVo postvo = sqlSession.selectOne("post.getCategoryPostDefault",id);
		return postvo;
	}

}
