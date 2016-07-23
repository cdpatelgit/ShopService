package com.db.ss.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.db.ss.dto.Shop;
import com.db.ss.service.LocationService;

public class LocationServiceTest {

	@Test
	public void testFindLocationByLatLng() {

		Shop shop = new Shop();
		shop.setShopLatitude("18.5511754");
		shop.setShopLongitude("73.8907873");
		LocationService service = new LocationService();
		String locationDetails = service.findLocationByLatLng(shop);

		assertEquals("103/2, Airport Rd, Jayprakash Nagar, Yerawada, Pune, Maharashtra 411006, India", locationDetails);

	}

	@Test
	public void testGetLocation() {

		Shop shop = new Shop();
		shop.setShopName("103/2, Airport Rd, Jayprakash Nagar, Yerawada, Pune, Maharashtra");
		shop.setShopNumber("103/2");
		shop.setShopPostCode("411006");
		LocationService service = new LocationService();
		Shop locationDetails = service.getLocationDetails(shop);

		assertEquals("18.551043", locationDetails.getShopLatitude());
		assertEquals("73.88977799999999", locationDetails.getShopLongitude());

	}
	
	@Test
	public void testLocationNotFound() {


		Shop shop = new Shop();
		shop.setShopLatitude("980");
		shop.setShopLongitude("600");
		LocationService service = new LocationService();
		String locationDetails = service.findLocationByLatLng(shop);

		assertEquals("Location Not Found",locationDetails);
	}

}
