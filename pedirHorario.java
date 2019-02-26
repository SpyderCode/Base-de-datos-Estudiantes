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
import javax.swing.table.DefaultTableModel;
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
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class pedirHorario extends JInternalFrame {
	// Obtener el contexto del Frame principal Tecnologico
	public Tecnologico principal;
	public Estudiante estudiantex = null;
	public JPanel contentPanel;
	private JTextField txtIngreseNoctrl;
	private JTable table;

	public pedirHorario(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, Tecnologico padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);

		JLabel lblPideTuHorario = new JLabel("Pide tu Horario");
		lblPideTuHorario.setFont(new Font("Impact", Font.BOLD, 26));
		lblPideTuHorario.setBounds(64, 72, 188, 37);
		getContentPane().add(lblPideTuHorario);

		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Impact", Font.ITALIC, 66));
		lblHorario.setForeground(Color.BLUE);
		lblHorario.setBounds(12, 13, 240, 65);
		getContentPane().add(lblHorario);

		txtIngreseNoctrl = new JTextField();
		txtIngreseNoctrl.setText("Ingrese su No. Ctrl");
		txtIngreseNoctrl.setBounds(326, 13, 210, 22);
		getContentPane().add(txtIngreseNoctrl);
		txtIngreseNoctrl.setColumns(10);

		JScrollPane scrollDatos = new JScrollPane();
		scrollDatos.setBounds(12, 153, 624, 151);
		getContentPane().add(scrollDatos);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombre.setBounds(278, 59, 78, 26);
		getContentPane().add(lblNombre);

		JTextPane textNombre = new JTextPane();
		textNombre.setBackground(Color.LIGHT_GRAY);
		textNombre.setEditable(false);
		textNombre.setBounds(353, 56, 183, 22);
		getContentPane().add(textNombre);

		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCarrera.setBounds(278, 88, 78, 26);
		getContentPane().add(lblCarrera);

		JTextPane textCarrera = new JTextPane();
		textCarrera.setEditable(false);
		textCarrera.setBackground(Color.LIGHT_GRAY);
		textCarrera.setBounds(353, 92, 183, 22);
		getContentPane().add(textCarrera);

		table = new JTable();
		scrollDatos.setViewportView(table);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int NoCtrlx = Integer.parseInt(txtIngreseNoctrl.getText());
					int pos = principal.lista.buscarPosicionEstudiante(NoCtrlx);
					int renglon = 0;
					
					// Encabezado de la table
					String[] encabezados = { "Asignatura", "Grupo", "Cred", "Lunes", "Martes", "Miercoles", "Jueves",
							"Viernes", "Docente" };
					
					Object datos[][] = new Object[principal.lista.estudiantes.get(pos).getMateria().size()][];
					
					textCarrera.setText(principal.lista.estudiantes.get(pos).getCarrera());
					textNombre.setText(principal.lista.estudiantes.get(pos).getNombre());

					// Ingresa los daots al table
					for (int i = 0; i < principal.lista.estudiantes.get(pos).getMateria().size(); i++) {
						datos[renglon] = new Object[9];
						// Asignatura
						datos[renglon][0] = principal.lista.estudiantes.get(pos).getMateria().get(i).getAsignatura();
						// Grupo
						datos[renglon][1] = principal.lista.estudiantes.get(pos).getMateria().get(i).getGrupo();
						// Cred
						datos[renglon][2] = principal.lista.estudiantes.get(pos).getMateria().get(i).getCred();
						// Lunes
						datos[renglon][3] = principal.lista.estudiantes.get(pos).getMateria().get(i).getHorario().get(0)
								.getHora();
						// Martes
						datos[renglon][4] = principal.lista.estudiantes.get(pos).getMateria().get(i).getHorario().get(1)
								.getHora();
						// Miercoled
						datos[renglon][5] = principal.lista.estudiantes.get(pos).getMateria().get(i).getHorario().get(2)
								.getHora();
						// Jueves
						datos[renglon][6] = principal.lista.estudiantes.get(pos).getMateria().get(i).getHorario().get(3)
								.getHora();
						// Viernes
						if (principal.lista.estudiantes.get(pos).getMateria().get(i).getHorario().size() == 5) {
							datos[renglon][7] = principal.lista.estudiantes.get(pos).getMateria().get(i).getHorario()
									.get(4).getHora();
						} else {
							datos[renglon][7] = "-";// Si no tiene clases los viernes, pone un '-' en su lugar
						}
						// Profesor
						datos[renglon][8] = principal.lista.estudiantes.get(pos).getMateria().get(i).getProfesor();
						renglon++;
					}
					DefaultTableModel modelo = new DefaultTableModel(datos, encabezados);
					table.setModel(modelo);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(539, 13, 97, 25);
		getContentPane().add(btnBuscar);

		setBounds(100, 100, 664, 369);
	}
}