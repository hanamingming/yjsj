package com.fenbi.yjsj.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenbi.yjsj.mapper.CityMapper;
import com.fenbi.yjsj.pojo.City;
import com.fenbi.yjsj.service.CityService;
@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityMapper cityMapper;


	@Override
	public List<String> getLabels() {
		return cityMapper.queryLabels();
	}
	
	@Override
	public List<String> getLineColors() {
		return cityMapper.queryLineColors();
	}

	@Override
	@Transactional(transactionManager="txManager", rollbackFor= {Exception.class})
	public List<HashMap<Object, Object>> queryCity() {
		List<HashMap<Object, Object>> arrayList= new ArrayList<>();;
		List<String> years = cityMapper.queryYear();
		for(int i=0;i<years.size();i++) {
			String year = years.get(i);
			HashMap<Object, Object> hashMap = new HashMap<>();
			hashMap.put("year", year);
			List<String> citys = cityMapper.queryLabels();
			List<Double> prices = cityMapper.queryPriceByYear(year);
			for(int k=0;k<citys.size();k++) {
				String city = citys.get(k);
				hashMap.put(city, prices.get(k));
			} 
			arrayList.add(hashMap);
		}
		return arrayList;
		
	}

}
