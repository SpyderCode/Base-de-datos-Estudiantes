package BaseDatos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class altaHorario extends JInternalFrame{
	// Obtener el contexto del Frame principal Hospital
	public Tecnologico principal;
	public Estudiante estudiantex = null;
	public JPanel contentPanel;
	private JTextField textClase;
	private JTextField txtNoCtrl;
	private JTextField textNombreProf;
	private JTextField textCred;
	private JTextField txtGrupo;
	private int pos;
	private String hour;

	public altaHorario(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, Tecnologico padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(new Color(255, 140, 0));
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel lblIngresarHorario = new JLabel("Ingresar Horario");
		lblIngresarHorario.setForeground(new Color(139, 0, 0));
		lblIngresarHorario.setFont(new Font("Impact", Font.ITALIC, 57));
		lblIngresarHorario.setBounds(12, 13, 432, 95);
		getContentPane().add(lblIngresarHorario);
		
		JLabel lblParaProfesores = new JLabel("para Profesores");
		lblParaProfesores.setForeground(new Color(0, 0, 0));
		lblParaProfesores.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblParaProfesores.setBounds(12, -12, 159, 44);
		getContentPane().add(lblParaProfesores);
		
		JLabel lblClase = new JLabel("Nombre de la clase");
		lblClase.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblClase.setBounds(22, 134, 167, 26);
		getContentPane().add(lblClase);
		
		textClase = new JTextField();
		textClase.setBounds(230, 138, 147, 22);
		getContentPane().add(textClase);
		textClase.setColumns(10);
		
		JLabel lblNoCtrlDel = new JLabel("No. Ctrl del Estudiante");
		lblNoCtrlDel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNoCtrlDel.setBounds(22, 103, 197, 26);
		getContentPane().add(lblNoCtrlDel);
		
		txtNoCtrl = new JTextField();
		txtNoCtrl.setBounds(230, 107, 116, 22);
		getContentPane().add(txtNoCtrl);
		txtNoCtrl.setColumns(10);
		
		JLabel lblDatos = new JLabel("Datos");
		lblDatos.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDatos.setBounds(654, 13, 78, 45);
		getContentPane().add(lblDatos);
		
		JTextPane textNombre = new JTextPane();
		textNombre.setBounds(625, 63, 120, 22);
		getContentPane().add(textNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombre.setBounds(546, 63, 78, 26);
		getContentPane().add(lblNombre);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCarrera.setBounds(546, 103, 78, 26);
		getContentPane().add(lblCarrera);
		
		JTextPane textCarrera = new JTextPane();
		textCarrera.setBounds(625, 103, 120, 22);
		getContentPane().add(textCarrera);
		
		JLabel lblLunes = new JLabel("Hora de la clase");
		lblLunes.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLunes.setBounds(22, 241, 167, 26);
		getContentPane().add(lblLunes);
		
		JComboBox comboBoxHoraMat = new JComboBox();
		comboBoxHoraMat.setModel(new DefaultComboBoxModel(new String[] {"7:00-8:00", "8:00-9:00", "9:00-10:00", "10:00-11:00", "12:00-13:00", "13:00-14:00"}));
		comboBoxHoraMat.setForeground(new Color(139, 0, 0));
		comboBoxHoraMat.setBackground(new Color(255, 140, 0));
		comboBoxHoraMat.setBounds(193, 245, 78, 22);
		getContentPane().add(comboBoxHoraMat);
		
		JLabel lblNombreDelProfessor = new JLabel("Nombre del Professor");
		lblNombreDelProfessor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombreDelProfessor.setBounds(22, 162, 197, 26);
		getContentPane().add(lblNombreDelProfessor);
		
		textNombreProf = new JTextField();
		textNombreProf.setColumns(10);
		textNombreProf.setBounds(230, 166, 147, 22);
		getContentPane().add(textNombreProf);
		
		JCheckBox chckbxViernes = new JCheckBox("Viernes");
		chckbxViernes.setBounds(293, 244, 113, 25);
		getContentPane().add(chckbxViernes);
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("Images/mapaches.png"));
		label.setBounds(485, 134, 346, 393);
		getContentPane().add(label);
		
		JLabel lblCreditos = new JLabel("Creditos");
		lblCreditos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCreditos.setBounds(22, 202, 83, 26);
		getContentPane().add(lblCreditos);
		
		textCred = new JTextField();
		textCred.setColumns(10);
		textCred.setBounds(99, 206, 44, 22);
		getContentPane().add(textCred);
		
		JLabel lblCred = new JLabel("Grupo");
		lblCred.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCred.setBounds(163, 201, 83, 26);
		getContentPane().add(lblCred);
		
		txtGrupo = new JTextField();
		txtGrupo.setColumns(10);
		txtGrupo.setBounds(227, 206, 44, 22);
		getContentPane().add(txtGrupo);
		
		JComboBox comboBoxHorarioTarde = new JComboBox();
		comboBoxHorarioTarde.setEnabled(false);
		comboBoxHorarioTarde.setModel(new DefaultComboBoxModel(new String[] {"12:00-13:00", "13:00-14:00", "14:00-15:00", "16:00-17:00", "17:00-18:00", "18:00-19:00"}));
		comboBoxHorarioTarde.setForeground(new Color(139, 0, 0));
		comboBoxHorarioTarde.setBackground(new Color(255, 140, 0));
		comboBoxHorarioTarde.setBounds(193, 245, 78, 22);
		getContentPane().add(comboBoxHorarioTarde);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int noctrl=Integer.parseInt(txtNoCtrl.getText());
				
				pos=principal.lista.buscarPosicionEstudiante(noctrl);
				
				String horx=principal.lista.estudiantes.get(pos).getHorario();
				textNombre.setText(""+principal.lista.estudiantes.get(pos).getNombre());
				textCarrera.setText(principal.lista.estudiantes.get(pos).getCarrera());
				
				if(horx.equals("Matutino")) {
					comboBoxHoraMat.setVisible(true);
					comboBoxHoraMat.setEnabled(true);
					comboBoxHorarioTarde.setVisible(false);
					comboBoxHorarioTarde.setEnabled(false);
				}else {
					comboBoxHoraMat.setVisible(false);
					comboBoxHoraMat.setEnabled(false);
					comboBoxHorarioTarde.setVisible(true);
					comboBoxHorarioTarde.setEnabled(true);
					
				}
				
			}
		});
		btnBuscar.setBounds(366, 106, 78, 25);
		getContentPane().add(btnBuscar);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String asignatura=textClase.getText();
				String Profx=textNombreProf.getText();
				char grupox=txtGrupo.getText().charAt(0);
				int credx=Integer.parseInt(txtNoCtrl.getText());
				String horx=principal.lista.estudiantes.get(pos).getHorario();
				
				Materias materia=new Materias(asignatura,Profx,grupox,credx);
				if(horx.equals("Matutino")) {
					hour=(String) comboBoxHoraMat.getItemAt(comboBoxHoraMat.getSelectedIndex());
				}else {
					hour=(String) comboBoxHorarioTarde.getItemAt(comboBoxHorarioTarde.getSelectedIndex());
				}
				
				Horarios hor1=new Horarios("Lunes", hour);
				materia.AltaDia(hor1);
				Horarios hor2=new Horarios("Martes", hour);
				materia.AltaDia(hor2);
				Horarios hor3=new Horarios("Miercoles", hour);
				materia.AltaDia(hor3);
				Horarios hor4=new Horarios("Jueves", hour);
				materia.AltaDia(hor4);
				
				if(chckbxViernes.isSelected()) {
				Horarios hor5=new Horarios("Viernes", hour);
				materia.AltaDia(hor5);
				}
				principal.lista.estudiantes.get(pos).altaMateria(materia);
				System.out.println("Test: "+principal.lista.estudiantes.get(pos).getMateria().get(0).getGrupo());
			}
		});
		btnNewButton.setBounds(326, 288, 97, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(203, 288, 97, 25);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Images/TecNM2017T.png"));
		lblNewLabel.setBounds(0, 288, 472, 221);
		getContentPane().add(lblNewLabel);

		

		setBounds(100, 100, 773, 408);
	}
}