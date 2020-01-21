package com.kh.spring.common.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * String[] <-> String 변환
 * 
 * 3개의 getter(DB:string -> Java:String[])
 * -resultset에서 컬럼명으로 가져오기
 * -resultset에서 컬럼인덱스로 가져오기
 * -프로시져(callableStatement)용
 * 
 * 1개의 setter(Java:String[] -> DB(query):string)
 *
 */

public class StringArrayTypeHandler implements TypeHandler<String[]> {

	@Override
	public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
		// 쿼리에 자바의 문자배열을 작성할 때 사용
		if(parameter != null) {
			ps.setString(i, String.join(",", parameter));
		}
		else {
			ps.setString(i, "");
		}
		
	}

	@Override
	public String[] getResult(ResultSet rs, String columnName) throws SQLException {
		String str = rs.getString(columnName);
		String[] strArr = null;
		if(str != null) {
			strArr = str.split(",");
		}
		return strArr;
	}

	@Override
	public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
		String str = rs.getString(columnIndex);
		String[] strArr = null;
		if(str != null) {
			strArr = str.split(",");
		}
		return strArr;
	}

	@Override
	public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String str = cs.getString(columnIndex);
		String[] strArr = null;
		if(str != null) {
			strArr = str.split(",");
		}
		return strArr;
	}

}
