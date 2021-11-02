package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
/**
 * Clase VentanaRegistroPrograma Para crear programas
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaRegistroPrograma extends JFrame {

	public JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtHorario;
	public JTextField txtDuracion;
	public JTextField txtGenero;
	public JComboBox<String> cmbxLocutor;
	public JButton btnRegistrar;
	public JButton btnBorrar;
	public JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroPrograma frame = new VentanaRegistroPrograma();
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
	public VentanaRegistroPrograma() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 232);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setForeground(new Color(0, 0, 0));
		btnSalir.setBounds(12, 192, 79, 25);
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cerrarVentana();
			}
			
		});
		contentPane.add(btnSalir);
		
		JLabel label = new JLabel("Locutor");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		label.setBounds(25, 136, 66, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Genero");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		label_1.setBounds(25, 109, 66, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Duracion");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		label_2.setBounds(25, 74, 66, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Horario");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		label_3.setBounds(25, 43, 66, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Nombre");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		label_4.setBounds(25, 12, 66, 15);
		contentPane.add(label_4);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(124, 12, 248, 19);
		contentPane.add(txtNombre);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(124, 43, 248, 19);
		contentPane.add(txtHorario);
		
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
		txtDuracion.setBounds(124, 74, 248, 19);
		contentPane.add(txtDuracion);
	
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(124, 105, 248, 19);
		contentPane.add(txtGenero);
		
		cmbxLocutor = new JComboBox<String>();
		cmbxLocutor.setBounds(124, 136, 248, 19);
		contentPane.add(cmbxLocutor);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnRegistrar.setBackground(new Color(255, 255, 255));
		btnRegistrar.setForeground(new Color(0, 0, 0));
		btnRegistrar.setBounds(267, 192, 114, 25);
		contentPane.add(btnRegistrar);
		
		btnBorrar = new JButton("Limpiar");
		btnBorrar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnBorrar.setBackground(new Color(255, 255, 255));
		btnBorrar.setForeground(new Color(0, 0, 0));
		btnBorrar.setBounds(103, 192, 143, 25);
		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {limpiarCampos();}
		});
		contentPane.add(btnBorrar);
	}
	
	public void limpiarCampos() {
		this.txtDuracion.setText("");
		this.txtGenero.setText("");
		this.txtNombre.setText("");
		this.txtHorario.setText("");
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
}
