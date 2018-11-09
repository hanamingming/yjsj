package com.fenbi.yjsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

 import com.fenbi.yjsj.pojo.LoginCounts;

public interface LoginCountsMapper {
	/**
	 * 查询登陆次数
	 * @return
	 */
	
	@Select("select * from logincounts")
	@Result(javaType=LoginCounts.class)
	List<LoginCounts> selectCounts();

	
	
	
	
}
