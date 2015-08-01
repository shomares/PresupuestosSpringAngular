package org.upiicsa.web.model;

import java.io.Serializable;

public class UsoAuxiliarView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer idMateriaPrima;
	private String materiaPrima;
	private Float unidades;

	public String getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(String materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public Float getUnidades() {
		return unidades;
	}

	public void setUnidades(Float unidades) {
		this.unidades = unidades;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdMateriaPrima() {
		return idMateriaPrima;
	}

	public void setIdMateriaPrima(Integer idMateriaPrima) {
		this.idMateriaPrima = idMateriaPrima;
	}

}
