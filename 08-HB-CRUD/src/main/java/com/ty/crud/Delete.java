package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Employee;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Employee emp = em.find(Employee.class, 103);

		if (emp != null) {

			et.begin();
			em.remove(emp);
			et.commit();

			System.out.println("Employee is deleted");

		} else {
			System.out.println("Not found");
		}
	}
}
