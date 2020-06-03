/**
 * 
 */
package com.carros.interfaces;

import java.util.Collection;

import com.carros.dto.carrosDTO;
import com.carros.dto.marcaDTO;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface Icarros {
	
	//CREATE
	public boolean save (String modelo,String color,String anio,marcaDTO fkmarca );
	//READ
	public Collection<carrosDTO> getAll();
	//UPDATE
	public boolean update (String modelo, int id,String color,String anio,marcaDTO fkmarca );
	//DELETE
	
	public boolean delete (int id);
	//findVyid
	public carrosDTO findByid(int id);
	

}
