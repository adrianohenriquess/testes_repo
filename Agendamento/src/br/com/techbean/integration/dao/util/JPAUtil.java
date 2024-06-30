package br.com.techbean.integration.dao.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {	
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	public static EntityManager createEntityManager(String persistenceUnit){
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.user", "techbean_agend");
		properties.put("javax.persistence.jdbc.password", "adminagend");
		properties.put("javax.persistence.jdbc.url", "jdbc:mysql://techbean.com.br:3306/techbean_agendamento");
		properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		properties.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		factory = Persistence.createEntityManagerFactory(persistenceUnit, properties);
		entityManager = factory.createEntityManager();
		return entityManager;
	}
}
