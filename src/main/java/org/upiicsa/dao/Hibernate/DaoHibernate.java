package org.upiicsa.dao.Hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.transaction.annotation.Transactional;
import org.upiicsa.dao.IDao;
import org.upiicsa.dao.IEntity;

@Transactional
public class DaoHibernate<T extends IEntity> implements IDao<T> {
	final Class<T> typeParameterClass;
	public DaoHibernate(Class<T> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
	}

	
	private SessionFactory session;

	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	@Override
	public Integer insertorUpdate(T entidad) {
		// TODO Auto-generated method stub
		Session sesion = session.getCurrentSession();
		sesion.saveOrUpdate(entidad);
		return entidad.getId();
	}

	@Override
	public void delete(T entidad) {
		// TODO Auto-generated method stub
		Session sesion = session.getCurrentSession();
		sesion.delete(entidad);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		Criteria crit= session.getCurrentSession().createCriteria(typeParameterClass);
		crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Integer id) {
		// TODO Auto-generated method stub
	  T  objeto= (T)session.getCurrentSession().load(typeParameterClass, id);
	  Hibernate.initialize(objeto);
	  return objeto;
	  
	}

}
