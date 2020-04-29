package com.packet.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.packet.Model.State;

public interface XptoServiceState {
	List<State> findGreaterAndLeast();
}
