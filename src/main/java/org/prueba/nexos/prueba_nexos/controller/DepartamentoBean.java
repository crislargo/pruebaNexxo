package org.prueba.nexos.prueba_nexos.controller;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.prueba.nexos.prueba_nexos.entidad.Departamento;
import org.prueba.nexos.prueba_nexos.entidad.Empleado;
import org.prueba.nexos.prueba_nexos.servicio.DepartamentoLogica;
import org.prueba.nexos.prueba_nexos.servicio.EmpleadoLogica;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "departamentoBean")
@RequestScoped

public class DepartamentoBean {

	public List<Departamento> consultarDepartamentos() {
		DepartamentoLogica departamentoLogica = new DepartamentoLogica();
		List<Departamento> listaDepartamentos = departamentoLogica.listDepartamentos();
		return listaDepartamentos;
	}

	public String nuevo() {
		Departamento departamento = new Departamento();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("departamento", departamento);
		return "/creardepartamento.xhtml";
	}

	public String guardar(Departamento departamento) {
		// guarda la fecha de registro

		if (departamento.getDepartamentoNombre() == null || departamento.getDepartamentoNombre().isEmpty()) {
			FacesMessage message = new FacesMessage("El nombre es obligatorio.");
			FacesContext.getCurrentInstance().addMessage("formulario:nombres", message);
		}
		try {
			DepartamentoLogica departamentoLogica = new DepartamentoLogica();
			departamentoLogica.guardar(departamento);
			String mensajeInfo = departamento.getId() == null ? "Departamento Creado" : "Departamento Editado";
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensajeInfo));
			return this.mostrarDepartamentos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "error", e.getMessage()));
			return "/crearempleado.xhtml";
		}
	}

	public String mostrarDepartamentos() {
		DepartamentoLogica departamentoLogica = new DepartamentoLogica();
		List<Departamento> listDepartamentos = departamentoLogica.listDepartamentos();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("departamentos", listDepartamentos);
		return "/departamentos.xhtml";
	}

	public String mostrarEditar(Long id) {
		DepartamentoLogica departamentoLogica = new DepartamentoLogica();
		Departamento departamento = departamentoLogica.buscarDepartamentoId(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("departamento", departamento);
		return "/creardepartamento.xhtml";
	}

	public String eliminar(Long id) {
		DepartamentoLogica departamentoLogica = new DepartamentoLogica();
		List<Empleado> validarEmpleado = departamentoLogica.validarEmpleado(id);
		if (validarEmpleado.isEmpty()) {
			departamentoLogica.eliminar(id);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Empleado Eliminado"));
			return this.mostrarDepartamentos();
		}else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Existe una persona con el departamento enviado"));
			return "/departamentos.xhtml";
		}

	}
}
