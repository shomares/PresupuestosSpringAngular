package org.upiicsa.dao.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.upiicsa.dao.IEntity;

@Entity
public class Actividad implements IEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;

	@Column
	private Float cargoIndirecto;
	
	
	@Column
	private Float valesMantenimiento;
	
	@Column
	private Float valesAlmacen;
	
	
	
	@OneToMany(mappedBy="actividad", cascade = {CascadeType.REMOVE}, orphanRemoval=true, fetch=FetchType.EAGER)
	private List<CostoActividad> costosActividad;
	
	
	
	
	public Float getValesMantenimiento() {
		return valesMantenimiento;
	}
	public void setValesMantenimiento(Float valesMantenimiento) {
		this.valesMantenimiento = valesMantenimiento;
	}
	public Float getValesAlmacen() {
		return valesAlmacen;
	}
	public void setValesAlmacen(Float valesAlmacen) {
		this.valesAlmacen = valesAlmacen;
	}
	public List<CostoActividad> getCostosActividad() {
		return costosActividad;
	}
	public void setCostosActividad(List<CostoActividad> costosActividad) {
		this.costosActividad = costosActividad;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Float getCargoIndirecto() {
		return cargoIndirecto;
	}
	public void setCargoIndirecto(Float cargoIndirecto) {
		this.cargoIndirecto = cargoIndirecto;
	}
	
	

}
