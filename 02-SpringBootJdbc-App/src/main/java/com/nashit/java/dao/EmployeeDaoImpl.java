package com.nashit.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nashit.java.beans.EmployeeBO;

@Repository("dao")
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private DataSource dataSource;

	private static final String GET_EMP_DESG = "select * from employee where job in";

	@Override
	public List<EmployeeBO> fetchEmpByDesg(String cond) throws Exception {

		List<EmployeeBO> listBo = null;
		EmployeeBO bo = null;
		System.out.println("Datasource type is :: " + dataSource.getClass().getName());

		try (Connection connection = dataSource.getConnection();
				Statement smt = connection.createStatement();
				ResultSet resultSet = smt.executeQuery(GET_EMP_DESG + cond + "order by empName")) {

			listBo = new ArrayList<>();

			while (resultSet.next()) {
				bo = new EmployeeBO();
				bo.setEmpNo(resultSet.getInt(1));
				bo.setEmpName(resultSet.getString(2));
				bo.setJob(resultSet.getString(3));
				bo.setSalary(resultSet.getFloat(4));
				bo.setDeptNo(resultSet.getInt(5));
				bo.setMgrNo(resultSet.getInt(6));

				listBo.add(bo);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return listBo;
	}

}
