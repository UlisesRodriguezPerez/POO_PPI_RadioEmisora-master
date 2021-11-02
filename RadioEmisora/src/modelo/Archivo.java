package modelo;

/**
 * Clase que representa una cancion como archivo
 * @author Josue Rojas Vega
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */

public class Archivo extends Cancion {
	
	// Atributos
	String album;
	String ruta;
	
	// Constructor
	public Archivo(String album, String nombre, String cantante, String genero, int duracionMinutos, String ruta, String tipo) {
		super(nombre, cantante, genero, duracionMinutos, tipo);
		this.album = album;
		this.ruta = ruta;
	}

	// Metodos
	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "Archivo [album=" + album + ", ruta=" + ruta + "]";
	}
	
}
