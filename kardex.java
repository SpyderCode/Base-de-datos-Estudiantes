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
import javax.swing.DropMode;

public class kardex extends JInternalFrame{
	// Obtener el contexto del Frame principal Hospital
	public Tecnologico principal;
	public Estudiante estudiantex = null;
	public JPanel contentPanel;
	private JTextField txtIngresaTuNoctrl;
	private JTextField textAlumno;
	private JTextField textCarrera;
	private JTextField textCalifFinal;
	private JTable table;

	public kardex(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, Tecnologico padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(new Color(255, 255, 255));
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel lblKardex = new JLabel("Kardex");
		lblKardex.setForeground(new Color(0, 0, 128));
		lblKardex.setFont(new Font("Impact", Font.ITALIC, 65));
		lblKardex.setBackground(new Color(139, 0, 0));
		lblKardex.setBounds(12, 0, 210, 91);
		getContentPane().add(lblKardex);
		
		txtIngresaTuNoctrl = new JTextField();
		txtIngresaTuNoctrl.setBackground(Color.LIGHT_GRAY);
		txtIngresaTuNoctrl.setText("Ingresa tu No.Ctrl");
		txtIngresaTuNoctrl.setBounds(282, 30, 268, 22);
		getContentPane().add(txtIngresaTuNoctrl);
		txtIngresaTuNoctrl.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 224, 624, 295);
		getContentPane().add(scrollPane);
		
		textAlumno = new JTextField();
		textAlumno.setEditable(false);
		textAlumno.setBounds(117, 119, 116, 22);
		getContentPane().add(textAlumno);
		textAlumno.setColumns(10);
		
		JLabel lblAlumno = new JLabel("Alumno");
		lblAlumno.setFont(new Font("Impact", Font.PLAIN, 25));
		lblAlumno.setBounds(12, 104, 77, 43);
		getContentPane().add(lblAlumno);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Impact", Font.PLAIN, 25));
		lblCarrera.setBounds(12, 143, 97, 32);
		getContentPane().add(lblCarrera);
		
		textCarrera = new JTextField();
		textCarrera.setEditable(false);
		textCarrera.setColumns(10);
		textCarrera.setBounds(117, 153, 116, 22);
		getContentPane().add(textCarrera);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblCalificacionFinal = new JLabel("Calificacion Final");
		lblCalificacionFinal.setFont(new Font("Impact", Font.PLAIN, 25));
		lblCalificacionFinal.setBounds(292, 532, 179, 43);
		getContentPane().add(lblCalificacionFinal);
		
		textCalifFinal = new JTextField();
		textCalifFinal.setColumns(10);
		textCalifFinal.setBounds(483, 540, 116, 22);
		getContentPane().add(textCalifFinal);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAlumno.setText(null);
				textCalifFinal.setText(null);
				textCarrera.setText(null);
				txtIngresaTuNoctrl.setText(null);
				String[] encabezados = {"Materia","Docente","Calif","TipoCal","Grupo"};
				DefaultTableModel modelo=new DefaultTableModel(null, encabezados);
				table.setModel(modelo);
			}
		});
		btnNewButton_1.setBounds(539, 186, 97, 25);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int NoCtrlx = Integer.parseInt(txtIngresaTuNoctrl.getText());
				int pos = principal.lista.buscarPosicionEstudiante(NoCtrlx);
				int renglon = 0;
				String[] encabezados = {"Materia","Docente","Calif","TipoCal","Grupo"};
				Object datos[][]=new Object[principal.lista.estudiantes.get(pos).getMateria().size()][];
				textAlumno.setText(principal.lista.estudiantes.get(pos).getNombre());
				textCarrera.setText(principal.lista.estudiantes.get(pos).getCarrera());
				double califx=0;
				//Ingresa datos al table
				for (int i = 0; i < principal.lista.estudiantes.get(pos).getMateria().size(); i++) {
					datos[renglon] = new Object[5];
					datos[renglon][0]=principal.lista.estudiantes.get(pos).getMateria().get(i).getAsignatura();
					datos[renglon][1]=principal.lista.estudiantes.get(pos).getMateria().get(i).getProfesor();
					datos[renglon][2]=principal.lista.estudiantes.get(pos).getMateria().get(i).getCalificacion();
					datos[renglon][3]="Ord";
					datos[renglon][4]=principal.lista.estudiantes.get(pos).getMateria().get(i).getGrupo();
					renglon++;
					//suma todas las calificaciones
					califx=califx+principal.lista.estudiantes.get(pos).getMateria().get(i).getCalificacion();
				}
				textCalifFinal.setText(""+(califx/principal.lista.estudiantes.get(pos).getMateria().size()));
				DefaultTableModel modelo=new DefaultTableModel(datos,encabezados);
				table.setModel(modelo);
			}
			
		});
		btnNewButton.setBounds(549, 29, 97, 25);
		getContentPane().add(btnNewButton);

		setBounds(100, 100, 674, 628);
	}
}