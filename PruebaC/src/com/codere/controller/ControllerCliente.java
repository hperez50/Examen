/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codere.controller;

import com.codere.dao.ClienteDaoImpl;
import com.codere.idao.IClienteDAO;
import com.codere.model.Cliente;
import com.codere.vista.ViewCliente_2;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heibe
 */
public class ControllerCliente {
    
    private ViewCliente_2 vista= new ViewCliente_2();
	
	public ControllerCliente() {
	}
	
	//llama al DAO para guardar un cliente
	public void registrar(Cliente cliente ) {
		IClienteDAO dao= new  ClienteDaoImpl();
		dao.registrar(cliente);
	}
	
	//llama al DAO para actualizar un cliente
	public void actualizar(Cliente cliente) {
		IClienteDAO dao= new  ClienteDaoImpl();
		dao.actualizar(cliente);
	}
	
	//llama al DAO para eliminar un cliente
	public void eliminar(Cliente cliente) {
		IClienteDAO dao= new  ClienteDaoImpl();
		dao.eliminar(cliente);
	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verClientes(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		IClienteDAO dao= new  ClienteDaoImpl();
		clientes=dao.obtener();
                                                       
		vista.verClientes(clientes);
	}
    
}
