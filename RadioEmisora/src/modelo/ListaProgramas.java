package modelo;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class ListaProgramas extends ArrayList<Programa>{
		/**
		 * Ccrea los programas
		 */
	public void agregarPrograma(Programa programa) {
		this.add(programa);
	}
	/**
	 * Permite editar los programas
	 * @param index
	 * @param programa
	 */
	public void editarPrograma(int index, Programa programa) {
		this.remove(index);
		this.add(index, programa);
	}
	/**
	 * Permite eliminar los programas
	 * @param index
	 */
	public void eliminarPrograma(int index) {
		this.remove(index);
	}
	
}
