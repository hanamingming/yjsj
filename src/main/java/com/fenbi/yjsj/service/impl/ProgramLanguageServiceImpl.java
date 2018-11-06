package com.fenbi.yjsj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenbi.yjsj.mapper.ProgramLanguageMapper;
import com.fenbi.yjsj.pojo.ProgramLanguage;
import com.fenbi.yjsj.service.ProgramLanguageService;

@Service
public class ProgramLanguageServiceImpl implements ProgramLanguageService {

	@Autowired
	private ProgramLanguageMapper programLanguageMapper;
	
	@Override
	public List<String> getLabels() {
		return programLanguageMapper.queryLabels();
	}

	@Override
	public List<ProgramLanguage> getProgramLanguages() {
		List<ProgramLanguage> pls = programLanguageMapper.queryProgramLanguages();
		for(int i=0; i<pls.size(); i++) {
			int id = pls.get(i).getId();
			List<Double> data = programLanguageMapper.queryRatesByProgramLanguageId(id);
			pls.get(i).setData(data);
		}
		return pls;
	}

}
