package org.upiicsa.logica.Presupuesto;

import org.upiicsa.web.model.Presupuesto.IPresupuestoModel;

public interface IPresupuestoLogica {

	
	void addHandlerFin(INotificaEvento notificar);
	
	void addHandlerAvance(INotificaEvento notificar);

	/* (non-Javadoc)
	 * @see org.upiicsa.logica.Presupuesto.IPresusupuesto#calcular()
	 */
	void calcular();

	IPresupuestoModel getSalida();

	String getPlantilla();
	
	void setPlantilla(String args);

	String getNombre();


}