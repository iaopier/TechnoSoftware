package com.packet.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packet.Model.State;
import com.packet.Repository.XptoRepositoryState;
import com.packet.Service.XptoServiceState;

@Service
public class XptoServiceImplState implements XptoServiceState{

	@Autowired
	XptoRepositoryState xptoRepository;
	
	@Override
	public List<State> findGreaterAndLeast() {
		return xptoRepository.findGreaterAndLeast();
	}

}
