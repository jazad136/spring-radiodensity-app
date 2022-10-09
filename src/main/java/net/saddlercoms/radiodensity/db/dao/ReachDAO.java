package net.saddlercoms.radiodensity.db.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class ReachDAO extends DataAccessObject {
	
	/* SO FAR BIGGEST QUERY
select s.radio_id, s.call_name, s.fm_freq, s.category, n.nearby_id, n.nearby_name, n.near_city, n.st, n.nearby_type FROM rstatio
n s, nearby n;

	 */
	public final String GET_COMPLEX = "";
	
	public ReachDAO(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
	}
	
	
}
