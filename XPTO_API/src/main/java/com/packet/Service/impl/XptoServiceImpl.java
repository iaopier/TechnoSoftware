package com.packet.Service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.packet.Model.City;
import com.packet.Repository.XptoRepository;
import com.packet.Service.XptoService;

@Service
public class XptoServiceImpl implements XptoService{
	
	@Autowired
	XptoRepository xptoRepository;
	
	@Override
	public String saveAll(String stream) throws FileNotFoundException{
		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(City.class);
        String[] columns = {"ibge_id", "uf", "name", "capital","lon","lat","no_accents","alternative_names","microregion","mesoregion"};
        strat.setColumnMapping(columns);
        CsvToBean<City> csv = new CsvToBeanBuilder(new FileReader(stream))
                .withMappingStrategy(strat)
                .withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        Iterator<City> cityIterator = csv.iterator();
        while(cityIterator.hasNext()) {
            save(cityIterator.next());
        }
        return "Saved";
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
