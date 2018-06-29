package com.jfreedom.service;

import java.util.Date;
import java.util.List;

import com.jfreedom.model.Custommer;
import com.jfreedom.model.Shop;
import org.springframework.data.repository.query.Param;

public interface ShopService {

	public List<Shop> getAllShops();
	public  Shop findOneId();
	/*public  List<Shop> findAllArray();*/
	public List<Shop> findByName( String name);
	List<Shop> findByNameLike( String name);
	public  List<Shop> findByNameContaining(String name);
	List<Shop> findByNameStartingWith(String name);
	List<Shop> findByNameEndingWith(String name);
	List<Shop> findByNameEgnoreCase(String name);
	List<Shop> findByEmail(String email);
	List<Shop> findByNameAndLocal(String name,String local);
	List<Shop> findByNameOrLocal(String name,String local);
	List<Shop> findByNameNot(String name);
	List<Shop> findByDateAfter(Date date);
	List<Shop> findByDateBefore(Date date);
	List<Shop> findByDateBetween(Date from,Date to);
	 List<Shop> listAllShop();
	List<Shop> listAllShopByName(String name);
	List<Shop> findAllShop();



}
