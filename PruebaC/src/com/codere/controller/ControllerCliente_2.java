/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codere.controller;

import com.codere.dao.ClienteDaoImpl;
import com.codere.idao.IClienteDAO;
import com.codere.model.Cliente;
import com.codere.vista.ViewCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author heibe
 */
public class ControllerCliente_2 implements ActionListener{
    
    ClienteDaoImpl objP;
    ViewCliente objV;
    Cliente cliente = new Cliente();

    public ControllerCliente_2() {
        this.objP = new ClienteDaoImpl();
        this.objV = new ViewCliente();
        
        objV.getBtnEliminar().addActionListener(this);
        objV.getBtnCrear().addActionListener(this);
        
        
    }
    
    public void iniciar(){
        objV.setTitle("Ejemplo");
        objV.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == objV.getBtnEliminar()){
            JOptionPane.showMessageDialog(objV, "Nombre ingresado "+ 
                    objV.getTxtNombre_1().getText(),"Mensaje", 1);
            
            cliente.setNombre(objV.getTxtNombre_1().getText());
            eliminar(cliente);
                   
            
        }
        if(e.getSource() == objV.getBtnCrear()){
            
           // JOptionPane.showMessageDialog(objV, "Los datos de creación son: "+ 
                   // objV.getTxtId().getText()+"/"+ objV.getTxtNombre_1().getText()+"/"+ objV.getBoxRol().getItemAt(0) + "/" +objV.getBtnValidacion(),"Mensaje", 1);
            
            
            String p =objV.getTxtId().getText();
            int pt = Integer.parseInt(p);
            
            String p2 =objV.getBoxRol().getItemAt(0);
            int pt2 = Integer.parseInt(p);
            
                       
            // guarda un cliente a través del controlador
            cliente.setIdUsuario(pt);
            cliente.setNombre(objV.getTxtNombre_1().getText());
            cliente.setActivo(objV.getBtnValidacion());
            cliente.setIdRol(pt2);
            
            registrar(cliente);
        }
        
    }
    
    public void eliminar(Cliente cliente) {
		IClienteDAO dao= new  ClienteDaoImpl();
		dao.eliminar(cliente);
	}
    
    
    //llama al DAO para guardar un cliente
    public void registrar(Cliente cliente ) {
		IClienteDAO dao= new  ClienteDaoImpl();
		dao.registrar(cliente);
	}
	
    
    
    
    
    
}
