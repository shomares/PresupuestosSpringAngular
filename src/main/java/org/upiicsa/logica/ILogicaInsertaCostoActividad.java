package org.upiicsa.logica;

import org.upiicsa.web.model.CostoActividadView;

public interface ILogicaInsertaCostoActividad {

	CostoActividadView getByIdCostoActividad(Integer id);

	void insertaUsoProducto(CostoActividadView jSON);

}