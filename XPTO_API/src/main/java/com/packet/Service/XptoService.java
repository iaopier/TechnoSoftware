package com.packet.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.packet.Model.City;

public interface XptoService {
	<T> List<T> saveAll(Class<T> clazz, InputStream stream) throws IOException;
	List<City> findAll();
	City save(City city);
}	
