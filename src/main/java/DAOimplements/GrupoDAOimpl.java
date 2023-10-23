package DAOimplements;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Query;

import DAO.GrupoDAO;
import entidades.Grupo;
//import inicio.Factory;
import entidades.Usuario;

public class GrupoDAOimpl extends GenericDAOimpl<Grupo> implements GrupoDAO{
		
		public GrupoDAOimpl() {
			super(Grupo.class); //setea la entidad que va a manejar esta implementacion
		}
		
		

	
}
