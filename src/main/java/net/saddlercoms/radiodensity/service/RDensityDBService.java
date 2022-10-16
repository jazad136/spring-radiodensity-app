package net.saddlercoms.radiodensity.service;

import java.util.List;

import net.saddlercoms.radiodensity.db.StationRepository;
import net.saddlercoms.radiodensity.db.dao.RStationDAO;
import net.saddlercoms.radiodensity.db.dao.ReachDAO;
import net.saddlercoms.radiodensity.db.model.RStation;

public class RDensityDBService {
	private final RStationDAO stationDAO;
	private final ReachDAO reachDAO;
	private final StationRepository stationRepo;

	public RDensityDBService(StationRepository stationRepo, RStationDAO rStationDAO, ReachDAO reachDAO) {
		this.stationRepo = stationRepo;
		this.stationDAO = rStationDAO;
		this.reachDAO = reachDAO;
	}
	
	public List<RStation> getAllRadioStations() { 
		return stationRepo.findAll();
	}

	public List<RStation> getCountryRadioStations() {
		return stationRepo.findByCategory("Country");
	}

	public List<RStation> getStationsByCategoryContaining(String string) {
		return stationRepo.findByCategoryLike("%Christian%");
	}
	
}
