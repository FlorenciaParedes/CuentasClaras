package DAO;

import entidades.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	//podriamos tener un get id!!
	public Usuario buscarUsuarioPorMail(String email);
}
