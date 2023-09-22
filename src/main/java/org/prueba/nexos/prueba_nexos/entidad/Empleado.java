package org.prueba.nexos.prueba_nexos.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import jakarta.persistence.PreUpdate;

@Entity
@Table(name = "empleados")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "documento_tipo")
	private String documentoTipo;

	@Column(name = "documento_numero")
	private String documentoNumero;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "departamentos_Id")
	private Long departamentosId;

	@Column(name = "ciudad")
	private String ciudad;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "email")
	private String email;

	@Column(name = "telefono")
	private String telefono;

	 @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hora_crea")
	private Date fechaHoraCrea;

	 @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hora_modifica")
	private Date fechaHoraModifica;
	
    @PreUpdate
    private void beforeUpdate() {
    	fechaHoraModifica = new Date(); // Actualiza la fecha de actualización antes de la actualización
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentoTipo() {
		return documentoTipo;
	}

	public void setDocumentoTipo(String documentoTipo) {
		this.documentoTipo = documentoTipo;
	}

	public String getDocumentoNumero() {
		return documentoNumero;
	}

	public void setDocumentoNumero(String documentoNumero) {
		this.documentoNumero = documentoNumero;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Long getDepartamentosId() {
		return departamentosId;
	}

	public void setDepartamentosId(Long departamentosId) {
		this.departamentosId = departamentosId;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaHoraCrea() {
		return fechaHoraCrea;
	}

	public void setFechaHoraCrea(Date fechaHoraCrea) {
		this.fechaHoraCrea = fechaHoraCrea;
	}

	public Date getFechaHoraModifica() {
		return fechaHoraModifica;
	}

	public void setFechaHoraModifica(Date fechaHoraModifica) {
		this.fechaHoraModifica = fechaHoraModifica;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", documentoTipo=" + documentoTipo + ", documentoNumero=" + documentoNumero
				+ ", nombres=" + nombres + ", apellidos=" + apellidos + ", departamentosId=" + departamentosId
				+ ", ciudad=" + ciudad + ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono
				+ ", fechaHoraCrea=" + fechaHoraCrea + ", fechaHoraModifica=" + fechaHoraModifica + "]";
	}

}
