package com.entitylayer;

public class alltaxmethodupdate {
	private String unreim;
	private String insu;
	private String tax;
	private String mort;
	private String federal;
	private long itemized;
	private long agi;
	public long getAgi() {
		return agi;
	}
	public void setAgi(long agi) {
		this.agi = agi;
	}
	public long getStandardised() {
		return standardised;
	}
	public void setStandardised(long standardised) {
		this.standardised = standardised;
	}
	private long standardised;
	
	public long getItemized() {
		return itemized;
	}
	public void setItemized(long itemized) {
		this.itemized = itemized;
	}
	public String getUnreim() {
		return unreim;
	}
	public void setUnreim(String unreim) {
		this.unreim = unreim;
	}
	public String getInsu() {
		return insu;
	}
	public void setInsu(String insu) {
		this.insu = insu;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getMort() {
		return mort;
	}
	public void setMort(String mort) {
		this.mort = mort;
	}
	public String getFederal() {
		return federal;
	}
	public void setFederal(String federal) {
		this.federal = federal;
	}
	
}
