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
		usuario1 = new Usuario("Juancito", "Juan", "Pérez", "juan@mail.com", "contrasena2");
        usuario2 = new Usuario("usuario123", "Nombre", "Apellido", "unMail@mail.com", "contrasena123");
        usuario3 = new Usuario("Anita", "Ana", "García", "ana@mail.com", "contrasena1");

    }
	
	@Test
	public void testGuardarUsuarioDAOimpl() {
		//llamada al metodo que guarda
        Usuario usuarioGuardado = uDAO.guardar(usuario1);

        //testeo:
        Assertions.assertNotNull(usuarioGuardado, "No deberia ser null");
        Assertions.assertEquals("Juan", usuarioGuardado.getNombre(),"No deberia ser null");
        Assertions.assertEquals("juan@mail.com", usuarioGuardado.getEmail());
	}
	
	  @Test
	    public void testActualizarUsuarioDAOimpl() {
		  	// guardo el usuario.
		  	Usuario usuarioGuardado = uDAO.guardar(usuario2);
	        
		  	// Modifico atributos del usuario
	        usuarioGuardado.setNombreUsuario("Marita");
	        usuarioGuardado.setNombre("María");
	        usuarioGuardado.setApellido("Pérez");
	        usuarioGuardado.setEmail("maria.perez@mail.com");
	        
	        // Llamada al metodo que actualiza
	        Usuario usuarioActualizado = uDAO.actualizar(usuarioGuardado);

	        //testeo:
	        Assertions.assertNotNull(usuarioActualizado);
	        Assertions.assertEquals("Marita", usuarioActualizado.getNombreUsuario());
	        Assertions.assertEquals("María", usuarioActualizado.getNombre());
	        Assertions.assertEquals("Pérez", usuarioActualizado.getApellido());
	        Assertions.assertEquals("maria.perez@mail.com", usuarioActualizado.getEmail());
	        
	  }

	  @Test
	  public void testBorrar() {
			
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
	    public void testListarUsuarios() {
		    // Se agregaron 3 usuarios y se borro 1
	        // La lista tiene 2 usuarios
	        List<Usuario> ListaDeUsuariosGuardados = uDAO.listar();
	        
	        //Seria falso que la lista este vacia
	        Assertions.assertFalse(ListaDeUsuariosGuardados.isEmpty());
	        Assertions.assertEquals(2, ListaDeUsuariosGuardados.size());
	        
	        System.out.println("Lista de Usuarios ");
	        System.out.println("Nombres de usuario: ");

	    	for (Usuario user: uDAO.listar()) { 
	    		System.out.println("• "+user.getNombreUsuario());
	        }
	  }
}
