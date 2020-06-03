/**
 * 
 */
package com.carros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import com.carros.dto.carrosDTO;
import com.carros.dto.marcaDTO;
import com.carros.interfaces.Icarros;
import com.carros.util.conexion;


/**
 * @author Aldo Adrian Vargas Acuña
 *
 */
public class carrosDAO implements Icarros{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

@Override
public boolean save(String modelo,String color,String anio,marcaDTO fkmarca) {
	try {
		con = conexion.getConnection();
		String sql = "INSERT INTO carro(modelo, color, anio, fkmarca) VALUES(?,?,?,?)";
		ps = con.prepareStatement(sql);
		
		ps. setString(1,modelo);
		ps. setString(2,color);
		ps. setString(3,anio);
		ps. setInt(4,fkmarca.getId());
		
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
public Collection<carrosDTO> getAll() {		try {
	con = conexion .getConnection();
	String sql = "SELECT * FROM carro";
	ps = con.prepareStatement(sql);
	
	rs = ps.executeQuery();
	
	Vector<carrosDTO> vector = new Vector <carrosDTO>();
	
	while(rs.next()){
		carrosDTO carroFind= new carrosDTO();
				
		carroFind.setId(rs.getInt("id"));
		carroFind.setModelo(rs.getString("modelo"));
		carroFind.setColor(rs.getString("color"));
		carroFind.setAnio(rs.getString("anio"));
		carroFind.setFkmarca(rs.getInt("fkmarca"));
		
		vector.add(carroFind);
		
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
public boolean update( String modelo, int id,String color,String anio,marcaDTO fkmarca ) {
	try {
		con =conexion.getConnection();
		String sql = "UPDATE carro SET modelo =?,color = ?, anio=?, fkmarca=? WHERE id = ?";
		
		ps= con.prepareStatement(sql);
		ps.setInt(5,id);
		ps. setString(1,modelo);
		ps. setString(2,color);
		ps. setString(3,anio);
		ps. setInt(4,fkmarca.getId());
		
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
		String sql = "DELETE FROM carro where id=?";
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
public carrosDTO findByid(int id) {
	try{
		con = conexion.getConnection();
	
	String sql = "SELECT * FROM carro WHERE id=?";
	ps= con.prepareStatement(sql);
	ps.setInt(1, id);
	rs = ps.executeQuery();
	
	carrosDTO carroFind = null;
	if(rs.next()) {
		carroFind= new carrosDTO();
		//Se pone el mismo nombre de la tabla en la BD
		carroFind.setId(rs.getInt("id"));
		
		
	}
	return carroFind;
	
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
