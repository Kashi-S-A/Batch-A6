package com.ty.crud;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Account;
import com.ty.entity.Bank;

public class Save {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Bank bank = new Bank(1, "SBI", "Thane");

		Account a1 = new Account(1122, "A", 10000);
		Account a2 = new Account(2233, "B", 5000);
		Account a3 = new Account(2212, "C", 2000);

//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(a1);
//		accounts.add(a2);
//		accounts.add(a3);
//		bank.setAccounts(accounts);

		bank.setAccounts(Arrays.asList(a1, a2, a3));

		et.begin();
		em.persist(bank);
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		et.commit();

		System.out.println("saved");

	}
}
