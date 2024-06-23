package com.nashit.java;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nashit.java.controller.MainController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the designated count :: ");
		int count = sc.nextInt();

		String[] desg = null;

		if (count >= 1) {
			desg = new String[count];
		} else {
			System.out.println("Invalid designation count ..");
			System.exit(0);
		}

		for (int i = 0; i < count; i++) {
			System.out.print("Enter the designation :: ");
			desg[i] = sc.next();
		}

		try {
			MainController controller = context.getBean(MainController.class);
			controller.fetchEmpByDesg(desg).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

		sc.close();
		((ConfigurableApplicationContext) context).close();

	}

}
