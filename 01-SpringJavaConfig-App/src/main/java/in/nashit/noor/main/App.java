package in.nashit.noor.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.nashit.noor.main.bean.Employee;
import in.nashit.noor.main.config.AppConfig;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Employee emp = context.getBean("empObj", Employee.class);
		System.out.println(emp);
		context.close();
	}
}
