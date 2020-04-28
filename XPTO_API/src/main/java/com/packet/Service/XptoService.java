package com.packet.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.packet.Model.City;

public interface XptoService {
	String saveAll(String string) throws IOException;
	List<City> findAll();
	City save(City city);
}	
