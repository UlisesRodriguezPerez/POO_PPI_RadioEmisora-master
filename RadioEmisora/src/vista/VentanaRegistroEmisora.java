package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
/**
 * Clase VentanaRegistroEmisora para crear emisoras
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaRegistroEmisora extends JFrame {

	public JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtDireccion;
	public JTextField txtFrecuencia;
	public JTextField txtDireccionWeb;
	public JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroEmisora frame = new VentanaRegistroEmisora();
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
	public VentanaRegistroEmisora() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 417);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); // CENTRA LA VENTANA ********************************
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.setBounds(15, 129, 426, 239);
		contentPane.add(panel);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(173, 29, 205, 29);
		panel.add(txtNombre);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(173, 69, 205, 29);
		panel.add(txtDireccion);
		
		txtFrecuencia = new JTextField();
		txtFrecuencia.setColumns(10);
		txtFrecuencia.setBounds(173, 117, 205, 29);
		panel.add(txtFrecuencia);
	
		txtDireccionWeb = new JTextField();
//		txtDireccionWeb.addFocusListener(new FocusAdapter() {
//			public void focusLost(FocusEvent e) {
//				if ( validarDireccionWeb(txtDireccionWeb.getText())) {
//					
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Direccion Web incorrecto", "Validar direccion web"
//							,JOptionPane.INFORMATION_MESSAGE);
//					txtDireccionWeb.requestFocus();
//				}
//			}
//			});
		txtDireccionWeb.setBounds(173, 163, 205, 29);
		panel.add(txtDireccionWeb);
		txtDireccionWeb.setColumns(10);
		
		JLabel label = new JLabel("Nombre");
		label.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		label.setBounds(34, 36, 102, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Direccion");
		label_1.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		label_1.setBounds(34, 76, 102, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Frecuencia");
		label_2.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		label_2.setBounds(34, 124, 102, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Direccion Web");
		label_3.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		label_3.setToolTipText("");
		label_3.setBounds(34, 170, 121, 15);
		panel.add(label_3);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(253, 245, 230));
		btnSalir.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Ha salido del programa", null, JOptionPane.CLOSED_OPTION);
				System.exit(0); 
	
			}
		});
		btnSalir.setBounds(12, 380, 114, 25);
		contentPane.add(btnSalir);
		
		button = new JButton("Registrar");
		button.setBackground(new Color(253, 245, 230));
		button.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		button.setBounds(317, 380, 124, 25);
		contentPane.add(button);
		//		button.setMnemonic(KeyEvent.VK_ENTER);
				getRootPane().setDefaultButton(button);
				
				JLabel lblNewLabel = new JLabel("SISTEMA DE RADIOEMISORA");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("DejaVu Sans Light", Font.BOLD, 26));
				lblNewLabel.setBackground(new Color(255, 255, 255));
				lblNewLabel.setBounds(12, 12, 429, 105);
				contentPane.add(lblNewLabel);
	}
	public boolean validarDireccionWeb(String direccionWeb) {
		return direccionWeb.matches("^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}\\.([a-z]+)?$");
	}
}
