package net.saddlercoms.radiodensity.response;

import net.saddlercoms.radiodensity.db.model.RStation;

public class RStationResponse {

	private Long radioId;
	private String callName;
	private Double fmFreq;
	private String category;
	
	public RStationResponse() { } 
	
	public RStationResponse(RStation rs) { 
		this.radioId = rs.getRadioId();
		this.callName = rs.getCallName();
		this.fmFreq = rs.getFmFreq();
		this.category = rs.getCategory();
	}
	public RStationResponse(Long radio_id, String callName, Double fmFreq, String category) {
		this.radioId = radio_id;
		this.callName = callName;
		this.fmFreq = fmFreq;
		this.category = category;
	}

	public Long getRadioId() { return radioId; }
	public void setRadioId(Long radio_id) { this.radioId = radio_id; }
	
	public String getCallName() { return callName; }
	public void setCallName(String callName) { this.callName = callName; }
	
	public Double getFmFreq() { return fmFreq; }
	public void setFmFreq(Double fmFreq) { this.fmFreq = fmFreq; }
	
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	
	@Override
	public String toString() {
		return "RStationResponse [radio_id=" + radioId + ", callName=" + callName + ", fmFreq=" + fmFreq
				+ ", category=" + category + "]";
	}

}
