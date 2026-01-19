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

		Actor actor = new Actor(3, "SK", 61);

		Movie m1 = new Movie(55, "Sultan");

//		Movie m2 = new Movie(44, "Tiger Zinda Hai");// new object saving for the first time

		Movie m2 = em.find(Movie.class, 44);// it is an existing object

		actor.setMovies(Arrays.asList(m1, m2));

		et.begin();
		em.persist(actor);
		em.persist(m1);
//		em.persist(m2);
		et.commit();

		System.out.println("saved");

	}
}
