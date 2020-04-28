package com.packet.Service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.packet.Model.City;
import com.packet.Repository.XptoRepository;
import com.packet.Service.XptoService;

@Service
public class XptoServiceImpl implements XptoService{

	private static final CsvMapper mapper = new CsvMapper();
	private static final ObjectMapper mapperJson = new ObjectMapper();
	
	@Autowired
	XptoRepository xptoRepository;
	
	@Override
	public <T> List<T> saveAll(Class<T> clazz, InputStream stream) throws IOException {
        CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnReordering(true);
        ObjectReader reader = mapper.readerFor(clazz).with(schema);
        //List<City> myCities = Arrays.asList(mapperJson.readValue(reader.<T>readValues(stream)getParser(), City[].class));
        //System.out.println(myCities.get(0));
        int contReg = 0;
        List<City> cities = new ArrayList<Cities>();
        while(contReg < reader.<T>readValues(stream).readAll().size()) {
        	
        };
        System.out.println(cities.get(0));
        return reader.<T>readValues(stream).readAll();
	}

	
	@Override
	public List<City> findAll() {
		return xptoRepository.findAll();
	}
	
	@Override
	public City save(City city) {
		xptoRepository.save(city);
		return city;
	}
}
