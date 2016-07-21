package com.db.ss.dto;

public class Shop {

	private String shopName;
	private String shopNumber;
	private String shopPostCode;
	private String shopLongitude;
	private String shopLatitude;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}

	public String getShopPostCode() {
		return shopPostCode;
	}

	public void setShopPostCode(String shopPostCode) {
		this.shopPostCode = shopPostCode;
	}

	public String getShopLongitude() {
		return shopLongitude;
	}

	public void setShopLongitude(String shopLongitude) {
		this.shopLongitude = shopLongitude;
	}

	public String getShopLatitude() {
		return shopLatitude;
	}

	public void setShopLatitude(String shopLatitude) {
		this.shopLatitude = shopLatitude;
	}

	@Override
	public String toString() {
		return "Shop [shopName=" + shopName + ", shopNumber=" + shopNumber + ", shopPostCode=" + shopPostCode
				+ ", shopLongitude=" + shopLongitude + ", shopLatitude=" + shopLatitude + "]";
	}
}
