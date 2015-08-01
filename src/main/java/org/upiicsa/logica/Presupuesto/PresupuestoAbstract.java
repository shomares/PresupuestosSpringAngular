package org.upiicsa.logica.Presupuesto;

import java.util.ArrayList;
import java.util.List;
import org.upiicsa.web.model.Presupuesto.IPresupuestoModel;

public abstract class PresupuestoAbstract implements IPresupuestoLogica {

	protected List<INotificaEvento> notificarAvance;
	protected List<INotificaEvento> notificarFin;
	private String plantilla;
	protected IPresupuestoModel salida;

	public PresupuestoAbstract() {
		// TODO Auto-generated constructor stub
		notificarAvance = new ArrayList<INotificaEvento>();
		notificarFin = new ArrayList<INotificaEvento>();
	}
	@Override
	public void addHandlerAvance(INotificaEvento notificar) {
		this.notificarAvance.add(notificar);
	}

	@Override
	public void addHandlerFin(INotificaEvento notificar) {
		this.notificarFin.add(notificar);
	}

	protected static void notificaAvance(Object id, List<INotificaEvento> evts) {
		for (INotificaEvento evt : evts) {
			evt.notifica(id);
		}
	}
	@Override
	public IPresupuestoModel getSalida() {
		synchronized (salida) {
			return salida;
		}
	}

	@Override
	public String getPlantilla() {
		return plantilla;
	}

	@Override
	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}


}
