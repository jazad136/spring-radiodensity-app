package net.saddlercoms.radiodensity.db.model;


public class NearbyType {
	
	private Long nearbyId;
	private String nearbyName;
	private String nearbyCity;
	private String st;
	private int nearbyType;
	
	public Long getNearbyId() { return nearbyId; }
	public void setNearbyId(Long nearbyId) { this.nearbyId = nearbyId; }
	
	public String getNearbyName() { return nearbyName; }
	public void setNearbyName(String nearbyName) { this.nearbyName = nearbyName; }
	
	public String getNearbyCity() { return nearbyCity; }
	public void setNearbyCity(String nearbyCity) { this.nearbyCity = nearbyCity; }
	
	public String getSt() { return st; }
	public void setSt(String st) { this.st = st; }
	
	public int getNearbyType() { return nearbyType; }
	public void setNearbyType(int nearbyType) { this.nearbyType = nearbyType; }
	
	@Override
	public String toString() {
		return "NearbyType [nearby_id=" + nearbyId + ", nearby_name=" + nearbyName + ", nearby_city=" + nearbyCity
				+ ", st=" + st + ", nearby_type=" + nearbyType + "]";
	}
	
}
