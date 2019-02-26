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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PedirEstudianteDatos extends JInternalFrame {
	// Obtener el contexto del Frame principal Tecnologico
	public Tecnologico principal;
	public Estudiante estudiantex = null;
	public JPanel contentPanel;
	private JTextField txtBuscar;
	private JTable table;

	public PedirEstudianteDatos(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, Tecnologico padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(new Color(255, 140, 0));
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);

		JTextPane txtpnObtencionDeDatos = new JTextPane();
		txtpnObtencionDeDatos.setText("Obtencion de datos");
		txtpnObtencionDeDatos.setForeground(new Color(139, 0, 0));
		txtpnObtencionDeDatos.setFont(new Font("Impact", Font.ITALIC, 57));
		txtpnObtencionDeDatos.setBackground(new Color(255, 140, 0));
		txtpnObtencionDeDatos.setBounds(78, 13, 502, 76);
		getContentPane().add(txtpnObtencionDeDatos);

		JScrollPane scrlPnDatos = new JScrollPane();
		scrlPnDatos.setBounds(58, 140, 529, 153);
		getContentPane().add(scrlPnDatos);

		table = new JTable();
		scrlPnDatos.setViewportView(table);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(336, 102, 200, 25);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);

		JButton btnBuscar = new JButton("Buscar NoCtrl");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] encabezados = { "No. Ctrl", "Nombre", "Sexo", "Edad", "Carrera", "Horario" };
					Object datos[][] = new Object[principal.lista.estudiantes.size()][];
					
					int renglon = 0;
					int NoCtrlx = Integer.parseInt(txtBuscar.getText());
					int pos = principal.lista.buscarPosicionEstudiante(NoCtrlx);
					
					//Empieza desde el objeto deseado, y sigue hasta el final
					for (int i = pos; i < principal.lista.estudiantes.size(); i++) {
						datos[renglon] = new Object[6];
						datos[renglon][0] = principal.lista.estudiantes.get(i).getNoCtrl();
						datos[renglon][1] = principal.lista.estudiantes.get(i).getNombre();
						datos[renglon][2] = principal.lista.estudiantes.get(i).getSexo();
						datos[renglon][3] = principal.lista.estudiantes.get(i).getEdad();
						datos[renglon][4] = principal.lista.estudiantes.get(i).getCarrera();
						datos[renglon][5] = principal.lista.estudiantes.get(i).getHorario();
						renglon++;

					}
					DefaultTableModel modelo = new DefaultTableModel(datos, encabezados);
					table.setModel(modelo);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(537, 102, 109, 25);
		getContentPane().add(btnBuscar);

		JButton btnDefault = new JButton("Actualizar");
		btnDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] encabezados = { "No. Ctrl", "Nombre", "Sexo", "Edad", "Carrera", "Horario" };
					Object datos[][] = new Object[principal.lista.estudiantes.size()][];
					int renglon = 0;

					for (Estudiante x : principal.lista.estudiantes) {
						datos[renglon] = new Object[6];
						// No Ctrl
						datos[renglon][0] = x.getNoCtrl();
						// Nombre
						datos[renglon][1] = x.getNombre();
						// Sexo
						datos[renglon][2] = x.getSexo();
						// Edad
						datos[renglon][3] = x.getEdad();
						// Carrera
						datos[renglon][4] = x.getCarrera();
						// Horario
						datos[renglon][5] = x.getHorario();
						renglon++;
					}

					System.out.println("All fine here: PedirEstudiantesDatos.java"); // Solo para el developer, deja
																						// saber que todo va bien desde
																						// la consola
					DefaultTableModel modelo = new DefaultTableModel(datos, encabezados);
					table.setModel(modelo);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDefault.setBounds(22, 102, 97, 25);
		getContentPane().add(btnDefault);

		setBounds(100, 100, 674, 369);
	}
}
