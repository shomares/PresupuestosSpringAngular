package org.upiicsa.logica.Presupuesto;

import org.upiicsa.web.model.Presupuesto.CostoDeLoVendido.PresupuestoCostoVendido;

public class LogicaPresupuestoCostoVendido extends PresupuestoAbstract {

	@Override
	public void calcular() {
		// TODO Auto-generated method stub
		 this.salida= new PresupuestoCostoVendido();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

}
