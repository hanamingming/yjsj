package com.fenbi.yjsj.service;

import java.util.List;

import com.fenbi.yjsj.pojo.ProgramLanguage;

public interface ProgramLanguageService {

	/**
	 * 获取不重复的labels集合 (编程语言名称集合)
	 * @return
	 */
	List<String> getLabels();

	/**
	 * 获取所有数据集合
	 * @return
	 */
	List<ProgramLanguage> getProgramLanguages();

}
