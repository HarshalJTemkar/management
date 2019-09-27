package harshal.temkar.management.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao<id extends Serializable, T> {

	@Autowired
	private EntityManager entityManager;

	protected Session getSession() {
		return this.entityManager.unwrap(Session.class);
	}

	private final Class<T> generalClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.generalClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	public void save(T entity) {
		getSession().persist(entity);
	}

	public T update(T entity) {
		getSession().merge(entity);
		return entity;
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public void deleteById(id entityId) {
		T entity = getById(entityId);
		getSession().delete(entity);
	}

	public boolean isPresent(id id) {
		boolean obj = false;
		if (getById(id) != null) {
			obj = true;
		}
		return obj;
	}

	public T getById(id id) {
		return (T) getSession().get(generalClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return (List<T>) getSession().createCriteria(generalClass).list();
	}
}
