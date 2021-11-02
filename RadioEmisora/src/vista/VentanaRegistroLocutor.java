package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.regex.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import java.awt.Font;
/**
 * Clase VentanaRegistroLocutor para crear locutores
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaRegistroLocutor extends JFrame {

	private JPanel contentPane;
	public JTextField txtId;
	public JTextField txtNombre;
	public JTextField txtCorreo;
	public JTextField txtTelefono;
	public JTextField txtDireccion;
	public JTextField txtSexo;
	public JTextField txtFecha;
	public JButton btnRegistrar;
	public JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroLocutor frame = new VentanaRegistroLocutor();
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
	public VentanaRegistroLocutor() {
		setBackground(new Color(51, 153, 153));
		this.setUndecorated(true);
		setTitle("Registro de Locutor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 262);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, 0, 424, 259);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblNombre.setBounds(12, 47, 66, 15);
		panel.add(lblNombre);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblId.setBounds(12, 20, 66, 15);
		panel.add(lblId);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(new Color(255, 255, 255));
		lblCorreo.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblCorreo.setBounds(12, 74, 66, 15);
		panel.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblTelefono.setBounds(12, 101, 66, 15);
		panel.add(lblTelefono);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(new Color(255, 255, 255));
		lblSexo.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblSexo.setBounds(12, 155, 66, 15);
		panel.add(lblSexo);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblDireccion.setBounds(12, 128, 98, 15);
		panel.add(lblDireccion);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setForeground(new Color(255, 255, 255));
		lblFechaDeNacimiento.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblFechaDeNacimiento.setBounds(12, 182, 154, 15);
		panel.add(lblFechaDeNacimiento);
		this.setLocationRelativeTo(null);
		
		txtId = new JTextField();
		txtId.setBounds(206, 18, 190, 19);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(206, 45, 190, 19);
		panel.add(txtNombre);
		
		txtCorreo = new JTextField();
		//Validacion de correo
		txtCorreo.addFocusListener(new FocusAdapter() {
		
		public void focusLost(FocusEvent e) {
		}
		});
		
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(206, 72, 190, 19);
		panel.add(txtCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
			
			}
			});
		
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(206, 99, 190, 19);
		panel.add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(206, 126, 190, 19);
		panel.add(txtDireccion);
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(206, 153, 190, 19);
		panel.add(txtSexo);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(206, 180, 190, 19);
		panel.add(txtFecha);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {cerrarVentana();}
		});
		btnCancelar.setBounds(68, 222, 114, 25);
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnRegistrar.setBackground(new Color(255, 255, 255));
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistrar.setBounds(249, 222, 114, 25);
		panel.add(btnRegistrar);
		getRootPane().setDefaultButton(btnRegistrar);
	}
	
	public void cerrarVentana() {
		limpiarCampos();
		this.dispose();
	}

	public boolean isEmail(String correo) {
		Pattern pat = null;
		Matcher mat = null;
		pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
		mat = pat.matcher(correo);
		if ( mat.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validarCampos() {
		return validarTelefono(this.txtTelefono.getText()) && !txtId.getText().equals("") && !txtNombre.getText().equals("") && !txtCorreo.getText().equals("") && !txtDireccion.getText().equals("") 
			&& isEmail(this.txtCorreo.getText()) && !txtFecha.getText().equals("") && !txtSexo.getText().equals("") && !txtTelefono.getText().equals("");
	}
	
	public boolean validarEspaciosVacios() {
		return  !txtId.getText().equals("") && !txtNombre.getText().equals("") && !txtCorreo.getText().equals("") && !txtDireccion.getText().equals("") 
			 && !txtFecha.getText().equals("") && !txtSexo.getText().equals("") && !txtTelefono.getText().equals("");
	}
	
	public boolean validarTelefono(String telefono) {
		if(telefono.matches("[0-9]{8}"))
			return true;
		else
			return false;
	}
	
	public void limpiarCampos() {
		this.txtId.setText("");
		this.txtNombre.setText("");
		this.txtCorreo.setText("");
		this.txtDireccion.setText("");
		this.txtFecha.setText("");
		this.txtSexo.setText("");
		this.txtTelefono.setText("");
	}
	
	
}