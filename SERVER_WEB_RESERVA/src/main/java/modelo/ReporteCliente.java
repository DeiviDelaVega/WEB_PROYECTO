package modelo;

public class ReporteCliente {
private int	ID_Cliente;
private String Nombre;
private String Apellido;
private int Total_Reservas;


public ReporteCliente() {
	
}


public ReporteCliente(int iD_Cliente, String nombre, String apellido, int total_Reservas) {
	super();
	ID_Cliente = iD_Cliente;
	Nombre = nombre;
	Apellido = apellido;
	Total_Reservas = total_Reservas;
}


public int getID_Cliente() {
	return ID_Cliente;
}


public void setID_Cliente(int iD_Cliente) {
	ID_Cliente = iD_Cliente;
}


public String getNombre() {
	return Nombre;
}


public void setNombre(String nombre) {
	Nombre = nombre;
}


public String getApellido() {
	return Apellido;
}


public void setApellido(String apellido) {
	Apellido = apellido;
}


public int getTotal_Reservas() {
	return Total_Reservas;
}


public void setTotal_Reservas(int total_Reservas) {
	Total_Reservas = total_Reservas;
}



}
