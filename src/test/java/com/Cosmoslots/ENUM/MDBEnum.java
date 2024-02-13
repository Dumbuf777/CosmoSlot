package com.Cosmoslots.ENUM;

public enum MDBEnum {
	
	
	
	MBD("");
	
	
	
	
	private String value;

	MDBEnum(String value) {
		this.value = value;
	}

	public void setValue(String newValue) {
		this.value = newValue;
	}

	public int toInt() {
		return Integer.parseInt(value);
	}

	public String getValue() {
		return value;
	}

}
