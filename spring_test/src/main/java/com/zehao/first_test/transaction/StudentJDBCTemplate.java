package com.zehao.first_test.transaction;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class StudentJDBCTemplate implements StudentDao{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager){
		this.transactionManager = transactionManager;
	}

	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void create(String name, Integer age, Integer marks, Integer year) {
		// TODO Auto-generated method stub
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		try {
			String sql = "insert into Student(name, age) values(?,?)";
			jdbcTemplate.update(sql, name, age);
			String sql1 = "select max(id) from Student";
			int sid = jdbcTemplate.queryForInt(sql1);
			String sql2 = "insert into marks (sid,marks,year) values(?,?,?)";
			jdbcTemplate.update(sql2, sid, marks, year);
			System.out.println("create name = "+name + " age = "+age);
			transactionManager.commit(transactionStatus);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(transactionStatus);
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return;
	}

	public List<StudentMarks> listStudents() {
		// TODO Auto-generated method stub
		String sql = "select * from Student,Marks where Student.id=Marks.sid";
		List<StudentMarks> list = jdbcTemplate.query(sql, new StudentMarksMapper());
		return list;
	}

}
