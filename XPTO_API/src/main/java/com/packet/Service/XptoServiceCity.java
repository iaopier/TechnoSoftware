package com.packet.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.packet.Model.City;
import com.packet.Model.State;

public interface XptoServiceCity {
	String saveAll(String string) throws IOException;
	List<City> findAll();
	City save(City city);
	List<City> findAllCapital();
	List<State> findGreaterAndLeast();
	List<State> getNumberCitiesPerState();
	City cityPerIBGEid(int ibge_id);
}	
