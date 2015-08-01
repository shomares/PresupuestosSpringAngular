package org.upiicsa.web.model.Presupuesto.ManoObra;

import java.util.List;

import org.upiicsa.web.model.Presupuesto.IPresupuestoModel;

public class PresupuestoManoObra implements IPresupuestoModel {

	private List<ListaActividad> lista;

	private List<TotalPorPoducto> producto;

	public List<ListaActividad> getLista() {
		return lista;
	}

	public void setLista(List<ListaActividad> lista) {
		this.lista = lista;
	}

	public List<TotalPorPoducto> getProducto() {
		return producto;
	}

	public void setProducto(List<TotalPorPoducto> producto) {
		this.producto = producto;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public Float getHorasXActividad(Integer id) {
		// TODO Auto-generated method stub
		Float salida = 0.0f;
		for (ListaActividad actividad : lista) {
			if (actividad.getActividad().getId() == id) {
				for (CostoXActividad costo : actividad.getCostos()) {
					salida += costo.getHorasTotales();
				}
			}
		}
		return salida;
	}

	public Float getHorasXActividadProducto(Integer id, Integer id2) {
		// TODO Auto-generated method stub
		Float salida = 0.0f;
		for (ListaActividad actividad : lista) {
			if (actividad.getActividad().getId() == id) {
				for (CostoXActividad costo : actividad.getCostos()) {
					if (costo.getProducto().getId() == id2)
						salida += costo.getHorasTotales();
				}

			}
		}
		return salida;
	}

	public Float getTotalPorProducto(Integer id) {
		// TODO Auto-generated method stub
		Float salida = 0.0f;
		for (ListaActividad actividad : lista) {
			for (CostoXActividad costo : actividad.getCostos()) {
				if (costo.getProducto().getId() == id)
					salida += costo.getImporte();
			}

		}
		return salida;
	}

}
