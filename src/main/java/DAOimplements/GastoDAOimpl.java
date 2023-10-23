package DAOimplements;

import DAO.GastoDAO;
import entidades.Gasto;

public class GastoDAOimpl extends GenericDAOimpl<Gasto> implements GastoDAO{
		
		public GastoDAOimpl() {
			super(Gasto.class);
		}
}
