/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codere.idao;

import com.codere.model.Cliente;
import java.util.List;

/**
 *
 * @author heibe
 */
public interface IClienteDAO {
    public boolean registrar(Cliente cliente);
    public List<Cliente> obtener();
    public boolean actualizar(Cliente cliente);
    public boolean eliminar(Cliente cliente);

    
}
