package org.upiicsa.logica.Presupuesto;

import java.util.ArrayList;
import java.util.List;

import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.web.model.ProductoView;
import org.upiicsa.web.model.Presupuesto.CostoUnitarioProduccion.PresupuestoCostoUnitarioProduccion;
import org.upiicsa.web.model.Presupuesto.PresupuestoVenta.PresupuestoVenta;
import org.upiicsa.web.model.Presupuesto.PresupuestoVenta.PresupuestoVentaDetalle;

public class LogicaPresupuestoVenta extends PresupuestoAbstract {

	private IDao<Producto> daoProducto;
	private LogicCostoUnitarioProduccion costoUnitario;

	public IDao<Producto> getDaoProducto() {
		return daoProducto;
	}

	public void setDaoProducto(IDao<Producto> daoProducto) {
		this.daoProducto = daoProducto;
	}

	public LogicCostoUnitarioProduccion getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(LogicCostoUnitarioProduccion costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	@Override
	public void calcular() {
		// TODO Auto-generated method stub
		PresupuestoVenta salida = new PresupuestoVenta();
		List<PresupuestoVentaDetalle> lista = new ArrayList<PresupuestoVentaDetalle>();
		List<Producto> productos = daoProducto.getAll();
		PresupuestoCostoUnitarioProduccion unitario = (PresupuestoCostoUnitarioProduccion) costoUnitario.getSalida();
		for (Producto producto : productos) {
			Float precioUnitario = unitario.getPrecioUnitarioPorProducto(producto.getId());
			PresupuestoVentaDetalle detalle = new PresupuestoVentaDetalle();
			ProductoView pr = new ProductoView();
			pr.setId(producto.getId());
			pr.setNombre(producto.getNombre());
			detalle.setProducto(pr);
			detalle.setPrecioUnitario(precioUnitario);
			detalle.setImporte(precioUnitario * producto.getUnidades());
			lista.add(detalle);
		}
		salida.setLista(lista);
		this.salida = salida;
		notificaAvance(this.salida, this.notificarFin);

	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

}
