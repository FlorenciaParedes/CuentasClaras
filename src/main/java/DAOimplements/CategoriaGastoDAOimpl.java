package DAOimplements;


import DAO.CategoriaGastoDAO;
import entidades.CategoriaGasto;


public class CategoriaGastoDAOimpl extends GenericDAOimpl<CategoriaGasto> implements CategoriaGastoDAO{

	public CategoriaGastoDAOimpl() {
		super(CategoriaGasto.class);
	}


}
