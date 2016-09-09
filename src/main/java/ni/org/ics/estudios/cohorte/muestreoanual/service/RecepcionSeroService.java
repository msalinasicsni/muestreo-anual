package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.RecepcionSero;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.RecepcionSeroId;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto RecepcionSero
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("seroService")
@Transactional
public class RecepcionSeroService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las Sero
	 * 
	 * @return una lista de <code>RecepcionSero</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<RecepcionSero> getRecepcionSeros() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM RecepcionSero");
		// Retrieve all
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<RecepcionSero> getRecepcionSerosHoy() {
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
		Query query = session.createQuery("FROM RecepcionSero sero where sero.recSeroId.fechaRecSero = :fechaRecSero");
		query.setTimestamp("fechaRecSero", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<RecepcionSero> getCompSeroSupEstHoy() {
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
		Query query = session.createSQLQuery("select recepcionsero.codigo, recepcionsero.fecha_registro, recepcionsero.lugar, " +
				"recepcionsero.volbhc, recepcionsero.observacion, recepcionsero.username " +
				"from recepcionsero left join muestras on recepcionsero.codigo = muestras.codigo and recepcionsero.fecha_sero = muestras.fecha_registro " +
				"where ((recepcionsero.fecha_sero = :fechaSero) and " +
				"(muestras.codigo Is Null or recepcionsero.fecha_sero <> muestras.fecha_registro or muestras.tuborojo=0));");
		query.setTimestamp("fechaSero", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<RecepcionSero> getCompSeroSupLabHoy() {
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
		Query query = session.createSQLQuery("select recepcionsero.codigo, recepcionsero.fecha_registro, recepcionsero.lugar, " +
				"recepcionsero.volbhc, recepcionsero.observacion, recepcionsero.username " +
				"from recepcionsero left join labsero on recepcionsero.codigo = labsero.codigo and recepcionsero.fecha_sero = labsero.fecha_sero " +
				"where ((recepcionsero.fecha_sero  = :fechaSero) and (labsero.codigo Is Null or recepcionsero.fecha_sero <> labsero.fecha_sero));");
		query.setTimestamp("fechaSero", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa una RecepcionSero
	 * 
	 * @return un <code>RecepcionSero</code>
	 */

	public RecepcionSero getRecepcionSero(RecepcionSeroId seroId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(seroId.getFechaRecSero().getTime());
		Query query = session.createQuery("FROM RecepcionSero sero where sero.recSeroId.codigo = "
				+ seroId.getCodigo() +  " AND sero.recSeroId.fechaRecSero = :fechaSero");
		query.setTimestamp("fechaSero", timeStamp);
		
		RecepcionSero rSero = (RecepcionSero) query.uniqueResult();
		return rSero;
	}
	
	/**
	 * Verifica una RecepcionSero
	 * 
	 * @return true or false
	 */

	public Boolean checkRecepcionSero(RecepcionSeroId seroId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Timestamp timeStamp = new Timestamp(seroId.getFechaRecSero().getTime());
		Query query = session.createQuery("FROM RecepcionSero sero where sero.recSeroId.codigo = "
				+ seroId.getCodigo() +  " AND sero.recSeroId.fechaRecSero = :fechaSero");
		query.setTimestamp("fechaSero", timeStamp);
		
		RecepcionSero rSero = (RecepcionSero) query.uniqueResult();
		if(rSero!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega un RecepcionSero
	 * 
	 * 
	 */
	public void addRecepcionSero(RecepcionSero rSero) {
		Session session = sessionFactory.getCurrentSession();
		session.save(rSero);
	}
	
	/**
	 * Actualiza un RecepcionSero
	 * 
	 * 
	 */
	public void updateRecepcionSero(RecepcionSero rSero) {
		Session session = sessionFactory.getCurrentSession();
		session.update(rSero);
	}
	
}
