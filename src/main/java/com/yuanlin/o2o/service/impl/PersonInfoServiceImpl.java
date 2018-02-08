package com.yuanlin.o2o.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanlin.o2o.dao.PersonInfoDao;
import com.yuanlin.o2o.entity.UserInfo;
import com.yuanlin.o2o.service.PersonInfoService;
@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public UserInfo getPersonInfoById(Long userId) {
		return personInfoDao.queryPersonInfoById(userId);
	}

}
