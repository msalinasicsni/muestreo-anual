package ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika;

import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.TamizajeZikaCluster;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto TamizajeZikaCluster
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("tamizajeZikaClusterService")
@Transactional
public class TamizajeZikaClusterService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las TamizajeZikaCluster
	 * 
	 * @return una lista de <code>TamizajeZikaCluster</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<TamizajeZikaCluster> getTamizajeZikaCluster() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM TamizajeZikaCluster");
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa una TamizajeZikaCluster
	 * 
	 * @return un <code>TamizajeZikaCluster</code>
	 */

	public TamizajeZikaCluster getTamizajeZikaCluster(String idTam) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM TamizajeZikaCluster tam where tam.idTamizaje =:idTam");
		query.setParameter("idTam", idTam);
		TamizajeZikaCluster tamZika = (TamizajeZikaCluster) query.uniqueResult();
		return tamZika;
	}
	
	/**
	 * Guarda un TamizajeZikaCluster
	 * 
	 * 
	 */
	public void saveTamizajeZikaCluster(TamizajeZikaCluster tam) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tam);
	}
	
}
