package vista;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

/**
 * Clase PanelPrograma para agregar en el menu principal
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class PanelPlaylist extends JPanel {
	public JButton btnRegistrar;
	public JButton btnEliminar;
	private JScrollPane scrollPane;
	public JTable tblPrograma;
	private JScrollPane scrollPane_2;
	public JTable tblCanciones;

	/**
	 * Create the panel.
	 */
	public PanelPlaylist() {
		setBackground(new Color(204, 204, 204));
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnRegistrar.setBackground(new Color(51, 153, 153));
		btnRegistrar.setBounds(31, 51, 101, 25);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		setLayout(null);
		add(btnRegistrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnEliminar.setBackground(new Color(51, 153, 153));
		btnEliminar.setBounds(31, 102, 101, 25);
		add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(151, 26, 648, 173);
		add(scrollPane);
		
		tblPrograma = new JTable();
		tblPrograma.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		tblPrograma.setModel(new DefaultTableModel( new Object[][] {},
			new String[] {"Nombre del Programa", "Duracion"}) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {return false;}}
		);

		scrollPane.setViewportView(tblPrograma);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 209, 787, 173);
		add(scrollPane_2);
		
		tblCanciones = new JTable();
		tblCanciones.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		tblCanciones.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Cantante", "Genero", "Duracion"
			}
		));
		scrollPane_2.setViewportView(tblCanciones);
	}
	
	public void limpiarTabla() {
		DefaultTableModel modelo = (DefaultTableModel) this.tblCanciones.getModel();
		int filas1 = modelo.getRowCount();
		for (int i = filas1-1; i>=0; modelo.removeRow(0),i--);
		modelo = (DefaultTableModel) this.tblCanciones.getModel();
		filas1 = modelo.getRowCount();
		for (int j = filas1-1; j >= 0; modelo.removeRow(0),j--);
	}
	
	public void limpiarTablaInferior( ) {
		DefaultTableModel modelo = (DefaultTableModel) this.tblCanciones.getModel();
		int filas = modelo.getRowCount();
		for (int i = filas-1; i>=0 ;i--){
			 modelo.removeRow(0);
		}
	}
}

