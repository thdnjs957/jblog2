package com.cafe24.jblog.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog.service.BlogService;
import com.cafe24.jblog.service.CategoryService;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/{id:(?!assets).*}" )
public class BlogController {
	
	@Autowired
	BlogService blogService;
	

	@Autowired
	CategoryService categoryService;
	
	
	@RequestMapping({"","/{pathNo1}","/{pathNo1}/{pathNo2}"})
	public String index(@PathVariable String id, 
						@PathVariable Optional<Long> pathNo1, 
						@PathVariable Optional<Long> pathNo2,
		    			Model model)
	{
		Long categoryNo = 0L;
		Long postNo = 0L;
		if(pathNo2.isPresent()) {
			categoryNo = pathNo1.get();
			postNo = pathNo2.get();
		}else if(pathNo1.isPresent()) {
			categoryNo = pathNo1.get();
		}
		
		Map<String,Object> map  = blogService.getAll(id,categoryNo,postNo);
		
		BlogVo blogVo = (BlogVo) map.get("blogVo");
		
		model.addAttribute("blogVo",blogVo);
		
		return "blog/blog-main";
	}
	
	
	@RequestMapping("/admin/basic")
	public String adminBasic(@PathVariable String id) {
		
		
		return "blog/blog-admin-basic";
	}
	
	
	@RequestMapping("/admin/category")
	public String adminCategory(@PathVariable String id) {
		
		//blogService.existEmail(email);
		
		//JSONResult result = new JSONResult.success(exist);
		
		/*
		 * Map<String,Object> map = new HashMap<String, Object>();
		 * 
		 * map.put("result", "success"); map.put("data",exist);
		 */
		
		
		return "blog/blog-admin-category";
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/category", method=RequestMethod.POST)
	public String adminCategory(@ModelAttribute CategoryVo categoryVo) {
		
		System.out.println("***");
		
		boolean result = categoryService.insertCategory(categoryVo);
		
		if(result) {
			return "success";
		}
		
		return "fail";
	}
	
	
	@RequestMapping("/admin/write")
	public String adminWrite(@PathVariable String id) {
		
		return "blog/blog-admin-write";
	}
	

	
}
