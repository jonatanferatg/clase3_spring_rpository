package org.upiita.spring.jdbc.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.upiita.spring.jdbc.entidades.Usuario;

public class HibernateUsuarioDAO implements UsuarioDAO {

	public Usuario buscaUsuarioPorId(Integer usuarioId) {

		return null;
	}

	public void creaUsuario(Usuario usuario){
		

	}
	
	public Usuario buscaPorEmailYPassword(String email, String password){
		Session sesion = sessionFactory.openSession();
		sesion.beginTransaction();
		
		Session sesion = sessionFactory.openSession();
		Criteria criterio = sesion.createCriteria(Usuario, class);
		
		/*Criteria add(Restrictions.or(Restrictions.eq("email",email),
				                     Restrictions.eq("password",password));*/
		criterio.add(Restrictions.eq("email", email));
		criterio.add(Restrictions.eq("password", password));
		
		//Obteniendo un solo resultado
		//sino encuentra nada regresa null
		
		Usuario usuario =(Usuario) criterio.uniqueResult();
		
		return usuario;
	}

	public List<Usuario> buscaPorNombre(String nombre) {
	
			Session sesion = sessionFactory.openSession();
			sesion.beginTransaction();
			
			Criteria criterio = sesion.createCriteria(Usuario.class);
			criterio.add(Restrictions.like("nombre", nombre));
			criterio.list();
			List<Usuario> usuarios = criterio.list();
			
			sesion.getTransaction().commit();
			sesion.close();
						
			return null;
		}
	}

	
}
