package com.zehao.first_test.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMarksMapper implements RowMapper<StudentMarks>{

	public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		StudentMarks studentMarks = new StudentMarks();
		studentMarks.setId(rs.getInt("Id"));
		studentMarks.setName(rs.getString("name"));
		studentMarks.setAge(rs.getInt("age"));
		studentMarks.setSid(rs.getInt("sid"));
		studentMarks.setMarks(rs.getInt("marks"));
		studentMarks.setYear(rs.getInt("year"));
		return studentMarks;
	}

}
