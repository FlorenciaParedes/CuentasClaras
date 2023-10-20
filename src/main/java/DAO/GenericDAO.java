package DAO;

import entidades.Usuario;

public interface GenericDAO<T> {

	public T guardar(T base);
	
	T actualizar(T entidad);

    void borrar(T entidad);
	
	void eliminar(long id);

}
