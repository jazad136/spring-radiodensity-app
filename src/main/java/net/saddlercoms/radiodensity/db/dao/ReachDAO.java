package net.saddlercoms.radiodensity.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.saddlercoms.radiodensity.db.model.NearbyType;
import net.saddlercoms.radiodensity.db.model.RStation;

public class ReachDAO extends DataAccessObject {
	
	/* SO FAR BIGGEST QUERY
select s.radio_id, s.call_name, s.fm_freq, s.category, n.nearby_id, n.nearby_name, n.near_city, n.st, n.nearby_type FROM rstatio
n s, nearby n;

	 */
	public final String GET_BASIC = ""
			+ "select"
			+ "e.radio_";
	public final String GET_COMPLEX = "";
	
	public ReachDAO(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
	}
	
	/*
	    nearby_id |         nearby_name          | nearby_city | st | nearby_type
		-----------+------------------------------+-------------+----+-------------
         1 | Laingsburg Woodbury Car Pool | Lansing     | MI |           2
         2 | Great Lakes Crossing Mall    | Detroit     | MI |           2
         3 | Flint I-69/I-75 Junction     | Flint       | MI |           1
	 */
	public List<RStation> getRStationsForNearbyCode(int nearbyCode) {
		List<NearbyType> allNearby = jdbcTemplate.query(null, null);
	
	}
	public enum NearbyEnum { 
		NEARBY_ID, NEARBY_NAME, NEARBY_CITY, ST, NEARBY_TYPE;
	}
	public static class NearbyCollect implements RowMapper<NearbyType> {
		private NearbyEnum[] tableCols;
		
		public NearbyCollect(NearbyEnum[] tableCols) { 
			this.tableCols = tableCols;
		}

		@Override
		public NearbyType mapRow(ResultSet rs, int rowNum) throws SQLException {
			NearbyType nearbyData = new NearbyType();
			
			return nearbyData;
		}
		
	}
	public List<String> getCitiesAvailable() {
		
	}
}
