package modelo;

import java.sql.Date;

public class Empleado {
private int id_Empleado;
 private int  id_Asignacion;
 private String nombre;
 private String apellido;
 private  int nro_Documento;
 private   String Telefono;
 private String Correo_Electronico;
 private String clave;
 private Date fecha_Contratación;
 ;
 

public Empleado() {

}


public Empleado(int id_Asignacion, String nombre, String apellido, int nro_Documento, String telefono,String clave,
		String correo_Electronico) {
	super();
	this.id_Asignacion = id_Asignacion;
	this.nombre = nombre;
	this.apellido = apellido;
	this.nro_Documento = nro_Documento;
	this.Telefono = telefono;
	this.Correo_Electronico = correo_Electronico;
	this.clave=clave;
}


public Empleado(int id_Empleado, int id_Asignacion, String nombre, String apellido, int nro_Documento, String telefono,
		String correo_Electronico,String clave) {
	super();
	this.id_Empleado = id_Empleado;
	this.id_Asignacion = id_Asignacion;
	this.nombre = nombre;
	this.apellido = apellido;
	this.nro_Documento = nro_Documento;
	Telefono = telefono;
	Correo_Electronico = correo_Electronico;
	this.clave=clave;

}


public Date getFecha_Contratación() {
	return fecha_Contratación;
}


public void setFecha_Contratación(Date fecha_Contratación) {
	this.fecha_Contratación = fecha_Contratación;
}


public String getClave() {
	return clave;
}


public void setClave(String clave) {
	this.clave = clave;
}


public int getId_Empleado() {
	return id_Empleado;
}


public void setId_Empleado(int id_Empleado) {
	this.id_Empleado = id_Empleado;
}


public int getId_Asignacion() {
	return id_Asignacion;
}


public void setId_Asignacion(int id_Asignacion) {
	this.id_Asignacion = id_Asignacion;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getApellido() {
	return apellido;
}


public void setApellido(String apellido) {
	this.apellido = apellido;
}


public int getNro_Documento() {
	return nro_Documento;
}


public void setNro_Documento(int nro_Documento) {
	this.nro_Documento = nro_Documento;
}


public String getTelefono() {
	return Telefono;
}


public void setTelefono(String telefono) {
	Telefono = telefono;
}


public String getCorreo_Electronico() {
	return Correo_Electronico;
}


public void setCorreo_Electronico(String correo_Electronico) {
	Correo_Electronico = correo_Electronico;
}
 
 
 
}
