package modelo;

   public class rolEmpleado {
   private int idAsignacion;
   private String nombre;
   
   
   
public rolEmpleado(int idAsignacion, String nombre) {
	this.idAsignacion = idAsignacion;
	this.nombre = nombre;
}

public rolEmpleado(String nombre) {

	this.nombre = nombre;
}

public int getIdAsignacion() {
	return idAsignacion;
}
public void setIdAsignacion(int idAsignacion) {
	this.idAsignacion = idAsignacion;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
   
   
   
}

   