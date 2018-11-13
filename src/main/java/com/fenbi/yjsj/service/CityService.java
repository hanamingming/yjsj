package com.fenbi.yjsj.service;

import java.util.HashMap;
import java.util.List;

import com.fenbi.yjsj.pojo.City;

public interface CityService {
	//获取所有的city对象
	List<HashMap<Object, Object>> queryCity();

	List<String> getLabels();

	List<String> getLineColors();

	
	//获取city_price对象
}
