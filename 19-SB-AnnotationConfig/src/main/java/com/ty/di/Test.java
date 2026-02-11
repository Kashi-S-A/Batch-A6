package com.ty.di;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		Person person = app.getBean(Person.class);
		person.read();
		person.details();

		System.out.println("-----------");

		Employee emp = app.getBean(Employee.class);
		emp.display();

		System.out.println("------------");

		Student student = app.getBean(Student.class);
		student.display();

		System.out.println("-------------");

		Car car = app.getBean(Car.class);
		car.drive();
	}
}
