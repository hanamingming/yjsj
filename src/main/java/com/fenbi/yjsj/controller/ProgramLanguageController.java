package com.fenbi.yjsj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenbi.yjsj.pojo.FenbiResult;
import com.fenbi.yjsj.pojo.ProgramLanguage;
import com.fenbi.yjsj.service.ProgramLanguageService;

@Controller
@RequestMapping("/pl")
public class ProgramLanguageController {

	@Autowired
	private ProgramLanguageService programLanguageService;
	
	@RequestMapping("/labels")
	@ResponseBody
	public FenbiResult labels() {
		List<String> labels = programLanguageService.getLabels();
		return new FenbiResult(labels);
	} 
	
	@RequestMapping("/datasets")
	@ResponseBody
	public FenbiResult datasets() {
		List<ProgramLanguage> pls = programLanguageService.getProgramLanguages();
		return new FenbiResult(pls);
	} 
	
}







