package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Font;
import java.awt.Color;
/**
 * Clase VentanaEdicionLocutor
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaEdicionLocutor extends JFrame {

	public JPanel contentPane;
	public JTextField txtId;
	public JTextField txtNombre;
	public JTextField txtCorreo;
	public JTextField txtTelefono;
	public JTextField txtDireccion;
	public JTextField txtSexo;
	public JTextField txtFecha;
	public JButton btnGuardar;
	public JButton btnBorrar;
	public JButton btnCancelar; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEdicionLocutor frame = new VentanaEdicionLocutor();
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
	public VentanaEdicionLocutor() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, 0, 541, 307);
		contentPane.add(panel);
		panel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		txtId = new JTextField();
		txtId.setBounds(174, 24, 166, 26);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(174, 62, 166, 26);
		panel.add(txtNombre);
		
		txtCorreo = new JTextField();
		txtCorreo.addFocusListener(new FocusAdapter() {
		
		public void focusLost(FocusEvent e) {
		}
	});
	txtCorreo.setColumns(10);
	txtCorreo.setBounds(174, 100, 166, 26);
	panel.add(txtCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
			}
			});
		txtTelefono.setBounds(174, 138, 166, 26);
		panel.add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(174, 178, 166, 26);
		panel.add(txtDireccion);
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(174, 212, 166, 26);
		panel.add(txtSexo);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(174, 250, 166, 26);
		panel.add(txtFecha);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 35, 66, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblNombre.setBounds(12, 73, 66, 15);
		panel.add(lblNombre);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(new Color(255, 255, 255));
		lblCorreo.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblCorreo.setBounds(12, 111, 66, 15);
		panel.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblTelefono.setBounds(12, 149, 66, 15);
		panel.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblDireccion.setBounds(12, 189, 101, 15);
		panel.add(lblDireccion);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(new Color(255, 255, 255));
		lblSexo.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblSexo.setBounds(12, 223, 66, 15);
		panel.add(lblSexo);
		
		JLabel lblFecha = new JLabel("Fecha de Nacimiento");
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblFecha.setBounds(12, 255, 150, 21);
		panel.add(lblFecha);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.setForeground(new Color(0, 0, 0));
		
		btnGuardar.setBounds(383, 93, 133, 25);
		panel.add(btnGuardar);
		
		btnBorrar = new JButton("Limpiar");
		btnBorrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnBorrar.setBackground(new Color(255, 255, 255));
		btnBorrar.setForeground(new Color(0, 0, 0));
		btnBorrar.setBounds(383, 147, 133, 25);
		btnBorrar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {limpiarCampos();}
		});
		panel.add(btnBorrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { cerrarVentana(); }
		});
		btnCancelar.setBounds(383, 196, 133, 25);
		panel.add(btnCancelar);
	}
	
	public void cerrarVentana() {
		this.dispose();
	}
	
	public boolean validarTelefono(String telefono) {
		if(telefono.matches("[0-9]{8}"))
			return true;
		else
			return false;
	}
	
	public boolean validarCampos() {
		return validarTelefono(this.txtTelefono.getText()) && !txtId.getText().equals("") && !txtNombre.getText().equals("") && !txtCorreo.getText().equals("") && !txtDireccion.getText().equals("") 
			&& isEmail(this.txtCorreo.getText()) && !txtFecha.getText().equals("") && !txtSexo.getText().equals("") && !txtTelefono.getText().equals("");
	}
	public boolean validarEspaciosVacios() {
		return  !txtId.getText().equals("") && !txtNombre.getText().equals("") && !txtCorreo.getText().equals("") && !txtDireccion.getText().equals("") 
			 && !txtFecha.getText().equals("") && !txtSexo.getText().equals("") && !txtTelefono.getText().equals("");
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
	
	public void limpiarCampos() {
		this.txtId.setText("");
		this.txtNombre.setText("");
		this.txtCorreo.setText("");
		this.txtDireccion.setText("");
		this.txtTelefono.setText("");
		this.txtSexo.setText("");
		this.txtFecha.setText("");
	}
}
