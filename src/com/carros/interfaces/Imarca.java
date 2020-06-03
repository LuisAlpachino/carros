/**
 * 
 */
package com.carros.interfaces;

import java.util.Collection;


import com.carros.dto.marcaDTO;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public interface Imarca {

	//CREATE
		public boolean save (String nombre);
		//READ
		public Collection<marcaDTO> getAll();
		//UPDATE
		public boolean update(String nombre, int id );
		//DELETE
		public boolean delete (int id);
		//findVyid
		public marcaDTO findByid(int id);
}
