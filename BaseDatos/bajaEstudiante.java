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

public class bajaEstudiante extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public Tecnologico principal;
	public Estudiante estudiantex = null;
	public JPanel contentPanel;
	private JTextField txtBuscar;
	private JTextField txtNombre;
	private JTextField txtCarrera;
	private JTextField txtHorario;
	private JTextField txtEdad;
	private JTextField txtSexo;

	public bajaEstudiante(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, Tecnologico padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(new Color(255, 140, 0));
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);

		JLabel lblDarDeBaja = new JLabel("Dar de baja");
		lblDarDeBaja.setForeground(new Color(139, 0, 0));
		lblDarDeBaja.setFont(new Font("Impact", Font.ITALIC, 62));
		lblDarDeBaja.setBounds(12, 13, 299, 95);
		getContentPane().add(lblDarDeBaja);

		JLabel lblNewLabel = new JLabel("-Estudiante");
		lblNewLabel.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(307, 53, 137, 44);
		getContentPane().add(lblNewLabel);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(237, 110, 137, 22);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblNoCtrlPara = new JLabel("No. Ctrl para eleminar");
		lblNoCtrlPara.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNoCtrlPara.setBounds(22, 108, 219, 22);
		getContentPane().add(lblNoCtrlPara);

		JLabel lblDatos = new JLabel("Datos");
		lblDatos.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDatos.setBounds(224, 145, 70, 33);
		getContentPane().add(lblDatos);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(104, 194, 137, 22);
		getContentPane().add(txtNombre);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(22, 192, 97, 22);
		getContentPane().add(lblNombre);

		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCarrera.setBounds(22, 229, 81, 22);
		getContentPane().add(lblCarrera);

		JLabel lblCarrera_1 = new JLabel("Horario");
		lblCarrera_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCarrera_1.setBounds(22, 259, 97, 22);
		getContentPane().add(lblCarrera_1);

		txtCarrera = new JTextField();
		txtCarrera.setEditable(false);
		txtCarrera.setColumns(10);
		txtCarrera.setBounds(104, 231, 137, 22);
		getContentPane().add(txtCarrera);

		txtHorario = new JTextField();
		txtHorario.setEditable(false);
		txtHorario.setColumns(10);
		txtHorario.setBounds(104, 261, 137, 22);
		getContentPane().add(txtHorario);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEdad.setBounds(277, 191, 49, 22);
		getContentPane().add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setColumns(10);
		txtEdad.setBounds(327, 194, 35, 22);
		getContentPane().add(txtEdad);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSexo.setBounds(372, 194, 49, 22);
		getContentPane().add(lblSexo);

		txtSexo = new JTextField();
		txtSexo.setEditable(false);
		txtSexo.setColumns(10);
		txtSexo.setBounds(422, 194, 35, 22);
		getContentPane().add(txtSexo);
		
		JButton btnBuscar = new JButton("Buscar");
		JButton btnBorrar = new JButton("Borrar");
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCarrera.setText(null);
				txtEdad.setText(null);
				txtHorario.setText(null);
				txtNombre.setText(null);
				txtSexo.setText(null);
				txtBuscar.setText(null);
				btnBorrar.setEnabled(false);
				btnCancelar.setEnabled(false);
			}
		});
		
		btnBorrar.setEnabled(false);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int NoCtrlx = Integer.parseInt(txtBuscar.getText());
				principal.lista.eliminarEstudiante(NoCtrlx);
				txtCarrera.setText(null);
				txtEdad.setText(null);
				txtHorario.setText(null);
				txtNombre.setText(null);
				txtSexo.setText(null);
				txtBuscar.setText(null);
				btnBorrar.setEnabled(false);
				btnCancelar.setEnabled(false);
				JOptionPane.showMessageDialog(null,"Estudiante borrado");
			}
		});
		btnBorrar.setBounds(424, 260, 97, 25);
		getContentPane().add(btnBorrar);

		
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(307, 260, 97, 25);
		getContentPane().add(btnCancelar);

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int NoCtrlx = Integer.parseInt(txtBuscar.getText());
				int pos = principal.lista.buscarPosicionEstudiante(NoCtrlx);
				txtCarrera.setText(principal.lista.estudiantes.get(pos).getCarrera());
				txtEdad.setText("" + principal.lista.estudiantes.get(pos).getEdad());
				txtHorario.setText(principal.lista.estudiantes.get(pos).getHorario());
				txtNombre.setText(principal.lista.estudiantes.get(pos).getNombre());
				txtSexo.setText("" + principal.lista.estudiantes.get(pos).getSexo());

				btnBorrar.setEnabled(true);
				btnCancelar.setEnabled(true);
			}
		});
		btnBuscar.setBounds(386, 109, 97, 25);
		getContentPane().add(btnBuscar);

		setBounds(100, 100, 568, 380);
	}
}