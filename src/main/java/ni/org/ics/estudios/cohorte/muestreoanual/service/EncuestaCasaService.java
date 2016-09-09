package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;



import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaCasa;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaCasaId;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto EncuestaCasaEB
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("encuestaCasaService")
@Transactional
public class EncuestaCasaService {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	/**
	 * Regresa todos las encuestas de Casas de los participantes
	 * 
	 * @return una lista de <code>datos de las encuestas de casas</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<EncuestaCasa> getEncuestasCasas() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM EncuestaCasa");
		// Retrieve all
		return  query.list();
	}

	/**
	 * Regresa una Encuesta de caa
	 * 
	 * @return una <code>Encuesta de Casa</code>
	 */

	public EncuestaCasa getEncuestaCasa (EncuestaCasaId encCasaId){
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(encCasaId.getFechaEncCasa().getTime());
		Query query = session.createQuery("FROM EncuestaCasa enccas where enccas.encCasaId.codCasa = "
				+ encCasaId.getCodCasa() + " AND enccas.encCasaId.fechaEncCasa = :fechaE");
		query.setTimestamp("fechaE",timeStamp);

		EncuestaCasa encuestaCasa = (EncuestaCasa) query.uniqueResult();
		return encuestaCasa;
	}

	/**
	 * Verifica una Encuesta de Casa
	 * 
	 * @return true or false
	 */

	public Boolean checkEncuestaCasa (EncuestaCasaId encCasaId){
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		Timestamp timeStamp = new Timestamp(encCasaId.getFechaEncCasa().getTime());
		Query query = session.createQuery("FROM EncuestaCasa enccas where enccas.encCasaId.codCasa = "
				+ encCasaId.getCodCasa() + " AND enccas.encCasaId.fechaEncCasa = :fechaE");
		query.setTimestamp("fechaE",timeStamp);

		EncuestaCasa encuestacasa = (EncuestaCasa) query.uniqueResult();
		if (encuestacasa!=null){
			return true;
		}
		else{
			return false;
		}			
	}

	/**
	 * Agrega una Encuesta de Casa
	 * 
	 * 
	 */
	public void addEncuestaCasa(EncuestaCasa encuestaCasa){
		Session session = sessionFactory.getCurrentSession();
		session.save(encuestaCasa);
	}

	/**
	 * Actualiza una Encuesta de Casa
	 * 
	 * 
	 */

	public void updateEncuestaCasa(EncuestaCasa encuestaCasa){
		Session session = sessionFactory.getCurrentSession();
		session.update(encuestaCasa);
	}


}
