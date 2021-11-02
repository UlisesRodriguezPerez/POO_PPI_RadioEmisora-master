package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
/**
 * Clase VentanaRegistroDisco para crear discos
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaRegistroDisco extends JFrame {

	private JPanel contentPane;
	public JTextField txtCantante;
	public JTextField txtAnioEdicion;
	public JTextField txtGenero;
	public JTextField txtUbicacion;
	public JButton btnRegistrar;
	public JButton btnCancelar;
	public Icon imagenCargada;
	public JLabel lblNewLabel;
	public JTextField txtNombreDisco;
	public JButton btnAgregarImagen;
	public JLabel lblImagen;
	public JTable table;
	public JButton btnAgregarDesdeExcel;
	public JButton btnAgregarCancion; 
	public JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroDisco frame = new VentanaRegistroDisco();
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
	public VentanaRegistroDisco() {
		this.setUndecorated(true);
		setTitle("Registro del Disco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		imagenCargada = null;
		
		JPanel pnlRegistroDisco = new JPanel();
		pnlRegistroDisco.setBounds(12, 12, 396, 227);
		contentPane.add(pnlRegistroDisco);
		pnlRegistroDisco.setLayout(null);
		
		JLabel lblAnioEdicion = new JLabel("Año de Edición");
		lblAnioEdicion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblAnioEdicion.setBounds(12, 83, 130, 15);
		pnlRegistroDisco.add(lblAnioEdicion);
		
		JLabel lblCantante = new JLabel("Cantante");
		lblCantante.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblCantante.setBounds(12, 56, 66, 15);
		pnlRegistroDisco.add(lblCantante);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblGenero.setBounds(12, 110, 66, 15);
		pnlRegistroDisco.add(lblGenero);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblUbicacion.setBounds(12, 137, 73, 15);
		pnlRegistroDisco.add(lblUbicacion);
		this.setLocationRelativeTo(null);
		
		txtCantante = new JTextField();
		txtCantante.setBounds(160, 52, 190, 19);
		pnlRegistroDisco.add(txtCantante);
		txtCantante.setColumns(10);
		
		txtAnioEdicion = new JTextField();
		txtAnioEdicion.setColumns(10);
		txtAnioEdicion.setBounds(160, 83, 190, 19);
		pnlRegistroDisco.add(txtAnioEdicion);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(160, 110, 190, 19);
		pnlRegistroDisco.add(txtGenero);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setColumns(10);
		txtUbicacion.setBounds(160, 133, 190, 19);
		pnlRegistroDisco.add(txtUbicacion);
		
		btnRegistrar = new JButton("Registrar Disco");
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setBackground(new Color(51, 153, 153));
		btnRegistrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistrar.setBounds(226, 190, 158, 25);
		pnlRegistroDisco.add(btnRegistrar);
		
		lblNewLabel = new JLabel("Nombre del disco");
		lblNewLabel.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 29, 130, 15);
		pnlRegistroDisco.add(lblNewLabel);
		
		txtNombreDisco = new JTextField();
		txtNombreDisco.setBounds(160, 21, 190, 19);
		pnlRegistroDisco.add(txtNombreDisco);
		txtNombreDisco.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(51, 153, 153));
		btnCancelar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnCancelar.setBounds(36, 190, 112, 25);
		pnlRegistroDisco.add(btnCancelar);
		
		btnAgregarImagen = new JButton("Agregar Imagen");
		btnAgregarImagen.setBackground(new Color(255, 255, 255));
		btnAgregarImagen.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnAgregarImagen.setBounds(531, 202, 160, 25);
		contentPane.add(btnAgregarImagen);
		
		lblImagen = new JLabel("");
		lblImagen.setBorder( BorderFactory.createLineBorder(Color.black,
                5));
		lblImagen.setBounds(514, 25, 195, 165);
		contentPane.add(lblImagen);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 251, 740, 165);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Cantante", "Genero", "Duracion"
				}
			));
		scrollPane.setViewportView(table);
		
		btnAgregarCancion = new JButton("Agregar Cancion");
		btnAgregarCancion.setForeground(new Color(0, 0, 0));
		btnAgregarCancion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnAgregarCancion.setBackground(new Color(255, 255, 255));
		btnAgregarCancion.setBounds(142, 445, 153, 25);
		contentPane.add(btnAgregarCancion);
		
		btnAgregarDesdeExcel = new JButton("Agregar  desde Excel");
		btnAgregarDesdeExcel.setForeground(new Color(0, 0, 0));
		btnAgregarDesdeExcel.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnAgregarDesdeExcel.setBackground(new Color(255, 255, 255));
		btnAgregarDesdeExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregarDesdeExcel.setBounds(337, 445, 205, 25);
		contentPane.add(btnAgregarDesdeExcel);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(577, 445, 114, 25);
		contentPane.add(btnEliminar);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {cerrarVentana();}
		});
	}
	public void cerrarVentana() {
		limpiarCampos();
		limpiarTabla();
		this.dispose();
	}
	
	public void limpiarTabla() {
		DefaultTableModel modelo = (DefaultTableModel) this.table.getModel();
		int filas = modelo.getRowCount();
		for (int i = 0; i < filas; i++)
			modelo.removeRow(0);
	}
	
	public boolean validarCampos() {
		return !txtCantante.getText().equals("") && !txtAnioEdicion.getText().equals("") && !txtGenero.getText().equals("") && !txtUbicacion.getText().equals("");
	}
	
	public void limpiarCampos() {
		this.txtNombreDisco.setText("");
		this.txtCantante.setText("");
		this.txtAnioEdicion.setText("");
		this.txtGenero.setText("");
		this.txtUbicacion.setText("");
	}
}







