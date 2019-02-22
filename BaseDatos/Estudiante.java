package BaseDatos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Estudiante implements Serializable {

	// Atributos
	private int NoCtrl;
	private String nombre;
	private char sexo;
	private String horario;
	private int numClases;
	private ArrayList<Materias> materia;

	public int getNoCtrl() {
		return NoCtrl;
	}

	public String getNombre() {
		return nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public String getHorario() {
		return horario;
	}

	public void setNoCtrl(int noCtrl) {
		NoCtrl = noCtrl;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Estudiante(int Noctrl) {
		this.NoCtrl = Noctrl;
	}

	public Estudiante() {
		super();
		this.materia = new ArrayList<Materias>();
		this.numClases = 0;
	}

	public Estudiante(int noCtrl, String nombre, char sexo, String horario) {
		this();
		NoCtrl = noCtrl;
		this.nombre = nombre;
		this.sexo = sexo;
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + NoCtrl;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		if (NoCtrl != other.NoCtrl)
			return false;
		return true;
	}

	public void altaMateria(Materias materiax) {
		if (numClases <= 8) {
			materia.add(materiax);
			this.numClases++;
		} else {
			JOptionPane.showMessageDialog(null, "Este estudiante ya tiene sufficientes" + " materias",
					"Error a dar de alta una materia", JOptionPane.ERROR_MESSAGE);
		}
	}


	

}
