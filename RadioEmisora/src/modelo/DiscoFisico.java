package modelo;

import javax.swing.Icon;

/**
 * Clase que representa el Disco Fisico de la Emisora
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez
 * @author Josue Rojas Vega
 * @since 2019-09-14
 */

public class DiscoFisico {
	private String nombreDisco;
	private String cantante;
	private String anioEdicion;
	private String generoMusical;
	private String ubicacion;
	private ListaCanciones listaCanciones;
	private Icon imagenCaratula;

	//Contructor
	public DiscoFisico(String nombreDisco, String cantante, String anioEdicion, String generoMusical, String ubicacion, 
			ListaCanciones listaCanciones, Icon imagenCaratula) {
		super();
		this.nombreDisco = nombreDisco;
		this.cantante = cantante;
		this.anioEdicion = anioEdicion;
		this.generoMusical = generoMusical;
		this.ubicacion = ubicacion;
		this.listaCanciones = listaCanciones;
		this.imagenCaratula = imagenCaratula;
	}

	//Metodos
	public String getNombreDisco() {
		return nombreDisco;
	}
	
	public void setNombreDisco(String nombreDisco) {
		this.nombreDisco = nombreDisco;
	}
	
	public String getCantante() {
		return cantante;
	}


	public void setCantante(String cantante) {
		this.cantante = cantante;
	}


	public String getAnioEdicion() {
		return anioEdicion;
	}


	public void setAnioEdicion(String anioEdicion) {
		this.anioEdicion = anioEdicion;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public ListaCanciones getListaCanciones() {
		return listaCanciones;
	}

	public void setListaCanciones(ListaCanciones listaCanciones) {
		this.listaCanciones = listaCanciones;
	}

	public Icon getImagenCaratula() {
		return imagenCaratula;
	}

	public void setImagenCaratula(Icon imagenCaratula) {
		this.imagenCaratula = imagenCaratula;
	}

	@Override
	public String toString() {
		return "DiscoFisico [cantante=" + cantante + ", anioEdicion=" + anioEdicion + ", generoMusical=" + generoMusical
				+ ", ubicacion=" + ubicacion + "]";
	}
	
}
