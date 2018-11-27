package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController 
{


	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet()
	{ 
		log.info("basic-----------------------");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2()
	{
		log.info("basic only get......................");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto)
	{
		
		log.info(" " + dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids)
	{
		
		log.info( "ids" + ids );
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02List(@RequestParam("ids") String[] ids)
	{
		
		log.info( "array ids" + Arrays.toString(ids) );
		
		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list)
	{ 
		
		log.info( "list dtos" + list );
		
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo)
	{
		log.info("todo" + todo);
		
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page)
	{
		log.info("dto : " + dto);
		log.info("page : "+ page);
		
		return "/sample/ex04"; 
	}

	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06()
	{
		
		log.info("/ex06...........");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("ȫ�浿");
		return dto;
	}
	
	
}
