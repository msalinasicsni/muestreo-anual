package ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika;

import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.SintomasInicialesZikaCluster;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto SintomasInicialesZikaCluster
 * 
 * @author Jairo Carey
 * 
 **/

@Service("sintomasInicialesZikaClusterService")
@Transactional
public class SintomasInicialesZikaClusterService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las SintomasInicialesZikaCluster
	 * 
	 * @return una lista de <code>SintomasInicialesZikaCluster</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<SintomasInicialesZikaCluster> getSintomasInicialesZikaCluster() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM SintomasInicialesZikaCluster");
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa una SintomasInicialesZikaCluster
	 * 
	 * @return un <code>SintomasInicialesZikaCluster</code>
	 */

	public SintomasInicialesZikaCluster getSintomasInicialesZikaCluster(Integer codigo) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM SintomasInicialesZikaCluster sin where sin.codigo =:codigo");
		query.setParameter("codigo", codigo);
		SintomasInicialesZikaCluster sinZika = (SintomasInicialesZikaCluster) query.uniqueResult();
		return sinZika;
	}
	
	/**
	 * Guarda un SintomasInicialesZikaCluster
	 * 
	 * 
	 */
	public void saveSintomasInicialesZikaCluster(SintomasInicialesZikaCluster sin) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(sin);
	}
	
}
