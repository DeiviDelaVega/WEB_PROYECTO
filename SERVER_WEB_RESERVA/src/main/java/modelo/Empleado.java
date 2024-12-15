package modelo;

import java.sql.Date;

public class Empleado {
private int id_Empleado;
 private String nombre;
 private String apellido;
 private  int nro_Documento;
 private  String Telefono;
 private String Correo_Electronico;
 private String clave;
 private Date fecha_Contratacion;
 ;
 

public Empleado() {
	        id_Empleado = 0;
	    	nombre = "";
	    	apellido = "";
	    	nro_Documento = 0;
	    	Telefono = "";
	    	Correo_Electronico = "";
	    	clave = "";
	    	fecha_Contratacion = new Date(0);
		}

public Empleado( String nombre, String apellido, int nro_Documento, String telefono,String clave,
		String correo_Electronico) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.nro_Documento = nro_Documento;
	this.Telefono = telefono;
	this.Correo_Electronico = correo_Electronico;
	this.clave=clave;
}


public Empleado(int id_Empleado, String nombre, String apellido, int nro_Documento, String telefono,
		String correo_Electronico,String clave) {
	super();
	this.id_Empleado = id_Empleado;
	this.nombre = nombre;
	this.apellido = apellido;
	this.nro_Documento = nro_Documento;
	this.Telefono = telefono;
	this.Correo_Electronico = correo_Electronico;
	this.clave=clave;

}


public Date getFecha_Contratacion() {
	return fecha_Contratacion;
}


public void setFecha_Contratacion(Date fecha_Contratación) {
	this.fecha_Contratacion = fecha_Contratación;
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
