package inicio;

import DAOimplements.UsuarioDAOimpl;
import entidades.Usuario;

public class Main {
	public static void main(String[] args) {
	Usuario usuario= new Usuario("Juan");
	
	//Persiste Usuario y Servicio en BD
	UsuarioDAOimpl uDAO = new UsuarioDAOimpl();
	System.out.println("LLEGAMOS AL MAIN ANTES DEL GUARDAR");
	uDAO.guardar(usuario);
	System.out.println("LLEGAMOS AL MAIN LUEGO DEL GUARDAR");
	
	}
}