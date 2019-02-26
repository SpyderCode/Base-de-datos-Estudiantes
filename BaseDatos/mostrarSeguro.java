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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class mostrarSeguro extends JInternalFrame {
	// Obtener el contexto del Frame principal Tecnologico
	public Tecnologico principal;
	public Estudiante estudiantex = null;
	public JPanel contentPanel;
	private JTextField textBuscar;
	private JTable table;

	public mostrarSeguro(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, Tecnologico padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 224, 654, 260);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("Images/brand.gif"));
		label.setBounds(-20, 0, 183, 169);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("Seguro Social");
		label_1.setFont(new Font("Impact", Font.ITALIC, 70));
		label_1.setBounds(159, 0, 420, 126);
		getContentPane().add(label_1);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] encabezados = { "No.Ctrl", "Codigo", "Nombre" };
					Object datos[][] = new Object[principal.lista.estudiantes.size()][];
					int renglon = 0;
					for (Estudiante x : principal.lista.estudiantes) {
						datos[renglon] = new Object[4];
						if (x.isSeguro()) {
							//No Ctrl
							datos[renglon][0] = x.getNoCtrl();
							//Codigo de seguro
							datos[renglon][1] = x.getSeguroCode();
							//Nombre del estudiante
							datos[renglon][2] = x.getNombre();
						}
						renglon++;
					}
					DefaultTableModel modelo = new DefaultTableModel(datos, encabezados);
					table.setModel(modelo);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnActualizar.setBounds(581, 182, 97, 25);
		getContentPane().add(btnActualizar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					String[] encabezados = { "No.Ctrl", "Codigo", "Nombre" };
					Object datos[][] = new Object[principal.lista.estudiantes.size()][];

					int renglon = 0;
					int NoCtrlx = Integer.parseInt(textBuscar.getText());
					int pos = principal.lista.buscarPosicionEstudiante(NoCtrlx);

					// Al igual de la clase PedirEstudianteDatos.java, este empieza desde el
					// estudiante deseado y sigue
					for (int i = pos; i < principal.lista.estudiantes.size(); i++) {
						datos[renglon] = new Object[4];
						if (principal.lista.estudiantes.get(i).isSeguro()) {
							datos[renglon][0] = principal.lista.estudiantes.get(i).getNoCtrl();
							datos[renglon][1] = principal.lista.estudiantes.get(i).getSeguroCode();
							datos[renglon][2] = principal.lista.estudiantes.get(i).getNombre();
						}
						renglon++;
					}
					DefaultTableModel modelo = new DefaultTableModel(datos, encabezados);
					table.setModel(modelo);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(24, 182, 97, 25);
		getContentPane().add(btnBuscar);

		textBuscar = new JTextField();
		textBuscar.setBounds(117, 182, 281, 22);
		getContentPane().add(textBuscar);
		textBuscar.setColumns(10);

		setBounds(100, 100, 706, 533);
	}

}