package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
/**
 * Clase ventanaEdicionPrograma para editar los programs en el menu principal.
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaEdicionPrograma extends JFrame {
	
	private JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtHorario;
	public JTextField txtDuracion;
	public JTextField txtGenero;
	public JButton btnRegistrar;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JTable table;
	public JButton btnGuardar;
	public JButton btnBorrar;
	public JButton btnCancelar; 
	public JComboBox cmbxLocutor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEdicionPrograma frame = new VentanaEdicionPrograma();
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
	public VentanaEdicionPrograma() {
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, 0, 543, 257);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(174, 41, 166, 26);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(174, 79, 166, 26);
		panel.add(txtHorario);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
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
		txtDuracion.setBounds(174, 117, 166, 26);
		panel.add(txtDuracion);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(174, 155, 166, 26);
		panel.add(txtGenero);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 51, 66, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Horario");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblNombre.setBounds(31, 89, 66, 15);
		panel.add(lblNombre);
		
		JLabel lblCorreo = new JLabel("Duracion");
		lblCorreo.setForeground(new Color(255, 255, 255));
		lblCorreo.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblCorreo.setBounds(31, 127, 66, 15);
		panel.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Genero");
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblTelefono.setBounds(31, 165, 66, 15);
		panel.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Locutor");
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblDireccion.setBounds(31, 201, 66, 15);
		panel.add(lblDireccion);
		this.setLocationRelativeTo(null);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnGuardar.setBounds(381, 71, 133, 25);
		panel.add(btnGuardar);
		
		btnBorrar = new JButton("Limpiar");
		btnBorrar.setBackground(new Color(255, 255, 255));
		btnBorrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnBorrar.setBounds(381, 125, 133, 25);
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
		btnCancelar.setBounds(381, 174, 133, 25);
		panel.add(btnCancelar);
		
		cmbxLocutor = new JComboBox<String>();
		cmbxLocutor.setBounds(174, 197, 166, 24);
		panel.add(cmbxLocutor);
	}
	public void cerrarVentana() {
		limpiarCampos();
		this.dispose();
	}
	
	public boolean validarDuracion(String duracion) {
		return duracion.matches("[0-9]");
	}
	
	public boolean validarCampos() {
		return !this.txtDuracion.getText().equals("") && !this.txtNombre.getText().equals("") &&
				!this.txtGenero.getText().equals("") && !this.txtHorario.getText().equals("");
	}
	
	public void limpiarCampos() {
		this.txtNombre.setText("");
		this.txtHorario.setText("");
		this.txtDuracion.setText("");
		this.txtGenero.setText("");
	}

}
