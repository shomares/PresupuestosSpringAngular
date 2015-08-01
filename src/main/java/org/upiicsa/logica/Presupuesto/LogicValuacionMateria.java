package org.upiicsa.logica.Presupuesto;

import java.util.ArrayList;
import java.util.List;

import org.eneas.util.Utilerias;
import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.MateriaPrima;
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.dao.entidades.UsoMateriaPrima;
import org.upiicsa.web.model.MateriaPrimaView;
import org.upiicsa.web.model.ProductoView;
import org.upiicsa.web.model.Presupuesto.ConsumoMateriaPrima.PresupuestoConsumoMateriaPrima;
import org.upiicsa.web.model.Presupuesto.ValuacionMateriaPrima.PresupuestoValuacionMateriaPrima;
import org.upiicsa.web.model.Presupuesto.ValuacionMateriaPrima.ProductoValuacion;
import org.upiicsa.web.model.Presupuesto.ValuacionMateriaPrima.ValuacionMateriaPrima;

public class LogicValuacionMateria extends PresupuestoAbstract {

	private IDao<MateriaPrima> daoMateriaPrima;

	private LogicPresupuestoConsumoMateriaPrima consumoMateriaPrima;

	public IDao<MateriaPrima> getDaoMateriaPrima() {
		return daoMateriaPrima;
	}

	public void setDaoMateriaPrima(IDao<MateriaPrima> daoMateriaPrima) {
		this.daoMateriaPrima = daoMateriaPrima;
	}

	@Override
	public void calcular() {
		// TODO Auto-generated method stub
		PresupuestoValuacionMateriaPrima presupuestoValuacion = new PresupuestoValuacionMateriaPrima();
		List<ValuacionMateriaPrima> listaValuacionMateriaPrima = new ArrayList<ValuacionMateriaPrima>();
		List<MateriaPrima> materiasPrimas = daoMateriaPrima.getAll();
		PresupuestoConsumoMateriaPrima presupuestoMateriaPrima = (PresupuestoConsumoMateriaPrima) consumoMateriaPrima
				.getSalida();
		for (MateriaPrima materiaPrima : materiasPrimas) {
			List<ProductoValuacion> listaProducto = new ArrayList<ProductoValuacion>();
			MateriaPrimaView viewMateriaPrima = new MateriaPrimaView();
			viewMateriaPrima.setId(materiaPrima.getId());
			viewMateriaPrima.setNombre(materiaPrima.getNombre());
			ValuacionMateriaPrima valuacion = new ValuacionMateriaPrima();
			valuacion.setMateriaPrima(viewMateriaPrima);

			Float totalXMateriaPrima = 0.0f;
			Float unidadesMateriaPrima = presupuestoMateriaPrima.getUnidadesaConsumirMateriaPrima(materiaPrima.getId());

			for (UsoMateriaPrima uso : materiaPrima.getUsoMateriaPrima()) {
				Producto producto = uso.getProducto();
				ProductoView productoView = new ProductoView();
				productoView.setId(producto.getId());
				productoView.setNombre(producto.getNombre());
				ProductoValuacion productoValuacion = new ProductoValuacion();
				productoValuacion.setProducto(productoView);

				// **********************
				Float unidadesPorProducto = presupuestoMateriaPrima
						.getUnidadesAConsumirXProductoyMateriaPrima(producto.getId(), materiaPrima.getId());
				Float mezclaInventarioInicial = (unidadesPorProducto / unidadesMateriaPrima)
						* materiaPrima.getCantidadInventarioInicial();

				mezclaInventarioInicial = Utilerias.round(mezclaInventarioInicial, 0);

				productoValuacion.setUnidadConsumidad(unidadesPorProducto);
				productoValuacion.setCostoUnidadInicial(materiaPrima.getCostoInicial());
				productoValuacion.setCostoUnidadFinal(materiaPrima.getCostoPresupuestado());
				productoValuacion.setMezclaInventarioInicial(mezclaInventarioInicial);
				productoValuacion.setMezclaInventarioFinal(unidadesPorProducto - mezclaInventarioInicial);
				productoValuacion.setImporteInicial(
						productoValuacion.getCostoUnidadInicial() * productoValuacion.getMezclaInventarioInicial());
				productoValuacion.setImporteFinal(
						productoValuacion.getCostoUnidadFinal() * productoValuacion.getMezclaInventarioFinal());
				productoValuacion
						.setImporteTotal(productoValuacion.getImporteInicial() + productoValuacion.getImporteFinal());
				listaProducto.add(productoValuacion);

				totalXMateriaPrima += productoValuacion.getImporteTotal();
			}
			valuacion.setTotal(totalXMateriaPrima);
			valuacion.setProductoValuacion(listaProducto);
			listaValuacionMateriaPrima.add(valuacion);
		}
		presupuestoValuacion.setValuaciones(listaValuacionMateriaPrima);
		this.salida = presupuestoValuacion;
		notificaAvance(this.salida, this.notificarFin);

	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Presupuesto de Valuacion de Materia Prima";
	}

	public LogicPresupuestoConsumoMateriaPrima getConsumoMateriaPrima() {
		return consumoMateriaPrima;
	}

	public void setConsumoMateriaPrima(LogicPresupuestoConsumoMateriaPrima consumoMateriaPrima) {
		this.consumoMateriaPrima = consumoMateriaPrima;
	}

}
