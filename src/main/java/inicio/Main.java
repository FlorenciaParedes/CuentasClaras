package inicio;

import DAOimplements.UsuarioDAOimpl;
import entidades.Grupo;
import entidades.Usuario;

public class Main {
	public static void main(String[] args) {
	//Usuario usuario= new Usuario("Juan");
	//Grupo grupo = new Grupo("Grupo1", (byte) 1);	Esta linea daria es para luego relacionar el usuario con un grupo, pero todavia no esta el metodo y la vuelta con los dao.
	Usuario usuario = new Usuario("juan123", "Juan", "Pérez", "juan@mail.com", "contrasena123");

	//Persiste Usuario y Servicio en BD
	UsuarioDAOimpl uDAO = new UsuarioDAOimpl();
	System.out.println("LLEGAMOS AL MAIN ANTES DEL GUARDAR");
	uDAO.guardar(usuario);
	System.out.println("LLEGAMOS AL MAIN LUEGO DEL GUARDAR");
	
	}
}
