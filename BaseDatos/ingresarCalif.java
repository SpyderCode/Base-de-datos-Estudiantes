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
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class ingresarCalif extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public Tecnologico principal;
	public Estudiante estudiantex = null;
	public JPanel contentPanel;
	private JTextField txtBuscar;
	private JTextField textNombre;
	private JTextField textCarrera;
	private JTextField textHorario;
	private JTextField textCalif;
	private JComboBox comboBox;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public ingresarCalif(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, Tecnologico padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(new Color(255, 140, 0));
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ingrese Calificacion");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setBackground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Impact", Font.ITALIC, 62));
		lblNewLabel.setBounds(0, 0, 546, 91);
		getContentPane().add(lblNewLabel);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(314, 90, 248, 22);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);

		JButton btnBuscarNoCtrl = new JButton("Buscar No Ctrl");
		btnBuscarNoCtrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int NoCtrlx = Integer.parseInt(txtBuscar.getText());
				int pos = principal.lista.buscarPosicionEstudiante(NoCtrlx);
				// Sets textCarrera de la carrera del estudiante
				textCarrera.setText(principal.lista.estudiantes.get(pos).getCarrera());
				// Sets textNombre del nombre del estudiante
				textNombre.setText(principal.lista.estudiantes.get(pos).getNombre());
				// and so on...
				textHorario.setText(principal.lista.estudiantes.get(pos).getHorario());
				String[] horariosx = new String[principal.lista.estudiantes.get(pos).getMateria().size()];
				for (int i = 0; i < principal.lista.estudiantes.get(pos).getMateria().size(); i++) {
					horariosx[i] = principal.lista.estudiantes.get(pos).getMateria().get(i).getAsignatura();
				}
				comboBox.setModel(new DefaultComboBoxModel<>(horariosx));
				btnAceptar.setEnabled(true);
				btnCancelar.setEnabled(true);
			}
		});
		btnBuscarNoCtrl.setBounds(558, 89, 120, 25);
		getContentPane().add(btnBuscarNoCtrl);

		JLabel lblDatos = new JLabel("Datos");
		lblDatos.setFont(new Font("Impact", Font.BOLD, 35));
		lblDatos.setBounds(105, 104, 112, 43);
		getContentPane().add(lblDatos);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Impact", Font.BOLD, 25));
		lblNombre.setBounds(12, 152, 112, 43);
		getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(105, 167, 151, 22);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Impact", Font.BOLD, 25));
		lblCarrera.setBounds(12, 194, 112, 43);
		getContentPane().add(lblCarrera);

		textCarrera = new JTextField();
		textCarrera.setEditable(false);
		textCarrera.setBounds(105, 202, 151, 22);
		getContentPane().add(textCarrera);
		textCarrera.setColumns(10);

		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Impact", Font.BOLD, 25));
		lblHorario.setBounds(12, 243, 112, 43);
		getContentPane().add(lblHorario);

		textHorario = new JTextField();
		textHorario.setEditable(false);
		textHorario.setColumns(10);
		textHorario.setBounds(105, 250, 151, 22);
		getContentPane().add(textHorario);

		comboBox = new JComboBox<String[]>();
		comboBox.setBounds(467, 167, 151, 22);
		getContentPane().add(comboBox);

		JLabel lblMateria = new JLabel("Materia");
		lblMateria.setFont(new Font("Impact", Font.BOLD, 25));
		lblMateria.setBounds(364, 152, 112, 43);
		getContentPane().add(lblMateria);

		JLabel txtCalifFinal = new JLabel("Calificacion Final");
		txtCalifFinal.setFont(new Font("Impact", Font.BOLD, 25));
		txtCalifFinal.setBounds(364, 194, 216, 43);
		getContentPane().add(txtCalifFinal);

		textCalif = new JTextField();
		textCalif.setColumns(10);
		textCalif.setBounds(574, 202, 44, 22);
		getContentPane().add(textCalif);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int NoCtrlx = Integer.parseInt(txtBuscar.getText());
				int pos = principal.lista.buscarPosicionEstudiante(NoCtrlx);
				int posM = comboBox.getSelectedIndex();
				double califx = Double.parseDouble(textCalif.getText());
				if (califx <= 100 && califx >= 0) {
					principal.lista.estudiantes.get(pos).getMateria().get(posM).setCalificacion(califx);
				} else {
					JOptionPane.showMessageDialog(null, "La calificacion no puede ser mayor que 100 o menor que 0",
							"Out of bounds", JOptionPane.ERROR_MESSAGE);

				}
				textCalif.setText(null);
				textCarrera.setText(null);
				textHorario.setText(null);
				textNombre.setText(null);
				textCalif.setText(null);
				txtBuscar.setText(null);
				btnAceptar.setEnabled(false);
				btnCancelar.setEnabled(false);
				
				//Test que funciono bien
				System.out.println("Calif final"+principal.lista.estudiantes.get(pos).getMateria().get(posM).getCalificacion());
			}
		});
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(581, 257, 97, 25);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textCalif.setText(null);
				textCarrera.setText(null);
				textHorario.setText(null);
				textNombre.setText(null);
				textCalif.setText(null);
				txtBuscar.setText(null);
				btnAceptar.setEnabled(false);
				btnCancelar.setEnabled(false);
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(465, 257, 97, 25);
		getContentPane().add(btnCancelar);

		setBounds(100, 100, 706, 338);
	}
}