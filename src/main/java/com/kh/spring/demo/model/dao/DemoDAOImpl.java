package com.kh.spring.demo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Dev;

@Repository
public class DemoDAOImpl implements DemoDAO {

	/*mybatis설정이 필요하지만 아직 설정하지 않았기에 주석처리 해둠*/
	@Autowired
	private SqlSessionTemplate sqlSession;
	//이제 sqlSession은 AOP때문에 Service단이 아닌 DAO단에서 처리하겠다.

	@Override
	public int insertDev(Dev dev) {
		return sqlSession.insert("demo.insertDev",dev);
	}

	@Override
	public List<Dev> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("demo.selectDevList");
	}
}
