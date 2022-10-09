package net.saddlercoms.radiodensity.db.model;


public class NearbyType {
	
	private Long nearby_id;
	private String nearby_name;
	private String nearby_city;
	private String st;
	private int nearby_type;
	
	public Long getNearby_id() { return nearby_id; }
	public void setNearby_id(Long nearby_id) { this.nearby_id = nearby_id; }
	
	public String getNearby_name() { return nearby_name; }
	public void setNearby_name(String nearby_name) { this.nearby_name = nearby_name; }
	
	public String getNearby_city() { return nearby_city; }
	public void setNearby_city(String nearby_city) { this.nearby_city = nearby_city; }
	
	public String getSt() { return st; }
	public void setSt(String st) { this.st = st; }
	
	public int getNearby_type() { return nearby_type; }
	public void setNearby_type(int nearby_type) { this.nearby_type = nearby_type; }
	
	@Override
	public String toString() {
		return "NearbyType [nearby_id=" + nearby_id + ", nearby_name=" + nearby_name + ", nearby_city=" + nearby_city
				+ ", st=" + st + ", nearby_type=" + nearby_type + "]";
	}
	
}
