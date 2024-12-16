package modelo;

public class ReporteDepartamento {
	private int	ID_Departamento;
	private String Nombre;
	private int Total_Reservas;
	
	public ReporteDepartamento() {
		
	}
	
	public ReporteDepartamento(int iD_Departamento, String nombre, int total_Reservas) {
		ID_Departamento = iD_Departamento;
		Nombre = nombre;
		Total_Reservas = total_Reservas;
	}
	
	public int getID_Departamento() {
		return ID_Departamento;
	}
	
	public void setID_Departamento(int iD_Departamento) {
		ID_Departamento = iD_Departamento;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public int getTotal_Reservas() {
		return Total_Reservas;
	}
	
	public void setTotal_Reservas(int total_Reservas) {
		Total_Reservas = total_Reservas;
	}
}
