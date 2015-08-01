package org.upiicsa.dao;

import org.upiicsa.dao.entidades.Actividad;
import org.upiicsa.dao.entidades.Producto;

public interface IDaoPresupuesto {

	Producto getProductoById(Integer id);
	
	Actividad getActividadById(Integer id);

}
