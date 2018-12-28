package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	 @RequestMapping("/test")
	 @ResponseBody
	public Date say(Date date) {
		 
		 
		 System.out.println("dddddd");
	        return date;
	    }
	 @RequestMapping("/data")
	    @ResponseBody
	    public String getData() {
		 
		 System.out.println("dddddd");
	        return getClass().getName().toString();
	    }
	
	 @RequestMapping("/xmlOrJson")
	 @ResponseBody
	 public Map<String, Object> xmlOrJson() {
	 	
	     Map<String, Object> map = new HashMap<String, Object>();
	     Emplovee em = new Emplovee();
	     em.setId(1);
	     em.setName("tom");
	     em.setAge(23);
	     map.put("list",em);
	     return map;
	 }

	/**
	 * 自定义注解实现参数得解析
	 * @param dept
	 * @param emp
	 * @return
	 */
	@RequestMapping("/test1")
	@ResponseBody
	public String test1(@FormObj Dept dept, @FormObj Emplovee emp) {
		return dept.toString()+emp.toString();
	}

	@RequestMapping("/test2")
	@ResponseBody
	public String test2(@FormObj("d") Dept dept, @FormObj("e") Emplovee emp) {
		return dept.toString()+emp.toString();
	}

	@RequestMapping("/test3")
	@ResponseBody
	public String test3(@FormObj(value = "d", show = false) Dept dept, @FormObj("e") Emplovee emp) {
		return dept.toString()+emp.toString();
	}

	/**
	 * 对时间参数得转化
	 * @param binder
	 */
	 @InitBinder
	 public void initBinder(WebDataBinder binder){
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 binder.registerCustomEditor(Date.class,new CustomDateEditor(simpleDateFormat,false));

	 }


}
