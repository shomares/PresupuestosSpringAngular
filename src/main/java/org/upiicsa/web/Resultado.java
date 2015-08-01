package org.upiicsa.web;

public class Resultado<T> {

	private String resultado;
	private T objeto;
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public T getObjeto() {
		return objeto;
	}
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}
	
	
}
