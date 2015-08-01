package org.upiicsa.logica.Presupuesto;

import java.util.List;

import org.eneas.util.Utilerias;
import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.Configuracion;
import org.upiicsa.web.model.Presupuesto.CostoDeLoVendido.PresupuestoCostoVendido;
import org.upiicsa.web.model.Presupuesto.Finales.EstadodeResultados;
import org.upiicsa.web.model.Presupuesto.PresupuestoVenta.PresupuestoVenta;

public class LogicaEstadoResultados extends PresupuestoAbstract {

	private IDao<Configuracion> daoConfiguracion;

	private LogicaPresupuestoVenta ventas;

	private LogicaPresupuestoCostoVendido costoVendido;

	public IDao<Configuracion> getDaoConfiguracion() {
		return daoConfiguracion;
	}

	public void setDaoConfiguracion(IDao<Configuracion> daoConfiguracion) {
		this.daoConfiguracion = daoConfiguracion;
	}

	public LogicaPresupuestoVenta getVentas() {
		return ventas;
	}

	public void setVentas(LogicaPresupuestoVenta ventas) {
		this.ventas = ventas;
	}

	public LogicaPresupuestoCostoVendido getCostoVendido() {
		return costoVendido;
	}

	public void setCostoVendido(LogicaPresupuestoCostoVendido costoVendido) {
		this.costoVendido = costoVendido;
	}

	@Override
	public void calcular() {
		// TODO Auto-generated method stub
		PresupuestoVenta venta = (PresupuestoVenta) ventas.getSalida();
		PresupuestoCostoVendido costoV = (PresupuestoCostoVendido) costoVendido.getSalida();
		EstadodeResultados estado = new EstadodeResultados();
		List<Configuracion> confs = daoConfiguracion.getAll();
		if (!confs.isEmpty()) {
			Float ventasT = venta.getVentasTotales();
			Float costoventas = costoV.getTotal();
			Float utbruta = ventasT - costoventas;
			Float gastosop = confs.get(0).getGastoAdministracion() + confs.get(0).getGastoVentas();
			Float utantes = utbruta - gastosop;
			Float isr = 0.3f * utantes;
			Float utejercicio = utantes - isr;
			estado.setCostoVentas(costoventas);
			estado.setVentas(ventasT);
			estado.setGastosOperacion(gastosop);
			estado.setUtantes(utantes);
			estado.setIsr(Utilerias.round(isr, 0));
			estado.setUtilidadEjercicio(utejercicio);
		}
		this.salida = estado;
		notificaAvance(this.salida, this.notificarFin);

	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public Float getVentasTotales() {
		// TODO Auto-generated method stub
		return ((EstadodeResultados) salida).getVentas();
	}

	public Float getCostoVentas() {
		// TODO Auto-generated method stub
		return ((EstadodeResultados) salida).getCostoVentas();
	}

	public Float getISR() {
		// TODO Auto-generated method stub
		return ((EstadodeResultados) salida).getIsr();
	}

	public Float getUilidad() {
		// TODO Auto-generated method stub
		return ((EstadodeResultados) salida).getUtilidadEjercicio();
	}

}
