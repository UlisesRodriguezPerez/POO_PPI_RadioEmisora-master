package vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

/**
 * Clase PanelCancion para agregar en el menu principal
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class PanelCancion extends JPanel {
	public JButton btnRegistrar;
	public JButton btnModificar;
	public JButton btnActualizar;
	public JButton btnEliminar;
	public JTable tblCancion;
	private JScrollPane scrollPane;
	public JButton btnRegistrarDesdeXls;
	public JButton btnReproducir ;

	/**
	 * Crea el panel.
	 */
	public PanelCancion() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 204));
		setLayout(null);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(51, 153, 153));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 12));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistrar.setBounds(12, 364, 101, 25);
		add(btnRegistrar);						
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(new Color(51, 153, 153));
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 12));
		btnModificar.setBounds(493, 364, 101, 25);
		add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(51, 153, 153));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 12));
		btnEliminar.setBounds(594, 364, 101, 25);
		add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 807, 336);
		add(scrollPane);
		
		btnReproducir = new JButton("Reproducir");
		btnReproducir.setBackground(new Color(51, 153, 153));
		btnReproducir.setForeground(new Color(255, 255, 255));
		btnReproducir.setFont(new Font("DejaVu Sans Light", Font.BOLD, 12));
		btnReproducir.setBounds(695, 364, 114, 25);
		add(btnReproducir);
		
		tblCancion = new JTable();
		tblCancion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 12));
		tblCancion.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Cantante", "Genero", "Duracion", "Tipo"
			}
		) {
		public boolean isCellEditable(int rowIndex, int columnIndex) {return false;}});
		tblCancion.getColumnModel().getColumn(4).setPreferredWidth(114);
		scrollPane.setViewportView(tblCancion);
		
		btnRegistrarDesdeXls = new JButton("Registrar desde XLS");
		btnRegistrarDesdeXls.setBackground(new Color(51, 153, 153));
		btnRegistrarDesdeXls.setForeground(new Color(255, 255, 255));
		btnRegistrarDesdeXls.setFont(new Font("DejaVu Sans Light", Font.BOLD, 12));
		btnRegistrarDesdeXls.setBounds(118, 364, 177, 25);
		add(btnRegistrarDesdeXls);

	}

	public void limpiarTabla() {
		DefaultTableModel modelo = (DefaultTableModel) this.tblCancion.getModel();
		int filas = modelo.getRowCount();
		for (int i = filas-1; i>=0 ;i--)
			modelo.removeRow(0);
	}
}
