package org.upiicsa.dao.Hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.upiicsa.dao.IDaoPresupuesto;
import org.upiicsa.dao.entidades.Actividad;
import org.upiicsa.dao.entidades.Producto;

@Transactional
public class DaoPresupuesto implements IDaoPresupuesto {
	
	private SessionFactory session;

	@Override
	public Producto getProductoById(Integer id) {
		// TODO Auto-generated method stub
		Session sesion= session.getCurrentSession();
		Producto pr= (Producto)sesion.get(Producto.class, id);
		Hibernate.initialize(pr.getUsoMateriaPrima());
		
		return pr;
	}
	
	@Override	
	public Actividad getActividadById(Integer id){
		Session sesion= session.getCurrentSession();
		Actividad pr= (Actividad)sesion.get(Actividad.class, id);
		Hibernate.initialize(pr.getCostosActividad());
		return pr;
	}
	
	

	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}
	
	

}
