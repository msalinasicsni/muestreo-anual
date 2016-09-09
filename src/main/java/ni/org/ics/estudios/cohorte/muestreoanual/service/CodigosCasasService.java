package ni.org.ics.estudios.cohorte.muestreoanual.service;


import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.CodigosCasas;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto CodigosCasas
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("codigosCasasService")
@Transactional
public class CodigosCasasService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las CodigosCasas
	 * 
	 * @return una lista de <code>CodigosCasas</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<CodigosCasas> getCodigosCasas() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM CodigosCasas");
		// Retrieve all
		return  query.list();
	}
	

	
	/**
	 * Verifica una CodigosCasas
	 * 
	 * @return true or false
	 */

public Boolean checkCodigosCasas (Long fecha){
		// Retrieve session from Hibernate
	Session session = sessionFactory.getCurrentSession();
	Timestamp timeStamp = new Timestamp(fecha);
	Query query = session.createQuery("FROM CodigosCasas encsat where encsat.fechaRegistro = :fechaE");
	query.setTimestamp("fechaE",timeStamp);
	
	CodigosCasas codigoCasa = (CodigosCasas) query.uniqueResult();
	if (codigoCasa!=null){
		return true;
	}
	else{
		return false;
	}			
	}
	
	/**
	 * Agrega una CodigosCasas
	 * 
	 * 
	 */
public void addCodigosCasas(CodigosCasas codigoCasa){
	Session session = sessionFactory.getCurrentSession();
	session.save(codigoCasa);
	}
	
	/**
	 * Actualiza una Encuesta de Satisfaccion
	 * 
	 * 
	 */

public void updateCodigosCasas(CodigosCasas codigoCasa){
	Session session = sessionFactory.getCurrentSession();
	session.update(codigoCasa);
	}

	
}
