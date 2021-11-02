package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

/**
 * Clase PanelLocutor para agregar en el menu principal
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */

public class PanelLocutor extends JPanel {
	public JButton btnRegistrar;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JTable table;
	private JScrollPane scrollPane;
	/**	
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public PanelLocutor() {
		
		setBackground(new Color(204, 204, 204));
		setLayout(null);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnRegistrar.setBackground(new Color(51, 153, 153));
		btnRegistrar.setBounds(474, 371, 106, 25);
		add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnModificar.setBackground(new Color(51, 153, 153));
		btnModificar.setBounds(361, 371, 101, 25);
		add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnEliminar.setBackground(new Color(51, 153, 153));
		btnEliminar.setBounds(248, 371, 101, 25);
		add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 807, 336);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel( new Object[][] {},
			new String[] { "Id", "Nombre", "Correo", "Telefono", "Direccion", "Sexo", "Fecha"}) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {return false;}}
		);
		scrollPane.setViewportView(table);
		
	}
}
