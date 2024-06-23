package com.nashit.java.service;

import java.util.List;

import com.nashit.java.beans.EmployeeDTO;

public interface IEmployeeService {
	
	public List<EmployeeDTO> fetchEmpByDesg(String desg[]) throws Exception;
}
