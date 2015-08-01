package org.upiicsa.logica;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.upiicsa.dao.IDao;
import org.upiicsa.dao.IDaoPresupuesto;
import org.upiicsa.dao.entidades.MateriaPrima;
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.dao.entidades.UsoMateriaPrima;
import org.upiicsa.web.model.UsoAuxiliarView;
import org.upiicsa.web.model.UsoMateriaPorProductoView;

@Component
public class LogicaUsoMateriaPrimaProducto implements IUsoMateriaPrima {

	@Autowired
	@Qualifier(value = "daoUsoMateriaPrima")
	private IDao<UsoMateriaPrima> daoUsoMateriaPrima;

	@Autowired
	private IDaoPresupuesto daoPresupuesto;

	@Autowired
	@Qualifier(value = "daoMateriaPrima")
	private IDao<MateriaPrima> daoMateriaPrima;
	
	

	@Override
	public UsoMateriaPorProductoView getByIdProducto(Integer id) {
		// TODO Auto-generated method stub
		Producto producto = daoPresupuesto.getProductoById(id);
		
		List<UsoMateriaPrima> lista = producto.getUsoMateriaPrima();
		List<UsoAuxiliarView> auxiliarl = new ArrayList<UsoAuxiliarView>();
		UsoAuxiliarView[] usoAuxiliarA;

		UsoMateriaPorProductoView salida = new UsoMateriaPorProductoView();
		salida.setIdProducto(producto.getId());
		salida.setNombre(producto.getNombre());

		for (UsoMateriaPrima uso : lista) {
			UsoAuxiliarView auxiliar = new UsoAuxiliarView();
			auxiliar.setId(uso.getId());
			auxiliar.setIdMateriaPrima(uso.getMateriaPrima().getId());
			auxiliar.setMateriaPrima(uso.getMateriaPrima().getNombre());
			auxiliar.setUnidades(uso.getUsoProducto());
			auxiliarl.add(auxiliar);
		}

		usoAuxiliarA = new UsoAuxiliarView[lista.size()];
		usoAuxiliarA = auxiliarl.toArray(usoAuxiliarA);
		salida.setUsomateria(usoAuxiliarA);
		return salida;
	}

	@Override
	public void insertaUsoProducto(UsoMateriaPorProductoView jSON) {
		// TODO Auto-generated method stub

		Producto producto = daoPresupuesto.getProductoById(jSON.getIdProducto());
		for (UsoAuxiliarView aux : jSON.getUsomateria()) {
			UsoMateriaPrima entidad = new UsoMateriaPrima();
			MateriaPrima materiaPrima = daoMateriaPrima.getById(aux.getIdMateriaPrima());
			entidad.setProducto(producto);
			entidad.setMateriaPrima(materiaPrima);
			entidad.setId(aux.getId());
			entidad.setUsoProducto(aux.getUnidades());
			daoUsoMateriaPrima.insertorUpdate(entidad);
		}

	}

}
