package com.cbm.base.designpattern.singleton;

public enum EnumSingleton {

	INSTANCE;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSomething() {
		return "String";
	}
}
