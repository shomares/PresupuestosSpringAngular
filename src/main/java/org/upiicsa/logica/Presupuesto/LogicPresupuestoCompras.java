package org.upiicsa.logica.Presupuesto;

import java.util.ArrayList;
import java.util.List;

import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.MateriaPrima;
import org.upiicsa.web.model.MateriaPrimaView;
import org.upiicsa.web.model.Presupuesto.Compras.LineaPresupuestoCompras;
import org.upiicsa.web.model.Presupuesto.Compras.PresupuestoCompras;
import org.upiicsa.web.model.Presupuesto.ConsumoMateriaPrima.PresupuestoConsumoMateriaPrima;

public class LogicPresupuestoCompras extends PresupuestoAbstract {

	private IDao<MateriaPrima> daoMateriaPrima;
	private LogicPresupuestoConsumoMateriaPrima consumoMateriaPrima;
	
	
	
	public LogicPresupuestoConsumoMateriaPrima getConsumoMateriaPrima() {
		return consumoMateriaPrima;
	}

	public void setConsumoMateriaPrima(LogicPresupuestoConsumoMateriaPrima consumoMateriaPrima) {
		this.consumoMateriaPrima = consumoMateriaPrima;
	}

	public IDao<MateriaPrima> getDaoMateriaPrima() {
		return daoMateriaPrima;
	}

	public void setDaoMateriaPrima(IDao<MateriaPrima> daoMateriaPrima) {
		this.daoMateriaPrima = daoMateriaPrima;
	}

	@Override
	public void calcular() {
		// TODO Auto-generated method stub
		PresupuestoCompras salida=new PresupuestoCompras();
		Float total= 0.0f;
		Float i=0.0f;
		List<LineaPresupuestoCompras> lineas= new ArrayList<LineaPresupuestoCompras>();
		PresupuestoConsumoMateriaPrima anterior= (PresupuestoConsumoMateriaPrima) consumoMateriaPrima.getSalida();
		List<MateriaPrima> lista= daoMateriaPrima.getAll();
		
		for(MateriaPrima materia : lista){
			MateriaPrimaView view= new MateriaPrimaView();
			Float unidadesConsumir= anterior.getUnidadesaConsumirMateriaPrima(materia.getId());
			LineaPresupuestoCompras linea= new LineaPresupuestoCompras();
			
			view.setId(materia.getId());
			view.setNombre(materia.getNombre());
			
			linea.setMateriaPrima(view);
			linea.setUnidadesConsumir(unidadesConsumir);
			linea.setInventarioFinalDeseado(materia.getCantidadInventarioFinal());
			linea.setNecesidadTotal(unidadesConsumir+ linea.getInventarioFinalDeseado());
			linea.setInventarioInicial(materia.getCantidadInventarioInicial());
			linea.setUnidadesaComprar(linea.getNecesidadTotal()-linea.getInventarioInicial());
			linea.setCostoXUnidad(materia.getCostoInicial());
			linea.setImporte(linea.getUnidadesaComprar()* linea.getCostoXUnidad());
			
			total+= linea.getImporte();
			lineas.add(linea);
			notificaAvance((Object) (i++ / lista.size() * 100), this.notificarAvance);
		}
		salida.setLineas(lineas);
		salida.setTotal(total);
		this.salida= salida;
		notificaAvance(this.salida, this.notificarFin);
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Presupuesto de Compras";
	}

	public Float getTotal() {
		// TODO Auto-generated method stub
		PresupuestoCompras compras= (PresupuestoCompras)this.salida;
		return compras.getTotal();
	}

}
