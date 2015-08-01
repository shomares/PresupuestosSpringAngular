package org.upiicsa.dao;

import java.util.List;

public interface IDao<T extends IEntity> {
	Integer insertorUpdate(T entidad);
	void delete(T entidad);
	List<T> getAll();
	T getById(Integer id);
}
