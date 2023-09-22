package org.prueba.nexos.prueba_nexos.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.PrimeFaces;
import org.prueba.nexos.prueba_nexos.entidad.Departamento;
import org.prueba.nexos.prueba_nexos.entidad.Empleado;
import org.prueba.nexos.prueba_nexos.servicio.DepartamentoLogica;
import org.prueba.nexos.prueba_nexos.servicio.EmpleadoLogica;

@ManagedBean(name = "empleadoBean")
@RequestScoped
public class EmpleadoBean {
	
	public List<Departamento> consultarDepartamentos() {
		DepartamentoLogica departamentoLogica = new DepartamentoLogica();
		List<Departamento> listaDepartamentos = departamentoLogica.listDepartamentos();
		return listaDepartamentos;
	}

	public String mostrarEmpleados() {
		EmpleadoLogica empleadoLogica = new EmpleadoLogica();
		List<Empleado> listaEmpleados = empleadoLogica.listEmpleados();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("empleados", listaEmpleados);
		return "/empleados.xhtml";
	}
	
	public String nuevo() {
		Empleado empleado = new Empleado();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("empleado", empleado);
		return  "/crearempleado.xhtml";
	}
	
	public String mostrarEditar(Long id) {
		EmpleadoLogica empleadoLogica = new EmpleadoLogica();
		Empleado empleado = empleadoLogica.buscarEmpleadoId(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("empleado", empleado);
		return  "/crearempleado.xhtml";
	}

	public String guardar(Empleado empleado) {
		// guarda la fecha de registro
		
		 if (empleado.getApellidos() == null || empleado.getApellidos().isEmpty()) {
	            FacesMessage message = new FacesMessage("El nombre es obligatorio.");
	            FacesContext.getCurrentInstance().addMessage("formulario:nombre", message);
		 }
		try{
		EmpleadoLogica empleadoLogica = new EmpleadoLogica();
		empleadoLogica.guardar(empleado);
		String mensajeInfo = empleado.getId() == null ? "Empleado Creado" : "Empleado Editado";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensajeInfo));
		return this.mostrarEmpleados();
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "error", e.getMessage()));
			return  "/crearempleado.xhtml";
		}
	}
	
	public String eliminar(Long id) {
		EmpleadoLogica empleadoLogica = new EmpleadoLogica();
		empleadoLogica.eliminar(id);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Empleado Eliminado"));
		return this.mostrarEmpleados();
	}
	
    public String obtenerNombreDepartamento(Long departamentoId) {
		DepartamentoLogica departamentoLogica = new DepartamentoLogica();
    	Departamento departamento = departamentoLogica.buscarDepartamentoId(departamentoId);
       
            return departamento.getDepartamentoNombre();

    }

}
