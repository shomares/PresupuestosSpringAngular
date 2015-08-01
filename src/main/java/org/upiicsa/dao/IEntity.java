package org.upiicsa.dao;

import java.io.Serializable;

public interface IEntity extends Serializable {
	void setId(Integer id);
	Integer getId();
}
