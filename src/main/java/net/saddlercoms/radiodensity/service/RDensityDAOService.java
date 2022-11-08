package net.saddlercoms.radiodensity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.saddlercoms.radiodensity.db.dao.RStationDAO;
import net.saddlercoms.radiodensity.db.dao.ReachDAO;
import net.saddlercoms.radiodensity.db.model.RStation;

@Service
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
	public List<RStation> getStationsByCity(Integer nearbyNum) { 
		return reachDAO.findByNearbyCode(nearbyNum);
	}
	
	public List<RStation> getStationsByCity(Long nearbyNum) { 
		return reachDAO.findByNearbyCode(nearbyNum.intValue());
	}

//	public List<RStation> getCountryRadioStations() {
//		return stationDAO.findByCategory("Country");
//	}

//	public List<RStation> getStationsByCategoryContaining(String string) {
//		return stationRepo.findByCategoryLike("%Christian%");
//	}
	
}
