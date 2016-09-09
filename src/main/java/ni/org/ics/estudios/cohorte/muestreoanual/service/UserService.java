package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.util.List;
import javax.annotation.Resource;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto Usuario
 * 
 * @author William Aviles
 * 
 **/

@Service("userService")
@Transactional
public class UserService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos los Datos de los usuarios
	 * 
	 * @return una lista de <code>User</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<User> getUsuarios() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM User");
		// Retrieve all
		return  query.list();
	}
	
	
	public User getUsuario(String username) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM User u where u.username = '" + username + "'");
		User user = (User) query.uniqueResult();
		// Retrieve all
		return  user;
	}	
	
}
