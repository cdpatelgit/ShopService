package com.db.ss.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.db.ss.dto.Shop;
import com.db.ss.service.LocationService;
import com.db.ss.utils.ShopUtils;

@RestController
@RequestMapping(value = "/ShopService", method = RequestMethod.POST)
public class ShopFinderController {

	@Resource
	private LocationService locationService;
	
	@RequestMapping("/addShopDetails")
	public Shop addShop(@RequestBody Shop shopDetail, HttpServletRequest request) {
		Shop location = locationService.getLocationDetails(shopDetail);
		ShopUtils.addShopList(location);
		return location;
	}
	
	@RequestMapping("/findShopDetails")
	public String findShop(@RequestBody Shop shopDetail, HttpServletRequest request) {

		return locationService.findLocationByLatLng(shopDetail);
	}

}
