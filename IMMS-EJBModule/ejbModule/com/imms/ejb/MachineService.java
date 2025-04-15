package com.imms.ejb;

import jakarta.ejb.Stateless;


@Stateless
public class MachineService {
	
	
	public String getMachineStatus(int id) {
		return "Machine #" + id + " is running smoothly.";
	}
}
