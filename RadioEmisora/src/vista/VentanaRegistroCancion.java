package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
/**
 * Clase VentanaRegistroCancion para crear canciones
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaRegistroCancion extends JFrame {

	private JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtCantante;
	public JTextField txtGenero;
	public JTextField txtDuracionCancion;
	public JButton btnCancelar;
	public JButton btnRegistrar;
	public JTextField txtRuta;
	public JLabel lblAlbum;
	public JTextField txtAlbum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroCancion frame = new VentanaRegistroCancion();
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
	public VentanaRegistroCancion() {
		this.setUndecorated(true);
		setTitle("Registro de Cancion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 269);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(12, 12, 424, 247);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblNombre.setBounds(26, 54, 66, 15);
		panel.add(lblNombre);
		
		JLabel lblCantante = new JLabel("Cantante");
		lblCantante.setForeground(new Color(255, 255, 255));
		lblCantante.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblCantante.setBounds(26, 81, 66, 15);
		panel.add(lblCantante);
		
		JLabel lblGnero = new JLabel("Género");
		lblGnero.setForeground(new Color(255, 255, 255));
		lblGnero.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblGnero.setBounds(26, 108, 66, 15);
		panel.add(lblGnero);
		
		JLabel lblDuracionEnMinutos = new JLabel("Duracion en minutos");
		lblDuracionEnMinutos.setForeground(new Color(255, 255, 255));
		lblDuracionEnMinutos.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblDuracionEnMinutos.setBounds(26, 135, 151, 15);
		panel.add(lblDuracionEnMinutos);
		this.setLocationRelativeTo(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(199, 48, 213, 19);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCantante = new JTextField();
		txtCantante.setColumns(10);
		txtCantante.setBounds(199, 79, 213, 19);
		panel.add(txtCantante);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(199, 106, 213, 19);
		panel.add(txtGenero);
		
		txtDuracionCancion = new JTextField();
		txtDuracionCancion.addKeyListener(new KeyAdapter() {
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
		txtDuracionCancion.setColumns(10);
		txtDuracionCancion.setBounds(199, 133, 213, 19);
		panel.add(txtDuracionCancion);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {cerrarVentana();}
		});
		
		btnCancelar.setBounds(67, 195, 114, 25);
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(new Color(0, 0, 0));
		btnRegistrar.setBackground(new Color(255, 255, 255));
		btnRegistrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnRegistrar.setBounds(279, 195, 114, 25);
		panel.add(btnRegistrar);
		
		JLabel lblRutaDeArchivo = new JLabel("Ruta de archivo");
		lblRutaDeArchivo.setForeground(new Color(255, 255, 255));
		lblRutaDeArchivo.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblRutaDeArchivo.setBounds(26, 162, 114, 15);
		panel.add(lblRutaDeArchivo);
		
		txtRuta = new JTextField();
		txtRuta.setBounds(199, 164, 213, 19);
		panel.add(txtRuta);
		txtRuta.setColumns(10);
		
		lblAlbum = new JLabel("Album");
		lblAlbum.setForeground(new Color(255, 255, 255));
		lblAlbum.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblAlbum.setBounds(26, 25, 66, 15);
		panel.add(lblAlbum);
		
		txtAlbum = new JTextField();
		txtAlbum.setBounds(196, 17, 216, 19);
		panel.add(txtAlbum);
		txtAlbum.setColumns(10);
		setLocationRelativeTo(null);
	}
	
	public void cerrarVentana() {
		this.dispose();
		limpiarCampos();
	}
	
	public boolean validarCampos() {
		return 	!this.txtAlbum.getText().equals("") && !this.txtNombre.getText().equals("") &&
				!this.txtCantante.getText().equals("") && !this.txtGenero.getText().equals("") &&
				!this.txtDuracionCancion.getText().equals("") && !this.txtRuta.getText().equals("");
	}
	
	public boolean validarDuracion() {
		if(txtDuracionCancion.getText().matches("[0-9]*"))
			return true;
		else
			return false;
	}
	
	public void limpiarCampos() {
		this.txtRuta.setText("");
		this.txtAlbum.setText("");
		this.txtCantante.setText("");
		this.txtNombre.setText("");
		this.txtGenero.setText("");
		this.txtDuracionCancion.setText("");
	}
}
