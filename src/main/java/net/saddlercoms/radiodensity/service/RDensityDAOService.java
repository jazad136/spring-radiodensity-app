package net.saddlercoms.radiodensity.service;

import net.saddlercoms.radiodensity.db.dao.RStationDAO;
import net.saddlercoms.radiodensity.db.dao.ReachDAO;

public class RDensityDAOService {
	private final RStationDAO stationDAO;
	private final ReachDAO reachDAO;

	public RDensityDAOService(RStationDAO rStationDAO, ReachDAO reachDAO) {
		this.stationDAO = rStationDAO;
		this.reachDAO = reachDAO;
	}
}
