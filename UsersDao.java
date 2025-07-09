package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Entity.User;

public class UsersDao {
	
	JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	
	public void addUser(String name, String pass, String email)
	{
		try
		{
			jt.update("insert into users values(?,?,?)", name, pass, email);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	boolean flag = false;
	public boolean checkUser(String username, String password)
	{
		try
		{
			User u = jt.queryForObject("select * from users where username=? and password=?", new UserRowMapper(), username, password);
			if(u.getUsername().equals(username) && u.getPassword().equals(password))
			{
				flag = true;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			return flag;
		}
		
	}
	
	

	class UserRowMapper implements RowMapper<User>
	{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User u = new User();
			u.setUsername(rs.getString(1));
			u.setPassword(rs.getString(2));
			u.setEmail(rs.getString(3));
			return u;
		}
		
	}

}
