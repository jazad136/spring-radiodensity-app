package net.saddlercoms.radiodensity.db.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

public class DataAccessObject {
	protected final Connection connection;
	protected final JdbcTemplate jdbcTemplate;
	public DataAccessObject(JdbcTemplate template)  {
		this.jdbcTemplate = template;
		try{this.connection = template.getDataSource().getConnection();}
		catch(SQLException sqle) { throw new RuntimeException("Connection unavailable", sqle); }
	}
}
