package modelo;

import java.util.ArrayList;

public class ListaPlaylist extends ArrayList<Playlist>{
	/**
	 * Crea las listas para la playlist
	 * @param playlist
	 * 
	 */
	public void agregarPrograma(Playlist playlist) {
		this.add(playlist);
	}

	public void editarPrograma(int index, Playlist playlist) {
		this.remove(index);
		this.add(index, playlist);
	}
	/**
	 * Permite eliminar la playlist
	 * @param index
	 */
	public void eliminarPrograma(int index) {
		this.remove(index);
	}
}
