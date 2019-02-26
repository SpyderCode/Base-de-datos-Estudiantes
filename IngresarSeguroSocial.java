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

public class IngresarSeguroSocial extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public Tecnologico principal;
	public Estudiante estudiantex = null;
	public JPanel contentPanel;
	private JTextField textNoCtrl;
	private JTextField txtCodigoImss;

	public IngresarSeguroSocial(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, Tecnologico padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Images/brand.gif"));
		label.setBounds(-15, 0, 183, 169);
		getContentPane().add(label);

		JLabel lblSeguro = new JLabel("Seguro Social");
		lblSeguro.setFont(new Font("Impact", Font.ITALIC, 70));
		lblSeguro.setBounds(165, 0, 420, 126);
		getContentPane().add(lblSeguro);

		JLabel lblNoCtrl = new JLabel("No Ctrl");
		lblNoCtrl.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNoCtrl.setBounds(180, 136, 114, 45);
		getContentPane().add(lblNoCtrl);

		JLabel lblNewLabel = new JLabel("Codigo del Imss");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(88, 177, 175, 39);
		getContentPane().add(lblNewLabel);

		textNoCtrl = new JTextField();
		textNoCtrl.setBounds(260, 147, 221, 22);
		getContentPane().add(textNoCtrl);
		textNoCtrl.setColumns(10);

		txtCodigoImss = new JTextField();
		txtCodigoImss.setColumns(10);
		txtCodigoImss.setBounds(270, 190, 211, 22);
		getContentPane().add(txtCodigoImss);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int NoCtrlx = Integer.parseInt(textNoCtrl.getText());
					int pos = principal.lista.buscarPosicionEstudiante(NoCtrlx);
					String textox = txtCodigoImss.getText();

					// Da el codigo al estudiante
					principal.lista.estudiantes.get(pos).setSeguroCode(textox);
					
					// Quita el texto a los cuadros
					textNoCtrl.setText(null);
					txtCodigoImss.setText(null);
					
					// Sets seguro to true
					principal.lista.estudiantes.get(pos).setSeguro(true);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(486, 233, 97, 25);
		getContentPane().add(btnAceptar);

		setBounds(100, 100, 651, 314);
	}

}