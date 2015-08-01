package org.upiicsa.logica;

import java.util.List;

import org.upiicsa.dao.entidades.Actividad;
import org.upiicsa.web.model.ActividadView;

public interface ILogicaActividad {

	void insertaActividad(Actividad actividad);

	ActividadView getById(Integer id);

	List<Actividad> getActividades();

	void borrarActividad(Integer id);

	void updateActividad(Actividad actividad);

}