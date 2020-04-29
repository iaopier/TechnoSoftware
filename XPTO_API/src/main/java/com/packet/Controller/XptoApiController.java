package com.packet.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.packet.Model.City;
import com.packet.Service.XptoServiceCity;
import com.packet.Service.XptoServiceState;

@RestController
@RequestMapping("")
public class XptoApiController {
	
	@Autowired
	XptoServiceCity xptoServiceCity;
	
	@Autowired
	XptoServiceState xptoServiceState;
	
	
	
	@RequestMapping(value = "/inputCSV", method = RequestMethod.GET)
	public ResponseEntity<?> inputCSV() throws IOException{
		return new ResponseEntity<>(xptoServiceCity.saveAll("E:\\Testes\\TechnoSoftware\\Desafio Cidades - Back End.csv"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCSV", method = RequestMethod.GET)
	public ResponseEntity<?> getCSV() throws IOException {
		return new ResponseEntity<>(xptoServiceCity.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getByCapital", method = RequestMethod.GET)
	public ResponseEntity<?> getByCapital() throws IOException {
		return new ResponseEntity<>(xptoServiceCity.findAllCapital(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getStateNameGreaterAndLeast", method = RequestMethod.GET)
	public ResponseEntity<?> getStateNameGreaterAndLeast() throws IOException {
		return new ResponseEntity<>(xptoServiceCity.findGreaterAndLeast(), HttpStatus.OK);
	}
	
}
