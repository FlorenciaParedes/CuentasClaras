package DAOimplements;
	import java.util.ArrayList;
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Query;

	import DAO.GenericDAO;
	import inicio.Factory;


public class GenericDAOimpl<T> implements GenericDAO<T>{

	
		protected Class<T> persistentClass;
		
		public GenericDAOimpl(Class<T> clase) {
			persistentClass = clase;
		}
		 

		@Override
		public T guardar(T entidad) {
			//instancia de EntityManager
			EntityManager em = Factory.getEntityManagerFactory().createEntityManager();
			//variable para la transacción.
			EntityTransaction tx = null;
			try {
				//obtiene una transaccion 
				tx = em.getTransaction();
				// inicia la transaccion
				 tx.begin();
				 //persiste la entidad
				 em.persist(entidad);
				 //confirma la tx y aplica los cambios en la bd
				 tx.commit();
			}
			catch (RuntimeException e) {
				//En caso de excepcion verifica si la tx esta activa para hacer rollback
				 if ( tx != null && tx.isActive() ) 
					 tx.rollback();
				 throw e; 
			}
			finally {
				//cierra el entity manager
				em.close();
			}
			return entidad; 

		}


}
