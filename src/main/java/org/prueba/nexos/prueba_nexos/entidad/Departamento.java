package org.prueba.nexos.prueba_nexos.entidad;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departamentos")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "departamento_codigo")
	private String departamentoCodigo;
	
	@Column(name = "departamento_nombre")
	private String departamentoNombre;
	
	@Column(name = "fecha_hora_crea")
	private Date fechaHoraCrea;
	
	@Column(name = "fecha_hora_modifica")
	private Date fechaHoraModifica;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartamentoCodigo() {
		return departamentoCodigo;
	}

	public void setDepartamentoCodigo(String departamentoCodigo) {
		this.departamentoCodigo = departamentoCodigo;
	}

	public String getDepartamentoNombre() {
		return departamentoNombre;
	}

	public void setDepartamentoNombre(String departamentoNombre) {
		this.departamentoNombre = departamentoNombre;
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
	
}





