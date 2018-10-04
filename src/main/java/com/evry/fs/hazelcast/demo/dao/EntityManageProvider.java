/**
 * 
 */
package com.evry.fs.hazelcast.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManageProvider {
	private static final EntityManagerFactory entityManagerFactory = init();

	private static EntityManager entityManager = null;

	private static EntityManagerFactory  init()  {
		EntityManagerFactory entityManagerFactoryCreated = null;
		try {
			entityManagerFactoryCreated  = Persistence.createEntityManagerFactory("oracledbconnection");
			if (entityManagerFactory == null) {
				System.out.println("Could not init Persistence conetxt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entityManagerFactoryCreated;
	}
	public static EntityManager provideEntityManager() {
		if (entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
			return entityManager;
		}
		else {
			return entityManager;
		}
	}
}
