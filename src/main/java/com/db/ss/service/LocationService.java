package com.db.ss.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.db.ss.dto.Shop;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderComponent;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;

@Service
public class LocationService {

	public Shop getLocationDetails(Shop shopDetail) {
		Geocoder geocoder = new Geocoder();
		StringBuffer sb = new StringBuffer();
		sb.append(shopDetail.getShopName());
		sb.append(",");
		sb.append(shopDetail.getShopNumber());

		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(sb.toString()).getGeocoderRequest();
		geocoderRequest.addComponent(GeocoderComponent.POSTAL_CODE, shopDetail.getShopPostCode());

		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		List<GeocoderResult> results = geocoderResponse.getResults();

		if (results != null && !results.isEmpty()) {
			BigDecimal latitude = results.get(0).getGeometry().getLocation().getLat();

			BigDecimal longitude = results.get(0).getGeometry().getLocation().getLng();

			shopDetail.setShopLatitude(latitude.toString());
			shopDetail.setShopLongitude(longitude.toString());

		}

		return shopDetail;
	}

	public String findLocationByLatLng(Shop shopDetail) {
		Geocoder geocoder = new Geocoder();
		LatLng lng = new LatLng();
		lng.setLat(new BigDecimal(shopDetail.getShopLatitude()));
		lng.setLng(new BigDecimal(shopDetail.getShopLongitude()));

		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setLocation(lng).getGeocoderRequest();

		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		List<GeocoderResult> results = geocoderResponse.getResults();

		if (results != null && !results.isEmpty()) {

			return results.get(0).getFormattedAddress();

		}
		return "";
	}

}
