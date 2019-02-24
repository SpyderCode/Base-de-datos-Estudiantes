package BaseDatos;

import java.util.ArrayList;

public class Materias {
	//Atributos
	private String Asignatura;
	private char grupo;
	private int cred;
	private String Profesor;
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

}
