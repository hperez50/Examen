/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codere.dao;

import com.codere.idao.IClienteDAO;
import com.codere.model.Cliente;
//import com.codere.model.Cliente;
import com.connection.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heibe
 */
public class ClienteDaoImpl implements IClienteDAO{

    @Override
    public boolean registrar(Cliente cliente) {
        boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO usuario values ('"+cliente.getIdUsuario()+"','"+cliente.getIdRol()+"','"+cliente.getNombre()+"','"+cliente.getActivo()+"')";
                           //"INSERT INTO usuario values (NULL,'"+cliente.getI()+"','"+cliente.getNombre()+"','"+cliente.getActivo()+"')";
		
		try {			
			con=Conexion.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método registrar");
			e.printStackTrace();
		}
		return registrar;
    }

    @Override
    public List<Cliente> obtener() {
        Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM usuario ORDER BY nombre";
		
		List<Cliente> listaCliente= new ArrayList<Cliente>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Cliente c = new Cliente();
                                //ControllerCliente controller = new ControllerCliente();
                                c.setIdUsuario(rs.getInt(1));
				c.setIdRol(rs.getInt(2));
				c.setNombre(rs.getString(3));
				c.setActivo(rs.getString(4));
				listaCliente.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return listaCliente;
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE usuario SET Rol_id_Rol='"+cliente.getIdRol()+"', activo='"+cliente.getActivo()+"' WHERE nombre='"+cliente.getNombre()+"'" ;
               // "UPDATE usuario SET nombre='"+cliente.getNombre()+"', Rol_id_Rol='"+cliente.getIdRol()+"', activo='"+cliente.getActivo()+"'";
                // UPDATE Persona SET Telefono='202030' WHERE Id = 4;
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
    }

    @Override
    public boolean eliminar(Cliente cliente) {
        Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM usuario WHERE nombre='"+cliente.getNombre()+"'";
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
    }
    
}
