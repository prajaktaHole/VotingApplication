package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Entity.Candidate;

public class CandidatesDao {
	
	JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	
	public void addCandidate(String cname)
	{
		try
		{
			jt.update("insert into candidates values(?)", cname);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	
	
	public List<Candidate> readAll()
	{
		List<Candidate> l = jt.query("select * from candidates", new CandidateRowMapper());
		return l;
	}
	
	

	class CandidateRowMapper implements RowMapper<Candidate>
	{

		@Override
		public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Candidate c = new Candidate();
			c.setCname(rs.getString("cname"));
			return c;
		}
		
	}
	
	
	
	public void deleteCandidate(String cname)
	{
		jt.update("delete from candidates where cname=?", cname);
	}
	
	
	
	
	
	
	
	
	
	
}
