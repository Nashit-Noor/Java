package com.nashit.java.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashit.java.beans.EmployeeBO;
import com.nashit.java.beans.EmployeeDTO;
import com.nashit.java.dao.IEmployeeDao;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;

	@Override
	public List<EmployeeDTO> fetchEmpByDesg(String desg[]) throws Exception {

		// desg = ['batsman','bowler']

		System.out.println(dao.getClass().getName());

		// create mutable memory for conversion
		StringBuilder sb = new StringBuilder("(");
		for (int i = 0; i < desg.length; i++) {
			// processing last index
			if (i == desg.length - 1) {
				sb.append("'" + desg[i] + "')");
			} else {
				// still data is there to be processed
				sb.append("'" + desg[i] + "',");
			}
		}

		// converting StringBuilder to String
		String cond = sb.toString();
		System.out.println("Condition to be sent is :: " + cond);

		List<EmployeeBO> listBo = dao.fetchEmpByDesg(cond);
		List<EmployeeDTO> listDto = new ArrayList<>();
		listBo.forEach(bo -> {

			EmployeeDTO dto = new EmployeeDTO();

			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDto.size() + 1);
			
			listDto.add(dto);
		});

		return listDto;
	}

}
