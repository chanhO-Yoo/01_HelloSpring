package com.kh.spring.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.demo.model.dao.DemoDAO;
import com.kh.spring.demo.model.vo.Dev;

@Service
public class DemoServiceImpl implements DemoService {
	//인터페이스에 어노테이션 붙이지 않는것 주의!!
	
	//private DemoDAO demoDAO = new DemoDAOImpl();

	@Autowired
	private DemoDAO demoDAO;

	@Override
	public int insertDev(Dev dev) {
		return demoDAO.insertDev(dev);
	}

	@Override
	public List<Dev> selectDevList() {
		return demoDAO.selectList();
	}
	
	
	
}
