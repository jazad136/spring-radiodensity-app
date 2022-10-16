package net.saddlercoms.radiodensity.service;

import java.util.List;

import net.saddlercoms.radiodensity.db.dao.RStationDAO;
import net.saddlercoms.radiodensity.db.dao.ReachDAO;
import net.saddlercoms.radiodensity.db.model.RStation;

public class RDensityDAOService {
	private final RStationDAO stationDAO;
	private final ReachDAO reachDAO;

	public RDensityDAOService(RStationDAO rStationDAO, ReachDAO reachDAO) {
		this.stationDAO = rStationDAO;
		this.reachDAO = reachDAO;
	}
	
	public List<RStation> getAllRadioStations() { 
		return stationDAO.findAll();
	}

	public List<RStation> getCountryRadioStations() {
		return stationDAO.findByCategory("Country");
	}

	public List<RStation> getStationsByCategoryContaining(String string) {
		return stationRepo.findByCategoryLike("%Christian%");
	}
	
}
