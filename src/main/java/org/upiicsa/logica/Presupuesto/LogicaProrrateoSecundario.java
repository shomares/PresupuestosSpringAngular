package org.upiicsa.logica.Presupuesto;

import java.util.ArrayList;
import java.util.List;

import org.eneas.util.Utilerias;
import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.Actividad;
import org.upiicsa.dao.entidades.Configuracion;
import org.upiicsa.web.model.ActividadView;
import org.upiicsa.web.model.Presupuesto.CargosIndirectos.ProrrateoSecundario;

public class LogicaProrrateoSecundario implements ILogicaProrrateoSecundario {

	private IDao<Configuracion> daoConfiguracion;
	private IDao<Actividad> daoActividad;

	public IDao<Configuracion> getDaoConfiguracion() {
		return daoConfiguracion;
	}

	public void setDaoConfiguracion(IDao<Configuracion> daoConfiguracion) {
		this.daoConfiguracion = daoConfiguracion;
	}

	public IDao<Actividad> getDaoActividad() {
		return daoActividad;
	}

	public void setDaoActividad(IDao<Actividad> daoActividad) {
		this.daoActividad = daoActividad;
	}

	public List<ProrrateoSecundario> calculaProrrateoSecundario() {
		List<ProrrateoSecundario> salida = new ArrayList<ProrrateoSecundario>();
		List<Actividad> actividades = daoActividad.getAll();

		// Planchado--------------------------------------------------
		List<Configuracion> conf = daoConfiguracion.getAll();
		Configuracion configuracion = null;

		if (!conf.isEmpty())
			configuracion = conf.get(0);
		// ------------------------------------------
		if (configuracion != null) {
			Float costoAlmacen = configuracion.getCostoAlmacen();

			// Primero prorrateamos el almacen
			Float baseAlmacen = costoAlmacen / configuracion.getNumeroValesAlmacen();

			Float prorrateoMantoAlmacen = configuracion.getCostoMantenimiento()
					+ (configuracion.getNumeroValesAlmacenManto() * baseAlmacen);

			prorrateoMantoAlmacen = Utilerias.round(prorrateoMantoAlmacen, 0);
			configuracion.setCostoMantenimiento(prorrateoMantoAlmacen);
			// Primero ja ja ja esto se puso feo
			// ProrrateoAlmacen
			for (Actividad actividad : actividades) {
				Float monto = actividad.getCargoIndirecto();
				monto += actividad.getValesAlmacen() * baseAlmacen;

				actividad.setCargoIndirecto(Utilerias.round(monto, 0));
			}

			Float baseManto = configuracion.getCostoMantenimiento()/configuracion.getNumeroValesMantenimiento();
			// ProrrateoManto
			for (Actividad actividad : actividades) {
				ProrrateoSecundario secundario = new ProrrateoSecundario();
				ActividadView viewActividad = new ActividadView();
				Float monto = actividad.getCargoIndirecto();
				System.out.println(actividad.getValesMantenimiento() * baseManto);
				monto += actividad.getValesMantenimiento() * baseManto;
				secundario.setMontoPorrateo(Utilerias.round(monto, 0));
				viewActividad.setId(actividad.getId());
				viewActividad.setNombre(actividad.getNombre());
				secundario.setActividad(viewActividad);
				salida.add(secundario);
			}
		}
		return salida;
	}

}
