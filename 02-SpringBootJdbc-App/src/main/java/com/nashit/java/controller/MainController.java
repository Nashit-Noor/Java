package com.nashit.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nashit.java.beans.EmployeeDTO;
import com.nashit.java.beans.EmployeeVO;
import com.nashit.java.service.IEmployeeService;

@Component("controller")
public class MainController {

	@Autowired
	private IEmployeeService service;

	public List<EmployeeVO> fetchEmpByDesg(String desg[]) throws Exception {

		List<EmployeeDTO> listDto = service.fetchEmpByDesg(desg);

		List<EmployeeVO> listVO = new ArrayList<>();

		listDto.forEach(dto -> {

			EmployeeVO vo = new EmployeeVO();

			// copy such properties whose datatype and fieldNames should be same
			BeanUtils.copyProperties(dto, vo);

			//setting the properties whose datatype is not same
			vo.setEmpNo(String.valueOf(dto.getEmpNo()));
			vo.setSalary(String.valueOf(dto.getSalary()));
			vo.setDeptNo(String.valueOf(dto.getDeptNo()));
			vo.setMgrNo(String.valueOf(dto.getMgrNo()));
			vo.setSrNo(String.valueOf(dto.getSrNo()));

			listVO.add(vo);
		});

		return listVO;

	}
}
