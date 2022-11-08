package net.saddlercoms.radiodensity.ctrl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.saddlercoms.radiodensity.db.model.RStation;
import net.saddlercoms.radiodensity.response.RStationListingsResponse;
import net.saddlercoms.radiodensity.response.RStationResponse;
import net.saddlercoms.radiodensity.service.RDensityDAOService;

@Controller
@RequestMapping(path="/cities")
public class RDensityNearbyViewController {
	
	private RDensityDAOService stationService;
	
	
	public RDensityNearbyViewController(RDensityDAOService stationService) {
		this.stationService = stationService;
	}
	
	@GetMapping(path="/ping")
	@ResponseStatus(HttpStatus.OK)
	public String pingPage() { 
		return "ping.html";
	}
	
	private int tryParseInt(Long num, String argName) { 
		if(num == null || num > Integer.MAX_VALUE) { 
			throw new IllegalArgumentException("Numerical Argument " + argName + " is too large to be parsed as int");
		}
		return num.intValue();
	}
	@GetMapping("/{nearbyNum}")
	public String getNearbyStations(Model model, @PathVariable Long nearbyNum) {
		int parseNum = tryParseInt(nearbyNum, "nearbyNum");
		
		String nearCity = "";
		switch(parseNum) { 
		case 1: nearCity = "Lansing, MI";
		case 2: nearCity = "Detroit, MI";
		case 3: nearCity = "Flint, MI";
		default : 
			parseNum = 1;
			nearCity = "Lansing, MI";
		}
		List<RStationResponse> allResponses = toResponses(stationService.getStationsByCity(parseNum));
		RStationListingsResponse response = new RStationListingsResponse("Stations near to " + nearCity, allResponses);
		model.addAttribute("radsets", response);
		return "all-station.html";
	}
	
	
	private static List<RStationResponse> toResponses(final List<RStation> stations) { 
		return stations.stream()
				.map(RStationResponse::new)
				.collect(Collectors.toList());
	}
}
