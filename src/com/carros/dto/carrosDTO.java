/**
 * 
 */
package com.carros.dto;

import java.io.Serializable;


/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class carrosDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String modelo;
	private String color;
	private String anio;
	private int fkmarca;
	
	public carrosDTO() {
		
	}
	
public carrosDTO(String modelo,String color,String anio,int fkmarca ) {
		//Imarca imarca=(Imarca) Fabrica.getInstancia("MARCA");
		
		this.modelo=modelo;
		this.color=color;
		this.anio=anio;
		this.fkmarca=fkmarca;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFkmarca() {
		return fkmarca;
	}
	public void setFkmarca(int fkmarca) {
		this.fkmarca = fkmarca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	

}
