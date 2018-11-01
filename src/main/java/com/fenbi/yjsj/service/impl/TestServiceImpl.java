package com.fenbi.yjsj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenbi.yjsj.mapper.TestMapper;
import com.fenbi.yjsj.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestMapper testMapper;
	
	@Override
	public void testMethod() {
		testMapper.insert();
	}

}
