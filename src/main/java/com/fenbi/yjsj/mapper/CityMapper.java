package com.fenbi.yjsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.fenbi.yjsj.pojo.City;
import com.fenbi.yjsj.pojo.ProgramLanguage;

public interface CityMapper {
	/**
	 * 查找不重复的labels集合
	 */
	@Select("select labels from city")
	@Result(javaType=java.lang.String.class)
	List<String> queryLabels();
	
	/**
	 * 查找不重复的lineColors集合
	 */
	@Select("select line_colors lineColors from city")
	@Result(javaType=java.lang.String.class)
	List<String> queryLineColors();
	
	/**
	 * 查询每一年的不同城市房价
	 * @param id
	 */
	@Select("select price from house_price where year=#{year}")
	@Result(javaType=java.lang.Double.class)
	List<Double> queryPriceByYear(String year);
	
	/**
	 * 查找不重复的year集合
	 */
	@Select("select distinct year from house_price")
	@Result(javaType=java.lang.String.class)
	List<String> queryYear();
}
