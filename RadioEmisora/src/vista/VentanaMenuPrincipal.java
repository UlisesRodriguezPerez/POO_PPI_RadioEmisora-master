package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * Clase VentanaMenuPrincipal donde los paneles son agregados como pestañas
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaMenuPrincipal extends JFrame {

	public JPanel contentPane;
	public JLabel radioDescripcion;
	public PanelLocutor pnlLocutor;
	public PanelPrograma pnlPrograma;
	public PanelDisco pnlDisco;
	public PanelCancion pnlCancion;
	public JTabbedPane tabbedPane;
	public VentanaRegistroLocutor ventanaRegistroLocutor;
	public VentanaRegistroPrograma ventanaRegistroPrograma;
	public VentanaRegistroCancion ventanaRegistroCancion;
	public VentanaRegistroDisco ventanaRegistroDisco;
	public PanelPlaylist pnlPlaylist;
	public PanelConsultar pnlConsultar;
	public JButton btnSalir;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenuPrincipal frame = new VentanaMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *
	 * Create the frame.
	 */
	public VentanaMenuPrincipal() {
		this.setUndecorated(true);
		ventanaRegistroLocutor = new VentanaRegistroLocutor();
		ventanaRegistroPrograma = new VentanaRegistroPrograma();
		ventanaRegistroCancion = new VentanaRegistroCancion();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 524);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(UIManager.getFont("Button.font"));
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(12, 52, 835, 423);
		contentPane.add(tabbedPane);
		
		pnlLocutor = new PanelLocutor();
		pnlLocutor.table.setSize(461, -39);
		pnlLocutor.btnEliminar.setLocation(260, 358);
		pnlLocutor.btnModificar.setLocation(373, 358);
		pnlLocutor.btnRegistrar.setLocation(486, 358);
		pnlLocutor.table.setLocation(13, 86);
		tabbedPane.addTab("Locutores", null, pnlLocutor, null);
		
		pnlPrograma = new PanelPrograma();
		pnlPrograma.btnEliminar.setLocation(459, 359);
		pnlPrograma.btnModificar.setLocation(344, 359);
		pnlPrograma.btnRegistrar.setLocation(231, 359);
		tabbedPane.addTab("Programas", null, pnlPrograma, null);
		
		pnlDisco = new PanelDisco();
		pnlDisco.table.setBounds(13, 37, 600, -5);
		pnlDisco.lblCanciones.setLocation(655, 239);
		pnlDisco.lblImagenDisco.setLocation(629, 73);
		tabbedPane.addTab("Discos", null, pnlDisco, null);
		
		pnlCancion = new PanelCancion();
		tabbedPane.addTab("Canciones", null, pnlCancion, null);
		
	
		
		pnlPlaylist = new PanelPlaylist();
		tabbedPane.addTab("Playlist", null, pnlPlaylist, null);
		
		pnlConsultar = new PanelConsultar();
		tabbedPane.addTab("Consultas", null, pnlConsultar, null);
		
		radioDescripcion = new JLabel("");
		radioDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		radioDescripcion.setForeground(SystemColor.text);
		radioDescripcion.setBackground(new Color(0, 0, 0));
		radioDescripcion.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 21));
		radioDescripcion.setBounds(12, 12, 847, 35);
		contentPane.add(radioDescripcion);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.LIGHT_GRAY);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Ha salido del programa", null, JOptionPane.CLOSED_OPTION);
				System.exit(0); 
	
			}
		});
		btnSalir.setBounds(733, 487, 114, 25);
		contentPane.add(btnSalir);
		this.setLocationRelativeTo(null);
	}
}
