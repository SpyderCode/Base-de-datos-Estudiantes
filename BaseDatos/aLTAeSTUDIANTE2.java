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

public class aLTAeSTUDIANTE2 extends JInternalFrame{
	// Obtener el contexto del Frame principal Hospital
	public Tecnologico principal;
	public Estudiante estudiantex = null;
	public JPanel contentPanel;
	public JTextField txtNoCtrl;
	public JTextField txtNombre;
	public JTextField txtEdad;

	public aLTAeSTUDIANTE2(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, Tecnologico padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(new Color(255, 140, 0));
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);

		txtNoCtrl = new JTextField();
		txtNoCtrl.setColumns(10);
		txtNoCtrl.setBounds(332, 85, 284, 20);
		getContentPane().add(txtNoCtrl);

		JTextPane textPane = new JTextPane();
		textPane.setText("Nuevos Estudiantes");
		textPane.setForeground(new Color(139, 0, 0));
		textPane.setFont(new Font("Impact", Font.ITALIC, 57));
		textPane.setBackground(new Color(255, 140, 0));
		textPane.setBounds(0, 0, 502, 76);
		getContentPane().add(textPane);

		JLabel lblNoCtrl = new JLabel("No. Ctrl");
		lblNoCtrl.setForeground(new Color(139, 0, 0));
		lblNoCtrl.setFont(new Font("Impact", Font.ITALIC, 18));
		lblNoCtrl.setBackground(new Color(255, 140, 0));
		lblNoCtrl.setBounds(264, 82, 66, 23);
		getContentPane().add(lblNoCtrl);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(331, 121, 284, 20);
		getContentPane().add(txtNombre);

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setForeground(new Color(139, 0, 0));
		labelNombre.setFont(new Font("Impact", Font.ITALIC, 18));
		labelNombre.setBackground(new Color(255, 140, 0));
		labelNombre.setBounds(264, 118, 66, 23);
		getContentPane().add(labelNombre);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(331, 154, 39, 20);
		getContentPane().add(txtEdad);

		JLabel labelEdad = new JLabel("Edad");
		labelEdad.setForeground(new Color(139, 0, 0));
		labelEdad.setFont(new Font("Impact", Font.ITALIC, 18));
		labelEdad.setBackground(new Color(255, 140, 0));
		labelEdad.setBounds(286, 154, 44, 23);
		getContentPane().add(labelEdad);

		JLabel labelSexo = new JLabel("Sexo");
		labelSexo.setForeground(new Color(139, 0, 0));
		labelSexo.setFont(new Font("Impact", Font.ITALIC, 18));
		labelSexo.setBackground(new Color(255, 140, 0));
		labelSexo.setBounds(382, 154, 44, 23);

		getContentPane().add(labelSexo);

		ButtonGroup sexo = new ButtonGroup();
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnMasculino.setBackground(new Color(255, 140, 0));
		rdbtnMasculino.setBounds(434, 156, 103, 23);
		sexo.add(rdbtnMasculino);
		getContentPane().add(rdbtnMasculino);

		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setSelected(true);
		rdbtnFemenino.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnFemenino.setBackground(new Color(255, 140, 0));
		rdbtnFemenino.setBounds(541, 156, 114, 23);
		sexo.add(rdbtnFemenino);
		getContentPane().add(rdbtnFemenino);

		JLabel labelCarrera = new JLabel("Carrera");
		labelCarrera.setForeground(new Color(139, 0, 0));
		labelCarrera.setFont(new Font("Impact", Font.ITALIC, 18));
		labelCarrera.setBackground(new Color(255, 140, 0));
		labelCarrera.setBounds(264, 204, 66, 23);
		getContentPane().add(labelCarrera);

		JComboBox CmbxCarrera = new JComboBox();
		CmbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "Sistemas Computacionales", "Gestion Empresarial",
				"Arquitectura", "Electromec\u00E1nica", "Materiales", "Industrial", "Informatica", "Administracion" }));
		CmbxCarrera.setForeground(new Color(139, 0, 0));
		CmbxCarrera.setBackground(new Color(255, 140, 0));
		CmbxCarrera.setBounds(331, 207, 171, 22);
		getContentPane().add(CmbxCarrera);

		JLabel labelHorario = new JLabel("Horario");
		labelHorario.setForeground(new Color(139, 0, 0));
		labelHorario.setFont(new Font("Impact", Font.ITALIC, 18));
		labelHorario.setBackground(new Color(255, 140, 0));
		labelHorario.setBounds(264, 240, 66, 23);
		getContentPane().add(labelHorario);

		ButtonGroup horario = new ButtonGroup();
		JRadioButton rdbtnMatutino = new JRadioButton("Matutino");
		rdbtnMatutino.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnMatutino.setBackground(new Color(255, 140, 0));
		rdbtnMatutino.setBounds(331, 242, 127, 25);
		horario.add(rdbtnMatutino);
		getContentPane().add(rdbtnMatutino);

		JRadioButton rdbtnTarde = new JRadioButton("Tarde");
		rdbtnTarde.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnTarde.setBackground(new Color(255, 140, 0));
		rdbtnTarde.setBounds(472, 241, 83, 25);
		horario.add(rdbtnTarde);
		getContentPane().add(rdbtnTarde);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancelar.setBounds(405, 285, 97, 25);
		getContentPane().add(btnCancelar);

		JButton btnDarDeAlta = new JButton("Dar de Alta");
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int NoCtrlx=Integer.parseInt(txtNoCtrl.getText());
				String nombrex=txtNombre.getText();
				char sexox='M';
				if(rdbtnFemenino.isSelected()) sexox='F';
				if(rdbtnMasculino.isSelected()) sexox='M';
				String horariox="";
				if(rdbtnMatutino.isSelected()) horariox="Matutino";
				if(rdbtnTarde.isSelected()) horariox="Tarde";
				String carrerax=(String) CmbxCarrera.getItemAt(CmbxCarrera.getSelectedIndex());
				Estudiante estudiantex=new Estudiante(NoCtrlx, nombrex, sexox, edadx, carrerax, horariox);
				principal.lista.altaEstudiante(estudiantex);
			}
		});
		btnDarDeAlta.setBounds(518, 285, 97, 25);
		getContentPane().add(btnDarDeAlta);

		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("Images/mapaches.png"));
		label.setBounds(-88, 76, 346, 393);
		getContentPane().add(label);

		setBounds(100, 100, 674, 369);
	}

}
