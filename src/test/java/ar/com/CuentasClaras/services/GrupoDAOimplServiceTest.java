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

	private Grupo grupoGuardado1;
	private Grupo grupoGuardado2;
	private Grupo grupoGuardado3;

	private GrupoDAOimpl gDAO = new GrupoDAOimpl();

	List<Grupo> ListaDeGastosGuardados = null;

	private CategoriaGrupoDAOimpl cgDAO = new CategoriaGrupoDAOimpl();
	private CategoriaGrupo categoriaGuardada;
	private CategoriaGrupo categoriaGrupo;

	private UsuarioDAOimpl usuarioDAO = new UsuarioDAOimpl();
	private Usuario usuarioOrigen;
	Usuario usuarioOrigenGuardado;

	@BeforeEach
	public void setUp() {

	}

	@Test
	public void testGuardarGrupoDAOimpl() {
		categoriaGrupo = new CategoriaGrupo("Amigos", (byte) 2);
		categoriaGuardada = cgDAO.guardar(categoriaGrupo);

		usuarioOrigen = new Usuario("flor", "Nombre", "Apellido", "email@example.com", "contrasena123");
		usuarioOrigenGuardado = usuarioDAO.guardar(usuarioOrigen);

		grupo1 = new Grupo("Recitalcitos", (byte) 2, categoriaGuardada, usuarioOrigenGuardado);
		grupoGuardado1 = gDAO.guardar(grupo1);

		// Asegura que los grupos se han guardado en la base de datos
		Assertions.assertNotNull(grupoGuardado1, "El grupo1 no debería ser null");

		// Para grupo1
		Assertions.assertEquals("Recitalcitos", grupoGuardado1.getNombre());
		Assertions.assertEquals("Amigos", grupoGuardado1.getCategoria().getNombre());

	}

	@Test
	public void testActualizarGrupoDAOimpl() {
		// inicializacion
		categoriaGrupo = new CategoriaGrupo("Facultad", (byte) 2);
		categoriaGuardada = cgDAO.guardar(categoriaGrupo);

		usuarioOrigen = new Usuario("Cata", "Nombre", "Apellido", "email@example.com", "contrasena123");
		usuarioOrigenGuardado = usuarioDAO.guardar(usuarioOrigen);

		grupo2 = new Grupo("Perces Raros", (byte) 2, categoriaGuardada,usuarioOrigenGuardado);
		grupoGuardado2 = gDAO.guardar(grupo2);

		// Modificacion
		grupoGuardado2.setNombre("Tallercito");

		Grupo grupoActualizado = gDAO.actualizar(grupoGuardado2);

		// testeo:
		Assertions.assertNotNull(grupoActualizado);
		Assertions.assertEquals("Tallercito", grupoActualizado.getNombre());

	}

	@Test
	public void testBorrar() {
		// inicializacion
		categoriaGrupo = new CategoriaGrupo("Estudio", (byte) 2);
		categoriaGuardada = cgDAO.guardar(categoriaGrupo);

		usuarioOrigen = new Usuario("Maria", "Nombre", "Apellido", "email@example.com", "contrasena123");
		usuarioOrigenGuardado = usuarioDAO.guardar(usuarioOrigen);

		grupo3 = new Grupo("Facultad", (byte) 2, categoriaGuardada,usuarioOrigenGuardado);
		grupoGuardado3 = gDAO.guardar(grupo3);

		// aseguro que existe
		Assertions.assertNotNull(grupoGuardado3);

		// metodo para borrar el usuario
		gDAO.borrar(grupoGuardado3);

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
