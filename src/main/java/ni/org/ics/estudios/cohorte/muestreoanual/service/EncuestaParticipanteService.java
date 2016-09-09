package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaParticipante;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaParticipanteId;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto EncuestaParticipante
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("encuestaParticipanteService")
@Transactional
public class EncuestaParticipanteService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las encuestas de los participantes
	 * 
	 * @return una lista de <code>datos de las encuestas de participantes</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<EncuestaParticipante> getEncuestasParticipantes() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM EncuestaParticipante");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa una Encuesta de caa
	 * 
	 * @return una <code>Encuesta de Participante</code>
	 */

	public EncuestaParticipante getEncuestaParticipante (EncuestaParticipanteId epId){
		// Retrieve session from Hibernate
	Session session = sessionFactory.getCurrentSession();
	
	Timestamp timeStamp = new Timestamp(epId.getFechaEncPar().getTime());
	Query query = session.createQuery("FROM EncuestaParticipante encpar where encpar.epId.codigo = " + epId.getCodigo() + " AND encpar.epId.fechaEncPar = :fechaE");
	query.setTimestamp("fechaE",timeStamp);
	
	EncuestaParticipante encuestaParticipante = (EncuestaParticipante) query.uniqueResult();
	return encuestaParticipante;
	}
	
	/**
	 * Verifica una Encuesta de Participante
	 * 
	 * @return true or false
	 */

public Boolean checkEncuestaParticipante (EncuestaParticipanteId epId){
		// Retrieve session from Hibernate
	Session session = sessionFactory.getCurrentSession();
	Timestamp timeStamp = new Timestamp(epId.getFechaEncPar().getTime());
	Query query = session.createQuery("FROM EncuestaParticipante encpar where encpar.epId.codigo = " + epId.getCodigo() + " AND encpar.epId.fechaEncPar = :fechaE");
	query.setTimestamp("fechaE",timeStamp);
	
	EncuestaParticipante encuestaparticipante = (EncuestaParticipante) query.uniqueResult();
	if (encuestaparticipante!=null){
		return true;
	}
	else{
		return false;
	}			
	}
	
	/**
	 * Agrega una Encuesta de Participante
	 * 
	 * 
	 */
public void addEncuestaParticipante(EncuestaParticipante encuestaParticipante){
	Session session = sessionFactory.getCurrentSession();
	session.save(encuestaParticipante);
	}
	
	/**
	 * Actualiza una Encuesta de Participante
	 * 
	 * 
	 */

public void updateEncuestaParticipante(EncuestaParticipante encuestaParticipante){
	Session session = sessionFactory.getCurrentSession();
	session.update(encuestaParticipante);
	}

	
}
