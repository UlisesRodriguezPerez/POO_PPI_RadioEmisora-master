package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

/**
 * Clase PanelPrograma para agregar en el menu principal
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class PanelPrograma extends JPanel {
	public JButton btnRegistrar;
	public JButton btnModificar;
	public JButton btnEliminar;
	private JScrollPane scrollPane;
	public JTable tblPrograma;

	/**
	 * Create the panel.
	 */
	public PanelPrograma() {
		setBackground(new Color(204, 204, 204));
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(51, 153, 153));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnRegistrar.setBounds(231, 321, 101, 25);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		setLayout(null);
		add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(new Color(51, 153, 153));
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnModificar.setBounds(344, 321, 101, 25);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(51, 153, 153));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnEliminar.setBounds(459, 321, 101, 25);
		add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 796, 334);
		add(scrollPane);
		
		tblPrograma = new JTable();
		tblPrograma.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		tblPrograma.setModel(new DefaultTableModel( new Object[][] {},
			new String[] {"Nombre", "Horario", "Duracion", "Genero", "Locutor"}) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {return false;}}
		);

		scrollPane.setViewportView(tblPrograma);

		
	}
}
