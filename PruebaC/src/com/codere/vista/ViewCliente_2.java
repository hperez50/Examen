/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codere.vista;

import com.codere.model.Cliente;
import java.util.List;

/**
 *
 * @author heibe
 */
public class ViewCliente_2 {
    
    	public void verCliente(Cliente cliente) {
		System.out.println("Datos del Cliente: "+cliente);
	}
	
	public void verClientes(List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			System.out.println("Datos del Cliente: "+cliente);
		}		
	}
    
}
