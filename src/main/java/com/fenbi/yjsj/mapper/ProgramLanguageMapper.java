package com.fenbi.yjsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.fenbi.yjsj.pojo.ProgramLanguage;

public interface ProgramLanguageMapper {

	/**
	 * 查找不重复的labels集合
	 */
	@Select("select distinct year from program_language_rate order by year")
	@Result(javaType=java.lang.String.class)
	List<String> queryLabels();

	/**
	 * 查找编程语言数据集合
	 * @return
	 */
	@Select("select id, label, stroke_color as strokeColor, point_color as pointColor from program_language")
	@Result(javaType=ProgramLanguage.class)
	List<ProgramLanguage> queryProgramLanguages();

	/**
	 * 查询某一个编程语言每年的比重
	 * @param id
	 */
	@Select("select rate from program_language_rate where program_language_id=#{id}")
	@Result(javaType=java.lang.Double.class)
	List<Double> queryRatesByProgramLanguageId(int id);

	
	
	
}
