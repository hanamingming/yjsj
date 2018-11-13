package com.fenbi.yjsj.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenbi.yjsj.pojo.FenbiResult;
import com.fenbi.yjsj.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/labels")
	@ResponseBody
	public FenbiResult labels() {
		List<String> labels = cityService.getLabels();
		return new FenbiResult(labels);
	} 
	
	@RequestMapping("/lineColors")
	@ResponseBody
	public FenbiResult lineColors() {
		List<String> lineColors = cityService.getLineColors();
		return new FenbiResult(lineColors);
	}
	
	@RequestMapping("/data")
	@ResponseBody
	public FenbiResult data() {
		List<HashMap<Object, Object>> datas = cityService.queryCity();
		return new FenbiResult(datas);
	} 
	
	
}
