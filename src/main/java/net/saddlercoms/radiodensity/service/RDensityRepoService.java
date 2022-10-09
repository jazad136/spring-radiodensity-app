package net.saddlercoms.radiodensity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.saddlercoms.radiodensity.db.StationRepository;
import net.saddlercoms.radiodensity.db.model.RStation;

@Service
public class RDensityRepoService {
	private final StationRepository stationRepo;

	public RDensityRepoService(StationRepository stationRepo) {
		this.stationRepo = stationRepo;
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
