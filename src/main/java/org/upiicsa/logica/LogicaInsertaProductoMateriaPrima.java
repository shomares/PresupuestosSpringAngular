package org.upiicsa.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.Actividad;
import org.upiicsa.dao.entidades.CostoActividad;
import org.upiicsa.dao.entidades.MateriaPrima;
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.dao.entidades.UsoMateriaPrima;
import org.upiicsa.web.model.MateriaPrimaView;
import org.upiicsa.web.model.ProductoView;

@Component(value = "logicaMateriaPrimaProducto")
public class LogicaInsertaProductoMateriaPrima implements ILogicaInsertaProductoMateriaPrima {

	@Autowired
	@Qualifier(value = "daoMateriaPrima")
	private IDao<MateriaPrima> daoMateriaPrima;

	@Autowired
	@Qualifier(value = "daoProducto")
	private IDao<Producto> daoProducto;

	@Autowired
	@Qualifier(value = "daoMateriaPrimaProducto")
	private IDao<UsoMateriaPrima> daoUsoMateriaPrima;

	@Autowired
	@Qualifier("daoActividad")
	private IDao<Actividad> daoActividad;

	@Autowired
	@Qualifier("daoCostoActividad")
	private IDao<CostoActividad> daoCostoActividad;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.upiicsa.logica.ILogicaInsertaProductoMateriaPrima#insertaProducto(org
	 * .upiicsa.dao.entidades.Producto)
	 */
	@Override
	public void insertaProducto(Producto producto) {
		producto.setId(daoProducto.insertorUpdate(producto));

		// Por cada Materia Prima
		for (MateriaPrima prima : daoMateriaPrima.getAll()) {
			UsoMateriaPrima uso = new UsoMateriaPrima();
			uso.setMateriaPrima(prima);
			uso.setProducto(producto);
			uso.setUsoProducto(0.0f);
			uso.setId(daoUsoMateriaPrima.insertorUpdate(uso));
		}
		for (Actividad actividad : daoActividad.getAll()) {
			CostoActividad costo = new CostoActividad();
			costo.setActividad(actividad);
			costo.setProducto(producto);
			daoCostoActividad.insertorUpdate(costo);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.upiicsa.logica.ILogicaInsertaProductoMateriaPrima#insertaMateriaPrima
	 * (org.upiicsa.dao.entidades.MateriaPrima)
	 */
	@Override
	public void insertaMateriaPrima(MateriaPrima materiaPrima) {
		materiaPrima.setId(daoMateriaPrima.insertorUpdate(materiaPrima));
		// Por cada producto ya insertado
		for (Producto producto : daoProducto.getAll()) {
			UsoMateriaPrima uso = new UsoMateriaPrima();
			uso.setMateriaPrima(materiaPrima);
			uso.setProducto(producto);
			uso.setUsoProducto(0.0f);
			uso.setId(daoUsoMateriaPrima.insertorUpdate(uso));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.upiicsa.logica.ILogicaInsertaProductoMateriaPrima#
	 * insertaOModificaMateriaPrima(org.upiicsa.dao.entidades.UsoMateriaPrima)
	 */
	@Override
	public void insertaOModificaMateriaPrima(UsoMateriaPrima uso) {
		daoUsoMateriaPrima.insertorUpdate(uso);
	}

	@Override
	public List<MateriaPrima> getMateriaPrimas() {
		// TODO Auto-generated method stub
		return daoMateriaPrima.getAll();
	}

	@Override
	public List<Producto> getProductos() {
		// TODO Auto-generated method stub
		return daoProducto.getAll();
	}

	@Override
	public ProductoView getProductoPorId(Integer id) {
		// TODO Auto-generated method stub
		Producto producto = daoProducto.getById(id);
		ProductoView pv = new ProductoView();
		pv.setNombre(producto.getNombre());
		pv.setId(producto.getId());
		pv.setCantidadInventarioInicial(producto.getCantidadInventarioInicial());
		pv.setCantidadInventarioFinal(producto.getCantidadInventarioFinal());
		pv.setCostoInicial(producto.getCostoInicial());
		pv.setUnidades(producto.getUnidades());
		return pv;

	}

	@Override
	public MateriaPrimaView getMateriaPrimaPorId(Integer id) {
		// TODO Auto-generated method stub
		MateriaPrima materia = daoMateriaPrima.getById(id);
		MateriaPrimaView pv = new MateriaPrimaView();
		pv.setNombre(materia.getNombre());
		pv.setId(materia.getId());
		pv.setCantidadInventarioInicial(materia.getCantidadInventarioInicial());
		pv.setCantidadInventarioFinal(materia.getCantidadInventarioFinal());
		pv.setCostoInicial(materia.getCostoInicial());
		pv.setCostoPresupuestado(materia.getCostoPresupuestado());
		return pv;
	}

	@Override
	public void deleteProducto(Integer id) {
		// TODO Auto-generated method stub
		Producto producto = daoProducto.getById(id);
		if (producto != null)
			daoProducto.delete(producto);

	}

	@Override
	public void deleteMateriaPrima(Integer id) {
		// TODO Auto-generated method stub
		MateriaPrima materia = daoMateriaPrima.getById(id);
		if (materia != null)
			daoMateriaPrima.delete(materia);

	}

	@Override
	public void updateMateriaPrima(MateriaPrima pr) {
		// TODO Auto-generated method stub
		daoMateriaPrima.insertorUpdate(pr);

	}

	@Override
	public void updateProducto(Producto pr) {
		// TODO Auto-generated method stub
		daoProducto.insertorUpdate(pr);

	}
}
