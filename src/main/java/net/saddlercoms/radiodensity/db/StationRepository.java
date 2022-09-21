package net.saddlercoms.radiodensity.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.saddlercoms.radiodensity.db.model.RStation;

@Repository
public interface StationRepository extends JpaRepository<RStation, Long>{
	List<RStation> findAllByCallName(String callName);
	
	List<RStation> findByCategory(String category);

	List<RStation> findByCategoryLike(String likeString);
}
