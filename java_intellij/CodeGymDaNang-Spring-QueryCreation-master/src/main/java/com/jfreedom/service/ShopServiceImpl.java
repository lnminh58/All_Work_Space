package com.jfreedom.service;

import java.util.Date;
import java.util.List;


import com.jfreedom.model.Custommer;
import com.jfreedom.reponsitory.CustomerJPAReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.jfreedom.dao.ShopDAO;
import com.jfreedom.model.Shop;
import com.jfreedom.reponsitory.ShopJPAReponsitoryCustom;




@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	//ShopDAO dao;
	ShopJPAReponsitoryCustom reponsitoryCustom;

	
	
	public List<Shop> getAllShops() {
		
		//return dao.getAllShops();
		return reponsitoryCustom.findAll();
	}
	public  Shop findOneId(){

		return reponsitoryCustom.findOne(1);
	}
	/*public List<Shop> findAllArray(){
		return  reponsitoryCustom.
	}*/
	public List<Shop> findByName( String name){

		return reponsitoryCustom.findByName(name);

	}
public List<Shop> findByNameLike( String name){

	return reponsitoryCustom.findByNameLike("%" + name + "%");

}
	public  List<Shop> findByNameContaining(String name){

		return reponsitoryCustom.findByNameContaining(name);
	}
	public  List<Shop> findByNameStartingWith(String name){

		return reponsitoryCustom.findByNameContaining(name);
	}
	public  List<Shop> findByNameEndingWith(String name){

		return reponsitoryCustom.findByNameEndingWith(name);
	}
	public  List<Shop> findByNameEgnoreCase(String name){

		return reponsitoryCustom.findByNameIgnoreCase(name);
	}
	public List<Shop> findByEmail(String email){
		return reponsitoryCustom.findByEmail(email);
	}
	public List<Shop> findByNameAndLocal(String name,String local){
	return reponsitoryCustom.findByNameAndLocal(name, local);
	}
	public List<Shop> findByNameOrLocal(String name,String local){
		return reponsitoryCustom.findByNameOrLocal(name, local);
	}
	public List<Shop> findByNameNot(String name){
		return reponsitoryCustom.findByNameNot(name);
	}

	public List<Shop> findByDateAfter(Date date){

		return  reponsitoryCustom.findByDateAfter(date);
	}
	public List<Shop> findByDateBefore (Date date){

		return  reponsitoryCustom.findByDateBefore(date);
	}
	public List<Shop> findByDateBetween(Date from,Date to){

		return reponsitoryCustom.findByDateBetween(from, to);
	}
	public List<Shop> listAllShop(){
		return reponsitoryCustom.listAllShop();
	}
	public List<Shop> listAllShopByName(String name){
		return reponsitoryCustom.listAllShopByName(name);
	}
	public List<Shop> findAllShop(){
		return reponsitoryCustom.findAllShop();
	}



	
}
