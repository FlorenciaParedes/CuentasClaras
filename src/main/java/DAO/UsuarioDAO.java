package DAO;

import entidades.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	public Usuario buscarUsuarioPorMail(String email);
}
