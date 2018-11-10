package com.fenbi.yjsj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenbi.yjsj.mapper.LoginCountsMapper;
import com.fenbi.yjsj.pojo.FenbiResult;
import com.fenbi.yjsj.pojo.LoginCounts;
import com.fenbi.yjsj.service.loginCountsService;

@Service
public class loginCountsServiceImpl implements loginCountsService {

	@Autowired
	private LoginCountsMapper loginCountsMapper;

	@Override
	public List<LoginCounts> selectCounts() {
		 
		return loginCountsMapper.selectCounts();
	}

	
	
	
}
