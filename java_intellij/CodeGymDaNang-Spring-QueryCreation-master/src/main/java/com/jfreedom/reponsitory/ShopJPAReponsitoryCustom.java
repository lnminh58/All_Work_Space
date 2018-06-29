package com.jfreedom.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfreedom.model.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ShopJPAReponsitoryCustom extends JpaRepository<Shop, Integer>{

    List<Shop> findByName (String name);
    List<Shop> findByNameLike (String name);
    List<Shop> findByNameContaining (String name);
    List<Shop> findByNameStartingWith(String name);
    List<Shop> findByNameEndingWith(String name);
    List<Shop> findByNameIgnoreCase(String name);

    List<Shop> findByEmail(String email);
    List<Shop> findByNameAndLocal(String name,String local);
    List<Shop> findByNameOrLocal(String name,String local);
    List<Shop> findByNameNot(String name);
    List<Shop> findByDateAfter(Date date);
    List<Shop> findByDateBefore (Date date);
    List<Shop> findByDateBetween(Date from,Date to);
    @Query("select s from Shop s")
    public List<Shop> listAllShop();

    @Query("select s from Shop s where s.name = :name")
    public List<Shop> listAllShopByName(@Param("name") String name);
    public List<Shop> findAllShop();



}
