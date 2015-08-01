package org.upiicsa.web.model.Presupuesto.Produccion;

import java.util.List;

import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.web.model.Presupuesto.IPresupuestoModel;


public class PresupuestoProduccion implements IPresupuestoModel {
	private List<ProductoPresupuestoProduccion> productos;
	/* (non-Javadoc)
	 * @see org.upiicsa.web.model.Presupuesto.IPresupuesto#getNombre()
	 */
	@Override
	public String getNombre(){
		return "Presupuesto de Produccion";
	}
	public List<ProductoPresupuestoProduccion> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoPresupuestoProduccion> productos) {
		this.productos = productos;
	}
	public Float getUnidadesAProducir(Producto finalp) {
		// TODO Auto-generated method stub
		
		for(ProductoPresupuestoProduccion arg: this.productos)
			if (arg.getProducto().getId()==finalp.getId())
				return arg.getUnidadesaProducir();
				
		return null;
	}
	
	
	
	
	
	
	
}
