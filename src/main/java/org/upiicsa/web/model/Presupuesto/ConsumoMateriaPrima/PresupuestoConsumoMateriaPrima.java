package org.upiicsa.web.model.Presupuesto.ConsumoMateriaPrima;

import java.io.Serializable;
import java.util.List;

import org.upiicsa.web.model.Presupuesto.IPresupuestoModel;

public class PresupuestoConsumoMateriaPrima implements IPresupuestoModel, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PresupuestoConsumoMateriaPrimaFila> fila;

	private List<PresupuestoXMateriaPrima> presupuestoXmateriaPrima;

	public List<PresupuestoConsumoMateriaPrimaFila> getFila() {
		return fila;
	}

	public void setFila(List<PresupuestoConsumoMateriaPrimaFila> fila) {
		this.fila = fila;
	}

	public List<PresupuestoXMateriaPrima> getPresupuestoXmateriaPrima() {
		return presupuestoXmateriaPrima;
	}

	public void setPresupuestoXmateriaPrima(List<PresupuestoXMateriaPrima> presupuestoXmateriaPrima) {
		this.presupuestoXmateriaPrima = presupuestoXmateriaPrima;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public Float getUnidadesaConsumirMateriaPrima(Integer id) {
		// TODO Auto-generated method stub
		for (PresupuestoXMateriaPrima materia : presupuestoXmateriaPrima) {
			if (materia.getMateriaPrima().getId() == id)
				return materia.getTotal();
		}
		return null;
	}

	public Float getUnidadesAConsumirXProducto(Integer id) {
		for (PresupuestoConsumoMateriaPrimaFila producto : fila) {
			if (producto.getProducto().getId() == id)
				return producto.getUnidadesAProducir();
		}
		return null;
	}

	public Float getUnidadesAConsumirXProductoyMateriaPrima(Integer id, Integer id2) {
		// TODO Auto-generated method stub
		for (PresupuestoConsumoMateriaPrimaFila producto : fila) {
			if (producto.getProducto().getId() == id)
			{
				for(PresupuestoConsumoMateriaXMateria consumo: producto.getConsumos())
					if(consumo.getMateriaPrima().getId()==id2)
						return consumo.getUnidadesConsumo();
			}
		}
		return null;
	}

	

}
