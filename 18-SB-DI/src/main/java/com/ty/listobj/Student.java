package com.ty.listobj;

import java.util.List;

public class Student {
	
	String name;
	List<Subject> subjects;

	public void display() {
		System.out.println("Name : " + name);
		System.out.println("----Subjects----");
		for (Subject subject : subjects) {
			subject.display();
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}