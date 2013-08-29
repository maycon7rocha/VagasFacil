package br.iff.campus.pooa20131n.vagasfacil.model.controller;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class AbstractPersistence {

	@PersistenceContext( unitName = "vagasfacilEJB")
	EntityManager entityManager;
	
	public Object insert(Object object) {

		entityManager.persist(object);
		
		return object;
	}

	public Object update(Object object) {
		

		entityManager.merge(object);

		
		return object;
	}

	public void delete(Class<?> classe, String codigo) {
		Object object = find(classe, codigo);
		 

		entityManager.remove(object);
		 
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> classe) {
		return entityManager.createQuery(
				"select e from " + classe.getName() + " e").getResultList();
	}

	public <T> T find(Class<T> classe, String codigo) {
		return entityManager.find(classe, codigo);
	}
}