package vista;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.awt.Color;
import java.awt.Font;

/**
 * Clase VentanaReproducirCancion para reproducir canciones de la lista de canciones.
 * @author Josue Rojas Vega 
 * @author Kevin Fallas Alvarado
 * @author Ulises Rodriguez Perez	
 * @since 2019-09-14
 */
public class VentanaReproducirCancion extends JFrame implements ActionListener, Runnable{
		public static VentanaReproducirCancion p;
		public JButton play, pause,stop,resume;
		public JButton btnSalir;
		Thread t;
		public String ruta = "";	
		
		public VentanaReproducirCancion() throws JavaLayerException{
			t = new Thread(this);
			getContentPane().setBackground(new Color(51, 204, 153));
			this.setUndecorated(true);
			this.setAlwaysOnTop(true);
			
			play = new JButton("Reproducir");
			play.setForeground(new Color(255, 255, 255));
			play.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
			play.setBackground(new Color(51, 51, 51));
			play.setBounds(39, 12, 125, 30);
			
			pause = new JButton ("Pausa");
			pause.setForeground(new Color(255, 255, 255));
			pause.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
			pause.setBackground(new Color(51, 51, 51));
			pause.setBounds(308, 12, 100, 30);
			
			stop = new JButton ("Detener");
			stop.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
			stop.setForeground(new Color(255, 255, 255));
			stop.setBackground(new Color(51, 51, 51));
			stop.setBounds(420, 12, 100, 30);
			
			resume = new JButton("Resumen");
			resume.setForeground(new Color(255, 255, 255));
			resume.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
			resume.setBackground(new Color(51, 51, 51));
			resume.setBounds(176, 12, 120, 30);

			play.addActionListener(this);
	 		pause.addActionListener(this);
			stop.addActionListener(this);
			resume.addActionListener(this);
			
			getContentPane().setLayout(null);
			getContentPane().add(play);
			getContentPane().add(pause);
			getContentPane().add(stop);
			getContentPane().add(resume);
			
			btnSalir = new JButton("Salir");
			btnSalir.setForeground(new Color(255, 255, 255));
			btnSalir.setFont(new Font("DejaVu Sans Light", Font.BOLD, 14));
			btnSalir.setBackground(new Color(153, 153, 153));
			btnSalir.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					t.stop();
					cerrarVentana();}
			});
			
			btnSalir.setBounds(592, 15, 114, 25);
			getContentPane().add(btnSalir);
			setSize(750,50);
			this.setLocation(257, 540 );
	}
			
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == play) {
			t.start();
		} else if (e.getSource() == pause) {
			t.suspend();
		} else if(e.getSource() == stop) {
			t.stop();
		} else if(e.getSource() == resume) {
			t.resume();
		}
	}
	
	public static void main(String[] args) throws JavaLayerException {
		p = new VentanaReproducirCancion();
		p.setVisible(true);
	}
	
	public void run() {
		try {
			FileInputStream fis = new FileInputStream(ruta);
			AdvancedPlayer player = new AdvancedPlayer(fis);
			player.play();
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"No se encontró la canción");
			cerrarVentana();
		}catch (JavaLayerException e){
			e.printStackTrace();
		}
	}
	
	public void abrirVentana()  {
		setVisible(true);
	}
	
	public void cerrarVentana() {
		dispose();
	}

}