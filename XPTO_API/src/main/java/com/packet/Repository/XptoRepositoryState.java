package com.packet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.packet.Model.State;

@Repository
public interface XptoRepositoryState extends JpaRepository<State,Long>{
	@Query(value = "SELECT id,uf,num FROM (SELECT uf,COUNT(*) AS 'num',0 AS id FROM city GROUP BY uf) AS HIGH" , nativeQuery=true)
	List<State> findGreaterAndLeast();
}
