package net.saddlercoms.radiodensity.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.saddlercoms.radiodensity.db.dao.NearbyDAO.NearbyCollect;
import net.saddlercoms.radiodensity.db.dao.NearbyDAO.NearbyEnum;
import net.saddlercoms.radiodensity.db.model.NearbyType;
import net.saddlercoms.radiodensity.db.model.RStation;

public class ReachDAO extends DataAccessObject {
	

/*
radio=# select e.nearby_id, r.radio_id, r.call_name, e.fm_freq, r.category from reach e join r
station r on e.radio_id=r.radio_id where nearby_id=1 ORDER BY fm_freq;
 nearby_id | radio_id |     call_name     | fm_freq |        category
-----------+----------+-------------------+---------+-------------------------
         1 |        1 | SmileFM           |    88.1 | Christian/Inspirational
         1 |        1 | SmileFM           |    88.5 | Christian/Inspirational
         1 |        2 | WDBM-FM           |    88.9 |
         1 |        3 | K-LOVE            |    89.1 | Christian/Inspirational
         1 |        4 | Christian 1       |    89.3 | Christian/Inspirational
         1 |        5 | WCMU NPR          |    89.5 | Classical
         1 |        6 | MI Radio          |    89.7 | Talk Radio
         1 |        6 | MI Radio          |    90.5 | Talk Radio
         1 |        7 | WKAR NPR          |    90.5 | Classical
         1 |        8 | Christian 2       |    90.9 | Christian
         1 |        9 | STACKS 92.1       |    92.1 | Party Hits
         1 |       10 | Z92.5 The Castle  |    92.5 | Variety
         1 |       11 | Cruisin 92.7 WLMI |    92.7 | Classic Hits
(13 rows)
*/

	public final String GET_NEAR_STATIONS_BASIC = ""
			+ "SELECT"
			+ "e.nearby_id"
			+ ", r.radio_id, r.call_name, e.fm_freq, r.category"
			+ " FROM reach e join rstation r "
			+ " ON e.radio_id=r.radio_id"
			+ " WHERE nearby_id=?;";
	private final RStationDAO rstationDAO;
	
	public ReachDAO(JdbcTemplate jdbcTemplate, RStationDAO rstationDao) {
		super(jdbcTemplate);
		this.rstationDAO = rstationDao;
	}
	
	public static class ReachCollect implements RowMapper<RStation> { 
		
		private RStationEnum[] rsTableCols;
		public ReachCollect(RStationEnum... rsTableCols) { 
			this.rsTableCols = rsTableCols;
		}
		@Override
		public RStation mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new RStationRow(rsTableCols).mapRow(rs, rowNum);
		}		
	}
	public List<RStation> getRStationsForNearbyCode(int nearbyCode) {
		List<RStation> allRStation = jdbcTemplate.query(GET_NEAR_STATIONS_BASIC, 
				new ReachCollect(
						RStationEnum.NO_OP, 
						RStationEnum.RADIO_ID, 
						RStationEnum.CALL_NAME, 
						RStationEnum.FM_FREQ, 
						RStationEnum.CATEGORY), nearbyCode);
		return allRStation;
	}
}
