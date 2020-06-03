/**
 * 
 */
package com.carros.dto;

import java.io.Serializable;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class marcaDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	private String nombre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
