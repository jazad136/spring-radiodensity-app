package net.saddlercoms.radiodensity.response;

import java.util.List;

public class RStationListingsResponse {
	
	private String listingsName;
	private List<RStationResponse> listings;
	
	
	public RStationListingsResponse(String listingType, List<RStationResponse> listings) {
		this.listingsName = listingType;
		this.listings = listings;
	}
	public String getListingsName() { return listingsName; }
	public void setListingsName(String value) { this.listingsName = value; }
	
	public List<RStationResponse> getListings() { return listings; }
	public void setListings(List<RStationResponse> value) { this.listings = value; }
	
	
}
