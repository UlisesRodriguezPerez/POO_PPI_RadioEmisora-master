package modelo;

public class Playlist {
	//Atributos
	private int duracion;
	private Programa programa;
	private ListaCanciones listaCanciones;
	
	//Contructores
	public Playlist(int duracion,ListaCanciones listaCanciones, Programa programa) {
		super();
		this.duracion = duracion;
		this.listaCanciones = listaCanciones;
		this.programa = programa;
	}
	
	//Metodos
	
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public ListaCanciones getListaCanciones() {
		return listaCanciones;
	}

	public void setListaCanciones(ListaCanciones listaCanciones) {
		this.listaCanciones = listaCanciones;
	}
	
	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	@Override
	public String toString() {
		return "Playlist [duracion=" + duracion + ", programa=" + programa + ", listaCanciones=" + listaCanciones + "]";
	}
}


