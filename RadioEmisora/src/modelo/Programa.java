package modelo;


/**
 * Representa el programa
 * @author Ulises Rodriguez Perez 
 * @author Kevin Fallas Alvarado
 * @author Josue Rojas Vega
 * @since 2019-09-14
 */

public class Programa {
	
	//Atributos
	private String nombre;
	private String horario;
	private int duracion;
	private String genero;
	private Locutor locutor;
	
	//Constructor
	public Programa(String nombre, String horario, int duracion, String genero, Locutor locutor){
		super();
		this.nombre = nombre;
		this.horario = horario;
		this.duracion = duracion;
		this.genero = genero;
		this.locutor = locutor;
	}
	
	//Metodos
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Locutor getLocutor() {
		return locutor;
	}

	public void setLocutor(Locutor locutor) {
		this.locutor = locutor;
	}

	@Override
	public String toString() {
		return "Programa [nombre=" + nombre + ", horario=" + horario + ", duracion=" + duracion + ", genero=" + genero
				+ ", locutor=" + locutor + "]";
	}

}
