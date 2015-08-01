package org.upiicsa.dao.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.upiicsa.dao.IEntity;

@Entity(name="UsoMateriaPrima")
public class UsoMateriaPrima implements IEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Cascade({ CascadeType.REMOVE })
	@ManyToOne(fetch=FetchType.EAGER)
	private Producto producto;
	@ManyToOne(fetch=FetchType.EAGER)
	private MateriaPrima materiaPrima;
	@Column
	private Float usoProducto;
	
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public Float getUsoProducto() {
		return usoProducto;
	}

	public void setUsoProducto(Float usoProducto) {
		this.usoProducto = usoProducto;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id= id;

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return  id;
	}

}
