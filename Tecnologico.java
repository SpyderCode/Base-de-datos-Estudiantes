package BaseDatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.Action;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Vista.AltaPaciente;
import Vista.Hospital;

//import Modelo.Paciente;

//import Modelo.Paciente;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Tecnologico extends JFrame {
	JDesktopPane principal;
	ListaEstudiante lista = new ListaEstudiante();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tecnologico frame = new Tecnologico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tecnologico() {
		Tecnologico t = this;
		setTitle("TECNOLOGICO DE ZACATECAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1138, 753);
		principal = new JDesktopPane();
		principal.setBackground(Color.WHITE);
		setContentPane(principal);
		principal.setLayout(null);
		this.repaint();
		
		JLabel lblNewLabel_1 = new JLabel("I.T.Z");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 200));
		lblNewLabel_1.setBounds(-13, -54, 541, 284);
		principal.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Ricardo Echaniz\\Documents\\Tecnologico\\Segundo A\u00F1o\\Estructuras de Datos\\Unidad 3 Datos Lineales\\eclipse-workspace\\Error en linea 1\\Images\\TecNM2017T.png"));
		lblNewLabel_2.setBounds(0, 430, 475, 237);
		principal.add(lblNewLabel_2);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser dialogo = new JFileChooser();
					if (dialogo.showSaveDialog(principal) == JFileChooser.APPROVE_OPTION) {
						File archivo = dialogo.getSelectedFile();
						if (archivo != null) {
							FileOutputStream fos = new FileOutputStream(archivo);
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							
							for (Estudiante p : lista.estudiantes) {
								oos.writeObject(p);
							}
								fos.close();
								JOptionPane.showMessageDialog(principal, "Archivo Guardado con Exito");
							
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(principal, "Error al guardar archivo"+ex);
				}
			}
		});
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileInputStream fis = null;
				try {
					JFileChooser dialogo = new JFileChooser();
					if (dialogo.showOpenDialog(principal) == JFileChooser.APPROVE_OPTION) {
						File archivo = dialogo.getSelectedFile();
						if (archivo != null) {
							fis = new FileInputStream(archivo);
							ObjectInputStream ois = new ObjectInputStream(fis);
							lista.estudiantes.clear();// Borra todos los elemtos de la lista
							// Lee cada objeto del archivo y lo escribe en la lista de pacientes
							Estudiante p;
							while (true) {
								p = (Estudiante) ois.readObject();
								lista.estudiantes.add(p);
							}
						}
					}
				} catch (EOFException ex) {
					try {
						fis.close();
						JOptionPane.showMessageDialog(principal, "Datos Cargados con Exito");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(principal, "Error al abrir archivo");
				}
			}
		});
		mnArchivo.add(mntmAbrir);

		JMenu mnCalificacion = new JMenu("Calificacion");
		menuBar.add(mnCalificacion);

		JMenuItem mntmEstudiante = new JMenuItem("Ingresar");
		mntmEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarCalif ventanaInterna=new ingresarCalif("Ingresar Calificacion",  true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		mnCalificacion.add(mntmEstudiante);

		JMenu mnHorarios = new JMenu("Horarios");
		menuBar.add(mnHorarios);

		JMenuItem mntmEstudiante_1 = new JMenuItem("Ver Horario Estudiante");
		mntmEstudiante_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pedirHorario ventanaInterna = new pedirHorario("Pide tu horario", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		mnHorarios.add(mntmEstudiante_1);

		JMenuItem mntmMaestro_1 = new JMenuItem("Generar Horario Estudiante");
		mntmMaestro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaHorario ventantaInterna = new altaHorario("Ingresar Horarios al Alumnos", true, true, true, t);
				principal.add(ventantaInterna);
				ventantaInterna.setVisible(true);
			}
		});
		mnHorarios.add(mntmMaestro_1);

		JMenu mnDatosAlumno = new JMenu("Datos Alumno");
		menuBar.add(mnDatosAlumno);

		JMenuItem mntmIngresar = new JMenuItem("Ingresar");
		mntmIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaEstudiante ventantaInterna = new altaEstudiante("Alta de Usuario", true, true, true, t);
				principal.add(ventantaInterna);
				ventantaInterna.setVisible(true);
			}
		});
		mnDatosAlumno.add(mntmIngresar);

		JMenuItem mntmPedir = new JMenuItem("Pedir");
		mntmPedir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PedirEstudianteDatos ventanaInterna = new PedirEstudianteDatos("Pedir Datos del Estudiante", true, true,
						true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		mnDatosAlumno.add(mntmPedir);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bajaEstudiante ventanaInterna=new bajaEstudiante("Dar de baja a un estudiante", true, true,
						true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		mnDatosAlumno.add(mntmBaja);

		JMenu mnSeguroSocial = new JMenu("Seguro social");
		menuBar.add(mnSeguroSocial);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Dar de alta");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresarSeguroSocial ventanaInterna=new IngresarSeguroSocial("Ingresar un seguro", true, true,
						true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		mnSeguroSocial.add(mntmNewMenuItem);
		
		JMenuItem mntmMostrar = new JMenuItem("Mostrar");
		mntmMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSeguro ventanaInterna=new mostrarSeguro("Mostrar seguro", true, true,
						true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		mnSeguroSocial.add(mntmMostrar);

		JMenu mnKardex = new JMenu("Kardex");
		menuBar.add(mnKardex);
		
		JMenuItem mntmObtener = new JMenuItem("Obtener");
		mntmObtener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kardex ventanaInterna=new kardex("Kardex", true, true,
						true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		mnKardex.add(mntmObtener);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		JMenuItem mntmCopyright = new JMenuItem("Copyright");
		mntmCopyright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "OC please no steal", "Copyright - es mio prro", JOptionPane.OK_OPTION);
			}
		});
		mnAbout.add(mntmCopyright);

		JMenuItem mntmAboutUs = new JMenuItem("About us");
		mntmAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Creador: \nRicardo Echaniz\nEmmanuel\nYessenia\nGema\n\n\n"
						+ "Equipo: Error en linea 1", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnAbout.add(mntmAboutUs);
	}
}




