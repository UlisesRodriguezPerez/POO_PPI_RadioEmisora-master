package modelo;

/**
 * Clase que representa una cancion de la emisora
 * @author Josue Rojas Vega
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */

public class Cancion {
	
	// Atributos
	private String nombre;
	private String cantante;
	private String genero;
	private int duracionMinutos;
	private String tipo;
	
	// Constructor
	public Cancion(String nombre, String cantante, String genero, int duracionMinutos, String tipo) {
		super();
		this.nombre = nombre;
		this.cantante = cantante;
		this.genero = genero;
		this.duracionMinutos = duracionMinutos;
		this.tipo = tipo;
	}
	
	// Metodos
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCantante() {
		return cantante;
	}
	public void setCantante(String cantante) {
		this.cantante = cantante;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getDuracionMinutos() {
		return duracionMinutos;
	}
	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cancion [nombre=" + nombre + ", cantante=" + cantante + ", genero=" + genero + ", duracionMinutos="
				+ duracionMinutos + "]";
	}
	
}
