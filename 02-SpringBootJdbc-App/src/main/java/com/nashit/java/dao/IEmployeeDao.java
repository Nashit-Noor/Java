package com.nashit.java.dao;

import java.util.List;

import com.nashit.java.beans.EmployeeBO;

public interface IEmployeeDao {
	
	public List<EmployeeBO> fetchEmpByDesg(String cond) throws Exception; 
}
