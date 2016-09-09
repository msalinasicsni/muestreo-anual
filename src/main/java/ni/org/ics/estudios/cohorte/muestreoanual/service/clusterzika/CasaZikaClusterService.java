package ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika;

import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.CasaZikaCluster;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto CasaZikaCluster
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("casaZikaClusterService")
@Transactional
public class CasaZikaClusterService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las CasaZikaCluster
	 * 
	 * @return una lista de <code>CasaZikaCluster</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<CasaZikaCluster> getCasaZikaCluster() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM CasaZikaCluster");
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa una CasaZikaCluster
	 * 
	 * @return un <code>CasaZikaCluster</code>
	 */

	public CasaZikaCluster getCasaZikaCluster(Integer codCasa) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM CasaZikaCluster casa where casa.codigo_casa =:codCasa");
		query.setParameter("codCasa", codCasa);
		CasaZikaCluster casaZika = (CasaZikaCluster) query.uniqueResult();
		return casaZika;
	}
	
	/**
	 * Guarda un CasaZikaCluster
	 * 
	 * 
	 */
	public void saveCasaZikaCluster(CasaZikaCluster casa) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(casa);
	}
	
}
