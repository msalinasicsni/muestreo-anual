package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.Participante;
import ni.org.ics.estudios.cohorte.muestreoanual.log.ParticipanteLog;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto Participante
 * 
 * @author William Aviles
 * 
 **/

@Service("participanteService")
@Transactional
public class ParticipanteService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos los Participantes
	 * 
	 * @return una lista de <code>Participante</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Participante> getParticipantes() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Participante");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos los Participantes Activos
	 * 
	 * @return una lista de <code>Participante</code>(s) Activos
	 */

	@SuppressWarnings("unchecked")
	public List<Participante> getParticipantesActivos() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Participante p where p.estPart = 1");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa un participante
	 * 
	 * @return un <code>Participante</code>
	 */

	public Participante getParticipante(Integer codigo) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Participante par where par.codigo = "+codigo);
		Participante participante = (Participante) query.uniqueResult();
		return participante;
	}
	
	/**
	 * Regresa un participante
	 * 
	 * @return un <code>Participante</code>
	 */

	@SuppressWarnings("unchecked")
	public List<Participante> getParticipanteMovil(Integer codigo) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Participante par where par.codigo = "+ codigo);
		return  query.list();
	}
		
	
	
	/**
	 * Regresa un codigo de casa
	 * 
	 * @return un <code>Integer</code>
	 */

	public Integer checkCasa(Integer codigo) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Integer codCasa = 0;
		Query query = session.createQuery("FROM Participante par where par.codigo = "+ codigo);
		Participante participante = (Participante) query.uniqueResult();
		if (participante!= null){
			codCasa = participante.getCodCasa();
			
		}
		return codCasa;
	}
	
	/**
	 * Verifica un Participante
	 * 
	 * @return true or false
	 */

	public Boolean checkParticipante(Integer codigo) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Participante par where par.codigo = "+codigo);
		Participante participante = (Participante) query.uniqueResult();
		if(participante!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega un Participante
	 * 
	 * 
	 */
	public void addParticipante(Participante participante) {
		ParticipanteLog partLog = new ParticipanteLog(new Date(), participante.getCodCasa(), 
				participante.getCodigo(), participante.getFecha(), participante.getEstPart(), 
				participante.getNombre1(), participante.getNombre2(), participante.getApellido1(), participante.getApellido2(),
				participante.getSexo(), participante.getFechaNac(), participante.getEdad(), participante.getNombrePt1(), participante.getNombrePt2(), 
				participante.getApellidoPt1(), participante.getApellidoPt2(), participante.getRelacionFam(), participante.getNombrePadre(), participante.getNombreMadre(), 
				participante.getAsiste(), participante.getUs(), participante.getHiDeng(), participante.getCuanDeng(), participante.getHospDeng(), participante.getCuanHospDeng(), 
				participante.getEstudio(), participante.getPbmc(), participante.getConsDeng(), participante.getConsFlu(), participante.getConmx(), 
				participante.getConmxbhc(), participante.getEncLacMat(), participante.getPesoTalla(), participante.getEncPart(), participante.getObsequio(),
				participante.getConvalesciente(), participante.getInfoVacuna(), participante.getPaxgene(),participante.getMovilInfo(), participante.getConsChik());
		Session session = sessionFactory.getCurrentSession();
		session.save(participante);
		session.save(partLog);
	}
	
	/**
	 * Actualiza un Participante
	 * 
	 * 
	 */
	public void updateParticipante(Participante participante) {
		ParticipanteLog partLog = new ParticipanteLog(new Date(), participante.getCodCasa(), 
				participante.getCodigo(), participante.getFecha(), participante.getEstPart(), 
				participante.getNombre1(), participante.getNombre2(), participante.getApellido1(), participante.getApellido2(),
				participante.getSexo(), participante.getFechaNac(), participante.getEdad(), participante.getNombrePt1(), participante.getNombrePt2(), 
				participante.getApellidoPt1(), participante.getApellidoPt2(), participante.getRelacionFam(), participante.getNombrePadre(), participante.getNombreMadre(), 
				participante.getAsiste(), participante.getUs(), participante.getHiDeng(), participante.getCuanDeng(), participante.getHospDeng(), participante.getCuanHospDeng(), 
				participante.getEstudio(), participante.getPbmc(), participante.getConsDeng(), participante.getConsFlu(), participante.getConmx(), 
				participante.getConmxbhc(), participante.getEncLacMat(), participante.getPesoTalla(), participante.getEncPart(), participante.getObsequio(),
				participante.getConvalesciente(), participante.getInfoVacuna(), participante.getPaxgene(),participante.getMovilInfo(), participante.getConsChik());
		Session session = sessionFactory.getCurrentSession();
		session.update(participante);
		session.save(partLog);
	}

	@SuppressWarnings("unchecked")
	public List<Participante> getParticipantesMensajes(Integer barrio,
			String tubo, String estudio, String edad) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Integer edad1 = 0;
		Integer edad2 = 0;
		// Create a Hibernate query (HQL)
		if (edad.equals("%")){
			edad2=360;
		}
		else if(edad.equals("<2")){
			edad1=6;
			edad2=23;
		}
		else if(edad.equals(">2")){
			edad1=24;
			edad2=360;
		}
		Query query = session.createQuery("FROM Participante par where par.barrioFicha1 =:barrio and par.pbmc=:tubo " +
				"and par.estudio like:estudio and edad between :edad1 and :edad2 and par.telefono is not null and par.estPart=1");
		query.setParameter("barrio", barrio);
		query.setParameter("estudio", estudio);
		query.setParameter("tubo", tubo);
		query.setParameter("edad1", edad1);
		query.setParameter("edad2", edad2);
		// Retrieve all
		return  query.list();
	}
	
}
