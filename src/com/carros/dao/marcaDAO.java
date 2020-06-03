/**
 * 
 */
package com.carros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;


import com.carros.dto.marcaDTO;
import com.carros.interfaces.Imarca;
import com.carros.util.conexion;

/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class marcaDAO implements Imarca {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

@Override
public boolean save(String nombre)  {
	try {
		con = conexion.getConnection();
		String sql = "INSERT INTO marca(nombre) VALUES(?)";
		ps = con.prepareStatement(sql);
		
		ps. setString(1,nombre);
		
		
		if(ps.executeUpdate() ==1) {
			return true;
		}else {
			return false;
		
		
		}
	}catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException (e);
		} finally {
			try {
			if(ps != null) ps.close();
			} catch (final Exception e2) {
				e2.printStackTrace();
		throw new RuntimeException(e2);
		}
	// TODO Auto-generated method stub
	
}
	
}


@Override
public Collection<marcaDTO> getAll() {		try {
	con = conexion .getConnection();
	String sql = "SELECT * FROM marca";
	ps = con.prepareStatement(sql);
	
	rs = ps.executeQuery();
	
	Vector<marcaDTO> vector = new Vector <marcaDTO>();
	
	while(rs.next()){
		marcaDTO marcaFind= new marcaDTO();		
		
		marcaFind.setId(rs.getInt("id"));
		marcaFind.setNombre(rs.getString("nombre"));
		
		
		vector.add(marcaFind);
		
	}
		return vector;	
	} catch (Exception e) { 
	e.printStackTrace();
	throw new RuntimeException (e);
	}
	finally
	{
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
		
	}catch (Exception e2) {
		e2.printStackTrace();
		throw new RuntimeException (e2);
		}
	}
}



	
@Override
public boolean update( String nombre,int id ) {
	try {
		con =conexion.getConnection();
		String sql = "UPDATE marca SET nombre =? WHERE id = ?";
		
		ps= con.prepareStatement(sql);
		ps.setInt(1,id);
		ps. setString(1,nombre);
		
		
		if(ps.executeUpdate() == 1) {
			return true;
		}else {
			return false;
			
		}
	}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		
		}
	
		
		finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}catch (Exception e2) {
				e2.printStackTrace();
				throw  new RuntimeException(e2);
				
			}
			
		}
	
}

@Override
public boolean delete(int id) {
	try {
		con = conexion.getConnection();
		String sql = "DELETE FROM marca where id=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		if(ps.executeUpdate() == 1) {
			return true;
		}else 
			return false;
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	
	}

	finally {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
		}catch (Exception e2) {
			e2.printStackTrace();
			throw  new RuntimeException(e2);
			
		}
		
	}
	
}

@Override
public marcaDTO findByid(int id) {
	try{
		con = conexion.getConnection();
	
	String sql = "SELECT * FROM marca WHERE id=?";
	ps= con.prepareStatement(sql);
	ps.setInt(1, id);
	rs = ps.executeQuery();
	
	marcaDTO marcaFind = null;
	if(rs.next()) {
		marcaFind= new marcaDTO();
		//Se pone el mismo nombre de la tabla en la BD
		marcaFind.setId(rs.getInt("id"));
		marcaFind.setNombre(rs.getString("nombre"));
		
		
	}
	return marcaFind;
	
} catch(Exception e) {
	e.printStackTrace();
	throw new RuntimeException(e);
}
	finally {
	try {
		if(rs != null) rs.close();
		if(ps != null) ps.close();
	}catch (Exception e2) {
		e2.printStackTrace();
		throw  new RuntimeException(e2);
		
	}
	
}
	


}

}

