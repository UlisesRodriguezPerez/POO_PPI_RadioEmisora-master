package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
/**
 * Clase VentanaEdicionCancion para editar las canciones
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaEdicionCancion extends JFrame {

		private JPanel contentPane;
		public JTextField txtNombre;
		public JTextField txtCantante;
		public JTextField txtDuracion;
		public JTextField txtGenero;
		public JButton btnRegistrar;
		public JButton btnModificar;
		public JButton btnEliminar;
		public JTable table;
		public JButton btnGuardar;
		public JButton btnBorrar;
		public JButton btnCancelar; 
		public JTextField txtRuta;
		public JTextField txtAlbum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEdicionCancion frame = new VentanaEdicionCancion();
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
	public VentanaEdicionCancion() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 286);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(12, 12, 531, 267);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(174, 63, 176, 26);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCantante = new JTextField();
		txtCantante.setColumns(10);
		txtCantante.setBounds(174, 101, 176, 26);
		panel.add(txtCantante);
		
		txtDuracion = new JTextField();
		txtDuracion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
				}
			}
		});
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(174, 183, 176, 26);
		panel.add(txtDuracion);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(174, 139, 176, 26);
		panel.add(txtGenero);
		
		JLabel lblNombreCancion = new JLabel("Nombre");
		lblNombreCancion.setForeground(new Color(255, 255, 255));
		lblNombreCancion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblNombreCancion.setBounds(12, 74, 507, 15);
		panel.add(lblNombreCancion);
		
		JLabel lblCancion = new JLabel("Cantante");
		lblCancion.setForeground(new Color(255, 255, 255));
		lblCancion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblCancion.setBounds(12, 112, 507, 15);
		panel.add(lblCancion);
		
		JLabel lblCorreo = new JLabel("Genero");
		lblCorreo.setForeground(new Color(255, 255, 255));
		lblCorreo.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblCorreo.setBounds(12, 150, 507, 15);
		panel.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Duracion en Minutos");
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblTelefono.setBounds(12, 188, 507, 21);
		panel.add(lblTelefono);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnGuardar.setBounds(383, 63, 136, 25);
		panel.add(btnGuardar);
		
		btnBorrar = new JButton("Limpiar");
		btnBorrar.setBackground(new Color(255, 255, 255));
		btnBorrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnBorrar.setBounds(383, 160, 136, 25);
		btnBorrar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {limpiarCampos();}
		});
		panel.add(btnBorrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {cerrarVentana();}
		});
		btnCancelar.setBounds(383, 197, 136, 25);
		panel.add(btnCancelar);
		
		txtRuta = new JTextField();
		txtRuta.setColumns(10);
		txtRuta.setBounds(174, 221, 176, 26);
		panel.add(txtRuta);
		
		JLabel lblRuta = new JLabel("Ruta");
		lblRuta.setForeground(new Color(255, 255, 255));
		lblRuta.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblRuta.setBounds(12, 223, 507, 21);
		panel.add(lblRuta);
		
		txtAlbum = new JTextField();
		txtAlbum.setColumns(10);
		txtAlbum.setBounds(174, 25, 176, 26);
		panel.add(txtAlbum);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setForeground(new Color(255, 255, 255));
		lblAlbum.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblAlbum.setBounds(12, 30, 507, 15);
		panel.add(lblAlbum);
		this.setLocationRelativeTo(null);
	}
	
	public boolean validarCampos() {
		return 	!this.txtAlbum.getText().equals("") && !this.txtNombre.getText().equals("") &&
				!this.txtCantante.getText().equals("") && !this.txtGenero.getText().equals("") &&
				!this.txtDuracion.getText().equals("") && !this.txtRuta.getText().equals("");
	}	
	
	public void cerrarVentana() {
		dispose();
		limpiarCampos();
	}
	public void limpiarCampos() {
		this.txtAlbum.setText("");
		this.txtNombre.setText("");
		this.txtCantante.setText("");
		this.txtDuracion.setText("");
		this.txtGenero.setText("");
		this.txtRuta.setText("");
	}
}
