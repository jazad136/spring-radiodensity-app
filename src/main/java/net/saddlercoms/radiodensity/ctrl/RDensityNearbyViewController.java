package net.saddlercoms.radiodensity.ctrl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.saddlercoms.radiodensity.db.model.RStation;
import net.saddlercoms.radiodensity.response.RStationListingsResponse;
import net.saddlercoms.radiodensity.response.RStationResponse;
import net.saddlercoms.radiodensity.service.RDensityDAOService;

@Controller
@RequestMapping(path="/city")
public class RDensityNearbyViewController {
	
	private RDensityDAOService stationService;
	
	public RDensityNearbyViewController(RDensityDAOService stationService) {
		this.stationService = stationService;
	}
	
	
	@GetMapping("/{nearby_num}")
	public String getCountryStations(Model model, @PathVariable Long nearbyNum) {
		List<RStationResponse> allResponses = toResponses(stationService.getStationsByCity());
		RStationListingsResponse response = new RStationListingsResponse("Country Stations", allResponses);
		model.addAttribute("radsets", response);
		return "all-station.html";
	}
	
	
	private static List<RStationResponse> toResponses(final List<RStation> stations) { 
		return stations.stream()
				.map(RStationResponse::new)
				.collect(Collectors.toList());
	}
}