/**
 * 
 * 






                                                              ..---..._
                                                        ..--""         "-.
                                                   ..-"""                 ".
                                               ..-""                        "
                                            .-"
                                         .-"      ... -_
                                     .="   _..-" F   .-"-.....___-..
                                     "L_ _-'    ."  j"  .-":   /"-._ "-
                                        "      :  ."  j"  :   :    |"" ".
                                  ......---------"""""""""""-:_     |   |\
                        ...---""""                             -.   f   | "
                ...---""       . ..----""""""""..                ".-... f  ".
         ..---"""       ..---""""""""-..--"""""""""^^::            |. "-.    .
     .--"           .mm::::::::::::::::::::::::::...  ""L           |x   ".
   -"             mm;;;;;;;;;;XXXXXXXXXXXXX:::::::::::.. |           |x.   -
 xF        -._ .mF;;;;;;XXXXXXXXXXXXXXXXXXXXXXXXXX:::::::|            |X:.  "
j         |   j;;;;;XXX#############################::::::|            XX::::
|          |.#;::XXX##################################::::|            |XX:::
|          j#::XXX#######################################::             XXX::
|         .#:XXX###########################################             |XX::
|         #XXX##############################XX############Fl             XXX:
|        .XXX###################XX#######X##XXX###########Fl             lXX:
 |       #XX##################XXX######XXXXXXX###########F j             lXXX
 |       #X#########X#X#####XXX#######XXXXXX#######XXX##F  jl            XXXX
 |       #X#######XX#"  V###XX#' ####XXXXXX##F"T##XXXXXX.  V   /  .    .#XXXX
  |       #########"     V#XX#'  "####XXXX##.---.##XXXXXX.    /  /  / .##XXXX
  |       "######X' .--"" "V##L   #####XXX#"      "###XXXX. ."  /  / .###XXXX
  |         #####X "   .m###m##L   ####XX#      m###m"###XX#   /  / .#####XXX
   |         "###X   .mF""   "y     #####     mX"   "Y#"^####X   / .######XXX
   |           "T#   #"        #     ####    X"       "F""###XX"###########XX
   |             L  d"     dXX  xm   "^##L mx     dXX  YL-"##XX"S""##########
    |            xL J     Xd%    T      ""  T    XdX    L. "##XS.f |#########
    |             BL      X## X                  X## X      T#SS"  |#########
    |              #L     X%##X                  X%##X|     j#SSS /##########
     |              #L  ._ TXXX-"           "-._  XXXF.-    ###SS\###########
     |              ##   """""                  """"""      ##DS.\###########
     |              TF                                      ##BBS.T#########F
      |             #L           ---                        ###BBS.T########'
      |            '##            ""                     jL|###BSSS.T#######
       |          '####             ______              .:#|##WWBBBSS.T####F
      J L        '######.            \___/            _c::#|###WWWBSSS|####
     J ;;       '########m            \_/            c:::'#|###WWWBBSS.T##"
    J ;;;L      :########.:m.          _          _cf:::'.L|####WWWWSSS|#"
  .J ;;;;B      ########B....:m..             _,c%%%:::'...L####WWWBBSSj
 x  ;;;;dB      #######BB.......##m...___..cc%%%%%::::'....|#####WWBBDS.|
" ;;;;;ABB#     #######BB........##j%%%%%%%%%%%%%%:::'..... #####WWWWDDS|
.;;;;;dBBB#     #######BB.........%%%%%%%%%%%%%%%:::'...   j####WWWWWBDF
;;;;;BBB####    ######BBB.........%%%%%%%%%%%%%%:::'..     #####WWWWWWS
;;;;dBBB####    ######BBB..........^%%%%%%%%%%:::"         #####WWWWWWB
;;;:BBB######   X#####BBB"..........."^YYYYY::"            #####WWWWWWW
;;.BB#########  X######BBB........:''                      #####WWWWWWW
;;BB##########L X######BBB.......mmmm..                 ..x#####WWWWWWB.
;dBB########### X#######BB.....        "-._           x""  #####WWWWWWBL
;BBB###########L X######BB...              "-              ######WWWWBBBL
BBB#############. ######BBB.                                #####WWWWBBBB
BBB############## X#####BBB                                 #####WWWWWBBB
BBB############### T#####BB                                  #####WWWBBB     :
BB################# T###BBP                                   #####WWBB"    .#
BB##################..W##P                                      ###BBB"    .##
BB###################..l                                         "WW"      ###
BB####################j ___                                        " l    j###
BBB##################J_-   """-..             ':::'   .-""""""""""-.  l  .####
BBB######B##########J########    "-.           ::'  -" ..mmm####mm.."-.< #####
MCL-5/7/88 BBB#####J############    "-_        :|  " .###############mmLlR####
BBBBBBBBBBBBBBB###/         #######    -.     .:| ".#####F^^^P^^"""^^^Y#lT####
BBBBBBBBBBBBBBBBBj|####mm        ######xx-...:::|" ###f      .....      "#T###
BBBBBBBBBBBBBBBBjj##########mm..           ":::."j##F  .mm#########mmm.. Yj###
BBBBBBBBBBBBBBBB|^WWWSRR############mmmmm xx """mjF.mm####################j###
BBBBBBBBBBBBBBBB|                      ######mmmmmm#######################j###
BBBBBBBBBBBBBBBBY#m...   ..mmm##########PPPPP#####m..                    lj###
BBBBBBBBBBBBBBBBB2##############^^""     ..umF^^^Tx ^##mmmm........mmmmmmlj###
BBBBBBBBBBBBBBBBBJT######^^^""     .mm##PPPF"...."m.  "^^###############lj####
BBBBBBBBBBBBBBBBB##^L         .mmm###PPP............"m..    """"^^^^^"" lj####
BBBBBBBBBBBBBBBB#####Y#mmx#########P.................."^:muuuummmmmm###^.#####
BBBBBBBBBBBBBBBB#####::Y##mPPPPF^".......|.............. ""^^######^^"...#####
BBBBBBBBBBBBBB########..................F............      \     ........#####
BBBBBBBBBBBBB#########.................|..........          :       ....l#####
BBBBBBBBBBBB###########...............F.........             \        ..######
BBBBBBBBBBB#############.............|........                :         dA####
BBBBBBBBBB##############.....................                           kM####
BBBBBBBBB################..................                             k#####
BBBBBBB##################................                               k#####
BBBBB#####################.............                                 t#####
BB########################............                                  "E####
B########################F............                           .       "####
#########################............'      |                    ..       "L##
########################F............                           ...        "L#
#######################F............'                           .....       "#
######################F.............                           .......       "
#####################$..............                         .........
#####################lmmm.............                      ...........   ..m#
####################j########mmmm.............            ......mmmmmm########
###################j###::::;:::::########mmmmmmm##############################
##################j:::::::;:::::::;;::##############################^^^""""
##################.mm:::mmm######mmmm:::' ^^^^^^""#######^^""""
#################F...^m::;::################mmm  .mm"""
#################.......m;::::::::::::#########^"
################F.........###mmm::::;' .##^"""
 ##############F...........:#######m.m#"
   ############..............':####
     #########F............mm^""
       #######..........m^""
          ####.......%^"
             #.....x"
             |.x""
            .-"
          .-
        .-
      .-
     -
   -"
 -"
"
                                                                             x
                                                                           xx
                                                                         xx
                                                                     xxx"
                                                                 xxx"
                                                           .xxxx"
                                                   ___xxx""
                                             .xxxx""....F
                """"mmxxxxx          ___xxx^^^..........'
                   .xx^^^^YYYY###xxx^^.................|
                .xx^"        #######x..................|
             .xx"          ###########mx..............f
           .x^            ##############xx............|
          j"             ##############    x..........;
.........#              ############       #x.........|
x.......j"              ##########       ####x.......f
 xxx....#..            ########        #######x......|
   xxxx.#....         #######        ##########x.....|
      xxx......       #####         #########   x....|
         xxx......    ###          #######      #m...|
           xxx......  ##           ######      ####..|
             xxx......#.          #####       ######m|
               xxxx.......        ###        #######Fx
                   xxx......      #         j#####    m
                      xx......              ####      Jxm
                       xxx......           ####      j###Km
                          xxx.....         ###      j####F  m
                             xx......       #       ###F    .m
                               xxx ....            j##F    .###m
                               m..xx.....          ##F    j#####K^mm.
                                m...xx......       ##     #####F    ####mm
                                m .....x......     F     j####F    ########
                                 m  ......x.....         ###F    J##########
                                 "m  ........x....      .#F     #########^^|
                                  "......mmF^^^x....    ##     ######      |
                                   lL..jF        x.... .F      ####       |
                                   lTLJF           x....      ####        |
                                   l::|.            "....    j###       ##
                                    l....            L....   ###F     x##
                                     l....       ..m##L...   ##F     j###
                                     l:...        #####L...  #F     j####
                                      l....    ####     ...        #####
                                      "....              ...       ####F |
                                       l....              ...     j###F  |
                                        #...               ....   ###F    |
                                        "#..              .jL.... ##F     |
                                         ##.            .m###L....#F      |
                                         "##        ..mm###### ....       |
                                          |                   |...        |
                                          k                    |...       |
                                          l                    |...       k
                                           k                 .m#L...     Jk
                                           ##            ..mm####L...     k
                                           ###         d########' L....   |
                                           l                   |   "-.__-"
                                           l                   |
                                           l                  j#
                                           :                 j##
                                            k               j##'
                                            l            .m###k
                                            l           ###^^"|
                                            |                 |
                                            j               .##
                                            |              ######
                                            |==          ##### ####
                                           .k          #####"   ####
                                           l         #####^     ####
                                           l       ###         ####'
                                           !                 m###F
                                           |               ######
                                           |           mm##m###'
                                           |.       m########F
                                           |.    m#######F" #
                                           d.   ###        #
                                          |..             .'
                                          |..             |
                                           k..           :
                                           \...          F
                                            |...        #d
                                            |...       ###
                                             L...     ####.
                                             |...    j### |
                                              L...   ###  |
                                              T...  j##    k
                                               \... ##     |
                                                 \...      .
                                                   "^-____-

 * 
 * /
 */