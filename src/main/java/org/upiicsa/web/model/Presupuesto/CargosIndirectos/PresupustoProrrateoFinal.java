package org.upiicsa.web.model.Presupuesto.CargosIndirectos;

import java.util.List;

import org.upiicsa.web.model.Presupuesto.IPresupuestoModel;

public class PresupustoProrrateoFinal implements IPresupuestoModel {

	private List<ProrrateoActividad> lista;

	private List<ProrrateoSecundario> secundario;

	public List<ProrrateoSecundario> getSecundario() {
		return secundario;
	}

	public void setSecundario(List<ProrrateoSecundario> secundario) {
		this.secundario = secundario;
	}

	public List<ProrrateoActividad> getLista() {
		return lista;
	}

	public void setLista(List<ProrrateoActividad> lista) {
		this.lista = lista;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public Float getTotalPorProducto(Integer id) {
		Float total = 0.0f;
		for (ProrrateoActividad actividad : lista) {
			for (ProrrateoProducto producto : actividad.getProrrateoProducto()) {
				if (producto.getProducto().getId() == id)
					total += producto.getImporte();
			}

		}
		return total;
	}

}
