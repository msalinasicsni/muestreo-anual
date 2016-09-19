package ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika;

import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.EncuestaParticipanteZikaCluster;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto EncuestaPartizipanteZikaCluster
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("encuestaParticipanteZikaClusterService")
@Transactional
public class EncuestaParticipanteZikaClusterService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las EncuestaParticipanteZikaCluster
	 * 
	 * @return una lista de <code>EncuestaParticipanteZikaCluster</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<EncuestaParticipanteZikaCluster> getEncuestaParticipanteZikaCluster() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM EncuestaParticipanteZikaCluster");
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa una EncuestaParticipanteZikaCluster
	 * 
	 * @return un <code>EncuestaParticipanteZikaCluster</code>
	 */

	public EncuestaParticipanteZikaCluster getEncuestaParticipanteZikaCluster(Integer codigo) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM EncuestaParticipanteZikaCluster encuestaParticipante where encuestaParticipante.codigo =:codigo");
		query.setParameter("codigo", codigo);
		EncuestaParticipanteZikaCluster encuestaParticipanteZika = (EncuestaParticipanteZikaCluster) query.uniqueResult();
		return encuestaParticipanteZika;
	}
	
	/**
	 * Guarda un CasaZikaCluster
	 * 
	 * 
	 */
	public void saveEncuestaParticipanteZikaCluster(EncuestaParticipanteZikaCluster epzc) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(epzc);
	}
	
}
