package com.ty.curd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Actor;
import com.ty.entity.Movie;

public class FetchByMovie {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Movie movie = em.find(Movie.class, 1);

		if (movie != null) {
			System.out.println("------Movie-----");
			System.out.println(movie.getMid());
			System.out.println(movie.getTitle());

			List<Actor> actors = movie.getActors();
			System.out.println("----Actors------");
			for (Actor actor : actors) {
				System.out.println(actor.getAid());
				System.out.println(actor.getName());
				System.out.println(actor.getAge());
				System.out.println("-------------");
			}
		} else {
			System.out.println("Not found");
		}

	}
}
