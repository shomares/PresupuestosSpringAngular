package org.upiicsa.logica.Presupuesto;

import java.util.ArrayList;
import java.util.List;

import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.Actividad;
import org.upiicsa.dao.entidades.CostoActividad;
import org.upiicsa.web.model.ActividadView;
import org.upiicsa.web.model.ProductoView;
import org.upiicsa.web.model.Presupuesto.CargosIndirectos.PresupustoProrrateoFinal;
import org.upiicsa.web.model.Presupuesto.CargosIndirectos.ProrrateoActividad;
import org.upiicsa.web.model.Presupuesto.CargosIndirectos.ProrrateoProducto;
import org.upiicsa.web.model.Presupuesto.CargosIndirectos.ProrrateoSecundario;
import org.upiicsa.web.model.Presupuesto.ManoObra.PresupuestoManoObra;

public class LogicProrrateoFinal extends PresupuestoAbstract {

	private ILogicaProrrateoSecundario prorrateoSecundario;

	private LogicPresupuestoManoObra manoObra;

	private IDao<Actividad> daoActividad;

	public ILogicaProrrateoSecundario getProrrateoSecundario() {
		return prorrateoSecundario;
	}

	public void setProrrateoSecundario(ILogicaProrrateoSecundario prorrateoSecundario) {
		this.prorrateoSecundario = prorrateoSecundario;
	}

	public LogicPresupuestoManoObra getManoObra() {
		return manoObra;
	}

	public void setManoObra(LogicPresupuestoManoObra manoObra) {
		this.manoObra = manoObra;
	}

	public IDao<Actividad> getDaoActividad() {
		return daoActividad;
	}

	public void setDaoActividad(IDao<Actividad> daoActividad) {
		this.daoActividad = daoActividad;
	}

	private ProrrateoSecundario getProrrateoSecundanrio(Integer id) {
		List<ProrrateoSecundario> secundario=  prorrateoSecundario.calculaProrrateoSecundario();
		
		for(ProrrateoSecundario sec: secundario){
			if (sec.getActividad().getId()==id)
				return sec;			
		}
		return null;
		
	}

	@Override
	public void calcular() {
		// TODO Auto-generated method stub
		PresupustoProrrateoFinal presupuesto = new PresupustoProrrateoFinal();
		PresupuestoManoObra mano = (PresupuestoManoObra) manoObra.getSalida();
		List<ProrrateoActividad> lista = new ArrayList<ProrrateoActividad>();
		List<Actividad> actividades = daoActividad.getAll();
		for (Actividad actividad : actividades) {
			List<ProrrateoProducto> prorrateoProductos = new ArrayList<ProrrateoProducto>();
			ProrrateoActividad actividadProrrateo = new ProrrateoActividad();
			ActividadView viewActividad = new ActividadView();
			Float total = 0.0f;
			Float horasXActividad, base;
			horasXActividad = mano.getHorasXActividad(actividad.getId());
			base = getProrrateoSecundanrio(actividad.getId()).getMontoPorrateo() / horasXActividad;
			viewActividad.setId(actividad.getId());
			viewActividad.setNombre(actividad.getNombre());
			for (CostoActividad costo : actividad.getCostosActividad()) {
				Float importe;
				Float horas= mano.getHorasXActividadProducto(actividad.getId(), costo.getProducto().getId());
				ProrrateoProducto prorrateoProducto = new ProrrateoProducto();
				ProductoView pr= new ProductoView();
				pr.setId(costo.getProducto().getId());
				pr.setNombre(costo.getProducto().getNombre());
				prorrateoProducto.setProducto(pr);
				prorrateoProducto.setHoras(horas);
				importe = horas*base;
				prorrateoProducto.setImporte(importe);
				total += prorrateoProducto.getImporte();
				prorrateoProductos.add(prorrateoProducto);
			}
			actividadProrrateo.setProrrateoProducto(prorrateoProductos);
			actividadProrrateo.setImporteTotal(total);
			actividadProrrateo.setActividad(viewActividad);
			lista.add(actividadProrrateo);

		}
		
		presupuesto.setLista(lista);
		this.salida= presupuesto;
		notificaAvance(this.salida, this.notificarFin);


	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Prorrateo Final";
	}

	public Float getTotal() {
		// TODO Auto-generated method stub
		Float total= 0.0f;
		PresupustoProrrateoFinal fina= (PresupustoProrrateoFinal) this.getSalida();
		for( ProrrateoActividad act: fina.getLista())
			total+= act.getImporteTotal();
		return total;
	}
	

}
