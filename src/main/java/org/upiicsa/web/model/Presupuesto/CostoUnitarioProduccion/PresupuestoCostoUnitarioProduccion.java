package org.upiicsa.web.model.Presupuesto.CostoUnitarioProduccion;

import java.util.List;

import org.upiicsa.web.model.Presupuesto.IPresupuestoModel;

public class PresupuestoCostoUnitarioProduccion  implements IPresupuestoModel{

	private List<DetalleCostoUnitarioProduccion> detalle;
	
	
	
	public List<DetalleCostoUnitarioProduccion> getDetalle() {
		return detalle;
	}



	public void setDetalle(List<DetalleCostoUnitarioProduccion> detalle) {
		this.detalle = detalle;
	}



	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Presupuesto de Costo Unitario de Produccion";
	}



	public Float getPrecioUnitarioPorProducto(Integer id) {
		// TODO Auto-generated method stub
		for(DetalleCostoUnitarioProduccion det:detalle){
			if(det.getProducto().getId()==id)
				return det.getPreciodeVenta();
		}
		return null;
		
	}

}
