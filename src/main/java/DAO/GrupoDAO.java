package DAO;

import entidades.Gasto;
import entidades.Grupo;
import entidades.Usuario;

public interface GrupoDAO extends GenericDAO<Grupo> {

	public Grupo buscarGrupoPorNombre(String nombre);
}
