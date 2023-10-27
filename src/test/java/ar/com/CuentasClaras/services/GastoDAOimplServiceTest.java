package ar.com.CuentasClaras.services;

import java.util.List;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import DAOimplements.CategoriaGastoDAOimpl;
import DAOimplements.GastoDAOimpl;
import DAOimplements.UsuarioDAOimpl;

import entidades.CategoriaGasto;
import entidades.CategoriaGrupo;
import entidades.Gasto;
import entidades.Grupo;
import entidades.Usuario;

public class GastoDAOimplServiceTest {

	/*
	 * @Test public void testGuardarUsuarioDAOimpl() {
	 * 
	 * CategoriaGastoDAOimpl cgDAO = new CategoriaGastoDAOimpl(); CategoriaGasto
	 * categoriaGasto = new CategoriaGasto("comida", (byte) 2);
	 * cgDAO.guardar(categoriaGasto);
	 * 
	 * UsuarioDAOimpl usuarioDAO = new UsuarioDAOimpl(); Usuario usuarioOrigen = new
	 * Usuario("flor", "Nombre", "Apellido", "email@example.com", "contrasena123");
	 * usuarioDAO.guardar(usuarioOrigen);
	 * 
	 * GastoDAOimpl gastoDAO = new GastoDAOimpl(); // Crear un gasto usuario para
	 * guardar Gasto gastoAGuardar = new Gasto("dulce", 1 , categoriaGasto ,
	 * usuarioOrigen , (byte) 2); Gasto gastoAGuardar2 = new Gasto("vino", 1 ,
	 * categoriaGasto , usuarioOrigen , (byte) 2);
	 * 
	 * // Llamo al método para guardar el usuario Gasto gastoGuardado =
	 * gastoDAO.guardar(gastoAGuardar); Gasto gastoGuardado2 =
	 * gastoDAO.guardar(gastoAGuardar2);
	 * 
	 * // Asegurarse de que el usuario guardado no sea nulo
	 * Assertions.assertNotNull(gastoGuardado);
	 * 
	 * Assertions.assertNotEquals(gastoGuardado, gastoGuardado2);
	 * 
	 * }
	 */

	// declaro variables
	private Gasto gasto1;
	private Gasto gasto2;
	private Gasto gasto3;
	private GastoDAOimpl gDAO;
	List<Gasto> ListaDeGastosGuardados = null;

	@BeforeEach
	// El setUp se corre antes que los test e inicializa variables que voy a usar en
	// los metodos test.
	public void setUp() {
		gDAO = new GastoDAOimpl();

		CategoriaGastoDAOimpl cgDAO = new CategoriaGastoDAOimpl();
		CategoriaGasto categoriaGasto = new CategoriaGasto("comida", (byte) 2);
		CategoriaGasto categoriaGuardada = cgDAO.guardar(categoriaGasto);

		UsuarioDAOimpl usuarioDAO = new UsuarioDAOimpl();
		Usuario usuarioOrigen = new Usuario("flor", "Nombre", "Apellido", "email@example.com", "contrasena123");
		Usuario usuarioGuardado = usuarioDAO.guardar(usuarioOrigen);

		gasto1 = new Gasto("dulce de leche", 1200, categoriaGuardada, usuarioGuardado, (byte) 2);
		gasto2 = new Gasto("vino", 2000, categoriaGuardada, usuarioGuardado, (byte) 2);
		gasto3 = new Gasto("yerba", 1500, categoriaGuardada, usuarioGuardado, (byte) 2);

	}

	@Test
	public void testGuardarGastoDAOimpl() {
		// llamada al metodo que guarda
		Gasto gastoGuardado = gDAO.guardar(gasto1);

		// testeo:
		Assertions.assertNotNull(gastoGuardado, "No deberia ser null");
		Assertions.assertEquals("dulce de leche", gastoGuardado.getNombre(), "No deberia ser null");
		Assertions.assertEquals(1200, gastoGuardado.getMonto());
		

	}

	@Test
	public void testActualizarGastoDAOimpl() {
		// guardo el gasto.
		Gasto gastoGuardado = gDAO.guardar(gasto2);

		// Modifico atributos del gasto
		/*gastoGuardado.setNombre("shampoo");
		gastoGuardado.setMonto(1);

		// Llamada al metodo que actualiza
		Gasto gastoActualizado = gDAO.actualizar(gastoGuardado);
		// System.out.println(gastoActualizado.getNombre());

		// testeo:
		Assertions.assertNotNull(gastoActualizado);
		Assertions.assertEquals("shampoo", gastoActualizado.getNombre());
		Assertions.assertEquals(1, gastoActualizado.getMonto());*/

	}

/*	@Test
	public void testBorrar() {

		Gasto gastoGuardado = gDAO.guardar(gasto3);
		// aseguro que existe
		Assertions.assertNotNull(gastoGuardado);

		// metodo para borrar el usuario
		gDAO.borrar(gastoGuardado);

		// Busco al usuario por su email después de borrarlo
		Gasto gastoBorrado = gDAO.buscarGastoPorNombre("yerba");

		// Aseguro que no existe mas
		Assertions.assertNull(gastoBorrado);
	}*/

	@Test
	public void testListarGrupo() {

	    Gasto gastoGuardado = gDAO.guardar(gasto3); //si pongo aca el del actualizar anda!! lo lista, sino no...... 
		List<Gasto> ListaDeGruposGuardados = gDAO.listar();

		Assertions.assertFalse(ListaDeGruposGuardados.isEmpty()); 

	//	Assertions.assertEquals(2, ListaDeGruposGuardados.size());

		System.out.println("Lista de grupos ");


		for (Gasto gasto : gDAO.listar()) {
			System.out.println("• " + gasto.getNombre());
		}

	}

}
