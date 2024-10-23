package com.tpcorp.exhiber;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import com.tpcorp.exhiber.modelo.Cursada;
import com.tpcorp.exhiber.modelo.Estudiante;
import com.tpcorp.exhiber.modelo.Materia;
import com.tpcorp.exhiber.modelo.MuestraEstudiante;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		// registroEstudiante("Cristiano", "Ronaldo");
		// registroMateria("REG121","Calculo I");
		listaEstudiantesPorCalificacion(67,90);
		

	}

	private static void listaEstudiantesPorCalificacion(int ini, int fin) {
		Transaction tx = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		tx = sesion.beginTransaction();
		HibernateCriteriaBuilder builder = sesion.getCriteriaBuilder();
		CriteriaQuery<MuestraEstudiante> cq = sesion.getCriteriaBuilder().createQuery(MuestraEstudiante.class);
		Root<Cursada> raiz = cq.from(Cursada.class);
		raiz.join("ide",JoinType.INNER);
		cq.select(builder.construct(MuestraEstudiante.class,raiz.get("est").get("nombre"), raiz.get("est").get("apellido"))).where(builder.between(raiz.get("calificacion"), ini, fin));
		List<MuestraEstudiante> mu = sesion.createQuery(cq).getResultList();
		System.out.println("Ejemplo de BETWEEN");
		for (MuestraEstudiante c : mu)
			System.out.println(String.format("NOmbre: %s  aspellido %s. ", c.getNombre(), c.getApellido()
					));
		
		///////
		
	}

	private static void registroMateria(String sigla, String descripcion) {
		Transaction tx = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		tx = sesion.beginTransaction();
		Materia m = new Materia();
		m.setSigla(sigla);
		m.setDescripcion(descripcion);
		sesion.save(m);
		tx.commit();
		System.out.println("Se registro exitosamente Materia");

	}

	private static void registroEstudiante(String nombre, String apellido) {
		Transaction tx = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		tx = sesion.beginTransaction();
		Estudiante es = new Estudiante();
		es.setNombre(nombre);
		es.setApellido(apellido);
		sesion.save(es);
		tx.commit();
		System.out.println("Se registro exitosamente");

	}
}
