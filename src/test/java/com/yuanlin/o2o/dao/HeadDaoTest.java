package com.yuanlin.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuanlin.o2o.BaseTest;
import com.yuanlin.o2o.entity.HotSpot;

public class HeadDaoTest extends BaseTest {
	@Autowired
	private HeadDao headLineDao;

	@Test
	public void testQueryArea() {
		List<HotSpot> headLineList = headLineDao.queryHeadLine(new HotSpot());
		assertEquals(1, headLineList.size());
	}
}
