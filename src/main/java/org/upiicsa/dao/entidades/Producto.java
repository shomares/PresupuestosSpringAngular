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
public class Producto implements IEntity {

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
	private Float cantidadInventarioInicial;
	@Column
	private Float cantidadInventarioFinal;
	@Column
	private Float costoInicial;
	
	@Column
	private Integer unidades;
	
	

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE}, orphanRemoval=true)
	private List<UsoMateriaPrima> usoMateriaPrima;

	
	@OneToMany(mappedBy="producto", fetch= FetchType.LAZY,cascade = {CascadeType.REMOVE}, orphanRemoval=true)
	private List<CostoActividad> costoXActividad;

	
	
	public List<CostoActividad> getCostoXActividad() {
		return costoXActividad;
	}

	public void setCostoXActividad(List<CostoActividad> costoXActividad) {
		this.costoXActividad = costoXActividad;
	}

	public void setUsoMateriaPrima(List<UsoMateriaPrima> usoMateriaPrima) {
		this.usoMateriaPrima = usoMateriaPrima;
	}

	public List<UsoMateriaPrima> getUsoMateriaPrima() {
		return usoMateriaPrima;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getCantidadInventarioInicial() {
		return cantidadInventarioInicial;
	}

	public void setCantidadInventarioInicial(Float cantidadInventarioInicial) {
		this.cantidadInventarioInicial = cantidadInventarioInicial;
	}

	public Float getCantidadInventarioFinal() {
		return cantidadInventarioFinal;
	}

	public void setCantidadInventarioFinal(Float cantidadInventarioFinal) {
		this.cantidadInventarioFinal = cantidadInventarioFinal;
	}

	public Float getCostoInicial() {
		return costoInicial;
	}

	public void setCostoInicial(Float costoInicial) {
		this.costoInicial = costoInicial;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

}
