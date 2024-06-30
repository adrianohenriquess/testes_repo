package br.com.techbean.integation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.techbean.integation.dao.GenericDAO;
import br.com.techbean.integration.dao.util.JPAUtil;

public abstract class GenericDAOImpl<T> implements GenericDAO<T>{
	private EntityManager entityManager;
	
	@Override
	public boolean save(T entity) {
		entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			if (entityManager != null
					&& entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return false;
		} finally {
			if (entityManager != null && !entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}
	
	@Override
	public boolean update(T entity) {
		entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			if (entityManager != null
					&& entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return false;
		} finally {
			if (entityManager != null && !entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}
	
	@Override
	public boolean remove(T entity, Class<T> type, Integer id) {
		entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entity = entityManager.find(type, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			if (entityManager != null
					&& entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return false;
		} finally {
			if (entityManager != null && !entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}
	
	@Override
	public boolean remove(T entity, Class<T> type, Object id) {
		entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entity = entityManager.find(type, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			if (entityManager != null
					&& entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return false;
		} finally {
			if (entityManager != null && !entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}
	
	@Override
	public T getById(Class<T> type, Integer id) {
		entityManager = getEntityManager();
		return entityManager.find(type, id);
	}
	
	@Override
	public T getById(Class<T> type, Object id) {
		entityManager = getEntityManager();
		return entityManager.find(type, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> type) {
		entityManager = getEntityManager();
		return entityManager.createQuery("SELECT o FROM " + type.getSimpleName() + " o").getResultList();
	}
	
	public EntityManager getEntityManager(){
		if (this.entityManager == null || !this.entityManager.isOpen()){
			entityManager = JPAUtil.createEntityManager("Agendamento");
		}
		return entityManager;
	}
}
