package com.jfreedom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jfreedom.model.Shop;

@Repository
@Transactional
public class ShopDAOImpl implements ShopDAO{

	@PersistenceContext
	private EntityManager manage;
	
	public List<Shop> getAllShops() {
		List<Shop> allShops =  manage.createQuery("SELECT s FROM Shop s", Shop.class).getResultList();
		return allShops;
	}
	
	

}
