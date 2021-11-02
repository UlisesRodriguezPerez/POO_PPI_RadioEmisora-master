package vista;

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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
/**
 * Clase VentanaRegistroCancionDisco para registrar una cancion en el disco
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaRegistrarCancionDisco extends JFrame {

	private JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtCantante;
	public JTextField txtGenero;
	public JTextField txtDuracionCancion;
	public JButton btnRegistrar;
	public JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrarCancionDisco frame = new VentanaRegistrarCancionDisco();
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
	public VentanaRegistrarCancionDisco() {
		setBackground(new Color(51, 153, 153));
		this.setUndecorated(true);
		setTitle("Registro de Cancion al Disco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, 0, 424, 247);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre de la cancion");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblNombre.setBounds(26, 29, 156, 15);
		panel.add(lblNombre);
		
		JLabel lblCantante = new JLabel("Cantante");
		lblCantante.setForeground(new Color(255, 255, 255));
		lblCantante.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblCantante.setBounds(26, 69, 66, 15);
		panel.add(lblCantante);
		
		JLabel lblGnero = new JLabel("Género");
		lblGnero.setForeground(new Color(255, 255, 255));
		lblGnero.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblGnero.setBounds(26, 108, 66, 15);
		panel.add(lblGnero);
		
		JLabel lblDuracionEnMinutos = new JLabel("Duracion en minutos");
		lblDuracionEnMinutos.setForeground(new Color(255, 255, 255));
		lblDuracionEnMinutos.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblDuracionEnMinutos.setBounds(26, 150, 151, 15);
		panel.add(lblDuracionEnMinutos);
		this.setLocationRelativeTo(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(199, 27, 213, 19);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCantante = new JTextField();
		txtCantante.setColumns(10);
		txtCantante.setBounds(199, 65, 213, 19);
		panel.add(txtCantante);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(199, 106, 213, 19);
		panel.add(txtGenero);
		
		txtDuracionCancion = new JTextField();
		txtDuracionCancion.setColumns(10);
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
		txtDuracionCancion.setBounds(199, 148, 213, 19);
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
		panel.add(txtDuracionCancion);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnCancelar.setBounds(67, 195, 114, 25);
		btnCancelar.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent arg0) {
				cerrarVentana();
			}
		});
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(255, 255, 255));
		btnRegistrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnRegistrar.setBounds(254, 195, 114, 25);
		panel.add(btnRegistrar);
	}
	
	public void mostrarVentana() {
		this.setVisible(true);
	}
	
	public void cerrarVentana() {
		this.dispose();
		limpiarCampos();
	}
	
	public boolean validarCampos() {
		return !this.txtCantante.getText().equals("") && !this.txtGenero.getText().equals("") &&
				!this.txtNombre.getText().equals("") && !this.txtDuracionCancion.getText().equals("");
	}
	
	public void limpiarCampos() {
		this.txtCantante.setText("");
		this.txtNombre.setText("");
		this.txtGenero.setText("");
		this.txtDuracionCancion.setText("");
	}

	public boolean validarDuracion() {
		return txtDuracionCancion.getText().matches("[0-9]*");
	}

}
