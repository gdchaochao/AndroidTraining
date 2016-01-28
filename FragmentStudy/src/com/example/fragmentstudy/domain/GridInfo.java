package com.example.fragmentstudy.domain;


public class GridInfo {
	private String name;
	private String appImage;
	public GridInfo(String name, String appImage) {
		super();
		this.name = name;
		this.appImage = appImage;
	}
	public String getAppImage() {
		return appImage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
