package ar.com.CuentasClaras.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import DAOimplements.UsuarioDAOimpl;
import entidades.Usuario;

public class UsuarioDAOimplServiceTest {

	
	@Test
	public void testGuardarUsuarioDAOimpl() {
		
		
		  // Crear una instancia de UsuarioDAOimpl
        UsuarioDAOimpl usuarioDAO = new UsuarioDAOimpl();

        // Crear un nuevo usuario para guardar
        Usuario usuarioAGuardar = new Usuario("usuario123", "Nombre", "Apellido", "email@example.com", "contrasena123");

        // Llamo al método para guardar el usuario
        Usuario usuarioGuardado = usuarioDAO.guardar(usuarioAGuardar);

        // Asegurarse de que el usuario guardado no sea nulo
        Assertions.assertNotNull(usuarioGuardado);

	}
}
