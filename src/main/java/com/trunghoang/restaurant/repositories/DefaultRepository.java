package com.trunghoang.restaurant.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.trunghoang.restaurant.constants.ErrorMessage;
import com.trunghoang.restaurant.domains.IdEntity;
import com.trunghoang.restaurant.exceptions.ApplicationException;

/**
 * 
 * 
 * Default repository
 * 
 * @param <ENTITY>
 */
public abstract class DefaultRepository<ENTITY extends IdEntity> implements IRepository<ENTITY> {

	private Class<ENTITY> clazz;

	@PersistenceContext(unitName = "restaurantpersistence")
	protected EntityManager em;

	/**
	 * 
	 * @param clazz
	 */
	public DefaultRepository(Class<ENTITY> clazz) {
		this.clazz = clazz;
	}

	@Override
	public List<ENTITY> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ENTITY> cq = cb.createQuery(clazz);
		Root<ENTITY> rootEntry = cq.from(clazz);
		CriteriaQuery<ENTITY> all = cq.select(rootEntry);
		TypedQuery<ENTITY> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}

	@Override
	public ENTITY findById(long id) {
		return em.find(clazz, id);
	}

	@Override
	public void add(ENTITY entity) {
		em.persist(entity);
	}

	@Override
	public void update(ENTITY entity) {
		ENTITY existedEntity = findById(entity.getId());
		updateInfo(existedEntity, entity);
	}

	@Override
	public void delete(long id) throws ApplicationException {
		ENTITY entity = findById(id);
		if (entity == null) {
			throw new ApplicationException(ErrorMessage.ENTITY_NOT_FOUND.toString());
		}
		em.remove(entity);
	}

	public abstract void updateInfo(ENTITY existedEntity, ENTITY entity);

}
