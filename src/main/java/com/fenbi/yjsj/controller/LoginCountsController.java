package com.fenbi.yjsj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenbi.yjsj.pojo.FenbiResult;
import com.fenbi.yjsj.pojo.LoginCounts;
import com.fenbi.yjsj.service.loginCountsService;

@Controller
@RequestMapping("/login")
public class LoginCountsController {

	@Autowired
	private loginCountsService loginCountsService;
	
	@RequestMapping("/selectCounts")
	@ResponseBody
	public FenbiResult selectCounts() {
		List<LoginCounts> lists = loginCountsService.selectCounts(); 
		return new FenbiResult(lists);
		
	}
	
	
}
