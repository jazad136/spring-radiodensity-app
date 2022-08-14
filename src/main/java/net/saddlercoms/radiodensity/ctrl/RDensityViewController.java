package net.saddlercoms.radiodensity.ctrl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.saddlercoms.radiodensity.db.model.RStation;
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
		model.addAttribute("radsets", allResponses);
		return "all-station.html";
	}
	
	private static List<RStationResponse> toResponses(final List<RStation> stations) { 
		return stations.stream()
				.map(RStationResponse::new)
				.collect(Collectors.toList());
	}
}
