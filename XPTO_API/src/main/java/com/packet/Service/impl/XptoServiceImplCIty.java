package com.packet.Service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.packet.Model.State;
import com.packet.Repository.XptoRepositoryCity;
import com.packet.Service.XptoServiceCity;

@Service
public class XptoServiceImplCIty implements XptoServiceCity {

	@Autowired
	XptoRepositoryCity xptoRepository;

	@Override
	public String saveAll(String stream) throws FileNotFoundException {
		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(City.class);
		String[] columns = { "ibge_id", "uf", "name", "capital", "lon", "lat", "no_accents", "alternative_names",
				"microregion", "mesoregion" };
		strat.setColumnMapping(columns);
		CsvToBean<City> csv = new CsvToBeanBuilder(new FileReader(stream)).withMappingStrategy(strat).withSkipLines(1)
				.withIgnoreLeadingWhiteSpace(true).build();
		Iterator<City> cityIterator = csv.iterator();
		while (cityIterator.hasNext()) {
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

	@Override
	public List<City> findAllCapital() {
		return xptoRepository.findByCapital();
	}

	@Override
	public List<State> findGreaterAndLeast() {
		List<State> s = getNumberCitiesPerState();
		List<State> outPut = new ArrayList<State>();

		State minCidades = s.get(0);
		State maxCidades = s.get(0);
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getNum() > maxCidades.getNum()) {
				maxCidades = s.get(i);
			}

		}
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getNum() < minCidades.getNum()) {
				minCidades = s.get(i);
			}

		}
		outPut.add(minCidades);
		outPut.add(maxCidades);
		return outPut;
	}

	@Override
	public List<State> getNumberCitiesPerState() {
		List<City> l = xptoRepository.findAll();
		List<State> s = new ArrayList<State>();
		City c0 = l.get(0);
		State e = new State();
		e.setUf(c0.getUf());
		s.add(e);
		for (City c : l) {
			if (c.getUf().equals(c0.getUf())) {
				for (State es : s) {
					if (es.getUf().equals(c.getUf())) {
						es.setNum();
					}
				}
			} else {
				State t = new State();
				t.setUf(c.getUf());
				t.setNum();
				s.add(t);
				c0 = c;
			}
		}
		return s;
	}

	@Override
	public City cityPerIBGEid(int ibge_id) {
		return xptoRepository.findByIBGE(ibge_id);
	}

	@Override
	public List<City> citiesInState(String uf) {
		return xptoRepository.findCitiesInState(uf);
	}

	@Override
	public City delete(City city) {
		xptoRepository.delete(city);
		return city;
	}

	@Override
	public String distanceBetweenCities() {
		List<City> l = xptoRepository.findAll();
		City c0 = l.get(0);
		double dist = 0;
		City c1 = null;
		City c2 = null;
		for (int i = 0; i < l.size(); i++) {
			if(getDistanceFromLatLonInKm(c0.getLat(),c0.getLon(),l.get(i).getLat(),l.get(i).getLon())> dist) {
				dist = getDistanceFromLatLonInKm(c0.getLat(),c0.getLon(),l.get(i).getLat(),l.get(i).getLon());
				c1 = c0;
				c2 = l.get(i);
			}

		}
		String d = "[{\"dist\":\""+dist+"\",\"c1\":\""+c1.getName()+"\",\"c2\":\""+c2.getName()+"\"}]"; 
		return d;
	}

	private double getDistanceFromLatLonInKm(double lat1, double lon1,double lat2, double lon2) {
		  int R = 6371; // Radius of the earth in km
		  double dLat = deg2rad(lat2-lat1);  // deg2rad below
		  double dLon = deg2rad(lon2-lon1); 
		  double a = 
		    Math.sin(dLat/2) * Math.sin(dLat/2) +
		    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
		    Math.sin(dLon/2) * Math.sin(dLon/2)
		    ; 
		  double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		  double d = R * c; // Distance in km
		  return d;
		}

	private double deg2rad(double deg) {
		  return deg * (Math.PI/180);
		}
	
	
	
	

}
