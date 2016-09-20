package ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika;

import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.SintomasZikaCluster;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto SintomasZikaCluster
 * 
 * @author Jairo Carey
 * 
 **/

@Service("sintomasZikaClusterService")
@Transactional
public class SintomasZikaClusterService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las SintomasZikaCluster
	 * 
	 * @return una lista de <code>SintomasZikaCluster</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<SintomasZikaCluster> getSintomasZikaCluster() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM SintomasZikaCluster");
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa una SintomasZikaCluster
	 * 
	 * @return un <code>SintomasZikaCluster</code>
	 */

	public SintomasZikaCluster getSintomasZikaCluster(Integer idSnt) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM SintomasZikaCluster snt where snt.idSintoma =:idSnt");
		query.setParameter("idSnt", idSnt);
		SintomasZikaCluster sntZika = (SintomasZikaCluster) query.uniqueResult();
		return sntZika;
	}
	
	/**
	 * Guarda un SintomasZikaCluster
	 * 
	 * 
	 */
	public void saveSintomasZikaCluster(SintomasZikaCluster participante) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(participante);
	}
	
}
