package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Muestra;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.MuestraId;

import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto Muestra
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("muestraService")
@Transactional
public class MuestraService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las Muestras
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Muestra> getMuestras() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Muestra");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las Muestras BHC
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Muestra> getMuestrasBHC() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Muestra mx where mx.tuboBHC = 1 and year(mx.movilInfo.today) = :anio ");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las Muestras BHC de hoy
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Muestra> getMuestrasBHCHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Muestra mx where mx.tuboBHC = 1 and mx.movilInfo.today = :fechaBHC");
		query.setTimestamp("fechaBHC", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Muestra> getCompBHCEstSupHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block0
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select muestras.codigo, muestras.fecha_muestra, muestras.pinchazos, muestras.recurso1, muestras.recurso2 " +
				"from estudios_ics.muestras left join estudios_ics.recepcionbhc on muestras.codigo = recepcionbhc.codigo and muestras.fecha_registro = recepcionbhc.fecha_bhc " +
				"where ((muestras.fecha_registro  = :fechaBHC and muestras.tubobhc =1) and (recepcionbhc.codigo Is Null or muestras.fecha_registro <> recepcionbhc.fecha_bhc) " +
				"and (YEAR(muestras.fecha_registro) = :anio));");
		query.setTimestamp("fechaBHC", timeStamp);
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Muestra> getCompBHCEstLabHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select muestras.codigo, muestras.fecha_muestra, muestras.pinchazos, muestras.recurso1, muestras.recurso2 " +
				"from estudios_ics.muestras left join estudios_ics.labbhc on muestras.codigo = labbhc.codigo and muestras.fecha_registro = labbhc.fecha_bhc " +
				"where ((muestras.fecha_registro = :fechaBHC and muestras.tubobhc =1) and (labbhc.codigo Is Null or muestras.fecha_registro <> labbhc.fecha_bhc) " +
				"and (YEAR(muestras.fecha_registro) = :anio));");
		query.setTimestamp("fechaBHC", timeStamp);
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Muestra> getCompSeroEstSupHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select muestras.codigo, muestras.fecha_muestra, muestras.pinchazos, muestras.recurso1, muestras.recurso2 " +
				"from estudios_ics.muestras left join estudios_ics.recepcionsero on muestras.codigo = recepcionsero.codigo and muestras.fecha_registro = recepcionsero.fecha_sero " +
				"where ((muestras.fecha_registro  = :fechaSero and muestras.tuborojo =1) and (recepcionsero.codigo Is Null or muestras.fecha_registro <> recepcionsero.fecha_sero) " +
				"and (YEAR(muestras.fecha_registro) = :anio));");
		query.setTimestamp("fechaSero", timeStamp);
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Muestra> getCompSeroEstLabHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select muestras.codigo, muestras.fecha_muestra, muestras.pinchazos, muestras.recurso1, muestras.recurso2 " +
				"from estudios_ics.muestras left join estudios_ics.labsero on muestras.codigo = labsero.codigo and muestras.fecha_registro = labsero.fecha_sero " +
				"where ((muestras.fecha_registro = :fechaSero and muestras.tuborojo =1) and (labsero.codigo Is Null or muestras.fecha_registro <> labsero.fecha_sero) " +
				"and (YEAR(muestras.fecha_registro) = :anio));");
		query.setTimestamp("fechaSero", timeStamp);
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Muestra> getCompPbmcEstLabHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select muestras.codigo, muestras.fecha_muestra, muestras.pinchazos, muestras.recurso1, muestras.recurso2 " +
				"from estudios_ics.muestras left join estudios_ics.labpbmc on muestras.codigo = labpbmc.codigo  and muestras.fecha_registro = labpbmc.fecha_pbmc " +
				"where ((muestras.fecha_registro = :fechaPbmc and muestras.tuboleu =1) and (labpbmc.codigo Is Null or muestras.fecha_registro <> labpbmc.fecha_pbmc) " +
				"and (YEAR(muestras.fecha_registro) = :anio));");
		query.setTimestamp("fechaPbmc", timeStamp);
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa todos las Muestras Rojos
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Muestra> getMuestrasRojo() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Muestra mx where mx.tuboRojo = 1 and year(mx.movilInfo.today) = :anio");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las Muestras Rojo de hoy
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Muestra> getMuestrasRojoHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Muestra mx where mx.tuboRojo = 1 and mx.movilInfo.today = :fechaRojo");
		query.setTimestamp("fechaRojo", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa todos las Muestras Rojos
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Muestra> getMuestrasPbmc() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Muestra mx where mx.tuboLeu = 1 and year(mx.movilInfo.today) = :anio");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las Muestras Pbmcs de hoy
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Muestra> getMuestrasPbmcHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Muestra mx where mx.tuboLeu = 1 and mx.movilInfo.today = :fechaLeu");
		query.setTimestamp("fechaLeu", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa una Muestra
	 * 
	 * @return un <code>Muestra</code>
	 */

	public Muestra getMuestra(MuestraId mId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(mId.getFechaMuestra().getTime());
		Query query = session.createQuery("FROM Muestra mx where " +
				"mx.mId.codigo = " + mId.getCodigo() + " AND mx.mId.fechaMuestra = :fechaE");
		query.setTimestamp("fechaE", timeStamp);
		
		Muestra muestra = (Muestra) query.uniqueResult();
		return muestra;
	}
	
	/**
	 * Verifica una Muestra
	 * 
	 * @return true or false
	 */

	public Boolean checkMuestra(MuestraId mId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Timestamp timeStamp = new Timestamp(mId.getFechaMuestra().getTime());
		Query query = session.createQuery("FROM Muestra mx where " +
				"mx.mId.codigo = " + mId.getCodigo() + " AND mx.mId.fechaMuestra = :fechaE");
		query.setTimestamp("fechaE", timeStamp);
		
		Muestra muestra = (Muestra) query.uniqueResult();
		if(muestra!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega una Muestra
	 * 
	 * 
	 */
	public void addMuestra(Muestra muestra) {
		Session session = sessionFactory.getCurrentSession();
		session.save(muestra);
	}
	
	/**
	 * Actualiza una Muestra
	 * 
	 * 
	 */
	public void updateMuestra(Muestra muestra) {
		Session session = sessionFactory.getCurrentSession();
		session.update(muestra);
	}
	
}
