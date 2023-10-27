package ar.com.CuentasClaras.services;
import org.junit.jupiter.api.Test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import DAOimplements.UsuarioDAOimpl;
import entidades.Grupo;
import entidades.Usuario;

public class UsuarioServiceTest {
	private Usuario usuario;
	private UsuarioDAOimpl uDAO;
	
	@BeforeEach
	//El setUp se corre antes que los test e inicializa variables que voy a usar en los metodos test.
    public void setUp() {
		Usuario u = new Usuario("Anita", "Ana", "García", "ana@mail.com", "contrasena1");
		uDAO = new UsuarioDAOimpl();
		usuario = uDAO.guardar(u);

	}
	
	@Test
	public void testRegistrarGrupo() {
		System.out.println("TOI ACA");
		Grupo grupo = usuario.registrarGrupo("Amigos",(byte)4);
		Assertions.assertNotNull(grupo);
		Assertions.assertEquals("Amigos", grupo.getNombre());
		Assertions.assertTrue(usuario.getGrupos().contains(grupo));

		List<Grupo> gruposDelUsuario = uDAO.obtenerGruposDelUsuarioPorId(usuario.getId());
		Assertions.assertEquals("Amigos", gruposDelUsuario.get(0).getNombre());
		
		 for (Grupo grupoUsuario : gruposDelUsuario) {
		        System.out.println("Nombre del Grupo: " + grupoUsuario.getNombre());
		    }
	}
	

}
