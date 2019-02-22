package BaseDatos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import Vista.Hospital;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AltaEstudiante extends JInternalFrame implements ActionListener{

	private Tecnologico principal;
	private JPanel contentPanel;
	private JTextField txtNoCtrl;
	private JTextField txtEdad;

	public AltaEstudiante(String titulo, boolean tamaño, 
			boolean cerrar, boolean maximizar,
			Tecnologico padre) {
		super(titulo, tamaño,cerrar, maximizar);
		getContentPane().setBackground(new Color(255, 140, 0));
		principal=padre;
		contentPanel=(JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		txtNoCtrl = new JTextField();
		txtNoCtrl.setColumns(10);
		txtNoCtrl.setBounds(295, 87, 284, 20);
		getContentPane().add(txtNoCtrl);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(295, 120, 83, 20);
		getContentPane().add(txtEdad);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBackground(new Color(255, 140, 0));
		rdbtnMasculino.setBounds(437, 121, 85, 23);
		getContentPane().add(rdbtnMasculino);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBackground(new Color(255, 140, 0));
		rdbtnFemenino.setSelected(true);
		rdbtnFemenino.setBounds(524, 121, 85, 23);
		getContentPane().add(rdbtnFemenino);
		
		JTextPane tituloNuevosEstudiantes = new JTextPane();
		tituloNuevosEstudiantes.setText("Nuevos Estudiantes");
		tituloNuevosEstudiantes.setForeground(new Color(139, 0, 0));
		tituloNuevosEstudiantes.setFont(new Font("Impact", Font.ITALIC, 57));
		tituloNuevosEstudiantes.setBackground(new Color(255, 140, 0));
		tituloNuevosEstudiantes.setBounds(0, 0, 502, 76);
		getContentPane().add(tituloNuevosEstudiantes);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(139, 0, 0));
		comboBox.setBackground(new Color(139, 0, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sistemas Computacionales", "Gestion Empresarial", "Arquitectura", "Electromec\u00E1nica", "Materiales", "Industrial", "Informatica", "Administracion"}));
		comboBox.setBounds(295, 153, 171, 22);
		getContentPane().add(comboBox);
		
		JTextPane labelNoCtrl = new JTextPane();
		labelNoCtrl.setText("No. Ctrl");
		labelNoCtrl.setForeground(new Color(139, 0, 0));
		labelNoCtrl.setFont(new Font("Impact", Font.ITALIC, 18));
		labelNoCtrl.setBackground(new Color(255, 140, 0));
		labelNoCtrl.setBounds(229, 79, 64, 32);
		getContentPane().add(labelNoCtrl);
		
		JTextPane labelEdad = new JTextPane();
		labelEdad.setText("Edad");
		labelEdad.setForeground(new Color(139, 0, 0));
		labelEdad.setFont(new Font("Impact", Font.ITALIC, 18));
		labelEdad.setBackground(new Color(255, 140, 0));
		labelEdad.setBounds(239, 112, 64, 32);
		getContentPane().add(labelEdad);
		
		JTextPane LabelSexo = new JTextPane();
		LabelSexo.setText("Sexo");
		LabelSexo.setForeground(new Color(139, 0, 0));
		LabelSexo.setFont(new Font("Impact", Font.ITALIC, 18));
		LabelSexo.setBackground(new Color(255, 140, 0));
		LabelSexo.setBounds(390, 120, 39, 32);
		getContentPane().add(LabelSexo);
		
		JTextPane LabelCarrera = new JTextPane();
		LabelCarrera.setText("Carrera");
		LabelCarrera.setForeground(new Color(139, 0, 0));
		LabelCarrera.setFont(new Font("Impact", Font.ITALIC, 18));
		LabelCarrera.setBackground(new Color(255, 140, 0));
		LabelCarrera.setBounds(219, 143, 64, 32);
		getContentPane().add(LabelCarrera);
		
		JTextPane labelHorario = new JTextPane();
		labelHorario.setText("Horario");
		labelHorario.setForeground(new Color(139, 0, 0));
		labelHorario.setFont(new Font("Impact", Font.ITALIC, 18));
		labelHorario.setBackground(new Color(255, 140, 0));
		labelHorario.setBounds(219, 188, 64, 32);
		getContentPane().add(labelHorario);
		
		JRadioButton rdbtnMatutino = new JRadioButton("Matutino");
		rdbtnMatutino.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnMatutino.setBackground(new Color(255, 140, 0));
		rdbtnMatutino.setBounds(302, 195, 127, 25);
		getContentPane().add(rdbtnMatutino);
		
		JRadioButton rdbtnTarde = new JRadioButton("Tarde");
		rdbtnTarde.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnTarde.setBackground(new Color(255, 140, 0));
		rdbtnTarde.setBounds(439, 195, 83, 25);
		getContentPane().add(rdbtnTarde);
		
		JButton btnDarDeAlta = new JButton("Dar de Alta");
		btnDarDeAlta.setBounds(512, 291, 97, 25);
		getContentPane().add(btnDarDeAlta);
		
		ImageIcon icon = new ImageIcon("Images/mapaches.png");
		JLabel LabelLogo = new JLabel("New label");
		LabelLogo.setIcon(icon);
		LabelLogo.setBounds(12, 274, 56, 16);
		getContentPane().add(LabelLogo);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
