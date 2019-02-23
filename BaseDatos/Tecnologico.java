package BaseDeDatos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.Action;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import Modelo.Paciente;

//import Modelo.Paciente;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Tecnologico extends JFrame {
	 JDesktopPane principal;
	ListaEstudiante lista=new ListaEstudiante();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tecnologico frame = new Tecnologico();
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
	public Tecnologico() {
		setTitle("TECNOLOGICO DE ZACATECAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 800, 600);
		principal=new JDesktopPane();
		principal.setBackground(Color.LIGHT_GRAY);
		setContentPane(principal);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				JFileChooser dialogo=new JFileChooser();
				if (dialogo.showSaveDialog(principal)==JFileChooser.APPROVE_OPTION) {
				      File archivo =dialogo.getSelectedFile();	
				      if  (archivo!=null){
				    	  FileOutputStream fos=new FileOutputStream(archivo);
				    	  ObjectOutputStream oos=new ObjectOutputStream(fos);
				    	  //Escribe cada objeto paciente en el archivo
				    	  for (Estudiante p:lista.estudiantes){
				    		  oos.writeObject(p);
				    	  }
				    	  fos.close();
				    	  JOptionPane.showMessageDialog(principal,"Archivo Guardado con Exito");
				      }
				}
				} catch (Exception ex){
					JOptionPane.showMessageDialog(principal,"Error al guardar archivo");
				}
			}
		});
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileInputStream fis=null;
				try{
					JFileChooser dialogo=new JFileChooser();
					if (dialogo.showOpenDialog(principal)==JFileChooser.APPROVE_OPTION) {
					      File archivo =dialogo.getSelectedFile();	
					      if  (archivo!=null){
					    	   fis=new FileInputStream(archivo);
					    	  ObjectInputStream ois=new ObjectInputStream(fis);
					    	  lista.estudiantes.clear();//Borra todos los elemtos de la lista
					    	  //Lee cada objeto del archivo y lo escribe en la lista de pacientes
					    	 Estudiante p;
					    	  while (true){
					    		   p=(Estudiante) ois.readObject();
					    		   lista.estudiantes.add(p);
					    	  }
					      }
					}
					} catch (EOFException ex){
						try {
							fis.close();
							JOptionPane.showMessageDialog(principal,"Datos Cargados con Exito");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				catch (Exception ex){
						JOptionPane.showMessageDialog(principal,"Error al abrir archivo");
					}
			}
		});
		mnArchivo.add(mntmAbrir);
		
		JMenu mnCalificacion = new JMenu("Calificacion");
		menuBar.add(mnCalificacion);
		
		JMenuItem mntmEstudiante = new JMenuItem("Estudiante");
		mnCalificacion.add(mntmEstudiante);
		
		JMenuItem mntmMaestro = new JMenuItem("Maestro");
		mnCalificacion.add(mntmMaestro);
		
		JMenu mnHorarios = new JMenu("Horarios");
		menuBar.add(mnHorarios);
		
		JMenuItem mntmEstudiante_1 = new JMenuItem("Estudiante");
		mnHorarios.add(mntmEstudiante_1);
		
		JMenuItem mntmMaestro_1 = new JMenuItem("Maestro");
		mnHorarios.add(mntmMaestro_1);
		
		JMenu mnDatosAlumno = new JMenu("Datos Alumno");
		menuBar.add(mnDatosAlumno);
		
		JMenuItem mntmIngresar = new JMenuItem("Ingresar");
		mnDatosAlumno.add(mntmIngresar);
		
		JMenuItem mntmPedir = new JMenuItem("Pedir");
		mnDatosAlumno.add(mntmPedir);
		
		JMenu mnNoCtrl = new JMenu("No. Ctrl");
		menuBar.add(mnNoCtrl);
		
		JMenu mnSeguroSocial = new JMenu("Seguro social");
		menuBar.add(mnSeguroSocial);
		
		JMenu mnKardex = new JMenu("Kardex");
		menuBar.add(mnKardex);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmCopyright = new JMenuItem("Copyright");
		mnAbout.add(mntmCopyright);
		
		JMenuItem mntmAboutUs = new JMenuItem("About us");
		mnAbout.add(mntmAboutUs);
	}
}
