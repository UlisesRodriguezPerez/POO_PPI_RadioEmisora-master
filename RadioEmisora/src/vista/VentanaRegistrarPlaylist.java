package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Playlist;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
/**
 * Clase VentanaRegistrarPlaylist  para crear la playList
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaRegistrarPlaylist extends JFrame {

	public JPanel contentPane;
	public JTable tblCanciones;
	public JTable tblPlaylist;
	public JComboBox cmbxPrograma;
	public JLabel lblNombrePrograma;
	public JLabel lblLaDuracionEs;
	public JLabel lblDuracionPrograma;
	public JButton btnCrearPlaylist;
	public JLabel lblDuracionPlaylist;
	public JButton btnGenerarPlaylist;
	public JButton btnSalir;
	public Playlist playlist;
	public boolean banderaRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrarPlaylist frame = new VentanaRegistrarPlaylist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistrarPlaylist() {
		banderaRegistro = false;
		this.setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 494);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.playlist = null;
		
		cmbxPrograma = new JComboBox<String>();
		cmbxPrograma.setForeground(new Color(255, 255, 255));
		cmbxPrograma.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		cmbxPrograma.setBackground(new Color(51, 153, 153));
		cmbxPrograma.setBounds(254, 7, 210, 24);
		contentPane.add(cmbxPrograma);
		
		lblNombrePrograma = new JLabel("Programa");
		lblNombrePrograma.setForeground(new Color(0, 0, 0));
		lblNombrePrograma.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblNombrePrograma.setBounds(47, 12, 75, 15);
		contentPane.add(lblNombrePrograma);
		
		lblLaDuracionEs = new JLabel("Duracion");
		lblLaDuracionEs.setForeground(new Color(0, 0, 0));
		lblLaDuracionEs.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblLaDuracionEs.setBounds(47, 40, 155, 15);
		contentPane.add(lblLaDuracionEs);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 67, 706, 151);
		contentPane.add(scrollPane);
		tblCanciones = new JTable();
		tblCanciones.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Nombre", "Cantante", "Genero", "Duracion"
			}
		));
		scrollPane.setViewportView(tblCanciones);
		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		
		lblDuracionPrograma = new JLabel("00");
		lblDuracionPrograma.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracionPrograma.setForeground(new Color(0, 0, 0));
		lblDuracionPrograma.setFont(new Font("DejaVu Sans Light", Font.BOLD, 16));
		lblDuracionPrograma.setBounds(264, 35, 134, 24);
		contentPane.add(lblDuracionPrograma);
		
		btnCrearPlaylist = new JButton("Crear Playlist");
		btnCrearPlaylist.setForeground(new Color(255, 255, 255));
		btnCrearPlaylist.setBackground(new Color(51, 153, 153));
		btnCrearPlaylist.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnCrearPlaylist.setBounds(532, 455, 186, 25);
		contentPane.add(btnCrearPlaylist);
		
		lblDuracionPlaylist = new JLabel("00");
		lblDuracionPlaylist.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracionPlaylist.setForeground(new Color(0, 0, 0));
		lblDuracionPlaylist.setFont(new Font("DejaVu Sans Light", Font.BOLD, 16));
		lblDuracionPlaylist.setBounds(93, 455, 134, 24);
		contentPane.add(lblDuracionPlaylist);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 267, 706, 176);
		contentPane.add(scrollPane_1);
		
		tblPlaylist = new JTable();
		tblPlaylist.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Album", "Nombre", "Cantante", "Genero", "Duracion", 
				}
			)
				{public boolean isCellEditable(int x, int y)
				{return false;}});
		scrollPane_1.setViewportView(tblPlaylist);
		
		btnGenerarPlaylist = new JButton("Generar Playlist");
		btnGenerarPlaylist.setForeground(new Color(255, 255, 255));
		btnGenerarPlaylist.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnGenerarPlaylist.setBackground(new Color(51, 153, 153));
		btnGenerarPlaylist.setBounds(227, 230, 271, 25);
		contentPane.add(btnGenerarPlaylist);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnSalir.setBackground(new Color(51, 153, 153));
		btnSalir.setBounds(604, 7, 114, 25);
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cerrarVentana();
				banderaRegistro = false;
			}

		});
		contentPane.add(btnSalir);
		
		this.setLocationRelativeTo(null);
	}
	public void limpiarTablaInferior() {
		DefaultTableModel modelo = (DefaultTableModel) this.tblPlaylist.getModel();
		int filas = modelo.getRowCount();
		for (int j = 0; j<filas; j++)
			modelo.removeRow(0);
	}
	
	/**
	 * Este metodo cierra la ventana de la playlist
	 */
	public void cerrarVentana() {
		this.dispose();
		this.playlist = null;
		DefaultTableModel modelo = (DefaultTableModel) this.tblCanciones.getModel();
		for (int i = 0; i<modelo.getRowCount(); i++)
			modelo.removeRow(0);
		modelo = (DefaultTableModel) this.tblPlaylist.getModel();
		for (int j = 0; j<modelo.getRowCount(); j++)
			modelo.removeRow(0);
	}
	
	
	
	
}
