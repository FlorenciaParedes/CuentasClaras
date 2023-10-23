package inicio;

import java.sql.Date;

import DAOimplements.GastoDAOimpl;
import DAOimplements.UsuarioDAOimpl;
import entidades.Gasto;
import entidades.Grupo;
import entidades.Usuario;

public class Main {
	public static void main(String[] args) {
	//Usuario usuario= new Usuario("Juan");
	//Grupo grupo = new Grupo("Grupo1", (byte) 1);	Esta linea daria es para luego relacionar el usuario con un grupo, pero todavia no esta el metodo y la vuelta con los dao.
	Usuario usuario = new Usuario("juan123", "Juan", "Pérez", "juan@mail.com", "contrasena123");
	Usuario usuario2 = new Usuario("pedro123", "Pedro", "Garcia", "pedro@mail.com", "pedro123");
	//Persiste Usuario y Servicio en BD
	UsuarioDAOimpl uDAO = new UsuarioDAOimpl();
	System.out.println("LLEGAMOS AL MAIN ANTES DEL GUARDAR");
	uDAO.guardar(usuario);
	System.out.println("LLEGAMOS AL MAIN LUEGO DEL GUARDAR");
	
	//pisa al otro este actualizar, preguntar si asi es la idea!
	//uDAO.actualizar(usuario2);
	System.out.println("LLEGAMOS AL MAIN LUEGO DEL actualizar");
	
	//uDAO.borrar(usuario2);
	System.out.println("LLEGAMOS AL MAIN LUEGO DE borrar entidad");
	
	Usuario userDB = uDAO.guardar(usuario2);
	
	//uDAO.eliminar(uDAO.buscarUsuarioPorMail("pedro@mail.com").getId());
	System.out.println("LLEGAMOS AL MAIN LUEGO DEL eliminar con id");
	
    System.out.println("Listar Usuarios");
	    for (Usuario user: uDAO.listar()) { // Va a imprimir todos los usuarios
	    	System.out.println(user.getNombreUsuario());
		
	    }
	
	Gasto gasto = new Gasto(usuario2.getNombreUsuario(),2);
	
	GastoDAOimpl gDAO= new GastoDAOimpl();
	
	gDAO.guardar(gasto); //con la imagen como hacemos para esta entrega?  
	//con bytes get byte y eso igual lo hacemos a lo ultimo lo de la img no hay apu
	//la imagen le decimos toda la ruta y la levantamos
	}
}
