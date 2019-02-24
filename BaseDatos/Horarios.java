package BaseDatos;

public class Horarios {
	private String Dia;
	private String hora;
	public Horarios(String dia, String hora) {
		super();
		Dia = dia;
		this.hora = hora;
	}
	public String getDia() {
		return Dia;
	}
	public String getHora() {
		return hora;
	}
	public void setDia(String dia) {
		Dia = dia;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	

}
