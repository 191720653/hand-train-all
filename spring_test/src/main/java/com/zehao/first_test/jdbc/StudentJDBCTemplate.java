package com.zehao.first_test.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void create(String name, Integer age) {
		// TODO Auto-generated method stub
		String sql = "insert into Student (name,age) values(?,?)";
		jdbcTemplate.update(sql, name, age);
		System.out.println("create name:"+name+" age:"+age);
		return;
	}

	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from Student where id=?";
		Student student = (Student) jdbcTemplate.query(sql, new Object[]{id}, new StudentMapper()).get(0);
		return student;
	}

	public List<Student> listStudents() {
		// TODO Auto-generated method stub
		String sql = "select * from Student";
		List<Student> list = jdbcTemplate.query(sql, new StudentMapper());
		return list;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from Student where id=?";
		jdbcTemplate.update(sql, id);
		System.out.println("delete record id="+id);
		return;
	}

	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		String sql = "update Student set age=? where id=?";
		jdbcTemplate.update(sql,age,id);
		System.out.println("update record id="+id);
		return;
		
	}

}
