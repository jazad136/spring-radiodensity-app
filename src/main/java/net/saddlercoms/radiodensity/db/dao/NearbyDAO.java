package net.saddlercoms.radiodensity.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import net.saddlercoms.radiodensity.db.model.NearbyType;

@Component
public class NearbyDAO extends DataAccessObject {
	
	/* SO FAR BIGGEST QUERY
select s.radio_id, s.call_name, s.fm_freq, s.category, n.nearby_id, n.nearby_name, n.nearby_city, n.st, n.nearby_type FROM rstatio
n s, nearby n;


	 */
	public final String GET_NEARBY_BASIC = ""
			+ "SELECT "
			+ "n.nearby_id, n.nearby_name, n.nearby_city, "
			+ "n.st, n.nearby_type "
			+ "FROM nearby n;";
	public final String GET_COMPLEX = "";
	private final RStationDAO rstationDAO;
	
	public NearbyDAO(JdbcTemplate jdbcTemplate, RStationDAO rstationDao) {
		super(jdbcTemplate);
		this.rstationDAO = rstationDao;
	}
	
	/*
>radio=# SELECT n.nearby_id, n.nearby_name, n.nearby_city, n.st, n.nearby_type FROM nearby n;
 nearby_id |         nearby_name          | nearby_city | st | nearby_type
-----------+------------------------------+-------------+----+-------------
         1 | Laingsburg Woodbury Car Pool | Lansing     | MI |           2
         2 | Great Lakes Crossing Mall    | Detroit     | MI |           2
         3 | Flint I-69/I-75 Junction     | Flint       | MI |           1
(3 rows)
 */
	
	
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
			for(int i = 1; i <= tableCols.length; i++) { 
				if(tableCols[i-1] == NearbyEnum.NEARBY_ID) { 
					nearbyData.setNearbyId(rs.getLong(i));
				}
				if(tableCols[i-1] == NearbyEnum.NEARBY_NAME) { 
					nearbyData.setNearbyName(rs.getString(i));
				}
				if(tableCols[i-1] == NearbyEnum.NEARBY_CITY) { 
					nearbyData.setNearbyCity(rs.getString(i));
				}
				if(tableCols[i-1] == NearbyEnum.ST) { 
					nearbyData.setSt(rs.getString(i));
				}
				if(tableCols[i-1] == NearbyEnum.NEARBY_TYPE) { 
					nearbyData.setNearbyType(rs.getInt(i));
				}
			}
			return nearbyData;
		}
		
	}
	public List<String> getCitiesAvailable() {
		return null;
	}
}
