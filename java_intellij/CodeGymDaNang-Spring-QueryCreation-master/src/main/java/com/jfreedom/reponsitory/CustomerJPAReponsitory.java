package com.jfreedom.reponsitory;

import com.jfreedom.model.Custommer;
import com.jfreedom.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by PC-PC on 9/8/2016.
 */
public interface CustomerJPAReponsitory extends JpaRepository<Custommer, Integer> {
    List<Custommer> findBycusName (String cusName);
}
