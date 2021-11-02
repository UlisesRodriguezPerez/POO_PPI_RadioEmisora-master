package modelo;

import java.util.ArrayList;

/**
 * Clase ArrayList de discos fisicos
 * @author Josue Rojas Vega,
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */

@SuppressWarnings("serial")
public class ListaDiscos extends ArrayList<DiscoFisico>{
	/**
	 * Crea el disco
	 * @param disco
	 */
	public void agregarDisco(DiscoFisico disco) {
		this.add(disco);
	}
	/**
	 * Permite editar Discos
	 * @param index
	 * @param disco
	 */
	public void editarDisco(int index, DiscoFisico disco) {
		this.remove(index);
		this.add(index, disco);
	}
	/**
	 * Permite eliminar Discos.
	 * @param index
	 */
	public void eliminarDisco(int index) {
		this.remove(index);
	}
	
	
}