package modelo;
import java.util.ArrayList;

/**
 * Clase que representa a la RadioEmisora
 * @author Josue Rojas Vega
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */

public class RadioEmisora {
	
	//Atributos
	private String nombre;
	private String direccionFisica;
	private String frecuencia;
	private String direccionWeb;
	
	public ListaCanciones listaCanciones;
	public ListaDiscos listaDiscos;
	public ListaLocutores listaLocutores;
	public ListaProgramas listaProgramas;
	public ListaPlaylist listaPlaylist;
	
	//Constructor
	public RadioEmisora(String nombre, String direccionFisica, String frecuencia, String direccionWeb) {
		super();
		this.nombre = nombre;
		this.direccionFisica = direccionFisica;
		this.frecuencia = frecuencia;
		this.direccionWeb = direccionWeb;
		this.listaCanciones = new ListaCanciones();
		this.listaDiscos = new ListaDiscos();
		this.listaLocutores = new ListaLocutores();
		this.listaProgramas = new ListaProgramas();
		this.listaPlaylist = new ListaPlaylist();
	}
	
	//Metodos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccionFisica() {
		return direccionFisica;
	}

	public void setDireccionFisica(String direccionFisica) {
		this.direccionFisica = direccionFisica;
	}

	public String getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getDireccionWeb() {
		return direccionWeb;
	}

	public void setDireccionWeb(String direccionWeb) {
		this.direccionWeb = direccionWeb;
	}

	@Override
	public String toString() {
		return "RadioEmisora [nombre=" + nombre + ", direccionFisica=" + direccionFisica + ", frecuencia=" + frecuencia
				+ ", direccionWeb=" + direccionWeb + ", listaCanciones=" + listaCanciones + ", listaDiscos="
				+ listaDiscos + "]";
	}
	
}
