package com.genesys.api.dao.entity;

public class Menssage {
	private String conversionId;
	private String menssage;
	
	public String getConversionId() {
		return conversionId;
	}
	public void setConversionId(String conversionId) {
		this.conversionId = conversionId;
	}
	public String getMenssage() {
		return menssage;
	}
	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}
	@Override
	public String toString() {
		return "Mesagge [conversionId=" + conversionId + ", menssage=" + menssage + "]";
	}
}
