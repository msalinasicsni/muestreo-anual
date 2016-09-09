package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.Barrio;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Casa;
import ni.org.ics.estudios.cohorte.muestreoanual.log.CasaLog;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto Casa
 * 
 * @author William Aviles
 * 
 **/

@Service("casaService")
@Transactional
public class CasaService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos los Datos de la casa de los participantes
	 * 
	 * @return una lista de <code>datos de casa</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Casa> getCasas() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Casa");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa los datos de una casa
	 * 
	 * 
	 * @return una <code>Casa</code>
	 */

	public Casa getCasa (Integer codCasa) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Casa cas where cas.codCasa = "+ codCasa);
		Casa casa = (Casa) query.uniqueResult();
		return casa;
	}
	
	/**
	 * Regresa los datos de una casa
	 * 
	 * 
	 * @return una <code>Casa</code>
	 */

	@SuppressWarnings("unchecked")
	public List<Casa> getCasaParticipante (Integer codCasa) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Casa cas where cas.codCasa = "+ codCasa);
		return  query.list();
	}
	
	/**
	 * Verifica los datos de la casa
	 * 
	 * @return true or false
	 */

	public Boolean checkCasa(Integer codCasa) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Casa cas where cas.codCasa = "+ codCasa);
		Casa casa = (Casa) query.uniqueResult();
		if(casa!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega los datos de la casa
	 * 
	 * 
	 */
	public void addCasa(Casa casa) {		
		CasaLog casaLog = new CasaLog(new Date(), casa.getCodCasa(), casa.getBarrio(), 
				casa.getDireccion(), casa.getManzana(), casa.getLatitud(), casa.getLongitud(), 
				casa.getTelCasa(), casa.getCoordenadas(), casa.getJefenom(), casa.getJefenom2(), 
				casa.getJefeap(), casa.getJefeap2(), casa.getTelefono1(), casa.getTelefono2(), 
				casa.getNomContacto(), casa.getDireContacto(), casa.getBarrioContacto(), casa.getOtrobarrioContacto(), 
				casa.getTelContacto1(), casa.getTelContacto2(), casa.getVivienda(), 
				casa.getResd(), casa.getInten(), casa.getEnCasa(), casa.getMovilInfo());
		
		Session session = sessionFactory.getCurrentSession();
		session.save(casa);
		session.save(casaLog);
	}
	
	/**
	 * Actualiza los datos de la casa
	 * 
	 * 
	 */
	public void updateCasa (Casa casa) {
		CasaLog casaLog = new CasaLog(new Date(), casa.getCodCasa(), casa.getBarrio(), 
				casa.getDireccion(), casa.getManzana(), casa.getLatitud(), casa.getLongitud(), 
				casa.getTelCasa(), casa.getCoordenadas(), casa.getJefenom(), casa.getJefenom2(), 
				casa.getJefeap(), casa.getJefeap2(), casa.getTelefono1(), casa.getTelefono2(), 
				casa.getNomContacto(), casa.getDireContacto(), casa.getBarrioContacto(), casa.getOtrobarrioContacto(), 
				casa.getTelContacto1(), casa.getTelContacto2(), casa.getVivienda(), 
				casa.getResd(), casa.getInten(), casa.getEnCasa(), casa.getMovilInfo());
		Session session = sessionFactory.getCurrentSession();
		session.update(casa);
		session.save(casaLog);
	}
	
	@SuppressWarnings("unchecked")
	public List<Barrio> getBarrios() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Barrio");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getMensajesSms() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("Select mensaje_code, mensaje_show from mensajes_sms");
		// Retrieve all
		return  query.list();
	}
	
	public String getMensajeSms(Integer idMensaje){
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("Select mensaje_text from mensajes_sms where mensaje_code=:idMensaje");
		query.setParameter("idMensaje", idMensaje);
		// Retrieve all
		return  (String) query.uniqueResult();
	}
	
	public String getApiKeySms(){
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("Select api_key from sms_api_key");
		// Retrieve all
		return  (String) query.uniqueResult();
	}
	
	public String getProjectIdSms(){
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("Select project_id from sms_project");
		// Retrieve all
		return  (String) query.uniqueResult();
	}
	
	public String getPhone1Sms(){
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("Select phone1 from sms_phones");
		// Retrieve all
		return  (String) query.uniqueResult();
	}
	
	public String getPhone2Sms(){
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("Select phone2 from sms_phones");
		// Retrieve all
		return  (String) query.uniqueResult();
	}

	
}
