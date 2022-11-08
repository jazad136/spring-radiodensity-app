package net.saddlercoms.radiodensity.ctrl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.saddlercoms.radiodensity.db.model.RStation;
import net.saddlercoms.radiodensity.response.PingResponse;
import net.saddlercoms.radiodensity.response.RStationListingsResponse;
import net.saddlercoms.radiodensity.response.RStationResponse;
import net.saddlercoms.radiodensity.service.RDensityDAOService;

@RestController
@RequestMapping(path="/api/cities")
public class RDensityNearbyRestController {
	
	private RDensityDAOService stationService;
	
	
	public RDensityNearbyRestController(RDensityDAOService stationService) {
		this.stationService = stationService;
	}
	
	@GetMapping(path="/ping")
	@ResponseStatus(HttpStatus.OK)
	public PingResponse ping() { return new PingResponse(true); }
	
	@GetMapping("/{nearby_num}")
	public String getCountryStations(Model model, @PathVariable Long nearbyNum) {
		List<RStationResponse> allResponses = toResponses(stationService.getStationsByCity(nearbyNum));
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
