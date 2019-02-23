package BaseDatos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaEstudiante extends JInternalFrame implements ActionListener {

	private Tecnologico principal;
	private Estudiante estudiantex = null;
	private JPanel contentPanel;
	private JTextField txtNoCtrl;
	private JTextField txtEdad;
	private JButton btnDarDeAlta;
	private JRadioButton rdbtnFemenino, rdbtnMasculino, rdbtnMatutino, rdbtnTarde;
	private JTextField txtNombre;
	private JComboBox<String> CmbxCarrera;
	private JButton btnCancelar;

	public AltaEstudiante(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, Tecnologico padre) {
		super(titulo, tamaño, cerrar, maximizar);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		getContentPane().setBackground(new Color(255, 140, 0));

		txtNoCtrl = new JTextField();
		txtNoCtrl.setColumns(10);
		txtNoCtrl.setBounds(295, 87, 284, 20);
		getContentPane().add(txtNoCtrl);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(295, 154, 83, 20);
		getContentPane().add(txtEdad);

		ButtonGroup sexo = new ButtonGroup();
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnMasculino.setBackground(new Color(255, 140, 0));
		rdbtnMasculino.setBounds(437, 163, 91, 23);
		sexo.add(rdbtnMasculino);
		rdbtnMasculino.addActionListener(this);
		getContentPane().add(rdbtnMasculino);

		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnFemenino.setBackground(new Color(255, 140, 0));
		rdbtnFemenino.setSelected(true);
		rdbtnFemenino.setBounds(524, 163, 114, 23);
		sexo.add(rdbtnFemenino);
		rdbtnFemenino.addActionListener(this);
		getContentPane().add(rdbtnFemenino);

		JTextPane tituloNuevosEstudiantes = new JTextPane();
		tituloNuevosEstudiantes.setText("Nuevos Estudiantes");
		tituloNuevosEstudiantes.setForeground(new Color(139, 0, 0));
		tituloNuevosEstudiantes.setFont(new Font("Impact", Font.ITALIC, 57));
		tituloNuevosEstudiantes.setBackground(new Color(255, 140, 0));
		tituloNuevosEstudiantes.setBounds(0, 0, 502, 76);
		getContentPane().add(tituloNuevosEstudiantes);

		JComboBox CmbxCarrera = new JComboBox();
		CmbxCarrera.setForeground(new Color(139, 0, 0));
		CmbxCarrera.setBackground(new Color(139, 0, 0));
		CmbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "Sistemas Computacionales", "Gestion Empresarial",
				"Arquitectura", "Electromec\u00E1nica", "Materiales", "Industrial", "Informatica", "Administracion" }));
		CmbxCarrera.setBounds(295, 197, 171, 22);
		getContentPane().add(CmbxCarrera);

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
		labelEdad.setBounds(246, 142, 47, 32);
		getContentPane().add(labelEdad);

		JTextPane LabelSexo = new JTextPane();
		LabelSexo.setText("Sexo");
		LabelSexo.setForeground(new Color(139, 0, 0));
		LabelSexo.setFont(new Font("Impact", Font.ITALIC, 18));
		LabelSexo.setBackground(new Color(255, 140, 0));
		LabelSexo.setBounds(390, 154, 39, 32);
		getContentPane().add(LabelSexo);

		JTextPane LabelCarrera = new JTextPane();
		LabelCarrera.setText("Carrera");
		LabelCarrera.setForeground(new Color(139, 0, 0));
		LabelCarrera.setFont(new Font("Impact", Font.ITALIC, 18));
		LabelCarrera.setBackground(new Color(255, 140, 0));
		LabelCarrera.setBounds(229, 187, 64, 32);
		getContentPane().add(LabelCarrera);

		JTextPane labelHorario = new JTextPane();
		labelHorario.setText("Horario");
		labelHorario.setForeground(new Color(139, 0, 0));
		labelHorario.setFont(new Font("Impact", Font.ITALIC, 18));
		labelHorario.setBackground(new Color(255, 140, 0));
		labelHorario.setBounds(229, 232, 64, 32);
		getContentPane().add(labelHorario);

		ButtonGroup horario = new ButtonGroup();
		JRadioButton rdbtnMatutino = new JRadioButton("Matutino");
		rdbtnMatutino.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnMatutino.setBackground(new Color(255, 140, 0));
		rdbtnMatutino.setBounds(295, 239, 127, 25);
		horario.add(rdbtnMatutino);
		getContentPane().add(rdbtnMatutino);

		JRadioButton rdbtnTarde = new JRadioButton("Tarde");
		rdbtnTarde.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnTarde.setBackground(new Color(255, 140, 0));
		rdbtnTarde.setBounds(419, 239, 83, 25);
		horario.add(rdbtnTarde);
		getContentPane().add(rdbtnTarde);

		JButton btnDarDeAlta = new JButton("Dar de Alta");
		btnDarDeAlta.setBounds(482, 270, 97, 25);
		btnDarDeAlta.addActionListener(this);
		getContentPane().add(btnDarDeAlta);

		ImageIcon icon = new ImageIcon("Images/mapaches.png");
		JLabel LabelLogo = new JLabel();
		LabelLogo.setIcon(icon);
		LabelLogo.setBounds(-51, 153, 231, 232);
		getContentPane().add(LabelLogo);

		JTextPane labelNombre = new JTextPane();
		labelNombre.setText("Nombre");
		labelNombre.setForeground(new Color(139, 0, 0));
		labelNombre.setFont(new Font("Impact", Font.ITALIC, 18));
		labelNombre.setBackground(new Color(255, 140, 0));
		labelNombre.setBounds(229, 112, 64, 32);
		getContentPane().add(labelNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(295, 120, 284, 20);
		getContentPane().add(txtNombre);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(356, 273, 97, 25);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDarDeAlta) {
			try {
				int NoCtrlx = Integer.parseInt(txtNoCtrl.getText());
				String nombrex = txtNombre.getText();
				int edadx = Integer.parseInt(txtEdad.getText());
				char sexox = 'M';
				String horariox = null;
				if (rdbtnFemenino.isSelected())
					sexox = 'F';
				if (rdbtnMasculino.isSelected())
					sexox = 'M';
				if (rdbtnTarde.isSelected())
					horariox = "Tarde";
				if (rdbtnMatutino.isSelected())
					horariox = "Matutino";
				String car = CmbxCarrera.getItemAt(CmbxCarrera.getSelectedIndex());
				Estudiante estudiantex = new Estudiante(NoCtrlx, nombrex, sexox, edadx, car, horariox);
				principal.lista.altaEstudiante(estudiantex);
				this.dispose();
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
			}

		}
		if (e.getSource() == btnCancelar) {
			estudiantex = null;
			this.dispose();
		}

	}
}
