package BaseDatos;

public class Horarios {
	private String Dia;
	private String hora;
	private String clase;
	public Horarios(String dia, String hora, String clase) {
		super();
		Dia = dia;
		this.hora = hora;
		this.clase = clase;
	}
	public String getDia() {
		return Dia;
	}
	public String getHora() {
		return hora;
	}
	public String getClase() {
		return clase;
	}
	public void setDia(String dia) {
		Dia = dia;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	
	

}
