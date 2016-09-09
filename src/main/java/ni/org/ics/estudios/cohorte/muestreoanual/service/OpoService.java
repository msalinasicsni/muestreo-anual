package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.util.List;
import javax.annotation.Resource;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.Opo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto Opo
 * 
 * @author William Aviles
 * 
 **/

@Service("opoService")
@Transactional
public class OpoService {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	/**
	 * Regresa todos los Datos de los opos
	 * 
	 * @return una lista de <code>Opo</code>(es)
	 */

	@SuppressWarnings("unchecked")
	public List<Opo> getOpo() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Opo");
		// Retrieve all
		return  query.list();
	}	
	
	/**
	 * Agrega un Opo
	 * 
	 * 
	 */
	public void addOpo(Opo opo) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(opo);
	}
	
}
