package ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika;

import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.MuestrasZikaCluster;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto MuestrasZikaCluster
 * 
 * @author Jairo Carey
 * 
 **/

@Service("muestrasZikaClusterService")
@Transactional
public class MuestrasZikaClusterService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las MuestrasZikaCluster
	 * 
	 * @return una lista de <code>MuestrasZikaCluster</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<MuestrasZikaCluster> getMuestrasZikaCluster() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM MuestrasZikaCluster");
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa una MuestrasZikaCluster
	 * 
	 * @return un <code>MuestrasZikaCluster</code>
	 */

	public MuestrasZikaCluster getMuestrasZikaCluster(Integer idMue) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM MuestrasZikaCluster mue where mue.IdMuestra =:idMue");
		query.setParameter("idMue", idMue);
		MuestrasZikaCluster mueZika = (MuestrasZikaCluster) query.uniqueResult();
		return mueZika;
	}
	
	/**
	 * Guarda un muestrasZikaCluster
	 * 
	 * 
	 */
	public void saveMuestrasZikaCluster(MuestrasZikaCluster participante) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(participante);
	}
	
}
