package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Documentos;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.DocumentosId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto Documentos
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("documentosService")
@Transactional
public class DocumentosService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las Documentos
	 * 
	 * @return una lista de <code>Documentos</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Documentos> getDocumentos() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Documentos");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las Documentos de un codigo
	 * 
	 * @return una lista de <code>Documentos</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Documentos> getDocumentosxCodigo(Integer codigo) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Documentos docs where docs.docsId.codigo=:codigo");
		query.setParameter("codigo", codigo);
		// Retrieve all
		return  query.list();
	}	
	
	/**
	 * Regresa todos las Documentos de un dia
	 * 
	 * @return una lista de <code>Documentos</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Documentos> getDocumentosxDia(Date fecha) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(fecha.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Documentos docs where docs.today=:fecha");
		query.setParameter("fecha", timeStamp);
		// Retrieve all
		return  query.list();
	}	
	
	/**
	 * Regresa una Documentos
	 * 
	 * @return un <code>Documentos</code>
	 */

	public Documentos getDocumentos(DocumentosId docId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(docId.getFechaDocumento().getTime());
		Query query = session.createQuery("FROM Documentos doc where " +
				"doc.docsId.codigo = " + docId.getCodigo() + " AND doc.docsId.fechaDocumento = :fechaD");
		query.setTimestamp("fechaD", timeStamp);
		
		Documentos documento = (Documentos) query.uniqueResult();
		return documento;
	}
	
	
	/**
	 * Edita un Documentos
	 * 
	 * 
	 */
	public void updateDocumentos(Documentos documento) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(documento);
	}
	
	
}
