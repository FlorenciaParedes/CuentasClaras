package inicio;

import DAOimplements.CategoriaGrupoDAOimpl;
import DAOimplements.GrupoDAOimpl;
import DAOimplements.UsuarioDAOimpl;
import entidades.CategoriaGrupo;
import entidades.Grupo;
import entidades.Usuario;

public class Main {
	public static void main(String[] args) {
	
	/*Alta usuario 1*/
		System.out.println("Alta");
	UsuarioDAOimpl uDAO = new UsuarioDAOimpl();
	Usuario usuario = new Usuario("juan123", "Juan", "P", "juan@mail.com", "contrasena123");
	uDAO.guardar(usuario);
	
	/*Alta grupo*/
		System.out.println("AltaGrupo");
	GrupoDAOimpl gDAO = new GrupoDAOimpl();	
	Grupo grupo1 = new Grupo("Grupo1", (byte) 1);	//Esta linea daria es para luego relacionar el usuario con un grupo, pero todavia no esta el metodo y la vuelta con los dao.
	gDAO.guardar(grupo1);
	
	/* relacionar grupo y usuario */
		System.out.println("relacionando grupo");
	grupo1.agregarIntegrante(usuario);
	gDAO.actualizar(grupo1);
	
	/*Alta categoria grupo*/
		System.out.println("AltaCategoria");
	CategoriaGrupoDAOimpl cgDAO = new CategoriaGrupoDAOimpl();
	CategoriaGrupo categoriaGrupo = new CategoriaGrupo("amigos", (byte) 2);
	cgDAO.guardar(categoriaGrupo);
	
	/*setear categoria al grupo*/
		System.out.println("SetCategoria");
	grupo1.setCategoria(categoriaGrupo);
	//gDAO.actualizar(grupo1); //Cuando actualizo el grupo se duplica la tabla intermedia
		
	/*Modificacion de datos del usuario*/
		System.out.println("Modificar");
	usuario.setNombre("Rosa");
	usuario.setApellido("Lia");
	uDAO.actualizar(usuario);

	/*Alta usuario 2 */
		System.out.println("Alta 2");
	Usuario usuario2 = new Usuario("pedro123", "Pedro", "Garcia", "pedro@mail.com", "pedro123");
	uDAO.guardar(usuario2);
	/*Alta usuario 3 */
	System.out.println("Alta 3");
	Usuario usuario3 =  new Usuario("maria456", "Maria", "López", "maria@mail.com", "maria123");
	uDAO.guardar(usuario3);
	
	/*Recorrer y listar usuarios*/
	System.out.println("** Listar Usuarios");
	for (Usuario user: uDAO.listar()) { // Va a imprimir todos los usuarios
		System.out.println(user.getNombreUsuario());
	}
	
	/*Baja de usuario 2*/
	uDAO.borrar(usuario2);
	
	/*Recorrer y listar usuarios despues de borrar*/
		System.out.println("** Listar Usuarios despues de borrar");
	for (Usuario user: uDAO.listar()) { // Va a imprimir todos los usuarios
		System.out.println(user.getNombreUsuario());
    }
	/*Agregar amigo*/
	usuario.agregarAmigo(usuario3);
	uDAO.actualizar(usuario);

	//Persiste Usuario y Servicio en BD

	//pisa al otro este actualizar, preguntar si asi es la idea!
	//uDAO.actualizar(usuario2);
	//System.out.println("LUEGO DEL actualizar");
	
	//uDAO.borrar(usuario2);
	//System.out.println("LLEGAMOS AL MAIN LUEGO DE borrar entidad");
	
	//uDAO.guardar(usuario2);
	
	//uDAO.eliminar(uDAO.buscarUsuarioPorMail("pedro@mail.com").getId());
	//System.out.println("LLEGAMOS AL MAIN LUEGO DEL eliminar con id");
	
   
	}
}