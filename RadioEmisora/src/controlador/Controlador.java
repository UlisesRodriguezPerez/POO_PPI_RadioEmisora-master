package controlador;

/*           Librerias      */

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import javazoom.jl.decoder.JavaLayerException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import modelo.Archivo;
import modelo.Cancion;
import modelo.DiscoFisico;
import modelo.ListaCanciones;
import modelo.Locutor;
import modelo.Playlist;
import modelo.Programa;
import modelo.RadioEmisora;
import vista.VentanaAgregarCancionPrograma;
import vista.VentanaCargaCancion;
import vista.VentanaEdicionCancion;
import vista.VentanaEdicionDisco;
import vista.VentanaEdicionLocutor;
import vista.VentanaEdicionPrograma;
import vista.VentanaMenuPrincipal;
import vista.VentanaRegistrarCancionDisco;
import vista.VentanaRegistrarPlaylist;
import vista.VentanaRegistroCancion;
import vista.VentanaRegistroDisco;
import vista.VentanaRegistroEmisora;
import vista.VentanaRegistroPrograma;
import vista.VentanaReproducirCancion;

/**
 * El Controlador maneja cada enlace de las clases con los 
 * metodos y los aspectos de la interfaz para el funcionamiento 
 * de la emisora
 * 
 * @author Josue
 * @author Kevin
 * @author Ulises
 *
 */
public class Controlador {
	
	/* Atributos */
	public RadioEmisora radioEmisora;
	public VentanaMenuPrincipal ventanaMenuPrincipal;
	public VentanaRegistroEmisora ventanaRegistroEmisora;
	public VentanaEdicionLocutor ventanaEdicionLocutor;
	public VentanaEdicionPrograma ventanaEdicionPrograma;
	public VentanaRegistroCancion ventanaRegistroCancion;
	public VentanaEdicionCancion ventanaEdicionCancion;
	public VentanaEdicionDisco ventanaEdicionDisco;
	public VentanaRegistroDisco ventanaRegistroDisco;
	public VentanaCargaCancion ventanaCargaCancion;
	public VentanaAgregarCancionPrograma ventanaAgregarCancionPrograma;
	public VentanaRegistrarPlaylist ventanaRegistroPlaylist;
	public VentanaRegistrarCancionDisco ventanaRegistrarCancionDisco;
	public VentanaRegistrarCancionDisco ventanaRegistrarCancionDisco1;
	public VentanaReproducirCancion ventanaReproducirCancion;
	
