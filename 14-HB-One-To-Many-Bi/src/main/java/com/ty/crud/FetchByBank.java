package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Account;
import com.ty.entity.Bank;

public class FetchByBank {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Bank bank = em.find(Bank.class, 1);

		if (bank != null) {
			System.out.println("----------Bank-----------");
			System.out.println(bank.getBid());
			System.out.println(bank.getName());
			System.out.println(bank.getAddress());

			List<Account> accounts = bank.getAccounts();
			System.out.println("-------Accounts-----------");
			for (Account account : accounts) {
				System.out.println(account.getAccno());
				System.out.println(account.getName());
				System.out.println(account.getAmount());
				System.out.println("-----------------");
			}

		} else {
			System.out.println("not found");
		}

	}
}
