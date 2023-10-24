package ar.com.CuentasClaras.services;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import DAOimplements.UsuarioDAOimpl;
import entidades.Usuario;

public class UsuarioDAOimplServiceTest {
	//declaro variables
	
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private UsuarioDAOimpl uDAO;
   
	@BeforeEach
	//El setUp se corre antes que los test e inicializa variables que voy a usar en los metodos test.
    public void setUp() {
		uDAO = new UsuarioDAOimpl();
        usuario1 = new Usuario("usuario123", "Nombre", "Apellido", "email@example.com", "contrasena123");
        usuario2 = new Usuario("usuario2", "Juan", "Pérez", "juan@example.com", "contrasena2");
        usuario3 = new Usuario("usuario1", "María", "García", "maria@example.com", "contrasena1");
    }
	
	@Test
	public void testGuardarUsuarioDAOimpl() {
		//llamada al metodo que guarda
        Usuario usuarioGuardado = uDAO.guardar(usuario1);

        //testeo:
        Assertions.assertNotNull(usuarioGuardado, "No deberia ser null");
        Assertions.assertEquals("Nombre", usuarioGuardado.getNombre(),"No deberia ser null");
        Assertions.assertEquals("email@example.com", usuarioGuardado.getEmail());
	}
	
	  @Test
	    public void testActualizarUsuarioDAOimpl() {
		  	// guardo el usuario.
		  	Usuario usuarioGuardado = uDAO.guardar(usuario2);
	        
		  	// Modifico atributos del usuario
	        usuarioGuardado.setNombre("María");
	        usuarioGuardado.setApellido("Pérez");
	        usuarioGuardado.setEmail("maria.perez@example.com");
	        
	        // Llamada al metodo que actualiza
	        Usuario usuarioActualizado = uDAO.actualizar(usuarioGuardado);

	        //testeo:
	        Assertions.assertNotNull(usuarioActualizado);
	        Assertions.assertEquals("María", usuarioActualizado.getNombre());
	        Assertions.assertEquals("Pérez", usuarioActualizado.getApellido());
	        Assertions.assertEquals("maria.perez@example.com", usuarioActualizado.getEmail());
	        
	  }

	  @Test
	  public void testBorrar() {
			//Usuario u = new Usuario("Anita", "Ana", "Gonzalez", "ana.gonzalez@mail.com", "contrasena123");
			
			Usuario usuarioGuardado = uDAO.guardar(usuario3);
			// aseguro que existe
			Assertions.assertNotNull(usuarioGuardado);
			 
			// metodo para borrar el usuario
			uDAO.borrar(usuarioGuardado);
			
			// Busco al usuario por su email después de borrarlo
			Usuario usuarioBorrado = uDAO.buscarUsuarioPorMail("ana.gonzalez@mail.com");
			
			// Aseguro que no existe mas
			Assertions.assertNull(usuarioBorrado);
	  }
	  
	  @Test
	    public void testListarUsuariosConTresUsuarios() {
		    // Se agregaron 3 usuarios y se borro 1
	        // La lista tiene 2 usuarios
	        List<Usuario> ListaDeUsuariosGuardados = uDAO.listar();
	        
	        //Seria falso que la lista este vacia
	        Assertions.assertFalse(ListaDeUsuariosGuardados.isEmpty());
	        Assertions.assertEquals(2, ListaDeUsuariosGuardados.size());
	        
	        System.out.println("** Lista de Usuarios **");
	    	for (Usuario user: uDAO.listar()) { 
	    		System.out.println(user.getNombreUsuario());
	        }
	  }
}
