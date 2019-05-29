package com.cafe24.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.CategoryDao;
import com.cafe24.jblog.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao categoryDao;

	public boolean insertCategory(CategoryVo categoryVo) {
		
		return categoryDao.insert(categoryVo);
	}

	public List<CategoryVo> getList(String id) {
		return categoryDao.getList(id);
	}

	
}
