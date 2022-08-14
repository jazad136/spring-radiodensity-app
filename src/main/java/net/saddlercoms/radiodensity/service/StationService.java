package net.saddlercoms.radiodensity.service;

import java.util.List;

import net.saddlercoms.radiodensity.db.StationRepository;
import net.saddlercoms.radiodensity.db.model.RStation;

public class StationService {
	private final StationRepository stationRepo;

	public StationService(StationRepository stationRepo) {
		this.stationRepo = stationRepo;
	}
	
	public List<RStation> getAllRadioStations() { 
		return stationRepo.findAll();
	}
}
