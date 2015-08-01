package org.upiicsa.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.Actividad;
import org.upiicsa.dao.entidades.CostoActividad;
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.web.model.ActividadView;

@Component
public class LogicaInsertaActividad implements ILogicaActividad {

	@Autowired
	@Qualifier("daoActividad")
	private IDao<Actividad> daoActividad;

	@Autowired
	@Qualifier("daoCostoActividad")
	private IDao<CostoActividad> daoCostoActividad;

	@Autowired
	@Qualifier("daoProducto")
	private IDao<Producto> daoProducto;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.upiicsa.logica.ILogicaActividad#insertaActividad(org.upiicsa.dao.
	 * entidades.Actividad)
	 */
	@Override
	public void insertaActividad(Actividad actividad) {
		daoActividad.insertorUpdate(actividad);
		for (Producto producto : daoProducto.getAll()) {
			CostoActividad costo = new CostoActividad();
			costo.setProducto(producto);
			costo.setActividad(actividad);
			daoCostoActividad.insertorUpdate(costo);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.upiicsa.logica.ILogicaActividad#getById(java.lang.Integer)
	 */
	@Override
	public ActividadView getById(Integer id) {
		Actividad act = daoActividad.getById(id);
		ActividadView actView = new ActividadView();
		actView.setId(act.getId());
		actView.setNombre(act.getNombre());
		actView.setCargoIndirecto(act.getCargoIndirecto());
		actView.setDescripcion(act.getDescripcion());
		actView.setValesAlmacen(act.getValesAlmacen());
		actView.setValesMantenimiento(act.getValesMantenimiento());
		return actView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.upiicsa.logica.ILogicaActividad#getActividades()
	 */
	@Override
	public List<Actividad> getActividades() {
		return daoActividad.getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.upiicsa.logica.ILogicaActividad#borrarActividad(java.lang.Integer)
	 */
	@Override
	public void borrarActividad(Integer id) {
		Actividad actividad = daoActividad.getById(id);
		if (actividad != null)
			daoActividad.delete(actividad);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.upiicsa.logica.ILogicaActividad#updateActividad(org.upiicsa.dao.
	 * entidades.Actividad)
	 */
	@Override
	public void updateActividad(Actividad actividad) {
		daoActividad.insertorUpdate(actividad);
	}

}
