package in.nashit.noor.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.nashit.noor.main.bean.Employee;

@Configuration
public class AppConfig {
	
	static {
		System.out.println("AppConfig.class file is loading");
	}
	
	public AppConfig() {
		System.out.println("AppConfig object is created..");
	}
	
	@Bean
	public Employee empObj() {
		System.out.println("AppConfig.empObj():: Creating the object...");
		Employee employee = new Employee();
		employee.setEid(10);
		employee.setEname("sachin");
		employee.setEage(52);
		employee.setEaddress("MI");
		return employee;
	}

}
