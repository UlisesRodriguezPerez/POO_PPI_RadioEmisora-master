package vista;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
/**
 * Clase PanelConsultar menu principal
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */

public class PanelConsultar extends JPanel {
	public JTextField txtConsultar;
	public JTable table;
	public JComboBox cmbxConsultar;
	public JButton btnConsultar; 
	
	
	/**
	 * Create the panel.
	 */
	public PanelConsultar() {
		setBackground(new Color(204, 204, 204));
		setLayout(null);
		
		cmbxConsultar = new JComboBox<String>();
		cmbxConsultar.setForeground(new Color(255, 255, 255));
		cmbxConsultar.setBackground(new Color(51, 153, 153));
		cmbxConsultar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 12));
		cmbxConsultar.setBounds(12, 38, 261, 24);
		cmbxConsultar.addItem("Genero");
		cmbxConsultar.addItem("Cantante");
		add(cmbxConsultar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBackground(new Color(51, 153, 153));
		btnConsultar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 12));
		btnConsultar.setBounds(311, 38, 114, 25);
		add(btnConsultar);
		
		txtConsultar = new JTextField();
		txtConsultar.setBounds(217, 87, 449, 24);
		add(txtConsultar);
		txtConsultar.setColumns(10);
		
		JLabel lblIngreseElDato = new JLabel("Ingrese el dato a consultar");
		lblIngreseElDato.setFont(new Font("DejaVu Sans Light", Font.BOLD, 12));
		lblIngreseElDato.setBounds(12, 91, 187, 15);
		add(lblIngreseElDato);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 145, 810, 250);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Album"
			}
		));
		scrollPane.setViewportView(table);

	}


	public void limpiarTabla() {
		DefaultTableModel modelo = (DefaultTableModel) this.table.getModel();
		int filas = modelo.getRowCount();
		for(int i=filas-1; i>=0; i--)
			modelo.removeRow(0);	
	}
}
