package ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika;

import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.ParticipanteZikaCluster;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto ParticipanteZikaCluster
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("participanteZikaClusterService")
@Transactional
public class ParticipanteZikaClusterService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las ParticipanteZikaCluster
	 * 
	 * @return una lista de <code>ParticipanteZikaCluster</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<ParticipanteZikaCluster> getParticipanteZikaCluster() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM ParticipanteZikaCluster");
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa una ParticipanteZikaCluster
	 * 
	 * @return un <code>ParticipanteZikaCluster</code>
	 */

	public ParticipanteZikaCluster getParticipanteZikaCluster(Integer codigo) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM ParticipanteZikaCluster par where par.codigo =:codigo");
		query.setParameter("codigo", codigo);
		ParticipanteZikaCluster parZika = (ParticipanteZikaCluster) query.uniqueResult();
		return parZika;
	}
	
	/**
	 * Guarda un ParticipanteZikaCluster
	 * 
	 * 
	 */
	public void saveParticipanteZikaCluster(ParticipanteZikaCluster participante) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(participante);
	}
	
}
