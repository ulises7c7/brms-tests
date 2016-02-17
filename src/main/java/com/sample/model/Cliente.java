package com.sample.model;

public class Cliente {
	
	private String tipoCliente;
	private String preferencias;
	private Integer edad;
	
	public Cliente(String tipoCliente, String preferencias, Integer edad){
		this.tipoCliente = tipoCliente;
		this.preferencias = preferencias;
		this.edad = edad;
		
	}
	
	

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	

}
