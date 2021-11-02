package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
/**
 * Clase VentanaAgegarCancionPrograma para agregar canciones al programa
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaAgregarCancionPrograma extends JFrame {

	private JPanel contentPane;
	public JButton btnCancelar;
	private JTextField txtNombre;
	private JTextField txtCantante;
	private JLabel lblGenero;
	private JTextField txtGenero;
	private JLabel lblDuracion;
	private JTextField txtDuracion;
	private JLabel lblRegistroCancionesPara;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarCancionPrograma frame = new VentanaAgregarCancionPrograma();
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
	public VentanaAgregarCancionPrograma() {
		this.setUndecorated(true);
		setTitle("Agregar Canciones al Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 337);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnCancelar.setBounds(12, 286, 102, 25);
		contentPane.add(btnCancelar);
		this.btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			cerrarVentana();
			}
			
		});
		
		JButton btnAgregarCancion = new JButton("Agregar Cancion");
		btnAgregarCancion.setBackground(new Color(255, 255, 255));
		btnAgregarCancion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		btnAgregarCancion.setBounds(198, 286, 172, 25);
		btnAgregarCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		
		});
		contentPane.add(btnAgregarCancion);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblNombre.setBounds(12, 78, 66, 15);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(168, 73, 202, 25);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCantante = new JLabel("Cantante");
		lblCantante.setForeground(new Color(255, 255, 255));
		lblCantante.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblCantante.setBounds(12, 119, 66, 15);
		contentPane.add(lblCantante);
		
		txtCantante = new JTextField();
		txtCantante.setBounds(168, 114, 202, 25);
		contentPane.add(txtCantante);
		txtCantante.setColumns(10);
		
		lblGenero = new JLabel("Genero");
		lblGenero.setForeground(new Color(255, 255, 255));
		lblGenero.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblGenero.setBounds(12, 217, 66, 15);
		contentPane.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(168, 212, 203, 25);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		
		lblDuracion = new JLabel("Duracion");
		lblDuracion.setForeground(new Color(255, 255, 255));
		lblDuracion.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
		lblDuracion.setBounds(12, 170, 66, 15);
		contentPane.add(lblDuracion);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(168, 165, 203, 25);
		contentPane.add(txtDuracion);
		txtDuracion.setColumns(10);
		
		lblRegistroCancionesPara = new JLabel("Registro Canciones para el Programa");
		lblRegistroCancionesPara.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroCancionesPara.setForeground(new Color(255, 255, 255));
		lblRegistroCancionesPara.setFont(new Font("DejaVu Sans Light", Font.BOLD, 16));
		lblRegistroCancionesPara.setBounds(36, 25, 318, 25);
		contentPane.add(lblRegistroCancionesPara);
		
		this.setLocationRelativeTo(null);
	}
	public void cerrarVentana(){
		dispose();
	}
}
