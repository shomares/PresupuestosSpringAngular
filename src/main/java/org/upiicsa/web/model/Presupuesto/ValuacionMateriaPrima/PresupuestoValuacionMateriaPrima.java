package org.upiicsa.web.model.Presupuesto.ValuacionMateriaPrima;

import java.util.List;

import org.upiicsa.web.model.Presupuesto.IPresupuestoModel;

public class PresupuestoValuacionMateriaPrima  implements IPresupuestoModel{
	private List<ValuacionMateriaPrima> valuaciones;

	public List<ValuacionMateriaPrima> getValuaciones() {
		return valuaciones;
	}

	public void setValuaciones(List<ValuacionMateriaPrima> valuacion) {
		this.valuaciones = valuacion;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public Float getTotalPorProducto(Integer id) {
		// TODO Auto-generated method stub
		Float salida=0.0f;
		for(ValuacionMateriaPrima valuacion: valuaciones){
			for(ProductoValuacion p : valuacion.getProductoValuacion()){
				if (p.getProducto().getId()==id)
					salida+= p.getImporteTotal();
			}
			
		}
		return salida;
	}
	
	
}
