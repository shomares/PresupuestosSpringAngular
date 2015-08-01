package org.upiicsa.logica.Presupuesto;

import java.util.ArrayList;
import java.util.List;

import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.Actividad;
import org.upiicsa.dao.entidades.CostoActividad;
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.web.model.ActividadView;
import org.upiicsa.web.model.ProductoView;
import org.upiicsa.web.model.Presupuesto.ManoObra.CostoXActividad;
import org.upiicsa.web.model.Presupuesto.ManoObra.ListaActividad;
import org.upiicsa.web.model.Presupuesto.ManoObra.PresupuestoManoObra;
import org.upiicsa.web.model.Presupuesto.ManoObra.TotalPorPoducto;
import org.upiicsa.web.model.Presupuesto.Produccion.PresupuestoProduccion;

public class LogicPresupuestoManoObra extends PresupuestoAbstract {

	private IDao<Actividad> daoActividad;
	private IDao<Producto> daoProducto;
	private LogicPresupuestoProduccion presupuestoProduccion;

	public LogicPresupuestoProduccion getPresupuestoProduccion() {
		return presupuestoProduccion;
	}

	public void setPresupuestoProduccion(LogicPresupuestoProduccion presupuestoProduccion) {
		this.presupuestoProduccion = presupuestoProduccion;
	}

	public IDao<Actividad> getDaoActividad() {
		return daoActividad;
	}

	public void setDaoActividad(IDao<Actividad> daoActividad) {
		this.daoActividad = daoActividad;
	}

	public IDao<Producto> getDaoProducto() {
		return daoProducto;
	}

	public void setDaoProducto(IDao<Producto> daoProducto) {
		this.daoProducto = daoProducto;
	}

	@Override
	public void calcular() {
		// TODO Auto-generated method stub
		List<Actividad> acitivdades = daoActividad.getAll();
		
		
		
		PresupuestoManoObra presupuesto = new PresupuestoManoObra();
		List<ListaActividad> lista = new ArrayList<ListaActividad>();
		List<TotalPorPoducto> listaProducto = new ArrayList<TotalPorPoducto>();
		PresupuestoProduccion pet = (PresupuestoProduccion) presupuestoProduccion.getSalida();

		Float unidadesAProducir = 0.0f;
		for (Actividad act : acitivdades) {
			List<CostoXActividad> costos = new ArrayList<CostoXActividad>();
			ActividadView actividad = new ActividadView();
			ListaActividad actividadCosto = new ListaActividad();
			actividad.setId(act.getId());
			actividad.setNombre(act.getNombre());
			actividadCosto.setActividad(actividad);
			for (CostoActividad costo : act.getCostosActividad()) {
				int j = 0;
				CostoXActividad costoXActividad = new CostoXActividad();
				ProductoView producto = new ProductoView();
				unidadesAProducir = pet.getUnidadesAProducir(costo.getProducto());
				producto.setId(costo.getProducto().getId());
				producto.setNombre(costo.getProducto().getNombre());
				costoXActividad.setProducto(producto);
				costoXActividad.setCuota(costo.getCouta());
				costoXActividad.setHoraxUnidad(costo.getHoras());
				costoXActividad.setHorasTotales(costoXActividad.getHoraxUnidad() * unidadesAProducir);
				costoXActividad.setUnidadesaProducir(unidadesAProducir);
				costoXActividad.setImporte(costoXActividad.getHorasTotales() * costoXActividad.getCuota());

				while (j < listaProducto.size()) {
					TotalPorPoducto totalProducto = listaProducto.get(j);
					if (totalProducto.getProducto().getId() == producto.getId()) {
						Float t = totalProducto.getTotal();
						t += costoXActividad.getImporte();
						totalProducto.setTotal(t);
						break;
					}
					j++;
				}
				if (j == listaProducto.size()) {
					TotalPorPoducto aux = new TotalPorPoducto();
					aux.setProducto(producto);
					aux.setTotal(costoXActividad.getHorasTotales() * costoXActividad.getCuota());
					listaProducto.add(aux);
				}
				costos.add(costoXActividad);
			}
			actividadCosto.setCostos(costos);
			lista.add(actividadCosto);
		}
		presupuesto.setLista(lista);
		presupuesto.setProducto(listaProducto);
		this.salida = presupuesto;
		notificaAvance(this.salida, this.notificarFin);
		

	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Presupuesto Mano de Obra";
	}

	public Float getTotal() {
		// TODO Auto-generated method stub
		Float salida=0.0f;
		PresupuestoManoObra sal= (PresupuestoManoObra) this.getSalida();
		for(ListaActividad ac: sal.getLista()){
			for(CostoXActividad costo:ac.getCostos())
			salida+= costo.getImporte();
		}
		return salida;
	}

}
