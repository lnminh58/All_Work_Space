package org.hocviencntt.rating.repository;

import org.hocviencntt.rating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
