package BaseDatos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ListaEstudiante {
	public ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

	public void altaEstudiante(Estudiante e) {
		//Primero busca a ver si existe el estudiante
		if(buscarPosicionEstudiante(e.getNoCtrl())==-1) {//Si no, lo agrega a la lista
			estudiantes.add(e);
			JOptionPane.showMessageDialog(null, "Estudiante dado de Alta", "Success", JOptionPane.INFORMATION_MESSAGE);
		}else {//Si si, hecha un error
			JOptionPane.showMessageDialog(null, "No Ctrl Duplicado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarEstudiante(int NoCtrlx) {
		int pos = buscarPosicionEstudiante(NoCtrlx);
		if (pos >= 0)
			estudiantes.remove(pos);
		else
			JOptionPane.showMessageDialog(null, "Estudiante no existe", "No existe", JOptionPane.ERROR_MESSAGE);
	}

	public int buscarPosicionEstudiante(int NoCtrlx) {
		int pos = -1;
		int i = 0;
		for (Estudiante e : estudiantes) {
			if (e.getNoCtrl() == NoCtrlx) {
				pos = i;
				break;
			}
			i++;
		}
		return pos;
	}

}
