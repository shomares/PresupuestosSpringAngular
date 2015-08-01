package org.upiicsa.dao.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.upiicsa.dao.IEntity;
import org.upiicsa.web.model.Presupuesto.IPresupuestoModel;

@Entity
public class BalanceGeneral implements IEntity, IPresupuestoModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private Float cajayBancos;
	@Column

	private Float clientes;
	@Column

	private Float inventariodeMateriaPrima;
	@Column

	private Float inventariodeArticulosterm;
	@Column

	private Float maquinaria;
	@Column

	private Float equipo;

	@Column
	private Float proveedores;
	@Column
	private Float impxpagar;

	
	@Column
	private Float acredorHipotecario;
	@Column
	private Float capitalSocial;
	@Column
	private Float utDelEjercicio;

	@Column
	private String nombre;
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getCajayBancos() {
		return cajayBancos;
	}

	public void setCajayBancos(Float cajayBancos) {
		this.cajayBancos = cajayBancos;
	}

	public Float getClientes() {
		return clientes;
	}

	public void setClientes(Float clientes) {
		this.clientes = clientes;
	}

	public Float getInventariodeMateriaPrima() {
		return inventariodeMateriaPrima;
	}

	public void setInventariodeMateriaPrima(Float inventariodeMateriaPrima) {
		this.inventariodeMateriaPrima = inventariodeMateriaPrima;
	}

	public Float getInventariodeArticulosterm() {
		return inventariodeArticulosterm;
	}

	public void setInventariodeArticulosterm(Float inventariodeArticulosterm) {
		this.inventariodeArticulosterm = inventariodeArticulosterm;
	}

	public Float getMaquinaria() {
		return maquinaria;
	}

	public void setMaquinaria(Float maquinaria) {
		this.maquinaria = maquinaria;
	}

	public Float getEquipo() {
		return equipo;
	}

	public void setEquipo(Float equipo) {
		this.equipo = equipo;
	}

	public Float getProveedores() {
		return proveedores;
	}

	public void setProveedores(Float proveedores) {
		this.proveedores = proveedores;
	}

	public Float getImpxpagar() {
		return impxpagar;
	}

	public void setImpxpagar(Float impxpagar) {
		this.impxpagar = impxpagar;
	}

	public Float getAcredorHipotecario() {
		return acredorHipotecario;
	}

	public void setAcredorHipotecario(Float acredorHipotecario) {
		this.acredorHipotecario = acredorHipotecario;
	}

	public Float getCapitalSocial() {
		return capitalSocial;
	}

	public void setCapitalSocial(Float capitalSocial) {
		this.capitalSocial = capitalSocial;
	}

	public Float getUtDelEjercicio() {
		return utDelEjercicio;
	}

	public void setUtDelEjercicio(Float utDelEjercicio) {
		this.utDelEjercicio = utDelEjercicio;
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

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

}
