package modelo;
	
/**
 * Representa el locutor
 * @author Ulises Rodriguez Perez
 * @author Kevin Fallas Alvarado
 * @author Josue Rojas Vega
 * @since 2019-09-14
 *
 */

public class Locutor {
	
	//Atributos
	private String id;
	private String nombre;
	private String correo;
	private String telefono;
	private String direccion;
	private String sexo;
	private String fechaDeNacimiento;
	
	//Constructor
	public Locutor(String id, String nombre, String correo, String telefono, String direccion, String sexo,
			String fechaDeNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.sexo = sexo;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	//Metodos
	
	@Override
	public String toString() {
		return "Locutor [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", sexo=" + sexo + ", fechaDeNacimiento=" + fechaDeNacimiento + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	

	
}	
