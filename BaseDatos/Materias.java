package BaseDatos;

import java.io.Serializable;
import java.util.ArrayList;

public class Materias implements Serializable{
	//Atributos
	private String Asignatura;
	private char grupo;
	private int cred;
	private String Profesor;
	private double Calificacion;
	private ArrayList<Horarios> horario=new ArrayList<Horarios>();
	
	public Materias() {}

	public Materias(String asignatura,String Profesor, char grupo, int cred) {
		super();
		this.Asignatura = asignatura;
		this.grupo = grupo;
		this.cred = cred;
		this.Profesor=Profesor;
	}

	public String getProfesor() {
		return Profesor;
	}

	public void setProfesor(String profesor) {
		Profesor = profesor;
	}

	public ArrayList<Horarios> getHorario() {
		return horario;
	}

	public void setHorario(ArrayList<Horarios> horario) {
		this.horario = horario;
	}

	public String getAsignatura() {
		return Asignatura;
	}

	public char getGrupo() {
		return grupo;
	}

	public int getCred() {
		return cred;
	}

	public void setAsignatura(String asignatura) {
		Asignatura = asignatura;
	}

	public void setGrupo(char grupo) {
		this.grupo = grupo;
	}

	public void setCred(int cred) {
		this.cred = cred;
	}
	public void AltaDia(Horarios horariox) {
		horario.add(horariox);
	}

	public double getCalificacion() {
		return Calificacion;
	}

	public void setCalificacion(double calificacion) {
		Calificacion = calificacion;
	}

}
