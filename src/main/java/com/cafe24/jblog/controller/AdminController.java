package com.cafe24.jblog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog.service.BlogService;
import com.cafe24.jblog.service.CategoryService;
import com.cafe24.jblog.vo.CategoryVo;

//@Auth(role = Auth.Role.ADMIN)
@Controller
@RequestMapping("/{id}")
public class AdminController {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	CategoryService categoryService;
	
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
	
//	@RequestMapping(value="/join", method=RequestMethod.GET)
//	public String join(@ModelAttribute UserVo userVo) {
//		return "user/join";
//	} 
//	
//	@RequestMapping(value="/join", method=RequestMethod.POST)
//	public String join(@ModelAttribute @Valid UserVo userVo,BindingResult result, Model model) { //valid하고 만약 에러가 있으면 result에 담음
//		System.out.println("controller에서는 있나?"+userVo.getId());
//		if(result.hasErrors()) {
//			model.addAllAttributes(result.getModel());
//			return "/user/join";
//		}
//		
//		userService.join(userVo); //성공하면
//		return "redirect:/user/joinsuccess";
//	} 

}
