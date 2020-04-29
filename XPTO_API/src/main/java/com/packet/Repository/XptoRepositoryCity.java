package com.packet.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.packet.Model.City;

@Repository
public interface XptoRepositoryCity extends JpaRepository<City,Long>{
	@Query(value = "SELECT * FROM city WHERE capital = 'true' ORDER BY name", nativeQuery=true)
	List<City> findByCapital();
}