	/* Constructor */
	public Controlador() {
		this.ventanaRegistroEmisora = new VentanaRegistroEmisora();
		this.ventanaMenuPrincipal = new VentanaMenuPrincipal();
		this.ventanaEdicionLocutor = new VentanaEdicionLocutor();
		this.ventanaMenuPrincipal = new VentanaMenuPrincipal();
		this.ventanaRegistroDisco = new VentanaRegistroDisco();
		this.ventanaEdicionDisco = new VentanaEdicionDisco();
		this.ventanaRegistroCancion = new VentanaRegistroCancion();
		this.ventanaEdicionCancion = new VentanaEdicionCancion();
		this.ventanaCargaCancion = new VentanaCargaCancion();
		this.ventanaAgregarCancionPrograma = new VentanaAgregarCancionPrograma();
		this.ventanaRegistroPlaylist = new VentanaRegistrarPlaylist();
		this.ventanaEdicionPrograma = new VentanaEdicionPrograma();
		this.ventanaRegistrarCancionDisco = new VentanaRegistrarCancionDisco();
		this.ventanaRegistrarCancionDisco1 = new VentanaRegistrarCancionDisco();
		
		setMetodosBotones();
		this.ventanaRegistroEmisora.setVisible(true);
		
		this.ventanaRegistroEmisora.button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!validarRegistroEmisora())
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del registro", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				if(!ventanaRegistroEmisora.validarDireccionWeb(ventanaRegistroEmisora.txtDireccionWeb.getText()))
					JOptionPane.showMessageDialog(null, "Direccion web no valida", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				else {
					cerrarVentana();
					crearEmisora();
				}
			}
		});
	}	
	
	/* PRUEBAS: muestra cualquier lista pasada por parametros */
	public void mostrarLista(ArrayList lista ) {
		System.out.println("\n");
		for (int i=0; i<lista.size(); i++) 	{System.out.println(lista.get(i).toString());}
		System.out.println("\n");
	}
	
	/**
	 * Este metodo es usado para registrar la emisora en el programa
	 */
	public void crearEmisora() {
		this.radioEmisora = new RadioEmisora(this.ventanaRegistroEmisora.txtNombre.getText()
				,this.ventanaRegistroEmisora.txtDireccion.getText(), 
				this.ventanaRegistroEmisora.txtFrecuencia.getText(), 
				this.ventanaRegistroEmisora.txtDireccionWeb.getText());
		String info = this.radioEmisora.getNombre()+" | \n"+
				this.radioEmisora.getDireccionFisica()+" | \n"+
				this.radioEmisora.getFrecuencia()+" | \n"+
				this.radioEmisora.getDireccionWeb()+" | \n";
		this.ventanaMenuPrincipal.radioDescripcion.setText(info);
	}

	/**
	 * Este metodo es usado para cerrar la ventana de registrar emisora
	 */
	public void cerrarVentana() {
		this.ventanaRegistroEmisora.dispose();
		this.ventanaMenuPrincipal.setVisible(true);
	}
	
	/**
	 * Metodo para añadir las funciones a los botones del programa
	 * 
	 */
	
	public void setMetodosBotones() {
		/*      Botones de Playlist    */
		this.ventanaMenuPrincipal.pnlPlaylist.tblPrograma.getModel().addTableModelListener( new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent arg0) {
				ventanaMenuPrincipal.pnlPlaylist.limpiarTablaInferior();
				if (ventanaMenuPrincipal.pnlPlaylist.tblPrograma.getSelectedRow() != -1 && !radioEmisora.listaPlaylist.isEmpty()) {
					Playlist playlist = radioEmisora.listaPlaylist.get(ventanaMenuPrincipal.pnlPlaylist.tblPrograma.getSelectedRow());
					cargarCancionesTablaPlaylist(playlist);
				}
			}
		});
		
		this.ventanaMenuPrincipal.pnlPlaylist.tblPrograma.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {	
				ventanaMenuPrincipal.pnlPlaylist.limpiarTablaInferior();
				if (ventanaMenuPrincipal.pnlPlaylist.tblPrograma.getSelectedRow() != -1) {
					Playlist playlist = radioEmisora.listaPlaylist.get(ventanaMenuPrincipal.pnlPlaylist.tblPrograma.getSelectedRow());
					cargarCancionesTablaPlaylist(playlist);
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		this.ventanaRegistroPlaylist.btnGenerarPlaylist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaRegistroPlaylist.limpiarTablaInferior();
				cargarCancionesTabla(obtenerListaPlaylist(generarPlaylistTabla(obtenerPosiblesCanciones())));
				ventanaRegistroPlaylist.banderaRegistro = true;
			}
		});
		this.ventanaRegistroPlaylist.btnCrearPlaylist.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 if (ventanaRegistroPlaylist.banderaRegistro)
					 generarPlaylist();
				 else
					 JOptionPane.showMessageDialog(null, "Debe presionar el boton generar playlist antes de crearla");
			 }
		});
		this.ventanaMenuPrincipal.pnlPlaylist.btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!radioEmisora.listaCanciones.isEmpty())
					mostrarVentanaRegistroPlaylist();
				else
					JOptionPane.showMessageDialog(null, "Deben existir canciones para generar la playlist");
			}
		});
		this.ventanaMenuPrincipal.pnlPlaylist.btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eliminarPrograma();
			}
		});
		this.ventanaRegistroPlaylist.cmbxPrograma.addItemListener( new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (!radioEmisora.listaProgramas.isEmpty() && ventanaRegistroPlaylist.cmbxPrograma.getSelectedIndex() != -1) {
					 ventanaRegistroPlaylist.lblDuracionPrograma.setText(
							 String.valueOf(radioEmisora.listaProgramas.get(ventanaRegistroPlaylist.cmbxPrograma.getSelectedIndex()).getDuracion()));
					 cargarCancionesTablaRegistroPlaylist(obtenerGeneroPrograma());
				}
			}
		});
		
		
		/*		Botones del Programa   */		
		this.ventanaMenuPrincipal.ventanaRegistroPrograma.btnRegistrar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {crearPrograma();}
		});
		this.ventanaMenuPrincipal.pnlPrograma.btnRegistrar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {mostrarVentanaRegistroPrograma();}
		});
		this.ventanaMenuPrincipal.pnlPrograma.btnModificar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {cargarVentanaEdicionPrograma(obtenerProgramaTabla());}
		});
		this.ventanaMenuPrincipal.pnlPrograma.btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {eliminarProgramaTabla();}
		});	
		this.ventanaEdicionPrograma.btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guardarPrograma();
			}
		});
		
		/*		Botones del Locutor  */
		this.ventanaMenuPrincipal.pnlLocutor.btnRegistrar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {mostrarVentanaRegistroLocutor();}
		});
		this.ventanaMenuPrincipal.ventanaRegistroLocutor.btnRegistrar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {crearLocutor();}
		});
		this.ventanaMenuPrincipal.pnlLocutor.btnModificar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {cargarVentanaEdicionLocutor(obtenerLocutorTabla());}
		});
		this.ventanaEdicionLocutor.btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {guardarLocutor();}
		});
		this.ventanaMenuPrincipal.pnlLocutor.btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {eliminarLocutorTabla();}
		});
		
		/*		Botones de Cancion */
		this.ventanaMenuPrincipal.pnlCancion.btnRegistrarDesdeXls.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {try {
				leerArchivoXlsCancionArchivo();
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	}
		});
		this.ventanaMenuPrincipal.ventanaRegistroCancion.btnRegistrar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {crearCancion();}
		});
		this.ventanaMenuPrincipal.pnlCancion.btnRegistrar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {mostrarVentanaRegistroCancion();}
		});			
		this.ventanaMenuPrincipal.pnlCancion.btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {eliminarCancionTabla();}
		});
		this.ventanaMenuPrincipal.pnlCancion.btnReproducir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!radioEmisora.listaCanciones.isEmpty())
					reproducirCancion();
				else
					JOptionPane.showMessageDialog(null, "Deben existir canciones para ser reproducidas");}
		});
		this.ventanaMenuPrincipal.pnlCancion.btnModificar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {cargarVentanaEdicionCancion(obtenerCancionTabla());}
		});
		this.ventanaEdicionCancion.btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {guardarCancion();}
		});
		
		/*		Botones del Disco */ 
		this.ventanaEdicionDisco.btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {mostrarRegistroCancionEdicionDisco();}
		});
		this.ventanaEdicionDisco.btnAgregarPorExcel.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					leerArchivoXlsEdicionDisco();
				} catch (BiffException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		this.ventanaMenuPrincipal.pnlDisco.table.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent arg0) {
				if (ventanaMenuPrincipal.pnlDisco.table.getSelectedRow() != -1 && !radioEmisora.listaDiscos.isEmpty())
					ventanaMenuPrincipal.pnlDisco.lblCanciones.setText("Canciones: "+
						radioEmisora.listaDiscos.get(ventanaMenuPrincipal.pnlDisco.table.getSelectedRow()).getListaCanciones().size());
				else
					ventanaMenuPrincipal.pnlDisco.lblCanciones.setText("");
			}
			
		});
		this.ventanaMenuPrincipal.pnlDisco.table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (ventanaMenuPrincipal.pnlDisco.table.getSelectedRow() != -1 && !radioEmisora.listaDiscos.isEmpty())
					ventanaMenuPrincipal.pnlDisco.lblCanciones.setText("Canciones: "+(
						radioEmisora.listaDiscos.get(
								ventanaMenuPrincipal.pnlDisco.table.getSelectedRow()).getListaCanciones().size()));
				else
					ventanaMenuPrincipal.pnlDisco.lblCanciones.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		this.ventanaEdicionDisco.btnCambiarCaratula.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {cargarImagenCaratulaEdicion();}
		});
		this.ventanaEdicionDisco.btnBorrarCampos.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {borrarCampos();}
		});
		this.ventanaMenuPrincipal.pnlDisco.table.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent arg0) {}
		});
		this.ventanaRegistrarCancionDisco.btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {agregarCancionDisco();}
		});
		this.ventanaRegistrarCancionDisco1.btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {agregarCancionEdicionDisco();}
		});
		this.ventanaMenuPrincipal.pnlDisco.table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cargarImagenPanelDisco(obtenerImagenDisco());
			}
			@Override
			public void mouseEntered(MouseEvent arg0)  {}
			@Override
			public void mouseExited(MouseEvent arg0)   {}
			@Override
			public void mousePressed(MouseEvent arg0)  {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		this.ventanaMenuPrincipal.pnlDisco.btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {mostrarVentanaRegistroDisco();}
		});
		this.ventanaMenuPrincipal.pnlDisco.btnModificar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ventanaEdicionDisco.valor = ventanaMenuPrincipal.pnlDisco.table.getSelectedRow();
				cargarVentanaEdicionDisco(obtenerDiscoTabla());}
		});
		this.ventanaRegistroDisco.btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {crearDisco();}
		});
		this.ventanaMenuPrincipal.pnlDisco.btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eliminarDiscoTabla();
				if (radioEmisora.listaDiscos.isEmpty())
					ventanaMenuPrincipal.pnlDisco.lblImagenDisco.setIcon(null);
			}
		});	
		this.ventanaEdicionDisco.btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { 
				ventanaEdicionDisco.discoTemporal = obtenerDiscoTabla();
				ventanaEdicionDisco.valor = ventanaMenuPrincipal.pnlDisco.table.getSelectedRow();
				guardarEdicionDiscoTabla(ventanaEdicionDisco.discoTemporal, ventanaEdicionDisco.valor);
				ventanaEdicionDisco.discoTemporal = null;
				}
		});
		this.ventanaEdicionDisco.btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {     eliminarCancionEdicionDisco();   }

			private void eliminarCancionEdicionDisco() {
				DefaultTableModel modelo = (DefaultTableModel) ventanaEdicionDisco.table.getModel();
				if (ventanaEdicionDisco.table.getSelectedRow() != -1) {
					modelo.removeRow(ventanaEdicionDisco.table.getSelectedRow());
				} else {
					JOptionPane.showMessageDialog(null, "No hay canciones agregadas o no hay seleccionadas");
				}
				
			};
		});
		this.ventanaRegistroDisco.btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {     eliminarCancionRegistroDisco();   }

			private void eliminarCancionRegistroDisco() {
				DefaultTableModel modelo = (DefaultTableModel) ventanaRegistroDisco.table.getModel();
				if (ventanaRegistroDisco.table.getSelectedRow() != -1) {
					modelo.removeRow(ventanaRegistroDisco.table.getSelectedRow());
				} else {
					JOptionPane.showMessageDialog(null, "No hay canciones agregadas o no hay seleccionadas");
				}
				
			};
		});
		
		this.ventanaRegistroDisco.btnAgregarImagen.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cargarImagenCaratula();
			}
		});
		this.ventanaRegistroDisco.btnAgregarCancion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {mostrarRegistroCancionDisco();}
		});
		this.ventanaRegistroDisco.btnAgregarDesdeExcel.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {leerArchivoXlsCancionDisco();} catch (BiffException | IOException e) {e.printStackTrace();}
			}
		});
		
		/*     Botones Consultar     */
		this.ventanaMenuPrincipal.pnlConsultar.btnConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {consultarCanciones();}
			});
		
	}
	
	/**
	 * Implementacion de logica para Playlist
	 * 
	 */
	
	/*
	 * Se encarga de visualiza en la tabla inferior del panel de canciones 
	 * la canciones respectivas a la playlist
	 */
	public void cargarCancionesTablaPlaylist(Playlist playlist) {
		
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlPlaylist.tblCanciones.getModel();
		
		if (playlist != null)
			for ( int i = 0; i < playlist.getListaCanciones().size(); i++) {
				Cancion cancion = playlist.getListaCanciones().get(i);
				modelo.addRow(new Object[]{cancion.getNombre(), cancion.getCantante(), cancion.getGenero(), cancion.getDuracionMinutos()});
			}
	}
	
	
	
	/**
	 * Este metodo es usado para eliminar los programas de la tabla del Programa
	 */
	public void eliminarPrograma() {
		JTable tabla = this.ventanaMenuPrincipal.pnlPlaylist.tblPrograma;
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		if (tabla.getSelectedRow() != -1) {
			this.radioEmisora.listaPlaylist.remove(tabla.getSelectedRow());
			modelo.removeRow(tabla.getSelectedRow());
		} else {
			JOptionPane.showMessageDialog(null, "No hay playlist a eliminar o no se encuentra seleccionada");
		}
	}
	
	/**
	 * Este metodo es usado para cargar los programas en la tabla del Programa
	 */
	public void cargarTablaProgramas() {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlPlaylist.tblPrograma.getModel();
		for (int i = 0; i<modelo.getRowCount(); i++)
			modelo.removeRow(0);
		for (int j = 0; j < this.radioEmisora.listaPlaylist.size(); j++)
			modelo.addRow(new Object[] {
					this.radioEmisora.listaPlaylist.get(j).getPrograma().getNombre(),
					this.radioEmisora.listaPlaylist.get(j).getDuracion()
			});
	}
	
	/* Implementacion de la logica de la playlist */
	
	/**
	 * Este metodo es usado para eliminar las playlist
	 */
	public void eliminarPlaylistTabla() {
		if (!this.radioEmisora.listaCanciones.isEmpty() && this.ventanaMenuPrincipal.pnlPlaylist.tblPrograma.getSelectedRow() != -1) {
			DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlPlaylist.tblPrograma.getModel();
			int indiceAEliminar = this.ventanaMenuPrincipal.pnlPlaylist.tblPrograma.getSelectedRow();
			this.radioEmisora.listaPlaylist.remove(indiceAEliminar);
			modelo.removeRow(indiceAEliminar);
			mostrarLista(this.radioEmisora.listaProgramas);
			cargarTablaProgramas();
		}
		else 
			JOptionPane.showMessageDialog(null, "No hay playlist registrados o no hay seleccionados", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Este metodo es usado para registar un elemento en la playlist
	 * @param playlist
	 */
	public void registroUnicoElementoPlaylist(Playlist playlist) {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlPlaylist.tblPrograma.getModel();
		modelo.addRow(new Object[] {
				playlist.getPrograma().getNombre(),
				playlist.getDuracion()
		});
	}
	
	/**
	 * Este metodo es usado para obtener el programa para agregar la playlist
	 * @return retorna el programa
	 */
	public Programa obtenerProgramaPlaylist() {
		return (Programa) this.radioEmisora.listaProgramas.get(this.ventanaRegistroPlaylist.cmbxPrograma.getSelectedIndex());
	}
	
	
	/**
	 * Este metodo es usado para obtener el random de las canciones
	 * @return lista
	 */
	public ListaCanciones obtenerPosiblesCanciones() {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaRegistroPlaylist.tblCanciones.getModel();
		ListaCanciones lista = new ListaCanciones();
		
		for (int i = 0; i < modelo.getRowCount(); i++)
			lista.add(new Cancion((String)modelo.getValueAt(i, 0), //NOMBRE
						(String)modelo.getValueAt(i, 1), //CANTANTE
						(String)modelo.getValueAt(i, 2), 
						 (int)modelo.getValueAt(i, 3),
						"Playlist"));
		return lista;
	}
	
	public String generarMensajeCorreo(ListaCanciones lista) {
		String mensaje = "<br><br>Lista de la Playlist:<br>";
		Cancion cancion = null;
		for (int i = 0; i <lista.size(); i++) {
			cancion = lista.get(i);
			mensaje+= cancion.getDuracionMinutos() + ":00 - " + cancion.getNombre() + "<br>";
		}
		return mensaje;
	}
	

	/**
	 * Este metodo es usado para registar la playlist en el programa
	 */
	public void generarPlaylist() {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaRegistroPlaylist.tblPlaylist.getModel();
		this.ventanaRegistroPlaylist.playlist = null;
		for (int i = 0; i<modelo.getRowCount(); i++)
			modelo.removeRow(0);
		modelo = (DefaultTableModel) this.ventanaRegistroPlaylist.tblCanciones.getModel();
		if (modelo.getRowCount() == 0)
			JOptionPane.showMessageDialog(null, "No existen canciones para generar el playlist");
		else {
			ListaCanciones lista = obtenerListaPlaylist(generarPlaylistTabla(obtenerPosiblesCanciones()));
			
			this.ventanaRegistroPlaylist.playlist = new Playlist(lista.duracionMinutos(), lista, obtenerProgramaPlaylist() );
			cargarCancionesTabla(lista);
			this.radioEmisora.listaPlaylist.add(this.ventanaRegistroPlaylist.playlist);
			cargarTablaProgramas();
			String mensajeLista = generarMensajeCorreo(lista);
			
			try {
				enviarCorreo(this.ventanaRegistroPlaylist.playlist.getPrograma().getLocutor().getCorreo(), 
						radioEmisora.getNombre(), mensajeLista);
			} catch (AddressException e) {
				JOptionPane.showMessageDialog(null, "El correo es inválido");
			} catch (MessagingException e) {
				JOptionPane.showMessageDialog(null, "Se ha producido un error al enviar el correo");
			}
			this.ventanaRegistroPlaylist.cerrarVentana();
			mostrarLista(this.radioEmisora.listaPlaylist);
			mostrarLista(lista);
			
		}
	}
	
	/**
	 * Este metodo es usado para registar un elemento en la playlist
	 * @return false si no hay canciones para la playlist y true si la duracion es menor
	 */
	public boolean hayCancionesSeleccionables(ListaCanciones lista, int minutos) {
		if (lista.isEmpty())
			return false;
		else {
			for (int i = 0; i < lista.size(); i++)
				if (lista.get(i).getDuracionMinutos() <= minutos)
					return true;
			return false;
		}
	}
	
	/**
	 * Este metodo es usado para visualizar las canciones de la playlist
	 * @param lista
	 */
	public void cargarCancionesTabla(ListaCanciones lista) { 
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaRegistroPlaylist.tblPlaylist.getModel();
		for (int j = 0; j<modelo.getRowCount(); j++)
			modelo.removeRow(0);
		for (int i = 0; i<lista.size(); i++) {
			if (!(lista.get(i) instanceof Archivo))
				modelo.addRow(new Object[] {
				"Album desconocido",
				lista.get(i).getNombre(), 
				lista.get(i).getCantante(), 
				lista.get(i).getGenero(), 
				lista.get(i).getDuracionMinutos()});
			else {
				Archivo archivo = (Archivo) lista.get(i);
				modelo.addRow(new Object[] {
						archivo.getAlbum(),
						archivo.getNombre(), 
						archivo.getCantante(), 
						archivo.getGenero(), 
						archivo.getDuracionMinutos()});
			}
		}
	}
	
	/**
	 * Este metodo es usado para obtener la lista de la playlist
	 * @param indicesAgregados
	 * @return lista 
	 */
	public ListaCanciones obtenerListaPlaylist(ArrayList<Integer> indicesAgregados) {
		ListaCanciones lista = new ListaCanciones();
		for (int i=0; i<indicesAgregados.size(); i++) {
			lista.add( new Cancion((String)this.ventanaRegistroPlaylist.tblCanciones.getValueAt(i, 0),
					(String)this.ventanaRegistroPlaylist.tblCanciones.getValueAt(i, 1),
					(String)this.ventanaRegistroPlaylist.tblCanciones.getValueAt(i, 2),
					(int)this.ventanaRegistroPlaylist.tblCanciones.getValueAt(i, 3),
					"Playlist"));
		}
		mostrarLista(lista);
		this.ventanaRegistroPlaylist.lblDuracionPlaylist.setText(String.valueOf(lista.duracionMinutos()));
		return lista;
	}
	
	/**
	 * Obtiene la lista de las canciones que se agregaron a la playlist
	 * @param posiblesCanciones
	 * @return listaAgregados
	 */
	public ArrayList<Integer> generarPlaylistTabla(ListaCanciones posiblesCanciones) {
		ArrayList<Integer> listaAgregados = new ArrayList<Integer>();
		Random generadorAleatorio = new Random();
		int numero = 0, limite = posiblesCanciones.size(), 
				minutosLista = posiblesCanciones.duracionMinutos(),
				minutosPrograma = obtenerProgramaPlaylist().getDuracion(), minutosPlaylist = 0;
		
		if (minutosPrograma >= 5 || this.ventanaRegistroPlaylist.tblCanciones.getRowCount() == 0) {
			if (minutosLista >= minutosPrograma) {
				while (minutosPrograma >= 0) {
					numero = generadorAleatorio.nextInt(limite);
					System.out.println("Hola");
					if (listaAgregados.contains(numero))
						continue;
					else {
						if (hayCancionesSeleccionables(posiblesCanciones, minutosPrograma)) {
							listaAgregados.add(numero);
							minutosPrograma-=posiblesCanciones.get(numero).getDuracionMinutos(); 
						} else {break;}}
				}
			} else {	
				for (int i = 0; i<posiblesCanciones.size(); i++) {
					if (posiblesCanciones.get(i).getDuracionMinutos() <= minutosPrograma) {
						listaAgregados.add(i);
						minutosPrograma-=posiblesCanciones.get(i).getDuracionMinutos();
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "El programa no se puede generar");
		}
		
		
		return listaAgregados;
	}

	/**
	 * Carga los programa del combo box a la ventana registro playlist\
	 */
	@SuppressWarnings("unchecked")
	public void cargarProgramasComboBox() {
		this.ventanaRegistroPlaylist.cmbxPrograma.removeAllItems();
		for( int i = 0; i<this.radioEmisora.listaProgramas.size();i++) {
			this.ventanaRegistroPlaylist.cmbxPrograma.addItem(
					this.radioEmisora.listaProgramas.get(i).getNombre() + " | " +
					this.radioEmisora.listaProgramas.get(i).getGenero() );
		}
	}
	
	/**
	 * Obtiene el genero del programa seleccionando 
	 * @return genero
	 */
	public String obtenerGeneroPrograma() {
		int indice = this.ventanaRegistroPlaylist.cmbxPrograma.getSelectedIndex();
		return this.radioEmisora.listaProgramas.get(indice).getGenero();
	}
	
	/**
	 * Este metodo es usado para que se muestre la ventana de Registro de la Playlist
	 */
	public void mostrarVentanaRegistroPlaylist() { 
		if (!this.radioEmisora.listaProgramas.isEmpty()) {
			cargarProgramasComboBox();
			this.ventanaRegistroPlaylist.lblDuracionPrograma.setText( String.valueOf(
					this.radioEmisora.listaProgramas.get(this.ventanaRegistroPlaylist.cmbxPrograma.getSelectedIndex()).getDuracion()));
			this.ventanaRegistroPlaylist.setVisible(true);
		} else 
			JOptionPane.showMessageDialog(null, "Deben existir como minimo un programa para el registro de una playlist", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Carga las canciones de la tabla
	 * @param genero
	 */
	public void cargarCancionesTablaRegistroPlaylist(String genero) {
		DefaultTableModel modelo = (DefaultTableModel)this.ventanaRegistroPlaylist.tblCanciones.getModel();
		int filasTabla = modelo.getRowCount();
		for (int j=0; j<filasTabla; j++ ) 
			modelo.removeRow(0); // eliminado para actualizar la tabla
		
		for (int i=0; i<this.radioEmisora.listaCanciones.size(); i++) {
			if (this.radioEmisora.listaCanciones.get(i).getGenero().equals(genero)) {
				modelo.addRow(new Object[] {
					this.radioEmisora.listaCanciones.get(i).getNombre(),
					this.radioEmisora.listaCanciones.get(i).getCantante(), 
					this.radioEmisora.listaCanciones.get(i).getGenero(), 
					this.radioEmisora.listaCanciones.get(i).getDuracionMinutos()
				}); // carga de los elementos a la tabla
			}
		}
	}
	
	
	/**********************************************************************************************************/
	/**
	 * Implementacion de logica para Locutor
	 * 
	 * 
	 * 
	 */
	
	
	/**
	 * Carga los locutores del combobox 
	 */
	@SuppressWarnings("unchecked")
	public void cargarLocutoresComboBox() {
		this.ventanaMenuPrincipal.ventanaRegistroPrograma.cmbxLocutor.removeAllItems();
		for( int i = 0; i<this.radioEmisora.listaLocutores.size();i++) {
			this.ventanaMenuPrincipal.ventanaRegistroPrograma.cmbxLocutor.addItem(this.radioEmisora.listaLocutores.get(i).getNombre());
		}
	}
	
	/**
	 * Carga los locutores del combo box en la ventana editar programa
	 * @param programa
	 */
	@SuppressWarnings("unchecked")
	public void cargarLocutoresComboBoxModificar(Programa programa) {
		this.ventanaEdicionPrograma.cmbxLocutor.removeAllItems();
		String nombreProgramaCargado = programa.getLocutor().getNombre();
		this.ventanaEdicionPrograma.cmbxLocutor.addItem(nombreProgramaCargado);
		for ( int i = 0; i<this.radioEmisora.listaLocutores.size(); i++) {
			if (!this.radioEmisora.listaLocutores.get(i).getNombre().equals(nombreProgramaCargado))
				this.ventanaEdicionPrograma.cmbxLocutor.addItem(
						this.radioEmisora.listaLocutores.get(i).getNombre());
		}
	}
	
	/**
	 * El metodo agrega al programa la cancion
	 */
	public void agregarCancionPrograma() {
		this.ventanaAgregarCancionPrograma.setVisible(true);
	}
	
	/**
	 * El metedo muestra la ventana del registro de cada locutor
	 */
	public void mostrarVentanaRegistroLocutor() { 
		this.ventanaMenuPrincipal.ventanaRegistroLocutor.setVisible(true);
	}
	
	/**
	 * Asigna los datos del locutor creado 
	 */
	public void crearLocutor() {
		Locutor nuevoLocutor = null;
		if (this.ventanaMenuPrincipal.ventanaRegistroLocutor.validarCampos()){
			nuevoLocutor = new Locutor(
					        this.ventanaMenuPrincipal.ventanaRegistroLocutor.txtId.getText(), 
							this.ventanaMenuPrincipal.ventanaRegistroLocutor.txtNombre.getText(),
							this.ventanaMenuPrincipal.ventanaRegistroLocutor.txtCorreo.getText(),
							this.ventanaMenuPrincipal.ventanaRegistroLocutor.txtTelefono.getText(),
							this.ventanaMenuPrincipal.ventanaRegistroLocutor.txtDireccion.getText(),
							this.ventanaMenuPrincipal.ventanaRegistroLocutor.txtSexo.getText(), 
							this.ventanaMenuPrincipal.ventanaRegistroLocutor.txtFecha.getText());
			
			this.radioEmisora.listaLocutores.agregarLocutor(nuevoLocutor);
			this.ventanaMenuPrincipal.ventanaRegistroLocutor.dispose();
			mostrarLista(this.radioEmisora.listaLocutores);
			this.registroUnicoElementoLocutor(nuevoLocutor);
			this.ventanaMenuPrincipal.ventanaRegistroLocutor.limpiarCampos();
		} else {
			if (!this.ventanaMenuPrincipal.ventanaRegistroLocutor.isEmail(
					this.ventanaMenuPrincipal.ventanaRegistroLocutor.
					txtCorreo.getText())) 
				JOptionPane.showMessageDialog(null, "Correo inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			
			if (!this.ventanaMenuPrincipal.ventanaRegistroLocutor.validarTelefono(
					this.ventanaMenuPrincipal.ventanaRegistroLocutor.
					txtTelefono.getText())) 
				JOptionPane.showMessageDialog(null, "Telefono inválido ( 8 digitos )", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			
			if (!this.ventanaMenuPrincipal.ventanaRegistroLocutor.validarEspaciosVacios())
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	/**
	 * Obtiene el objeto de la lista en el indice seleccionado
	 * @return locutor
	 */
	public Locutor obtenerLocutorTabla() {
		Locutor locutor = null;
		if (this.ventanaMenuPrincipal.pnlLocutor.table.getSelectedRow() != -1)
			locutor = this.radioEmisora.listaLocutores.get(this.ventanaMenuPrincipal.pnlLocutor.table.getSelectedRow());
		if (locutor == null) 
			JOptionPane.showMessageDialog(null, "No hay locutores a modificar o no se han seleccionado", "Aviso", JOptionPane.INFORMATION_MESSAGE);

		return locutor;
	}
	
	/**
	 *  Toma el item seleccionado de la tabla y lo elimina tambien en la lista
	 */
	public void eliminarLocutorTabla() {
		if (!this.radioEmisora.listaLocutores.isEmpty() && this.ventanaMenuPrincipal.pnlLocutor.table.getSelectedRow() != -1) {
			DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlLocutor.table.getModel();
			int indiceAEliminar = this.ventanaMenuPrincipal.pnlLocutor.table.getSelectedRow();
			actualizarProgramas(this.radioEmisora.listaLocutores.get(indiceAEliminar));
			this.radioEmisora.listaLocutores.remove(indiceAEliminar);
			modelo.removeRow(indiceAEliminar);
			mostrarLista(this.radioEmisora.listaLocutores);
		} else 
			JOptionPane.showMessageDialog(null, "No hay locutores a eliminar o no se han seleccionado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Carga la ventana de edicion locutor 
	 * @param locutor
	 */
	public void cargarVentanaEdicionLocutor(Locutor locutor) {
		if (locutor != null ) {
			// carga cada dato del locutor
			this.ventanaEdicionLocutor.txtId.setText(locutor.getId());
			this.ventanaEdicionLocutor.txtNombre.setText(locutor.getNombre());
			this.ventanaEdicionLocutor.txtCorreo.setText(locutor.getCorreo());
			this.ventanaEdicionLocutor.txtTelefono.setText(locutor.getTelefono());
			this.ventanaEdicionLocutor.txtDireccion.setText(locutor.getDireccion());
			this.ventanaEdicionLocutor.txtSexo.setText(locutor.getSexo());
			this.ventanaEdicionLocutor.txtFecha.setText(locutor.getFechaDeNacimiento());
			this.ventanaEdicionLocutor.setVisible(true);
		}
	}
	
	/**
	 * El metodo guarda los cambios realizados en modificar del locutor
	 */
	public void guardarLocutor() {
		if (this.ventanaEdicionLocutor.validarCampos()) {
			DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlLocutor.table.getModel();
			int indice = this.ventanaMenuPrincipal.pnlLocutor.table.getSelectedRow();
			this.radioEmisora.listaLocutores.remove(indice);
			modelo.removeRow(indice);
			Locutor locutor = new Locutor(
					this.ventanaEdicionLocutor.txtId.getText(), 
					this.ventanaEdicionLocutor.txtNombre.getText(),
					this.ventanaEdicionLocutor.txtCorreo.getText(),
					this.ventanaEdicionLocutor.txtTelefono.getText(),
					this.ventanaEdicionLocutor.txtDireccion.getText(),
					this.ventanaEdicionLocutor.txtSexo.getText(),
					this.ventanaEdicionLocutor.txtFecha.getText());
			
			this.radioEmisora.listaLocutores.add(locutor);
			registroUnicoElementoLocutor(locutor);
			this.ventanaEdicionLocutor.dispose();
			this.ventanaEdicionLocutor.limpiarCampos();
			
		} else {
			if (!this.ventanaEdicionLocutor.isEmail(
					this.ventanaEdicionLocutor.
					txtCorreo.getText())) 
				JOptionPane.showMessageDialog(null, "Correo inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			
			if (!this.ventanaEdicionLocutor.validarTelefono(
					this.ventanaEdicionLocutor.
					txtTelefono.getText())) 
				JOptionPane.showMessageDialog(null, "Telefono inválido ( 8 digitos )", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			
			if (!this.ventanaEdicionLocutor.validarEspaciosVacios()) 
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		
		//depuracion
		mostrarLista(this.radioEmisora.listaLocutores);
	}
	
	/**
	 * Registra el locutor en la tabla de locutores
	 * @param locutor
	 */
	public void registroUnicoElementoLocutor(Locutor locutor) {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlLocutor.table.getModel();
		modelo.addRow(new Object[] {
				locutor.getId(),
				locutor.getNombre(),
				locutor.getCorreo(),
				locutor.getTelefono(),
				locutor.getDireccion(),
				locutor.getSexo(),
				locutor.getFechaDeNacimiento(),
		});
	}
	
	/**
	 * Actualiza la tabla del Panel Locutor
	 */
	public void actualizarTablaRegistroLocutor() {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlLocutor.table.getModel();
		for ( int i = 0; i < this.radioEmisora.listaLocutores.size(); i++) {
			modelo.addRow(new Object[] {
					this.radioEmisora.listaLocutores.get(i).getId(),
					this.radioEmisora.listaLocutores.get(i).getNombre(), 
					this.radioEmisora.listaLocutores.get(i).getCorreo(), 
					this.radioEmisora.listaLocutores.get(i).getTelefono(), 
					this.radioEmisora.listaLocutores.get(i).getDireccion(),
					this.radioEmisora.listaLocutores.get(i).getSexo(),
					this.radioEmisora.listaLocutores.get(i).getFechaDeNacimiento()
			});
		}
	}

	/**********************************************************************************************************/
	/**
	 * Implementacion de logica para Programa
	 * 
	 * 
	 * 
	 */
	
	/**
	 * Actualiza la tabla de los programas despues de modificaciones
	 * @param locutor
	 */
	public void actualizarProgramas(Locutor locutor) {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlPrograma.tblPrograma.getModel();
		int largoTabla = modelo.getRowCount();
		int largoLista = this.radioEmisora.listaProgramas.size();
	
		for (int i = 0; i < largoLista; i++) 
			if (this.radioEmisora.listaProgramas.get(i).getLocutor().getNombre().equals(locutor.getNombre()))
				this.radioEmisora.listaProgramas.remove(i);
		for (int j = 0; j< largoTabla; j++) 
			if (modelo.getValueAt(j, 4).equals(locutor.getNombre()))
				modelo.removeRow(j);
	}
	
	/**
	 * Metodo para cargar las canciones de excel
	 * @param data
	 */
	public void cargarCancionesExcelDisco(ArrayList<Cancion> data) {
		boolean banderaCeroElementosCargados = true;
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaRegistroDisco.table.getModel();
		for (int i=0; i<data.size(); ++i) {
			modelo.addRow(new Object[] {data.get(i).getNombre(), data.get(i).getCantante(), 
					data.get(i).getGenero(), data.get(i).getDuracionMinutos() });
			
//			this.radioEmisora.listaCanciones.agregarCancion(new Cancion (data.get(i).getNombre(), data.get(i).getCantante(), 
//					data.get(i).getGenero(), data.get(i).getDuracionMinutos(), "Archivo"));
			banderaCeroElementosCargados = false;
		}
		if (banderaCeroElementosCargados) 
			JOptionPane.showMessageDialog(null, "Archivo vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		mostrarLista(this.radioEmisora.listaCanciones);
	}
	/**
	 * Cargar canciones en la ventana de edicion del disco
	 * @param data
	 */
	public void cargarCancionesExcelEdicionDisco(ArrayList<Cancion> data) {
		boolean banderaCeroElementosCargados = true;
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaEdicionDisco.table.getModel();
		for (int i=0; i<data.size(); ++i) {
			modelo.addRow(new Object[] {data.get(i).getNombre(), data.get(i).getCantante(), 
					data.get(i).getGenero(), data.get(i).getDuracionMinutos() });
			
//			this.radioEmisora.listaCanciones.add(new Cancion (data.get(i).getNombre(), data.get(i).getCantante(), 
//					data.get(i).getGenero(), data.get(i).getDuracionMinutos(), "Archivo"));
			banderaCeroElementosCargados = false;
		}
		if (banderaCeroElementosCargados) 
			JOptionPane.showMessageDialog(null, "Archivo vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		mostrarLista(this.radioEmisora.listaCanciones);
	}
	
	/**
	 * Carga canciones de excel y las agrega en el panel de cancion
	 * @param data
	 */
	public void cargarCancionesExcelArchivo(ArrayList<Archivo> data) {
		boolean banderaCeroElementosCargados = true;
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlCancion.tblCancion.getModel();
		for (int i=0; i<data.size(); ++i) {
			modelo.addRow(new Object[] {data.get(i).getNombre(), data.get(i).getCantante(), 
					data.get(i).getGenero(), data.get(i).getDuracionMinutos(), data.get(i).getTipo() });
			
			this.radioEmisora.listaCanciones.add(new Archivo (data.get(i).getAlbum(), data.get(i).getNombre(), data.get(i).getCantante(), 
					data.get(i).getGenero(), data.get(i).getDuracionMinutos(), data.get(i).getRuta(), "Archivo"));
			banderaCeroElementosCargados = false;
		}
		if (banderaCeroElementosCargados) 
			JOptionPane.showMessageDialog(null, "Archivo vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		mostrarLista(this.radioEmisora.listaCanciones);
	}
	
	/**
	 * Metodo para leer archivos de excel con canciones
	 * @throws BiffException
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public void leerArchivoXlsCancionArchivo() throws BiffException, IOException {
		
		this.ventanaCargaCancion.setVisible(true);
		this.ventanaCargaCancion.ventanaArchivo.setFileFilter(new FileNameExtensionFilter("Excel file", "xls", "xlsx"));
		int seleccion  = this.ventanaCargaCancion.mostrarSeleccionadorDeArchivo();
		
		if  (seleccion == JFileChooser.APPROVE_OPTION) {
			File archivo = this.ventanaCargaCancion.ventanaArchivo.getSelectedFile();
			Workbook workbook = Workbook.getWorkbook(archivo); // ruta de archivo xls a leer
			Sheet sheet = workbook.getSheet(0); // se elige la pagina de excel a leer
			ArrayList<Archivo> data = new ArrayList<Archivo>();
			
			for (int fila = 1; fila < sheet.getRows(); fila++) { 
				if (!sheet.getCell(4, fila).getContents().equals(""))
					data.add( new Archivo(
								(String)sheet.getCell(0, fila).getContents(), 					//ALBUM
								(String)sheet.getCell(1, fila).getContents(), 					//NOMBRE
								(String)sheet.getCell(2, fila).getContents(), 					//CANTANTE
								(String)sheet.getCell(3, fila).getContents(), 					//GENERO
								Integer.parseInt((String)sheet.getCell(4, fila).getContents()), //DURACION
								(String)sheet.getCell(5, fila).getContents(), 					//PATH
								"Archivo")
					);
			}
			this.ventanaCargaCancion.dispose();
			cargarCancionesExcelArchivo(data);
		} else if (seleccion == JFileChooser.ERROR_OPTION) {
			this.ventanaCargaCancion.dispose();
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error durante la carga de archivo", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			this.ventanaCargaCancion.dispose();
			JOptionPane.showMessageDialog(null, "No se ha podido cargar el archivo", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	/**
	 * Carga el archivo de excel de las canciones para el disco
	 * @throws BiffException
	 * @throws IOException
	 */
	public void leerArchivoXlsCancionDisco() throws BiffException, IOException {
		
		if (this.ventanaRegistroDisco.validarCampos()) {
			this.ventanaCargaCancion.setVisible(true);
			this.ventanaCargaCancion.ventanaArchivo.setFileFilter(new FileNameExtensionFilter("Excel file", "xls", "xlsx"));
			int seleccion  = this.ventanaCargaCancion.mostrarSeleccionadorDeArchivo();
			
			if  (seleccion == JFileChooser.APPROVE_OPTION) {
				File archivo = this.ventanaCargaCancion.ventanaArchivo.getSelectedFile();
				Workbook workbook = Workbook.getWorkbook(archivo); // ruta de archivo xls a leer
				Sheet sheet = workbook.getSheet(0); // se elige la pagina de excel a leer
				ArrayList<Cancion> data = new ArrayList<Cancion>();
				
				for (int fila = 1; fila < sheet.getRows(); fila++) { 	
					if (this.ventanaRegistroDisco.txtCantante.getText().equals((String)sheet.getCell(1, fila).getContents())
							&& this.ventanaRegistroDisco.txtGenero.getText().equals((String)sheet.getCell(2, fila).getContents()))
						
						data.add( new Cancion(
									(String)sheet.getCell(0, fila).getContents(), // NOMBRE
									(String)sheet.getCell(1, fila).getContents(), // CANTANTE
									(String)sheet.getCell(2, fila).getContents(), // GENERO
									Integer.parseInt((String)sheet.getCell(3, fila).getContents()), // DURACION
									"DiscoFisico") // TIPO
						);
				}
				this.ventanaCargaCancion.dispose();
				if (!data.isEmpty())
					cargarCancionesExcelDisco(data);
				else
					JOptionPane.showMessageDialog(null, "No se han agregado canciones "
							+ "ya que no coinciden con el genero y el cantante del disco", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			} else if (seleccion == JFileChooser.ERROR_OPTION) {
				this.ventanaCargaCancion.dispose();
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error durante la carga de archivo", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			} else {
				this.ventanaCargaCancion.dispose();
				JOptionPane.showMessageDialog(null, "No se ha podido cargar el archivo", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe ingresar primero la informacion del disco", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Carga el archivo de excel para la ventana de editar el disco
	 * @throws BiffException
	 * @throws IOException
	 */
	public void leerArchivoXlsEdicionDisco() throws BiffException, IOException {
		
		if (this.ventanaEdicionDisco.validarCampos()) {
			this.ventanaCargaCancion.setVisible(true);
			this.ventanaCargaCancion.ventanaArchivo.setFileFilter(new FileNameExtensionFilter("Excel file", "xls", "xlsx"));
			int seleccion  = this.ventanaCargaCancion.mostrarSeleccionadorDeArchivo();
			
			if  (seleccion == JFileChooser.APPROVE_OPTION) {
				File archivo = this.ventanaCargaCancion.ventanaArchivo.getSelectedFile();
				Workbook workbook = Workbook.getWorkbook(archivo); // ruta de archivo xls a leer
				Sheet sheet = workbook.getSheet(0); // se elige la pagina de excel a leer
				ArrayList<Cancion> data = new ArrayList<Cancion>();
				
				for (int fila = 1; fila < sheet.getRows(); fila++) { 	
					if (this.ventanaEdicionDisco.txtCantante.getText().equals((String)sheet.getCell(1, fila).getContents())
							&& this.ventanaEdicionDisco.txtGenero.getText().equals((String)sheet.getCell(2, fila).getContents()))
						
						data.add( new Cancion(
									(String)sheet.getCell(0, fila).getContents(), // NOMBRE
									(String)sheet.getCell(1, fila).getContents(), // CANTANTE
									(String)sheet.getCell(2, fila).getContents(), // GENERO
									Integer.parseInt((String)sheet.getCell(3, fila).getContents()), // DURACION
									"DiscoFisico") // TIPO
						);
				}
				this.ventanaCargaCancion.dispose();
				if (!data.isEmpty())
					cargarCancionesExcelEdicionDisco(data);
				else
					JOptionPane.showMessageDialog(null, "No se han agregado canciones "
							+ "ya que no coinciden con el genero y el cantante del disco", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			} else if (seleccion == JFileChooser.ERROR_OPTION) {
				this.ventanaCargaCancion.dispose();
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error durante la carga de archivo", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			} else {
				this.ventanaCargaCancion.dispose();
				JOptionPane.showMessageDialog(null, "No se ha podido cargar el archivo", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe ingresar primero la informacion del disco", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Muestra la ventana de registro del programa
	 */
	public void mostrarVentanaRegistroPrograma() { 
		if (!this.radioEmisora.listaLocutores.isEmpty()) {
			this.ventanaMenuPrincipal.ventanaRegistroPrograma.setVisible(true);
			cargarLocutoresComboBox();
		} else {
			JOptionPane.showMessageDialog(null, "Deben existir como minimo un locutor para el registro de un programa", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Crea el programa con los datos ingresados 
	 */
	public void crearPrograma() {
		Programa programa = null;
		VentanaRegistroPrograma vRegistro = this.ventanaMenuPrincipal.ventanaRegistroPrograma;
		if (vRegistro.validarCampos()) {
			programa = new Programa(vRegistro.txtNombre.getText(), 
															vRegistro.txtHorario.getText(),
															Integer.parseInt(vRegistro.txtDuracion.getText()),
															vRegistro.txtGenero.getText(), 
															this.radioEmisora.listaLocutores.get(vRegistro.cmbxLocutor.getSelectedIndex()));
			this.radioEmisora.listaProgramas.add(programa);
			vRegistro.cerrarVentana();
			mostrarLista(this.radioEmisora.listaProgramas);
			registroUnicoElementoPrograma(programa);
		} else {
			JOptionPane.showMessageDialog(null, "Debe ingresar cada uno de los campos en forma correcta", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}	

	/**
	 * Obtiene los datos de la tabla programa
	 * @return programa
	 */
	public Programa obtenerProgramaTabla() {
		Programa programa = null;
		if (this.ventanaMenuPrincipal.pnlPrograma.tblPrograma.getSelectedRow() != -1)
			programa = this.radioEmisora.listaProgramas.get(this.ventanaMenuPrincipal.pnlPrograma.tblPrograma.getSelectedRow());
		if (programa == null) 
			JOptionPane.showMessageDialog(null, "No hay programas a modificar o no se han seleccionado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		return programa;
	}

	/**
	 * Elimina el programa seleccionado en el JTable
	 */
	public void eliminarProgramaTabla() {
		if (!this.radioEmisora.listaProgramas.isEmpty() && this.ventanaMenuPrincipal.pnlPrograma.tblPrograma.getSelectedRow() != -1) {
			DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlPrograma.tblPrograma.getModel();
			int indiceAEliminar = this.ventanaMenuPrincipal.pnlPrograma.tblPrograma.getSelectedRow();
			this.radioEmisora.listaProgramas.remove(indiceAEliminar);
			modelo.removeRow(indiceAEliminar);
			mostrarLista(this.radioEmisora.listaProgramas);
		} else 
			JOptionPane.showMessageDialog(null, "\"No hay programas a eliminar o no se han seleccionado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Reemplaza el locutor seleccionado
	 * @param nombreSeleccionadoCombo
	 * @return
	 */
	public Locutor locutorAReemplazar(String nombreSeleccionadoCombo) {
		Locutor locutor = null;
		for (int i = 0; i < this.radioEmisora.listaLocutores.size(); i++)
			if (this.radioEmisora.listaLocutores.get(i).getNombre().equals(nombreSeleccionadoCombo))
				locutor = this.radioEmisora.listaLocutores.get(i);
		return locutor;
	}
	
	/**
	 * Guarda el programa luego de ser modificado 
	 */
	public void guardarPrograma() {
		if (this.ventanaEdicionPrograma.validarCampos()) {
			DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlPrograma.tblPrograma.getModel();
			int indice = this.ventanaMenuPrincipal.pnlPrograma.tblPrograma.getSelectedRow();
			this.radioEmisora.listaProgramas.remove(indice);
			modelo.removeRow(indice);
			Locutor nuevoLocutor = locutorAReemplazar((String)this.ventanaEdicionPrograma.cmbxLocutor.getSelectedItem());
			Programa programa = new Programa(
					this.ventanaEdicionPrograma.txtNombre.getText(), 
					this.ventanaEdicionPrograma.txtHorario.getText(),
					Integer.parseInt(this.ventanaEdicionPrograma.txtDuracion.getText()),
					this.ventanaEdicionPrograma.txtGenero.getText(),
					nuevoLocutor
					);
					
			this.radioEmisora.listaProgramas.add(programa);
			registroUnicoElementoPrograma(programa);
			this.ventanaEdicionPrograma.dispose();
			this.ventanaEdicionPrograma.limpiarCampos();
		} else {
			if (!this.ventanaEdicionPrograma.validarCampos()) 
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		

	}
	
	/**
	 * Muestra la Ventana de edicion del programa
	 * @param programa
	 */
	public void cargarVentanaEdicionPrograma(Programa programa) {
		if (programa != null) {
			// carga cada dato del programa
			
			this.ventanaEdicionPrograma.txtNombre.setText(programa.getNombre());
			this.ventanaEdicionPrograma.txtHorario.setText(programa.getHorario());
			this.ventanaEdicionPrograma.txtDuracion.setText(String.valueOf( programa.getDuracion()));
			this.ventanaEdicionPrograma.txtGenero.setText(programa.getGenero());
			cargarLocutoresComboBoxModificar(programa);
			//this.ventanaEdicionPrograma.cmbxLocutor.setSelectedIndex(anIndex);
			this.ventanaEdicionPrograma.setVisible(true);
		}
	}
	
	/**
	 * Registra los datos ingresados al programa
	 * @param programa
	 */
	public void registroUnicoElementoPrograma(Programa programa) {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlPrograma.tblPrograma.getModel();
		modelo.addRow(new Object[] {
				programa.getNombre(),
				programa.getHorario(),
				programa.getDuracion(),
				programa.getGenero(),
				programa.getLocutor().getNombre(),
		});
	}
	
	/**
	 * Actualiza la tabla de registro del programa
	 */
	public void actualizarTablaRegistroPrograma() {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlPrograma.tblPrograma.getModel();
		for ( int i = 0; i < this.radioEmisora.listaProgramas.size(); i++) {
			modelo.addRow(new Object[] {
					this.radioEmisora.listaProgramas.get(i).getNombre(),
					this.radioEmisora.listaProgramas.get(i).getHorario(), 
					this.radioEmisora.listaProgramas.get(i).getDuracion(), 
					this.radioEmisora.listaProgramas.get(i).getGenero(), 
					this.radioEmisora.listaProgramas.get(i).getLocutor().getNombre(),
			});
		}
	}
	
	/**
	 * Implementacion de logica para Cancion
	 * 
	 */

	/**
	 * Actualiza la tabla de canciones del programa
	 */
	public void actualizarTablaCanciones() {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlCancion.tblCancion.getModel();
		
		for (int j = 0; j<this.radioEmisora.listaCanciones.size(); j++) 
			modelo.addRow(new Object[] {
					this.radioEmisora.listaCanciones.get(j).getNombre(),
					this.radioEmisora.listaCanciones.get(j).getCantante(),
					this.radioEmisora.listaCanciones.get(j).getGenero(),
					this.radioEmisora.listaCanciones.get(j).getDuracionMinutos(),
					this.radioEmisora.listaCanciones.get(j).getTipo()
			});
	}

	/**
	 * Muestra la ventana de registro de la cancion 
	 */
	public void mostrarVentanaRegistroCancion() { 
		this.ventanaMenuPrincipal.ventanaRegistroCancion.setVisible(true);
	}

	/**
	 * Crea la cancion con los datos ingresados en el Jtext
	 */
	public void crearCancion() {
		Archivo nuevaCancion = null;
		if (this.ventanaMenuPrincipal.ventanaRegistroCancion.validarCampos()) {
			nuevaCancion = new Archivo(
					this.ventanaMenuPrincipal.ventanaRegistroCancion.txtAlbum.getText(), 
					this.ventanaMenuPrincipal.ventanaRegistroCancion.txtNombre.getText(), 
					this.ventanaMenuPrincipal.ventanaRegistroCancion.txtCantante.getText(),
					this.ventanaMenuPrincipal.ventanaRegistroCancion.txtGenero.getText(),
					Integer.parseInt(this.ventanaMenuPrincipal.ventanaRegistroCancion.txtDuracionCancion.getText()),
					this.ventanaMenuPrincipal.ventanaRegistroCancion.txtRuta.getText(),
					"Archivo");
					
			this.radioEmisora.listaCanciones.add(nuevaCancion);
			this.ventanaMenuPrincipal.ventanaRegistroCancion.dispose();
			this.registroUnicoElementoCancion(nuevaCancion);
			this.ventanaMenuPrincipal.ventanaRegistroCancion.limpiarCampos();
			
		} else {
			if (!this.ventanaMenuPrincipal.ventanaRegistroCancion.validarCampos()) 
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	/**
	 * Ontiene la cancion de la tabla 
	 * @return cancion
	 */
	public Archivo obtenerCancionTabla() {
		Archivo cancion = null;
	    if (this.ventanaMenuPrincipal.pnlCancion.tblCancion.getSelectedRow() != -1 && this.radioEmisora.listaCanciones.size() != 0)
	    	cancion = (Archivo) this.radioEmisora.listaCanciones.get(this.ventanaMenuPrincipal.pnlCancion.tblCancion.getSelectedRow());
		return cancion;
	}
	
	/**
	 * Elimina la cancion seleccionada de la tabla del panel cancion
	 */
	public void eliminarCancionTabla() {
		if (!this.radioEmisora.listaCanciones.isEmpty() && this.ventanaMenuPrincipal.pnlCancion.tblCancion.getSelectedRow() != -1) {
			DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlCancion.tblCancion.getModel();
			int indiceAEliminar = this.ventanaMenuPrincipal.pnlCancion.tblCancion.getSelectedRow();
			this.radioEmisora.listaCanciones.remove(indiceAEliminar);
			modelo.removeRow(indiceAEliminar);
			mostrarLista(this.radioEmisora.listaCanciones);
		} else 
			JOptionPane.showMessageDialog(null, "No hay canciones registradas o no hay seleccionadas", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Carga la ventana de edicion cancion con los datos de cada cancion
	 * @param cancion
	 */
	public void cargarVentanaEdicionCancion(Archivo cancion) {
		if (cancion != null) {
			
			// carga cada dato del Cancion
			this.ventanaEdicionCancion.txtAlbum.setText(cancion.getAlbum());
			this.ventanaEdicionCancion.txtNombre.setText(cancion.getNombre());
			this.ventanaEdicionCancion.txtCantante.setText(cancion.getCantante());
			this.ventanaEdicionCancion.txtRuta.setText(cancion.getRuta());
			this.ventanaEdicionCancion.txtGenero.setText(cancion.getGenero());
			this.ventanaEdicionCancion.txtDuracion.setText(String.valueOf(cancion.getDuracionMinutos()));
			//this.ventanaEdicionCancion.cmbxLocutor.setSelectedIndex(anIndex);
			this.ventanaEdicionCancion.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "No hay canciones o no hay seleccionadas", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		
}
	
	/**
	 * Registra solo un elemento a las canciones
	 * @param cancion
	 */
	public void registroUnicoElementoCancion(Archivo cancion) {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlCancion.tblCancion.getModel();
		modelo.addRow(new Object[] {
				
				cancion.getNombre(),
				cancion.getCantante(),
				cancion.getGenero(),
				cancion.getDuracionMinutos(),
				
				cancion.getTipo()
		});
	}
	
	/**
	 * Actualiza la tabla despues del registro de la cancion
	 */
	public void actualizarTablaRegistroCancion() {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlCancion.tblCancion.getModel();
		for ( int i = 0; i < this.radioEmisora.listaCanciones.size(); i++) {
			modelo.addRow(new Object[] {
					this.radioEmisora.listaCanciones.get(i).getNombre(),
					this.radioEmisora.listaCanciones.get(i).getCantante(), 
					this.radioEmisora.listaCanciones.get(i).getDuracionMinutos(), 
					this.radioEmisora.listaCanciones.get(i).getGenero()
			});
		}
	}
	

	/**
	 * Guarda la cancion luego de ser modificada 
	 */
	public void guardarCancion() {
		if (this.ventanaEdicionCancion.validarCampos()) {
			DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlCancion.tblCancion.getModel();
			int indice = this.ventanaMenuPrincipal.pnlCancion.tblCancion.getSelectedRow();
			this.radioEmisora.listaCanciones.remove(indice);
			modelo.removeRow(indice);
			Archivo cancion = new Archivo(
					this.ventanaEdicionCancion.txtAlbum.getText(), 
					this.ventanaEdicionCancion.txtNombre.getText(), 
					this.ventanaEdicionCancion.txtCantante.getText(),
					this.ventanaEdicionCancion.txtGenero.getText(),
					Integer.parseInt(this.ventanaEdicionCancion.txtDuracion.getText()),
					this.ventanaEdicionCancion.txtRuta.getText(),
					"Archivo");
			this.radioEmisora.listaCanciones.add(cancion);
			registroUnicoElementoCancion(cancion);
			this.ventanaEdicionCancion.dispose();
			this.ventanaEdicionCancion.limpiarCampos();
		} else {
			if (!this.ventanaEdicionCancion.validarCampos()) 
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/*
	 * Implementacion de logica para Disco
	 * 
	 */
	
	/**
	 * Crea la lista de general de las canciones
	 * @param lista
	 */
	public void cargarListaCancionesDiscos_ListaCancionesGeneral(ListaCanciones lista) { 
		for (int i = 0; i<lista.size(); ++i)
			this.radioEmisora.listaCanciones.add(lista.get(i));
	}
	
	/**
	 * Limpia los espacios de la tabla de canciones 
	 */
	public void limpiarTablaCancionesDiscoRegistro() {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaRegistroDisco.table.getModel();
		for (int i = 0; i<modelo.getRowCount(); ++i) 
			modelo.removeRow(0);	
		this.ventanaRegistroDisco.lblImagen.setIcon(null);
	}
	
	/**
	 * Carga las canciones de la tabla de tabla  
	 * @return data
	 */
	public ListaCanciones cargarCancionesEdicionTabla() {
		ListaCanciones data = new ListaCanciones();
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaEdicionDisco.table.getModel();
		int filas = modelo.getRowCount();
		for (int fila=0; fila < filas; fila++) {
			data.add( new Cancion(
					(String) modelo.getValueAt(fila, 0), 
					(String) modelo.getValueAt(fila, 1), 
					(String) modelo.getValueAt(fila, 2), 
					(int) modelo.getValueAt(fila, 3),
					"Disco Fisico"
			));
		}
		//////////////////////actualizarTablaCanciones();
		return data;
	}
	
	/**
	 * Carga las canciones registradas a la tabla
	 * @return data
	 */
	public ListaCanciones cargarCancionesRegistroTabla() {
		ListaCanciones data = new ListaCanciones();
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaRegistroDisco.table.getModel();
		int filas = modelo.getRowCount();
		for (int fila=0; fila < filas; fila++) {
			data.add( new Cancion(
					(String) modelo.getValueAt(fila, 0), 
					(String) modelo.getValueAt(fila, 1), 
					(String) modelo.getValueAt(fila, 2), 
					(int) modelo.getValueAt(fila, 3),
					"Disco Fisico"
			));
		}
		return data;
	}
	
	/**
	 * Carga los discos registradas a la tabla
	 * @param cancion
	 */
	public void cargarCancionTablaRegistroDisco(Cancion cancion) {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaRegistroDisco.table.getModel();
		modelo.addRow(new Object[] {
				cancion.getNombre(), cancion.getCantante(), cancion.getGenero(), cancion.getDuracionMinutos(), cancion.getTipo()
		});
	}
	
	/**
	 * Carga las canciones para editarlas
	 * @param cancion
	 */
	public void cargarCancionTablaEdicionDisco(Cancion cancion) {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaEdicionDisco.table.getModel();
		modelo.addRow(new Object[] {
				cancion.getNombre(), cancion.getCantante(), cancion.getGenero(), cancion.getDuracionMinutos(), cancion.getTipo()
		});
	}
	
	/**
	 * Agrega las canciones al disco que se esta creando 
	 */
	public void agregarCancionDisco() {
		Cancion cancion = null;
		if (this.ventanaRegistrarCancionDisco.validarCampos()) {
			cancion = new Cancion (
					this.ventanaRegistrarCancionDisco.txtNombre.getText(),
					this.ventanaRegistrarCancionDisco.txtCantante.getText(),
					this.ventanaRegistrarCancionDisco.txtGenero.getText(),
					Integer.parseInt(this.ventanaRegistrarCancionDisco.txtDuracionCancion.getText()),
					"Disco Fisico");
			
			cargarCancionTablaRegistroDisco(cancion);
			this.ventanaRegistrarCancionDisco.limpiarCampos();
			this.ventanaRegistrarCancionDisco.cerrarVentana();
		} else 
			JOptionPane.showMessageDialog(null, "Se debe llenar cada uno de los campos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Agrega la cancion de la ventana de edicion del disco
	 */
	public void agregarCancionEdicionDisco() {
		Cancion cancion = null;
		if (this.ventanaRegistrarCancionDisco1.validarCampos() && this.ventanaRegistrarCancionDisco1.validarDuracion()) {
			cancion = new Cancion (
					this.ventanaRegistrarCancionDisco1.txtNombre.getText(),
					this.ventanaRegistrarCancionDisco1.txtCantante.getText(),
					this.ventanaRegistrarCancionDisco1.txtGenero.getText(),
					Integer.parseInt(this.ventanaRegistrarCancionDisco1.txtDuracionCancion.getText()),
					"Disco Fisico");
			cargarCancionTablaEdicionDisco(cancion);
			this.ventanaRegistrarCancionDisco1.limpiarCampos();
			this.ventanaRegistrarCancionDisco1.cerrarVentana();
		} else {
			if (!this.ventanaRegistrarCancionDisco1.validarCampos())
				JOptionPane.showMessageDialog(null, "Se debe llenar cada uno de los campos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			if (!this.ventanaRegistrarCancionDisco1.validarDuracion())
				JOptionPane.showMessageDialog(null, "La duracion solo debe contener numeros", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Muestra la ventana de registro del disco
	 */
	public void mostrarRegistroCancionDisco() {
		if (this.ventanaRegistroDisco.validarCampos()) {
			this.ventanaRegistrarCancionDisco.txtCantante.setText(this.ventanaRegistroDisco.txtCantante.getText());
			this.ventanaRegistrarCancionDisco.txtGenero.setText(this.ventanaRegistroDisco.txtGenero.getText());
			this.ventanaRegistrarCancionDisco.mostrarVentana();
		} else
			JOptionPane.showMessageDialog(null, "Debe ingresar la informacion del disco del primero", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Muestra la ventana del registro de cancion en la ventana de editar disco
	 */
	public void mostrarRegistroCancionEdicionDisco() {
		if (this.ventanaEdicionDisco.validarCampos()) {
			this.ventanaRegistrarCancionDisco1.txtCantante.setText(this.ventanaEdicionDisco.txtCantante.getText());
			this.ventanaRegistrarCancionDisco1.txtGenero.setText(this.ventanaEdicionDisco.txtGenero.getText());
			this.ventanaRegistrarCancionDisco1.mostrarVentana();
		} else
			JOptionPane.showMessageDialog(null, "Debe ingresar la informacion del disco del primero", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Carga la imagen que se le asigna al disco, el cual estaba anteriormente en NULL
	 * @param imagen
	 */
	public void cargarImagenPanelDisco(Icon imagen) {
		
		if (this.ventanaMenuPrincipal.pnlDisco.table.getModel().getRowCount() == 0 ||
				this.radioEmisora.listaDiscos.isEmpty() || 
				this.ventanaMenuPrincipal.pnlDisco.table.getSelectedRow() == -1 || 
				imagen == null) {
			this.ventanaMenuPrincipal.pnlDisco.lblImagenDisco.setIcon(null);
		} else {
			this.ventanaMenuPrincipal.pnlDisco.lblImagenDisco.setIcon(imagen);
		}
	}
	
	/**
	 * Coloca la imagen del disco en la ventana de edicion
	 * @param imagen
	 */
	public void cargarImagenEdicionDisco(Icon imagen) {
		this.ventanaEdicionDisco.lblImagen.setIcon(imagen);
	}
	
	/**
	 * Coloca la imagen en el panel del Disco, el cual fue seleccionado en la edicion del Disco
	 * @param imagen
	 */
	public void editarImagenDisco(Icon imagen) {
		
		if (this.radioEmisora.listaDiscos.isEmpty() || 
				this.ventanaMenuPrincipal.pnlDisco.table.getSelectedRow() == -1 || 
				imagen == null) {
			this.ventanaMenuPrincipal.pnlDisco.lblImagenDisco.setIcon(null);
		} else {
			this.ventanaMenuPrincipal.pnlDisco.lblImagenDisco.setIcon(imagen);
		}
	}
	
	/**
	 * Obtiene la imagen del Disco
	 * @return imagenCaratula
	 */
	public Icon obtenerImagenDisco() {
		if (this.ventanaMenuPrincipal.pnlDisco.table.getSelectedRow() != -1 && !this.radioEmisora.listaDiscos.isEmpty())
			return (Icon) this.radioEmisora.listaDiscos.get(this.ventanaMenuPrincipal.pnlDisco.table.getSelectedRow()).getImagenCaratula();
		return null;
	}
	
	/**
	 * Escoge la imagen que se quiere cargar
	 */
	public void cargarImagenCaratulaEdicion() { 
	    File fichero;
	    
	    JFrame ventana = new JFrame();
	    ventana.setUndecorated(true);
	    JFileChooser ventanaEleccionImagen = new JFileChooser();
	    ventana.add(ventanaEleccionImagen);
	    FileNameExtensionFilter filtro =
	            new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
	    ventanaEleccionImagen.setFileFilter(filtro);
	    int resultado = ventanaEleccionImagen.showOpenDialog(ventana);
	    
	    if(JFileChooser.APPROVE_OPTION == resultado) {
	        fichero= ventanaEleccionImagen.getSelectedFile();
	        try {
	            ImageIcon icon= new ImageIcon(fichero.toString());
	            Icon icono = new ImageIcon(icon.getImage().
	                    getScaledInstance(this.ventanaEdicionDisco.lblImagen.getWidth(),
	                    		this.ventanaEdicionDisco.lblImagen.getHeight(), 
	                    		Image.SCALE_DEFAULT));
	            this.ventanaEdicionDisco.imagenCargada = icono; /// asignacion de imagen a cargar al disco
	            this.ventanaEdicionDisco.lblImagen.setIcon(this.ventanaEdicionDisco.imagenCargada);
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al abrir la imagen", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	        }
	    } else {
	    	JOptionPane.showMessageDialog(null, "No se ha cargado la imagen", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	
	/**
	 * Selecciona la imagen del disco que se quiere colocar 
	 */
	public void cargarImagenCaratula() { 
	    File fichero;
	    
	    JFrame ventana = new JFrame();
	    ventana.setUndecorated(true);
	    JFileChooser ventanaEleccionImagen = new JFileChooser();
	    ventana.add(ventanaEleccionImagen);
	    FileNameExtensionFilter filtro =
	            new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
	    ventanaEleccionImagen.setFileFilter(filtro);
	    int resultado = ventanaEleccionImagen.showOpenDialog(ventana);
	    
	    if(JFileChooser.APPROVE_OPTION == resultado) {
	        fichero= ventanaEleccionImagen.getSelectedFile();
	        try {
	            ImageIcon icon= new ImageIcon(fichero.toString());
	            Icon icono = new ImageIcon(icon.getImage().
	                    getScaledInstance(this.ventanaRegistroDisco.lblImagen.getWidth(),
	                    		this.ventanaRegistroDisco.lblImagen.getHeight(), 
	                    		Image.SCALE_DEFAULT));
	            this.ventanaRegistroDisco.imagenCargada = icono; /// asignacion de imagen a cargar al disco
	            this.ventanaRegistroDisco.lblImagen.setIcon(this.ventanaRegistroDisco.imagenCargada);
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al abrir la imagen", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	        }
	    } else {
	    	JOptionPane.showMessageDialog(null, "No se ha cargado la imagen", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	
	/**
	 * Muestra la Ventana de registro del disco
	 */
	public void mostrarVentanaRegistroDisco() { 
		this.ventanaRegistroDisco.setVisible(true);
		this.ventanaRegistroDisco.lblImagen.setIcon(null);
	}	
	
	/**
	 * Muestra la ventana de Edicion disco
	 */
	public void cargarVentanaEdicionDisco() {
		this.ventanaEdicionDisco.setVisible(true);
		this.ventanaEdicionDisco.lblImagen.setIcon(null);
	}
	
	/**
	 * Carga las canciones de la lista de canciones en la tabla principal
	 */
	public void cargarCancionesTablaPrincipal() {
		ListaCanciones lista = this.radioEmisora.listaCanciones;
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlCancion.tblCancion.getModel();
		this.ventanaMenuPrincipal.pnlCancion.limpiarTabla();
		
		for (int i=0; i<lista.size(); i++)
			modelo.addRow(new Object[] {
					(String)lista.get(i).getNombre(), 
					(String)lista.get(i).getCantante(), 
					(String)lista.get(i).getGenero(), 
					String.valueOf(lista.get(i).getDuracionMinutos()),
					(String)lista.get(i).getTipo()
			});
	}
	
	/**
	 * Crea el disco con la informacion captada en la ventana de registro del disco
	 */
	public void crearDisco() {
		DiscoFisico nuevoDiscoFisico = null;
		if (this.ventanaRegistroDisco.validarCampos()) {
			ListaCanciones listaDisco = cargarCancionesRegistroTabla();
			nuevoDiscoFisico = new DiscoFisico(
						this.ventanaRegistroDisco.txtNombreDisco.getText(),
						this.ventanaRegistroDisco.txtCantante.getText(),
						this.ventanaRegistroDisco.txtAnioEdicion.getText(),
						this.ventanaRegistroDisco.txtGenero.getText(),
						this.ventanaRegistroDisco.txtUbicacion.getText(),
						listaDisco, //LISTA CANCIONES
						this.ventanaRegistroDisco.imagenCargada); //
			
			cargarListaCancionesDiscos_ListaCancionesGeneral(listaDisco);
			cargarCancionesTablaPrincipal();
			limpiarTablaCancionesDiscoRegistro();
			
			this.radioEmisora.listaDiscos.agregarDisco(nuevoDiscoFisico);
			this.ventanaRegistroDisco.dispose();
			mostrarLista(this.radioEmisora.listaDiscos);
			this.ventanaRegistroDisco.limpiarCampos();
			this.registroUnicoElementoDisco(nuevoDiscoFisico);
		}else {
			JOptionPane.showMessageDialog(null, "Debe ingresar cada uno de los campos en forma correcta", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Obtiene la tabla del registro del disco.
	 * @return
	 */
	public DiscoFisico obtenerDiscoTabla() {
		DiscoFisico disco = null;
		if (this.ventanaMenuPrincipal.pnlDisco.table.getSelectedRow() != -1)
			disco = this.radioEmisora.listaDiscos.get(this.ventanaMenuPrincipal.pnlDisco.table.getSelectedRow());
		return disco;
	}
	
	/**
	 * Recibe dos canciones para comparar si son similares 
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static boolean cancionesIguales(Cancion c1, Cancion c2) {
		return c1.getNombre().equals(c2.getNombre())
				&& c1.getCantante().equals(c2.getCantante())
				&& c1.getGenero().equals(c2.getGenero())
				&& c1.getTipo().equals(c2.getTipo());
	}
	
	/**
	 * Este metodo determina las canciones que se deben eliminar cuando 
	 * se oprime el boton de eliminar del Disco  
	 * @param disco
	 * @return cancionesPorBorrar
	 */
	public ArrayList<Integer> cancionesDelDiscoPorEliminar(DiscoFisico disco) {
		ArrayList<Integer> cancionesPorBorrar = new ArrayList<Integer>();
		int cantidadCancionesDisco = disco.getListaCanciones().size();
		int cantidadOriginal = this.radioEmisora.listaCanciones.size();
		ListaCanciones listaDisco = disco.getListaCanciones();
		ListaCanciones listaOriginal = this.radioEmisora.listaCanciones;
		
		for (int i=0; i < cantidadCancionesDisco; i++) {
			for (int j=0; j<cantidadOriginal; j++) {
				if (cancionesIguales(listaDisco.get(i), listaOriginal.get(j) ))
					cancionesPorBorrar.add(j);
			}
		}
		
		return cancionesPorBorrar;
	}
	
	/**
	 * Borra las cacniones en el listado de las canciones en general
	 * @param indicesAEliminar
	 */
	public void eliminarCancionesDiscoGeneral(ArrayList<Integer> indicesAEliminar) {
		if(indicesAEliminar.isEmpty())
			return;
		
		System.out.println("LARGO DE LISTA ELIMINAR"+indicesAEliminar.size());// Depuracion 
		for (int indiceMaximo = indicesAEliminar.size()-1; indiceMaximo >= 0; indiceMaximo--) {
			int indice = indicesAEliminar.get(indiceMaximo);
			System.out.println("\nPRUEBA:" +indice);
			this.radioEmisora.listaCanciones.remove(indice);
			indicesAEliminar.remove(indiceMaximo);
			
			if(indicesAEliminar.isEmpty())
				break;
			
		}
	}
	
	/**
	 * Eliminar el disco de la tabla del panel del disco
	 */
	public void guardarEdicionDiscoTabla(DiscoFisico disco, int indiceAEliminar) {
		
		eliminarCancionesDiscoGeneral(cancionesDelDiscoPorEliminar(disco));
		
		ListaCanciones listaDisco = cargarCancionesEdicionTabla();
		DiscoFisico nuevoDiscoFisico = new DiscoFisico(
					this.ventanaEdicionDisco.txtNombreDisco.getText(),
					this.ventanaEdicionDisco.txtCantante.getText(),
					this.ventanaEdicionDisco.txtAnioEdicion.getText(),
					this.ventanaEdicionDisco.txtGenero.getText(),
					this.ventanaEdicionDisco.txtUbicacion.getText(),
					listaDisco, //LISTA CANCIONES
					this.ventanaEdicionDisco.imagenCargada); //
		cargarListaCancionesDiscos_ListaCancionesGeneral(listaDisco);
		
		this.radioEmisora.listaDiscos.remove(indiceAEliminar);
		DefaultTableModel modelo =(DefaultTableModel) this.ventanaMenuPrincipal.pnlDisco.table.getModel();
		registroUnicoElementoDisco(nuevoDiscoFisico);
		modelo.removeRow(indiceAEliminar);
		this.ventanaEdicionDisco.cerrarVentana();
		cargarCancionesTablaPrincipal();
		mostrarLista(this.radioEmisora.listaDiscos);
	}
	
	/**
	 * Eliminar el disco de la tabla del panel del disco
	 */
	public void eliminarDiscoTabla() {
		if (!this.radioEmisora.listaDiscos.isEmpty() && this.ventanaMenuPrincipal.pnlDisco.table.getSelectedRow() != -1) {
			DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlDisco.table.getModel();
			int indiceAEliminar = this.ventanaMenuPrincipal.pnlDisco.table.getSelectedRow();
			
			DiscoFisico discoPorEliminar = obtenerDiscoTabla();
			eliminarCancionesDiscoGeneral(cancionesDelDiscoPorEliminar(discoPorEliminar));
			cargarCancionesTablaPrincipal();
			this.ventanaRegistroDisco.limpiarTabla();
			
			this.radioEmisora.listaDiscos.remove(indiceAEliminar);
			modelo.removeRow(indiceAEliminar);
			mostrarLista(this.radioEmisora.listaDiscos);
			
		} else 
			JOptionPane.showMessageDialog(null, "No hay discos a eliminar o no se han seleccionado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Carga las canciones a la ventana de edicion del disco
	 * @param discoPorCargar
	 */
	public void cargarCancionesDiscoEdicion(DiscoFisico discoPorCargar) {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaEdicionDisco.table.getModel();
		for (int i = 0; i<modelo.getRowCount(); i++)
			modelo.removeRow(0);
		for (int j = 0; j<discoPorCargar.getListaCanciones().size(); ++j) 
			modelo.addRow(new Object[] {
					discoPorCargar.getListaCanciones().get(j).getNombre(),
					discoPorCargar.getListaCanciones().get(j).getCantante(),
					discoPorCargar.getListaCanciones().get(j).getGenero(),
					discoPorCargar.getListaCanciones().get(j).getDuracionMinutos(),
					discoPorCargar.getListaCanciones().get(j).getTipo()
			});
	}

	/**
	 * Toma un objeto de la tabla y mete los datos en la ventana de modificar
	 * @param disco
	 */
	public void cargarVentanaEdicionDisco(DiscoFisico disco) {
		if(this.ventanaMenuPrincipal.pnlDisco.table.getSelectedRow() != -1) {
			if ( disco != null) {
				// carga cada dato del disco
				this.ventanaEdicionDisco.txtNombreDisco.setText(disco.getNombreDisco());
				this.ventanaEdicionDisco.txtCantante.setText(disco.getCantante());
				this.ventanaEdicionDisco.txtAnioEdicion.setText(disco.getAnioEdicion());
				this.ventanaEdicionDisco.txtGenero.setText(disco.getGeneroMusical());
				this.ventanaEdicionDisco.txtUbicacion.setText(disco.getUbicacion());
				cargarImagenEdicionDisco(disco.getImagenCaratula());
				this.ventanaEdicionDisco.setVisible(true);
				cargarCancionesDiscoEdicion(disco);
			}
		}else
			JOptionPane.showMessageDialog(null, "No hay discos a modificar o no se han seleccionado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Agrega un registro individual del Disco
	 * @param disco
	 */
	public void registroUnicoElementoDisco(DiscoFisico disco) {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlDisco.table.getModel();
		modelo.addRow(new Object[] {
				disco.getNombreDisco(),
				disco.getCantante(),
				disco.getAnioEdicion(),
				disco.getGeneroMusical(),
				disco.getUbicacion(),
		});
		
	}
	
	/**
	 * Actualiza la tabla de registro del disco
	 */
	public void actualizarTablaRegistroDisco() {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlDisco.table.getModel();
		for ( int i = 0; i < this.radioEmisora.listaDiscos.size(); i++) {
			modelo.addRow(new Object[] {
					this.radioEmisora.listaDiscos.get(i).getNombreDisco(),
					this.radioEmisora.listaDiscos.get(i).getCantante(),
					this.radioEmisora.listaDiscos.get(i).getAnioEdicion(), 
					this.radioEmisora.listaDiscos.get(i).getGeneroMusical(), 
					this.radioEmisora.listaDiscos.get(i).getUbicacion(), 
					//this.radioEmisora.listaCanciones.get(i).getLocutor(),
			});
		}
	}
		
	/**
	 * Borra los campos de la ventana de Edicion Disco
	 */
	public void borrarCampos() {
		this.ventanaEdicionDisco.limpiarCampos();
	}
	
	/**
	 * Implementacion logica Consulta,
	 * Valida que los campos no esten vacios
	 *  verifica que los campos no esten vacios, y si se necesita otras validaciones irian aca
	 */
	public boolean validarRegistroEmisora() {
		return !this.ventanaRegistroEmisora.txtNombre.getText().equals("") && !this.ventanaRegistroEmisora.txtDireccionWeb.getText().equals("") 
				&& !this.ventanaRegistroEmisora.txtFrecuencia.getText().equals("") && !this.ventanaRegistroEmisora.txtDireccion.getText().equals("");
	}
	
	
	/**
	 * Implementacion de logica para Enviar Correo
	 * Envia el correo al email del locutor que crea la playlist
	 * @param destinatario
	 * @param emisora
	 * @param mensaje
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void enviarCorreo(String destinatario, String emisora, String mensaje) throws AddressException, MessagingException {
		// Primera 
		System.out.println("\nConfiguraciones del correo");
		Properties mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Configuraciones exitosas");
 
		// Segunda
		System.out.println("\n\nSesion del email");
		Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		MimeMessage generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("radioemisoraemail@gmail.com"));
		generateMailMessage.setSubject("Creacion de la Playlist");
		String emailBody = mensaje + "<br><br> Saludos, <br>" + emisora + ".";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Cargada exitosamente");
 
		// Tercera
		System.out.println("\n\nObtener sesion y envio del mail");
		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "radioemisoraemail@gmail.com", "radioEmail");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
	
	
	/**********************************************************************************************************/
	/**
	 * Implementacion de logica para Consultar
	 * 
	 * 
	 * 
	 */
	
	/**
	 * Consulta las canciones por genero o por cantante
	 */
	public void consultarCanciones() {
		DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlConsultar.table.getModel();
		this.ventanaMenuPrincipal.pnlConsultar.limpiarTabla();
		
		if(!radioEmisora.listaCanciones.isEmpty()) {
			String consulta = this.ventanaMenuPrincipal.pnlConsultar.txtConsultar.getText();
			if(this.ventanaMenuPrincipal.pnlConsultar.cmbxConsultar.getSelectedIndex() == 0) {
				for (int i=0; i<this.radioEmisora.listaCanciones.size(); i++)
					if (this.radioEmisora.listaCanciones.get(i).getGenero().equals(consulta)) {
							modelo.addRow(new Object[] {
								this.radioEmisora.listaCanciones.get(i).getNombre(),
								this.radioEmisora.listaCanciones.get(i).getCantante(), 
								this.radioEmisora.listaCanciones.get(i).getGenero(), 
								this.radioEmisora.listaCanciones.get(i).getDuracionMinutos()
							}); // carga de los elementos a la tabla
					}
			} else if (this.ventanaMenuPrincipal.
					pnlConsultar.cmbxConsultar.getSelectedIndex() == 1){
				for (int i=0; i<this.radioEmisora.listaCanciones.size(); i++) 
					if (this.radioEmisora.listaCanciones.get(i).getCantante().equals(consulta)) {
							modelo.addRow(new Object[] {
								this.radioEmisora.listaCanciones.get(i).getNombre(),
								this.radioEmisora.listaCanciones.get(i).getCantante(), 
								this.radioEmisora.listaCanciones.get(i).getGenero(), 
								this.radioEmisora.listaCanciones.get(i).getDuracionMinutos()
							}); // carga de los elementos a la tabla		
					}
			}
		}else 
			JOptionPane.showMessageDialog(null, "No hay canciones a consultar");	

}
		

	/**
	 * Implementa la reproduccion de la cancion, por la ruta del archivo
	 * 
	 **/
	public void reproducirCancion() {
		int indiceAReproducir = this.ventanaMenuPrincipal.pnlCancion.tblCancion.getSelectedRow();
		Archivo cancionAReproducir = (Archivo) this.radioEmisora.listaCanciones.get(indiceAReproducir);
		
		try {
			
			if (this.ventanaMenuPrincipal.pnlCancion.tblCancion.getSelectedRow() != -1 && !this.radioEmisora.listaCanciones.isEmpty()) {
				DefaultTableModel modelo = (DefaultTableModel) this.ventanaMenuPrincipal.pnlCancion.tblCancion.getModel();
				if (this.radioEmisora.listaCanciones.get(indiceAReproducir) instanceof Archivo) {
					cancionAReproducir = (Archivo) this.radioEmisora.listaCanciones.get(indiceAReproducir);
					try {this.ventanaReproducirCancion = new VentanaReproducirCancion();
					} catch (JavaLayerException e) {e.printStackTrace();}
					this.ventanaReproducirCancion.ruta = cancionAReproducir.getRuta();
					this.ventanaReproducirCancion.abrirVentana();
				} else 
					JOptionPane.showMessageDialog(null, "No se encontró la ruta del archivo.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
			else 
				JOptionPane.showMessageDialog(null, "No se encontró la ruta del archivo.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Esta cancion no se puede reproducir, no tiene una ruta valida", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}