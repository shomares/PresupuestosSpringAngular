package org.upiicsa.web.model.Presupuesto.PresupuestoVenta;

import java.util.List;

import org.upiicsa.web.model.Presupuesto.IPresupuestoModel;

public class PresupuestoVenta implements IPresupuestoModel{
	
	private List<PresupuestoVentaDetalle> lista;
	
	

	public List<PresupuestoVentaDetalle> getLista() {
		return lista;
	}



	public void setLista(List<PresupuestoVentaDetalle> lista) {
		this.lista = lista;
	}



	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Float getVentasTotales() {
		// TODO Auto-generated method stub
		Float salida= 0.0f;
		for(PresupuestoVentaDetalle detalle : lista){
			salida+=detalle.getImporte();
		}
		return salida;
		
	}

}
