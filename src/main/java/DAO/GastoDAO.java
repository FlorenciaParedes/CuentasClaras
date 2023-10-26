package DAO;

import entidades.Gasto;
import entidades.Usuario;

public interface GastoDAO extends GenericDAO<Gasto>{
	
	public Gasto buscarGastoPorNombre(String nombre);
}
