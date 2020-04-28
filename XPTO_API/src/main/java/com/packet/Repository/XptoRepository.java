package com.packet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.packet.Model.City;

@Repository
public interface XptoRepository extends JpaRepository<City,Long>{

}
