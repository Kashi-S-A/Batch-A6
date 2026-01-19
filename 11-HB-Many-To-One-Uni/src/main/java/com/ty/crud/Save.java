package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Product;
import com.ty.entity.Review;

public class Save {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product product = new Product(11, "Phone", 25000, "8GB RAM , 128GB Storage");

		Review r1 = new Review(1, "Good");
		Review r2 = new Review(2, "Best");
		Review r3 = new Review(3, "Average");

		r1.setProduct(product);
		r2.setProduct(product);
		r3.setProduct(product);

		et.begin();
		em.persist(product);
		em.persist(r3);
		em.persist(r2);
		em.persist(r1);
		et.commit();

		System.out.println("saved");

	}
}
