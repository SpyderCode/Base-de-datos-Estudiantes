package BaseDatos;

import java.util.ArrayList;

public class Materias {
	//Atributos
	private String Asignatura;
	private char grupo;
	private int cred;
	private ArrayList<Horarios> horario;
	
	public Materias() {}

	public Materias(String asignatura, char grupo, int cred, ArrayList<Horarios> horario) {
		super();
		Asignatura = asignatura;
		this.grupo = grupo;
		this.cred = cred;
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
