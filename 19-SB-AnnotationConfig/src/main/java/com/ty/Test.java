package com.ty;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		Student student = (Student) app.getBean("student");
		student.play();

		TestApp test = (TestApp) app.getBean("testApp");
		test.greet();

		DEMO d = (DEMO) app.getBean("demoId");
		d.sayHi();
		
		Student stu = app.getBean(Student.class);
		stu.play();
		TestApp t = app.getBean(TestApp.class);
		t.greet();
	}
}
