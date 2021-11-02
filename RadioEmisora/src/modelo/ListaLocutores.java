package modelo;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class ListaLocutores extends ArrayList<Locutor> {
		/**
		 * Crea el locutor
		 * @param locutor
		 */
	public void agregarLocutor(Locutor locutor) {
		this.add(locutor);
	}
	/**
	 * Permite editar el Locutor
	 * @param index
	 * @param locutor
	 */
	public void editarLocutor(int index, Locutor locutor) {
		this.remove(index);
		this.add(index, locutor);
	}
	/**
	 * Permite eliminar Locutores.
	 * @param index
	 */
	public void eliminarLocutor(int index) {
		this.remove(index);
	}
}
