package org.hocviencntt.location.service;

import java.util.List;

import org.hocviencntt.location.model.Location;
public interface LocationService {

	public List<Location> findByLocation(String city);
}
