package ar.com.CuentasClaras.services;

import java.util.List;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import DAOimplements.CategoriaGrupoDAOimpl;
import DAOimplements.GrupoDAOimpl;
import DAOimplements.UsuarioDAOimpl;
import entidades.CategoriaGrupo;
import entidades.Grupo;
import entidades.Usuario;

public class GrupoDAOimplServiceTest {

	// declaro variables
	private Grupo grupo1;
	private Grupo grupo2;
	private Grupo grupo3;

	private GrupoDAOimpl gDAO;
	List<Grupo> ListaDeGastosGuardados = null;

	@BeforeEach
	public void setUp() {
		gDAO = new GrupoDAOimpl();

		CategoriaGrupoDAOimpl cgDAO = new CategoriaGrupoDAOimpl();
		CategoriaGrupo categoriaGrupo = new CategoriaGrupo("comida", (byte) 2);
		CategoriaGrupo categoriaGuardada = cgDAO.guardar(categoriaGrupo);

		UsuarioDAOimpl usuarioDAO = new UsuarioDAOimpl();
		Usuario usuarioOrigen = new Usuario("flor", "Nombre", "Apellido", "email@example.com", "contrasena123");
		usuarioDAO.guardar(usuarioOrigen);

		grupo1 = new Grupo("Recitalcitos", (byte) 2, categoriaGuardada );
		grupo2 = new Grupo("Perces Raros", (byte) 2, categoriaGuardada );
		grupo3 = new Grupo("Facultad", (byte) 2, categoriaGuardada );

	}

	@Test
	public void testGuardarGrupoDAOimpl() {
		
		Grupo grupoGuardado = gDAO.guardar(grupo1);
		
		Assertions.assertNotNull(grupoGuardado, "No deberia ser null");
		Assertions.assertEquals("Recitalcitos", grupoGuardado.getNombre());
		Assertions.assertEquals("comida", grupoGuardado.getCategoria().getNombre());

	}

	@Test
	public void testActualizarGrupoDAOimpl() {
		
		Grupo grupoGuardado = gDAO.guardar(grupo2);

		
		grupoGuardado.setNombre("Tallercito");
		
		Grupo grupoActualizado = gDAO.actualizar(grupoGuardado);
		 System.out.println(grupoActualizado.getNombre());

		// testeo:
		Assertions.assertNotNull(grupoActualizado);
		Assertions.assertEquals("Tallercito", grupoActualizado.getNombre());


	}

	@Test
	public void testBorrar() {

		Grupo grupoGuardado = gDAO.guardar(grupo3);
		// aseguro que existe
		Assertions.assertNotNull(grupoGuardado);

		// metodo para borrar el usuario
		gDAO.borrar(grupoGuardado);

		// Busco al usuario por su email después de borrarlo
		Grupo grupoBorrado = gDAO.buscarGrupoPorNombre("Facultad");

		// Aseguro que no existe mas
		Assertions.assertNull(grupoBorrado);
	}

	@Test
	public void testListarGrupo() {

		
		List<Grupo> ListaDeGruposGuardados = gDAO.listar();

		Assertions.assertFalse(ListaDeGruposGuardados.isEmpty()); 

		Assertions.assertEquals(2, ListaDeGruposGuardados.size());

		System.out.println("Lista de grupos ");


		for (Grupo grupo : gDAO.listar()) {
			System.out.println("• " + grupo.getNombre());
		}

	}

}
