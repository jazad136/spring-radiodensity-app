package net.saddlercoms.radiodensity.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.saddlercoms.radiodensity.db.model.RStation;

public class RStationDAO {
	/*
	 *  @Id @Column(name="radio_id")  private Long radioId;
		@Column(name="call_name") private String callName;
		@Column(name="fm_freq")   private Double fmFreq;
		@Column(name="category")  private String category;
		@Column(name="haat")      private Integer haat;
		@Column(name="erpkw")     private Double erpkw;
	 */
	final JdbcTemplate jdbcTemplate;
	public RStationDAO(JdbcTemplate jdbcTemplate) { 
		this.jdbcTemplate = jdbcTemplate;
	}
	
//	public final String GET_BASIC = "SELECT s.turn_order, s.person_nickname, "
//			+ "s.person_name, s.new_score, g.common_name "
//			+ "FROM score s join game g on s.game_id=g.id";

	
	public final String GET_BASIC_SQL = ""
			+ "select "
			+ "r.radio_id, r.call_name, r.fm_freq, r.category "
			+ "FROM rstation r"
			+ ";";

	/*
>radio=# select r.radio_id, r.call_name, r.fm_freq, r.category FROM rstation r;
 radio_id |         call_name         | fm_freq |          category
----------+---------------------------+---------+-----------------------------
       19 | Channel 95.5              |    95.5 | Popular Hits
       20 | Windsors Country 95.9     |    95.9 | Country
       21 | WDVD Todays Best Music    |    96.3 | Popular Hits
	 */
	
	
	public List<RStation> getBasic() { 
		List<RStation> toReturn = jdbcTemplate.query(GET_BASIC_SQL, new RStationRow());
		return toReturn;
	}
	
	public static enum RStationCollect { 
		radio_id(RStationEnum.RADIO_ID)
		,call_name(RStationEnum.CALL_NAME)
		,fm_freq(RStationEnum.FM_FREQ)
		,category(RStationEnum.CATEGORY)
		;
		public final RStationEnum field;
		RStationCollect(RStationEnum rse) { 
			this.field = rse;
		}
		public static int tableSize() { return values().length; } 
		
	}
	public static enum RStationEnum {
		RADIO_ID,
		CALL_NAME,
		FM_FREQ,
		CATEGORY;
	}
	public static class RStationRow implements RowMapper<RStation> {
		
		@Override
		public RStation mapRow(ResultSet rs, int rowNum) throws SQLException {
			RStation toReturn = new RStation();
			for(int i = 1; i <= RStationCollect.tableSize(); i++) { 
				if(RStationCollect.values()[i-1].field == RStationEnum.RADIO_ID) { 
					toReturn.setRadioId(rs.getLong(i));
				}
				if(RStationCollect.values()[i-1].field == RStationEnum.CALL_NAME) { 
					toReturn.setCallName(rs.getString(i));
				}
				if(RStationCollect.values()[i-1].field == RStationEnum.FM_FREQ) { 
					toReturn.setFmFreq(rs.getDouble(i));
				}
				if(RStationCollect.values()[i-1].field == RStationEnum.CATEGORY) { 
					toReturn.setCategory(rs.getString(i));
				}
			}
			return toReturn;
		}
		
	}
	
	
}
