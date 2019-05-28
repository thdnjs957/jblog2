package com.cafe24.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.repository.CategoryDao;
import com.cafe24.jblog.repository.PostDao;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Service
public class BlogService {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	PostDao postDao;
	
	@Autowired
	BlogDao blogDao;
	
	public Map<String,Object> getAll(String id, Long categoryNo, Long postNo) {
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		//id에 해당하는 blog 정보 가져오기
		BlogVo blogVo = blogDao.get(id);
		
		//카테고리 리스트 : id에 해당하는  category 다 가져오기
		//List<CategoryVo> categoryList = categoryDao.getList(id);
		
		//포스트 리스트 : category no에 해당하는 post 다 가져오기
		//List<PostVo> postList = postDao.getList(categoryNo);
		
		//포스트 정보 :  postNo에 해당하는 자기 포스트 정보 다 가져오기
		//PostVo postVo = postDao.getByNo();
		
		map.put("blogVo",blogVo);
		//map.put("categoryList", categoryList);
		//map.put("postList", postList);
		//map.put("postVo",postVo);
		
		return map;
		
	}

}
