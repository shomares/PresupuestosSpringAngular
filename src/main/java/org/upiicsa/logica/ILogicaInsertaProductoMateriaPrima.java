package org.upiicsa.logica;

import java.util.List;

import org.upiicsa.dao.entidades.MateriaPrima;
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.dao.entidades.UsoMateriaPrima;
import org.upiicsa.web.model.MateriaPrimaView;
import org.upiicsa.web.model.ProductoView;

public interface ILogicaInsertaProductoMateriaPrima {
	void insertaProducto(Producto producto);
	void insertaMateriaPrima(MateriaPrima materiaPrima);
	void insertaOModificaMateriaPrima(UsoMateriaPrima uso);
	List<MateriaPrima> getMateriaPrimas();
	List<Producto> getProductos();
	ProductoView getProductoPorId(Integer id);
	MateriaPrimaView getMateriaPrimaPorId(Integer id);
	void deleteProducto(Integer id);
	void deleteMateriaPrima(Integer id);
	void updateMateriaPrima(MateriaPrima pr);
	void updateProducto(Producto pr);

}