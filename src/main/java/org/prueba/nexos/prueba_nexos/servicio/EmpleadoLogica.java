package org.prueba.nexos.prueba_nexos.servicio;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.prueba.nexos.prueba_nexos.entidad.Empleado;
import org.prueba.nexos.prueba_nexos.entidad.JPAUtil;


public class EmpleadoLogica {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	public List<Empleado> listEmpleados() {
		List<Empleado> listEmpleados = new ArrayList<Empleado>();
		Query q = entity.createQuery("SELECT e FROM Empleado e");
		listEmpleados = q.getResultList();
		return listEmpleados;
	}
	
	public void guardar(Empleado empleado) {
		entity.getTransaction().begin();
		entity.merge(empleado);
		entity.getTransaction().commit();
	}
	
	public void eliminar(Long id) {	
		Empleado empleado = this.buscarEmpleadoId(id);
		entity.getTransaction().begin();
		entity.remove(empleado);
		entity.getTransaction().commit();
	}
	
	public Empleado buscarEmpleadoId(Long id) {
		Empleado empleado = new Empleado();
		empleado = entity.find(Empleado.class, id);
		return empleado;
	}
}
