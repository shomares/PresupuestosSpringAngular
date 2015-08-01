package org.upiicsa.logica;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.upiicsa.dao.IDao;
import org.upiicsa.dao.IDaoPresupuesto;
import org.upiicsa.dao.entidades.Actividad;
import org.upiicsa.dao.entidades.CostoActividad;
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.web.model.CostoActividadAux;
import org.upiicsa.web.model.CostoActividadView;

@Component
public class LogicaInsertaCostoActividad implements ILogicaInsertaCostoActividad {

	@Autowired
	@Qualifier(value = "daoCostoActividad")
	private IDao<CostoActividad> daoCostoActividad;

	@Autowired
	private IDaoPresupuesto daoPresupuesto;

	@Autowired
	@Qualifier(value = "daoProducto")
	private IDao<Producto> daoProducto;

	/* (non-Javadoc)
	 * @see org.upiicsa.logica.ILogicaInsertaCostoActividad#getByIdCostoActividad(java.lang.Integer)
	 */
	@Override
	public CostoActividadView getByIdCostoActividad(Integer id) {
		// TODO Auto-generated method stub
		CostoActividadView salida = new CostoActividadView();
		Actividad actividad = daoPresupuesto.getActividadById(id);

		List<CostoActividad> lista = actividad.getCostosActividad();
		List<CostoActividadAux> viewAux = new ArrayList<CostoActividadAux>();
		CostoActividadAux[] costoActividadAux;

		salida.setId(actividad.getId());
		salida.setActividad(actividad.getNombre());

		for (CostoActividad uso : lista) {
			CostoActividadAux auxiliar = new CostoActividadAux();
			auxiliar.setId(uso.getId());
			auxiliar.setProducto(uso.getProducto().getNombre());
			auxiliar.setId(uso.getId());
			auxiliar.setCouta(uso.getCouta());
			auxiliar.setHoras(uso.getHoras());
			auxiliar.setIdProducto(uso.getProducto().getId());
			viewAux.add(auxiliar);
		}
		costoActividadAux = new CostoActividadAux[lista.size()];
		costoActividadAux = viewAux.toArray(costoActividadAux);
		salida.setCostoActividadAux(costoActividadAux);
		return salida;
	}

	/* (non-Javadoc)
	 * @see org.upiicsa.logica.ILogicaInsertaCostoActividad#insertaUsoProducto(org.upiicsa.web.model.CostoActividadView)
	 */
	@Override
	public void insertaUsoProducto(CostoActividadView jSON) {

		Actividad actividad = daoPresupuesto.getActividadById(jSON.getId());
		for (CostoActividadAux costoActividadAux : jSON.getCostoActividadAux()) {
			CostoActividad costoAct = new CostoActividad();
			costoAct.setId(costoActividadAux.getId());
			costoAct.setCouta(costoActividadAux.getCouta());
			costoAct.setHoras(costoActividadAux.getHoras());
			costoAct.setActividad(actividad);
			costoAct.setProducto(daoProducto.getById(costoActividadAux.getIdProducto()));
			daoCostoActividad.insertorUpdate(costoAct);
		}

	}

}
