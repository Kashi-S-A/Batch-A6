package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.entity.Employee;

public class FetchAll {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

//		String jpql = "select emp from Employee emp";
//		Query query = em.createQuery(jpql);

//		Naming based parameter
//		String jpql = "select emp from Employee emp where emp.salary=:empSal";
//		Query query = em.createQuery(jpql);
//		query.setParameter("empSal", 60000D);

//		Index based parameter
		String jpql = "select emp from Employee emp where emp.salary=?1 and emp.email=?2";
		Query query = em.createQuery(jpql);
		query.setParameter(1, 60000D);
		query.setParameter(2, "zingi@gmail.com");

		List<Employee> list = query.getResultList();

		System.out.println("===========Employee==========");

		if (list.isEmpty()) {
			System.out.println("No records found");
		} else {
			for (Employee employee : list) {
				System.out.println(employee.getName());
				System.out.println(employee.getEid());
				System.out.println(employee.getEmail());
				System.out.println(employee.getSalary());
				System.out.println("----------------");
			}
		}

		System.out.println("---------------------------");
		String jpq = "select emp.email from Employee emp";
		Query q = em.createQuery(jpq);

		List<String> l = q.getResultList();

		System.out.println("===========Employee==========");

		if (l.isEmpty()) {
			System.out.println("No records found");
		} else {
			System.out.println(l);
		}
	}
}
