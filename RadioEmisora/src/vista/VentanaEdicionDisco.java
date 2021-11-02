package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.DiscoFisico;
/**
 * Clase VentanaEdicionDisco para editar el disco
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaEdicionDisco extends JFrame {

	private JPanel contentPane;
	public JTextField txtNombreDisco;
	public JTextField txtCantante;
	public JTextField txtAnioEdicion;
	public JTextField txtGenero;
	public JTextField txtUbicacion;
	public JLabel lblImagen;
	public JButton btnGuardar;
	public JButton btnCancelar;
	public JButton btnBorrarCampos;
	public JButton btnAgregar;
	public JButton btnAgregarPorExcel;
	public JButton btnEliminar;
	public JButton btnCambiarCaratula;	
	public JTable table;
	public Icon imagenCargada;
	public DiscoFisico discoTemporal;
	public int valor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEdicionDisco frame = new VentanaEdicionDisco();
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
	public VentanaEdicionDisco() {
		discoTemporal = null;
		valor = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 551);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		
		imagenCargada = null;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setLayout(null);
		panel.setBounds(20, 12, 543, 219);
		contentPane.add(panel);
		
		txtCantante = new JTextField();
		txtCantante.setColumns(10);
		txtCantante.setBounds(174, 46, 166, 26);
		panel.add(txtCantante);
		
		txtAnioEdicion = new JTextField();
		txtAnioEdicion.setColumns(10);
		txtAnioEdicion.setBounds(174, 79, 166, 26);
		panel.add(txtAnioEdicion);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(174, 117, 166, 26);
		panel.add(txtGenero);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setColumns(10);
		txtUbicacion.setBounds(174, 161, 166, 26);
		panel.add(txtUbicacion);
		
		JLabel lblCantante = new JLabel("Cantante");
		lblCantante.setForeground(new Color(255, 255, 255));
		lblCantante.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblCantante.setBounds(12, 51, 66, 15);
		panel.add(lblCantante);
		
		JLabel lblAnioEdicion = new JLabel("Año de Edicion");
		lblAnioEdicion.setForeground(new Color(255, 255, 255));
		lblAnioEdicion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblAnioEdicion.setBounds(12, 90, 122, 15);
		panel.add(lblAnioEdicion);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setForeground(new Color(255, 255, 255));
		lblGenero.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblGenero.setBounds(12, 128, 66, 15);
		panel.add(lblGenero);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setForeground(new Color(255, 255, 255));
		lblUbicacion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblUbicacion.setBounds(12, 166, 86, 15);
		panel.add(lblUbicacion);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnGuardar.setForeground(new Color(0, 0, 0));
		btnGuardar.setBounds(383, 41, 133, 25);
		panel.add(btnGuardar);
		
		btnBorrarCampos = new JButton("Limpiar");
		btnBorrarCampos.setBackground(new Color(255, 255, 255));
		btnBorrarCampos.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnBorrarCampos.setForeground(new Color(0, 0, 0));
		btnBorrarCampos.setBounds(383, 95, 133, 25);
		btnBorrarCampos.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
			}
		
		});
		panel.add(btnBorrarCampos);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setBounds(383, 142, 133, 25);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {cerrarVentana();}
		});
		panel.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("Nombre del disco");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 12, 133, 15);
		panel.add(lblNewLabel);
		
		txtNombreDisco = new JTextField();
		txtNombreDisco.setBounds(174, 12, 166, 26);
		panel.add(txtNombreDisco);
		txtNombreDisco.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnAgregar.setBackground(new Color(255, 255, 255));
		btnAgregar.setBounds(151, 397, 114, 25);
		contentPane.add(btnAgregar);
		
		btnAgregarPorExcel = new JButton("Agregar por excel");
		btnAgregarPorExcel.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnAgregarPorExcel.setBackground(new Color(255, 255, 255));
		btnAgregarPorExcel.setBounds(292, 397, 180, 25);
		contentPane.add(btnAgregarPorExcel);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnEliminar.setBackground(new Color(255, 255, 255));
		btnEliminar.setBounds(511, 397, 114, 25);
		contentPane.add(btnEliminar);
		
		btnCambiarCaratula = new JButton("Cambiar Caratula");
		btnCambiarCaratula.setBackground(new Color(51, 153, 153));
		btnCambiarCaratula.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnCambiarCaratula.setForeground(new Color(255, 255, 255));
		btnCambiarCaratula.setBounds(582, 206, 160, 25);
		contentPane.add(btnCambiarCaratula);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 244, 695, 141);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre del disco", "Cantante", "Genero", "Duracion"
			}
		));
		scrollPane.setViewportView(table);
		
		lblImagen = new JLabel("");
		lblImagen.setBorder( BorderFactory.createLineBorder(Color.black,
                5));
		lblImagen.setBounds(581, 12, 161, 141);
		contentPane.add(lblImagen);
	}
	
	public boolean validarCampos() {
		return !txtCantante.getText().equals("") && !txtAnioEdicion.getText().equals("") 
				&& !txtGenero.getText().equals("") && !txtUbicacion.getText().equals("");
	}

	public void limpiarCampos() {
		this.txtNombreDisco.setText("");
		this.txtCantante.setText("");
		this.txtAnioEdicion.setText("");
		this.txtGenero.setText("");
		this.txtUbicacion.setText("");
	}
	public void cerrarVentana() {
		limpiarCampos();
		this.dispose();
	}

	public void limpiarTabla() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		int filas = modelo.getRowCount();
		for (int i = filas-1; i>=0; i++)
			modelo.removeRow(0);
	}

}
