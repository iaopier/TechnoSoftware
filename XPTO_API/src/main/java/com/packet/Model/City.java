package com.packet.Model;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "City")
public class City implements Serializable{
	@Id
	private int ibge_id;
	private String uf;
	private String name;
	private String capital;
	private double lon;
	private double lat;
	private String no_accents;
	private String alternative_names;
	private String microregion;
	private String mesoregion;
	public City() {
		super();
	}
	
	public int getIbge_id() {
		return ibge_id;
	}
	public void setIbge_id(int ibge_id) {
		this.ibge_id = ibge_id;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public String getNo_accents() {
		return no_accents;
	}
	public void setNo_accents(String name_no_accents) {
		this.no_accents = name_no_accents;
	}
	public String getMicroregion() {
		return microregion;
	}
	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}
	public String getMesoregion() {
		return mesoregion;
	}
	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}

	public String getAlternative_names() {
		return alternative_names;
	}

	public void setAlternative_names(String alternative_names) {
		this.alternative_names = alternative_names;
	}
	
	
	
}
