package com.cafe24.jblog.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.jblog.service.BlogService;
import com.cafe24.jblog.vo.BlogVo;

@Controller
@RequestMapping("/{id:(?!assets).*}" )
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
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

	
}
