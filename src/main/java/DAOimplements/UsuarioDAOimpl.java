package DAOimplements;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import DAO.UsuarioDAO;
import entidades.Usuario;
import inicio.Factory;

public class UsuarioDAOimpl extends GenericDAOimpl<Usuario> implements UsuarioDAO{
		
		public UsuarioDAOimpl() {
			super(Usuario.class);
		}

		public Usuario buscarUsuarioPorMail(String email) {
			try { 
				Query consulta = Factory.getEntityManagerFactory().createEntityManager().
				createQuery("select u from Usuario u where u.email =:email");
				consulta.setParameter("email", email);
				return (Usuario)consulta.getSingleResult();
				
			} catch (NoResultException e) {
				//En el caso de que no se encuentre ningun usuario para ese mail retorna null
				return null;
			}
		}
}
