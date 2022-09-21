package net.saddlercoms.radiodensity.ctrl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.saddlercoms.radiodensity.db.model.RStation;
import net.saddlercoms.radiodensity.response.RStationListingsResponse;
import net.saddlercoms.radiodensity.response.RStationResponse;
import net.saddlercoms.radiodensity.service.StationService;

@Controller
@RequestMapping(path="/")
public class RDensityViewController {
	
	private StationService stationService;
	
	public RDensityViewController(StationService stationService) {
		this.stationService = stationService;
	}
	
	@GetMapping
	public String getAllStations(Model model) {
		List<RStationResponse> allResponses = toResponses(stationService.getAllRadioStations());
		RStationListingsResponse response = new RStationListingsResponse("All Stations", allResponses);
		model.addAttribute("radsets", response);
		return "all-station.html";
	}
	
	@GetMapping("/country")
	public String getCountryStations(Model model) {
		List<RStationResponse> allResponses = toResponses(stationService.getCountryRadioStations());
		RStationListingsResponse response = new RStationListingsResponse("Country Stations", allResponses);
		model.addAttribute("radsets", response);
		return "all-station.html";
	}
	
	@GetMapping("/christian")
	public String getChristianStations(Model model) {
		List<RStationResponse> allResponses = toResponses(stationService.getStationsByCategoryContaining("Christian"));
		RStationListingsResponse response = new RStationListingsResponse("Christian Stations", allResponses);
		model.addAttribute("radsets", response);
		return "all-station.html";
	}
	
	
	private static List<RStationResponse> toResponses(final List<RStation> stations) { 
		return stations.stream()
				.map(RStationResponse::new)
				.collect(Collectors.toList());
	}
}
