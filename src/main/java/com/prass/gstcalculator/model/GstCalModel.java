package com.prass.gstcalculator.model;

public class GstCalModel {

	private Long gstPercentage;
	private Double baseAmount;
	private Double gstAmount;
	private Double totalAmount;

	public GstCalModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GstCalModel(Long gstPercentage, Double baseAmount, Double gstAmount, Double totalAmount) {
		super();
		this.gstPercentage = gstPercentage;
		this.baseAmount = baseAmount;
		this.gstAmount = gstAmount;
		this.totalAmount = totalAmount;
	}

	public Long getGstPercentage() {
		return gstPercentage;
	}

	public void setGstPercentage(Long gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	public Double getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(Double baseAmount) {
		this.baseAmount = baseAmount;
	}

	public Double getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(Double gstAmount) {
		this.gstAmount = gstAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "gstCalModel [gstPercentage=" + gstPercentage + ", baseAmount=" + baseAmount + ", gstAmount=" + gstAmount
				+ ", totalAmount=" + totalAmount + "]";
	}

}
