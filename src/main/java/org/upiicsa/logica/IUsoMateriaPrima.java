package org.upiicsa.logica;

import org.upiicsa.web.model.UsoMateriaPorProductoView;

public interface IUsoMateriaPrima {

	UsoMateriaPorProductoView  getByIdProducto(Integer id);

	void insertaUsoProducto(UsoMateriaPorProductoView jSON);

	
}
