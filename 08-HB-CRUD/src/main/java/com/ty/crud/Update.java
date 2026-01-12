package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Employee;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Employee emp = em.find(Employee.class, 1030);

		if (emp != null) {
			emp.setSalary(70000);

			et.begin();
			em.merge(emp);
			et.commit();

			System.out.println("employee salary is updated");

		} else {
			System.out.println("Not found");
		}
	}
}
