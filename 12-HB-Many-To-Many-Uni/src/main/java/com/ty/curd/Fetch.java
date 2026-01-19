package com.ty.curd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Actor;
import com.ty.entity.Movie;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Actor actor = em.find(Actor.class, 21);

		if (actor != null) {
			System.out.println("=======Actor==========");
			System.out.println(actor.getAid());
			System.out.println(actor.getName());
			System.out.println(actor.getAge());

			System.out.println("----------Movies--------");
			List<Movie> movies = actor.getMovies();
			for (Movie movie : movies) {
				System.out.println(movie.getMid());
				System.out.println(movie.getTitle());
				System.out.println("-----------------");
			}
		} else {
			System.out.println("not found");
		}
	}
}
