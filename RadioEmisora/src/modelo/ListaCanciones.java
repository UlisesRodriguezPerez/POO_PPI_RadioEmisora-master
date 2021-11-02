package modelo;

import java.util.ArrayList;

/**
 * Clase ArrayList de canciones
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */

@SuppressWarnings("serial")
public class ListaCanciones extends ArrayList<Cancion> {
	/**
	 * Crea la lista de canciones
	 * @param cancion
	 */
	public void agregarCancion(Cancion cancion) {
		this.add(cancion);
		
	}
	/**
	 * Permite editar las canciones
	 * @param index
	 * @param cancion
	 */
	public void editarCancion(int index, Cancion cancion) {
		this.remove(index);
		this.add(index, cancion);
	}
	/**
	 * Perimite eliminar las canciones.
	 * @param index
	 */
	public void eliminarCancion(int index) {
		this.remove(index);
	}
	/**
	 * 
	 * @return duracionMinutos
	 */
	public int duracionMinutos() {
		int minutos = 0;
		for ( int i=0; i < this.size(); ++i) 
			minutos += this.get(i).getDuracionMinutos();
		return minutos;
	}

}
