package org.upiita.spring.jdbc.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringHibernate {

	public static void main(String[] args) {
		//creamos el contexto de Spring
		ApplicationContext contexto = new ClassPathXmlApplicationContext("/contexto.xml");
		
		
	Usuario usuarioCriterio = usuarioDAO.buscaPorEmailYPassword("ismael@email.com", "1234");
	System.out.println("usuario por email y password es: " + usuarioCriterio);
	
	
	List<Usuario> usuarios = usuarioDAO.buscarPorNombre("%z%");
	System.out.println("usuarios por nombre "+ usuarios);
	}

}
