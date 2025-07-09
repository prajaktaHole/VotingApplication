package com.Dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class VotesDao {
	
	JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	
	public void addVote(String uname, String cname)
	{
		try
		{
			jt.update("insert into votes values(?,?)", uname, cname);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public int getVoteCount(String cname)
	{
		String sql = "select count(*) from votes where cname=?";
		Integer count = jt.queryForObject(sql, Integer.class, cname);
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
