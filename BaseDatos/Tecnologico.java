package BaseDatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 800, 600);
		principal=new JDesktopPane();
		principal.setBackground(Color.LIGHT_GRAY);
		setContentPane(principal);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnNewMenu.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnNewMenu.add(mntmGuardar);
		
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
