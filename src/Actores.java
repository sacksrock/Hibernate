// default package
// Generated Nov 20, 2017 4:23:37 PM by Hibernate Tools 5.2.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Actores generated by hbm2java
 */
public class Actores implements java.io.Serializable {

	private Integer codigo;
	private String nombre;
	private Date FNacimiento;
	private String nacionalidad;
	private Set repartos = new HashSet(0);

	public Actores() {
	}
	
	public Actores(String nombre, Date FNacimiento, String nacionalidad) {
		this.nombre = nombre;
		this.FNacimiento = FNacimiento;
		this.nacionalidad = nacionalidad;
	}

	public Actores(String nombre, Date FNacimiento, String nacionalidad, Set repartos) {
		this.nombre = nombre;
		this.FNacimiento = FNacimiento;
		this.nacionalidad = nacionalidad;
		this.repartos = repartos;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFNacimiento() {
		return this.FNacimiento;
	}

	public void setFNacimiento(Date FNacimiento) {
		this.FNacimiento = FNacimiento;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Set getRepartos() {
		return this.repartos;
	}

	public void setRepartos(Set repartos) {
		this.repartos = repartos;
	}

}
