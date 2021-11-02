package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * Clase VentanaCargaCancion para cargar canciones
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaCargaCancion extends JFrame {

	public JPanel contentPane;
	public JFileChooser ventanaArchivo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCargaCancion frame = new VentanaCargaCancion();
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
	public VentanaCargaCancion() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setUndecorated(true);
		this.ventanaArchivo = new JFileChooser();
		
		contentPane.add(this.ventanaArchivo);
	}
	
	public int mostrarSeleccionadorDeArchivo() {
		return this.ventanaArchivo.showOpenDialog(contentPane);
	}

}
