package ar.com.CuentasClaras.services;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import DAOimplements.CategoriaGastoDAOimpl;
import DAOimplements.GastoDAOimpl;
import DAOimplements.UsuarioDAOimpl;
import entidades.CategoriaGasto;
import entidades.CategoriaGrupo;
import entidades.Gasto;
import entidades.Usuario;

public class GastoDAOimplServiceTest {

	
	@Test
	public void testGuardarUsuarioDAOimpl() {
		     
    	CategoriaGastoDAOimpl cgDAO = new CategoriaGastoDAOimpl();
    	CategoriaGasto categoriaGasto = new CategoriaGasto("comida", (byte) 2);
    	cgDAO.guardar(categoriaGasto);
       
        UsuarioDAOimpl usuarioDAO = new UsuarioDAOimpl();       
        Usuario usuarioOrigen = new Usuario("flor", "Nombre", "Apellido", "email@example.com", "contrasena123");
        usuarioDAO.guardar(usuarioOrigen);
        
        GastoDAOimpl gastoDAO = new GastoDAOimpl();
        // Crear un gasto usuario para guardar 
        Gasto gastoAGuardar = new Gasto("dulce", 1 , categoriaGasto , usuarioOrigen ,  (byte) 2);
        Gasto gastoAGuardar2 = new Gasto("vino", 1 , categoriaGasto , usuarioOrigen ,  (byte) 2);
        
        // Llamo al método para guardar el usuario
        Gasto gastoGuardado = gastoDAO.guardar(gastoAGuardar);
        Gasto gastoGuardado2 = gastoDAO.guardar(gastoAGuardar2);
        
        // Asegurarse de que el usuario guardado no sea nulo
        Assertions.assertNotNull(gastoGuardado);
        
        Assertions.assertNotEquals(gastoGuardado, gastoGuardado2);
        
	}
}
