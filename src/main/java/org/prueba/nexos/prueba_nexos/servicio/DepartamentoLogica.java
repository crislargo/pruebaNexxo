package org.prueba.nexos.prueba_nexos.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.prueba.nexos.prueba_nexos.entidad.Departamento;
import org.prueba.nexos.prueba_nexos.entidad.Empleado;
import org.prueba.nexos.prueba_nexos.entidad.JPAUtil;

public class DepartamentoLogica {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	public List<Departamento> listDepartamentos() {
		List<Departamento> listDepartamento = new ArrayList<Departamento>();
		Query q = entity.createQuery("SELECT d FROM Departamento d",Departamento.class);
		listDepartamento = q.getResultList();
		return listDepartamento;
	}
	
	public Departamento buscarDepartamentoId(Long id) {
		Departamento departamento = new Departamento();
		departamento = entity.find(Departamento.class, id);
		return departamento;
	}
	
	public void guardar(Departamento departamento) {
		entity.getTransaction().begin();
		entity.merge(departamento);
		entity.getTransaction().commit();
	}
	
	public void eliminar(Long id) {	
		Departamento departamento = this.buscarDepartamentoId(id);
		entity.getTransaction().begin();
		entity.remove(departamento);
		entity.getTransaction().commit();
	}
	
	public List<Empleado> validarEmpleado(Long idDepartamento) {
		List<Empleado> listEmpleados = new ArrayList<Empleado>();
		Query q = entity.createQuery("SELECT d FROM Empleado d WHERE d.departamentosId=:id",Empleado.class);
		 q.setParameter("id", idDepartamento); // Aquí se pasa el parámetro
		 listEmpleados = q.getResultList();
		 return listEmpleados;
		 
		
	}
	
	
	
}
