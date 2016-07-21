package com.db.ss.utils;

import java.util.ArrayList;
import java.util.List;

import com.db.ss.dto.Shop;

public class ShopUtils {
	
	public static List<Shop> list = new ArrayList<Shop>();
	
	public static boolean addShopList(Shop shop){
		return list.add(shop);
	}

	public static int size(){
		return list.size();
	}
}
