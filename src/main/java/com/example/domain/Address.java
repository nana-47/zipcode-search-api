package com.example.domain;

public class Address {

	private Integer id;
	private String zipcode;
	private String prefecture;
	private String address1;
	private String address2;
	private String address3;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", zipcode=" + zipcode + ", prefecture=" + prefecture + ", address1=" + address1
				+ ", address2=" + address2 + ", address3=" + address3 + "]";
	}

}

