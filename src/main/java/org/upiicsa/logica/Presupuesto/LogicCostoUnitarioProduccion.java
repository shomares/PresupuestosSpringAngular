package org.upiicsa.logica.Presupuesto;

import java.util.ArrayList;
import java.util.List;

import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.Configuracion;
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.web.model.ProductoView;
import org.upiicsa.web.model.Presupuesto.CargosIndirectos.PresupustoProrrateoFinal;
import org.upiicsa.web.model.Presupuesto.CostoUnitarioProduccion.DetalleCostoUnitarioProduccion;
import org.upiicsa.web.model.Presupuesto.CostoUnitarioProduccion.PresupuestoCostoUnitarioProduccion;
import org.upiicsa.web.model.Presupuesto.ManoObra.PresupuestoManoObra;
import org.upiicsa.web.model.Presupuesto.Produccion.PresupuestoProduccion;
import org.upiicsa.web.model.Presupuesto.ValuacionMateriaPrima.PresupuestoValuacionMateriaPrima;

public class LogicCostoUnitarioProduccion extends PresupuestoAbstract {

	private IDao<Producto> daoProducto;
	private IDao<Configuracion> daoConfig;
	private LogicProrrateoFinal porrateoFinal;
	private LogicValuacionMateria valuacionMateria;
	private LogicPresupuestoManoObra manoObra;
	private LogicPresupuestoProduccion produccion;

	public IDao<Producto> getDaoProducto() {
		return daoProducto;
	}

	public void setDaoProducto(IDao<Producto> daoProducto) {
		this.daoProducto = daoProducto;
	}

	@Override
	public void calcular() {
		// TODO Auto-generated method stub
		List<Producto> productos = daoProducto.getAll();
		List<Configuracion> conf = daoConfig.getAll();
		List<DetalleCostoUnitarioProduccion> detalles = new ArrayList<DetalleCostoUnitarioProduccion>();
		PresupuestoCostoUnitarioProduccion salida = new PresupuestoCostoUnitarioProduccion();

		if (!conf.isEmpty()) {
			Configuracion config = conf.get(0);
			PresupustoProrrateoFinal prorrateoFinal = (PresupustoProrrateoFinal) porrateoFinal.getSalida();
			PresupuestoValuacionMateriaPrima valuacion = (PresupuestoValuacionMateriaPrima) valuacionMateria
					.getSalida();
			PresupuestoManoObra mano = (PresupuestoManoObra) manoObra.getSalida();
			PresupuestoProduccion produccionP = (PresupuestoProduccion) produccion.getSalida();

			for (Producto producto : productos) {
				DetalleCostoUnitarioProduccion detalle = new DetalleCostoUnitarioProduccion();
				ProductoView view = new ProductoView();
				view.setId(producto.getId());
				view.setNombre(producto.getNombre());

				Float materiaPrimaDirecta = valuacion.getTotalPorProducto(producto.getId());
				Float manoObraDirecta = mano.getTotalPorProducto(producto.getId());
				Float cargosIndirectos = prorrateoFinal.getTotalPorProducto(producto.getId());
				Float unidades = produccionP.getUnidadesAProducir(producto);
				Float suma = materiaPrimaDirecta + manoObraDirecta + cargosIndirectos;
				Float costoUnitario = suma / unidades;
				Float precioVenta = costoUnitario * (1 + (config.getPorcientoCostoProduccionXVenta() / 100));
				detalle.setMateriaPrimaDirecta(materiaPrimaDirecta);
				detalle.setManodeObraDirecta(manoObraDirecta);
				detalle.setCargosIndirectos(cargosIndirectos);
				detalle.setUnidades(unidades);
				detalle.setSuma(suma);
				detalle.setCostoUnitario(costoUnitario);
				detalle.setPreciodeVenta(precioVenta);
				detalle.setCargosIndirectos(cargosIndirectos);
				detalle.setProducto(view);
				detalles.add(detalle);
			}
			salida.setDetalle(detalles);
			this.salida = salida;
			notificaAvance(this.salida,this.notificarFin);
		}

	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDao<Configuracion> getDaoConfig() {
		return daoConfig;
	}

	public void setDaoConfig(IDao<Configuracion> daoConfig) {
		this.daoConfig = daoConfig;
	}

	public LogicProrrateoFinal getPorrateoFinal() {
		return porrateoFinal;
	}

	public void setPorrateoFinal(LogicProrrateoFinal porrateoFinal) {
		this.porrateoFinal = porrateoFinal;
	}

	public LogicValuacionMateria getValuacionMateria() {
		return valuacionMateria;
	}

	public void setValuacionMateria(LogicValuacionMateria valuacionMateria) {
		this.valuacionMateria = valuacionMateria;
	}

	public LogicPresupuestoManoObra getManoObra() {
		return manoObra;
	}

	public void setManoObra(LogicPresupuestoManoObra manoObra) {
		this.manoObra = manoObra;
	}

	public LogicPresupuestoProduccion getProduccion() {
		return produccion;
	}

	public void setProduccion(LogicPresupuestoProduccion produccion) {
		this.produccion = produccion;
	}

	public Float getCostoUnitario(Integer id) {
		// TODO Auto-generated method stub
		PresupuestoCostoUnitarioProduccion sal= (PresupuestoCostoUnitarioProduccion) this.salida;
		return sal.getPrecioUnitarioPorProducto(id);
	}

}
