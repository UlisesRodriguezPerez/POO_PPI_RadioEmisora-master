package vista;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import jxl.format.Border;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;

/**
 * Clase PanelDisco para agregar en el menu principal
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class PanelDisco extends JPanel {
	public JTable table;
	public JButton btnEliminar;
	public JButton btnModificar;
	public JButton btnRegistrar;
	public JLabel lblImagenDisco;
	public JLabel lblCanciones;
	/**
	 * Create the panel.
	 */
	public PanelDisco() {
		setBackground(new Color(204, 204, 204));
		setLayout(null);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(51, 153, 153));
		btnEliminar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminar.setBounds(95, 356, 111, 25);
		add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setBackground(new Color(51, 153, 153));
		btnModificar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModificar.setBounds(335, 356, 105, 25);
		add(btnModificar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setBackground(new Color(51, 153, 153));
		btnRegistrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnRegistrar.setBounds(218, 356, 105, 25);
		add(btnRegistrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 566, 332);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("DejaVu Sans Light", Font.BOLD, 12));
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Disco", "Cantante", "A\u00F1o Edicion", "Genero", "Ubicacion"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(142);
		scrollPane.setViewportView(table);
		
		lblImagenDisco = new JLabel("");
		lblImagenDisco.setBorder( BorderFactory.createLineBorder(Color.black,
                5));
		lblImagenDisco.setBackground(new Color(102, 102, 102));
		lblImagenDisco.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenDisco.setBounds(695, 57, 177, 161);
		add(lblImagenDisco);
		
		lblCanciones = new JLabel("Canciones: ");
		lblCanciones.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblCanciones.setBounds(737, 230, 111, 15);
		add(lblCanciones);
		
	}
	public void limpiarTabla() {
		DefaultTableModel modelo = (DefaultTableModel) this.table.getModel();
		int filas = modelo.getRowCount();
		for(int i = filas-1; i>=0; i--)
			modelo.removeRow(0);
	}
}
