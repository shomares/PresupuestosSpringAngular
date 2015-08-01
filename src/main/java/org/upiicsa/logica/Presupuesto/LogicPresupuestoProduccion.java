package org.upiicsa.logica.Presupuesto;

import java.util.ArrayList;
import java.util.List;

import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.web.model.ProductoView;
import org.upiicsa.web.model.Presupuesto.Produccion.PresupuestoProduccion;
import org.upiicsa.web.model.Presupuesto.Produccion.ProductoPresupuestoProduccion;

public class LogicPresupuestoProduccion extends PresupuestoAbstract  {

	private IDao<Producto> daoProducto;

	public LogicPresupuestoProduccion() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.upiicsa.logica.Presupuesto.IPresusupuesto#addHandler(org.upiicsa.
	 * logica.Presupuesto.INotificaEvento)
	 */

	public IDao<Producto> getDaoProducto() {
		return daoProducto;
	}

	public void setDaoProducto(IDao<Producto> daoProducto) {
		this.daoProducto = daoProducto;
	}

	@Override
	public void calcular() {
		Float i = 0.0f;
		PresupuestoProduccion salida = new PresupuestoProduccion();
		List<ProductoPresupuestoProduccion> lineas = new ArrayList<ProductoPresupuestoProduccion>();
		List<Producto> productos = daoProducto.getAll();
		for (Producto producto : productos) {
			ProductoPresupuestoProduccion presi = new ProductoPresupuestoProduccion();
			ProductoView prView = new ProductoView();
			prView.setNombre(producto.getNombre());
			prView.setId(producto.getId());
			presi.setProducto(prView);
			presi.setInventarioFinalDeseado(producto.getCantidadInventarioFinal());
			presi.setUnidadesaAVender(producto.getUnidades());
			presi.setInventarioTotal(producto.getCantidadInventarioInicial());
			presi.setNecesidadTotal(producto.getUnidades() + producto.getCantidadInventarioFinal());
			presi.setUnidadesaProducir(presi.getNecesidadTotal() - presi.getInventarioTotal());
			lineas.add(presi);
			notificaAvance((Object) (i++ / productos.size() * 100), this.notificarAvance);
		}
		synchronized (salida) {
			salida.setProductos(lineas);
		}
		this.salida= salida;
		notificaAvance(this.salida, this.notificarFin);
	}
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Presupuesto de Producccion";
	}
}
