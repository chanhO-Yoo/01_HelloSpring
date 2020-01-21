package com.kh.spring.demo.model.vo;

import java.io.Serializable;
import java.util.Arrays;

public class Dev implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int devNo; //등록번호(PK)
	private String devName;
	private int devCareer;
	private String devEmail;
	private String devGender;
	private String[] devLang;
	
	public Dev() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dev(int devNo, String devName, int devCareer, String devEmail, String devGender, String[] devLang) {
		super();
		this.devNo = devNo;
		this.devName = devName;
		this.devCareer = devCareer;
		this.devEmail = devEmail;
		this.devGender = devGender;
		this.devLang = devLang;
	}

	public int getDevNo() {
		return devNo;
	}

	public void setDevNo(int devNo) {
		this.devNo = devNo;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public int getDevCareer() {
		return devCareer;
	}

	public void setDevCareer(int devCareer) {
		this.devCareer = devCareer;
	}

	public String getDevEmail() {
		return devEmail;
	}

	public void setDevEmail(String devEmail) {
		this.devEmail = devEmail;
	}

	public String getDevGender() {
		return devGender;
	}

	public void setDevGender(String devGender) {
		this.devGender = devGender;
	}

	public String[] getDevLang() {
		return devLang;
	}

	public void setDevLang(String[] devLang) {
		this.devLang = devLang;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Dev [devNo=" + devNo + ", devName=" + devName + ", devCareer=" + devCareer + ", devEmail=" + devEmail
				+ ", devGender=" + devGender + ", devLang=" + Arrays.toString(devLang) + "]";
	}

	
	
	
	
}
