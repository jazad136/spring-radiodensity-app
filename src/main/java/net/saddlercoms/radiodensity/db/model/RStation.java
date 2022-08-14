package net.saddlercoms.radiodensity.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * radio_id bigint NOT NULL DEFAULT nextval('rs_rstation_seq'),
   call_name varchar(40), 
   fm_freq numeric(4,1) NOT NULL,
   category varchar(40), 
   haat int, 
   erpkw numeric(4,2), 
   PRIMARY KEY (radio_id)
 */
@Entity
@Table(name="rstation")
public class RStation {

	@Id @Column(name="radio_id")  private Long radioId;
	@Column(name="call_name") private String callName;
	@Column(name="fm_freq")   private Double fmFreq;
	@Column(name="category")  private String category;
	@Column(name="haat")      private Integer haat;
	@Column(name="erpkw")     private Double erpkw;
	
	public Long getRadioId() { return radioId; }
	public void setRadioId(Long radio_id) { this.radioId = radio_id; }
	
	public String getCallName() { return callName; }
	public void setCallName(String callName) { this.callName = callName; }
	
	public Double getFmFreq() { return fmFreq; }
	public void setFmFreq(Double fmFreq) { this.fmFreq = fmFreq; }
	
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	
	public Integer getHaat() { return haat; }
	public void setHaat(Integer haat) { this.haat = haat; }
	
	public Double getErpkw() { return erpkw; }
	public void setErpkw(Double erpkw) { this.erpkw = erpkw; }
	@Override
	public String toString() {
		return "RStation [radio_id=" + radioId + ", callName=" + callName + ", fmFreq=" + fmFreq + ", category="
				+ category + ", haat=" + haat + ", erpkw=" + erpkw + "]";
	}	
}
