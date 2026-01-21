package com.ty.curd;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Actor;
import com.ty.entity.Movie;

public class Save {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Movie m = new Movie(1, "Kedarnath");

		Actor a1 = new Actor(11, "SSR", 35);
		Actor a2 = new Actor(22, "Sara", 30);

		m.setActors(Arrays.asList(a1, a2));

		et.begin();
		em.persist(m);
		em.persist(a1);
		em.persist(a2);
		et.commit();

		System.out.println("saved");

	}
}
