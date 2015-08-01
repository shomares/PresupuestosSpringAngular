package org.upiicsa.dao.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.upiicsa.dao.IEntity;

@Entity
public class CostoActividad  implements IEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@ManyToOne
	private Actividad actividad;
	
	@ManyToOne
	private Producto producto;
	
	@Column
	private Float horas;
	
	@Column
	private Float couta;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Actividad getActividad() {
		return actividad;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Float getHoras() {
		return horas;
	}
	public void setHoras(Float horas) {
		this.horas = horas;
	}
	public Float getCouta() {
		return couta;
	}
	public void setCouta(Float couta) {
		this.couta = couta;
	}
	
	
}
