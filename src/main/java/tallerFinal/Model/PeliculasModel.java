package tallerFinal.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="peliculas")
public class PeliculasModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idpelicula;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="nombreoriginal")
	private String nombreoiginal;
	
	@Column(name="anio")
	private int anio;
	
	@Column(name="sinopsis")
	private String sinopsis;
	
	@Column(name="duracion")
	private int duracion;

	public int getIdpelicula() {
		return idpelicula;
	}

	public void setIdpelicula(int idpelicula) {
		this.idpelicula = idpelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombreoiginal() {
		return nombreoiginal;
	}

	public void setNombreoiginal(String nombreoiginal) {
		this.nombreoiginal = nombreoiginal;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	

}
