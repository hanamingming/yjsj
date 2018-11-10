package com.fenbi.yjsj.service;


import java.util.List;


import com.fenbi.yjsj.pojo.LoginCounts;

public interface loginCountsService {

	/**
	 * 查询登陆次数
	 * @return
	 */
	List<LoginCounts> selectCounts();


}
