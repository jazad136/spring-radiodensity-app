package net.saddlercoms.radiodensity.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import net.saddlercoms.radiodensity.db.dao.RStationDAO.RStationCollect;
import net.saddlercoms.radiodensity.db.model.RStation;

public class RStationRow implements RowMapper<RStation> {
	
	RStationEnum[] tableCols;
	
	public RStationRow(RStationEnum... tableCols) { 
		this.tableCols = tableCols;
	}
	
	@Override
	public RStation mapRow(ResultSet rs, int rowNum) throws SQLException {
		RStation toReturn = new RStation();
		for(int i = 1; i <= RStationCollect.tableSize(); i++) { 
			if(tableCols[i-1] == RStationEnum.RADIO_ID) { 
				toReturn.setRadioId(rs.getLong(i));
			}
			if(tableCols[i-1] == RStationEnum.CALL_NAME) { 
				toReturn.setCallName(rs.getString(i));
			}
			if(tableCols[i-1] == RStationEnum.FM_FREQ) { 
				toReturn.setFmFreq(rs.getDouble(i));
			}
			if(tableCols[i-1]== RStationEnum.CATEGORY) { 
				toReturn.setCategory(rs.getString(i));
			}
		}
		return toReturn;
	}
	
}