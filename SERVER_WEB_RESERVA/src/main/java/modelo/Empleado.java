package modelo;

import java.sql.Date;

//ID_Empleado INT AUTO_INCREMENT PRIMARY KEY,
//ID_Jefe INT NOT NULL,
//ID_Asignación INT NOT NULL,
//Nombre VARCHAR(100) NOT NULL,
//Apellido VARCHAR(100) NOT NULL,
//Puesto VARCHAR(100) NOT NULL,
//Fecha_Contratación DATE NOT NULL,
//Teléfono VARCHAR(15) NOT NULL CHECK (Teléfono LIKE '[0-9]%'),
//Correo_Electrónico VARCHAR(100) NOT NULL UNIQUE,
//FOREIGN KEY (ID_Asignación) REFERENCES Asignacion_Empleado(ID_Asignación),
//FOREIGN KEY (ID_Jefe) REFERENCES Empleado(ID_Empleado)
public class Empleado {
	private int idEmpleado;
	private int idAsignacion;
	private String nombre;
	private String apellido;
    private Date fechaContratación;
    private String telefono;
    private String correoElectrónico;


	public Empleado(int id, int idAsignacion, String nombre, String apellido, Date fechaContratación, String telefono,
			String correoElectrónico) {

		this.idEmpleado = id;
		this.idAsignacion = idAsignacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaContratación = fechaContratación;
		this.telefono = telefono;
		this.correoElectrónico = correoElectrónico;
	}


	public Empleado(int idAsignacion, String nombre, String apellido, Date fechaContratación, String telefono,
			String correoElectrónico) {
		super();
		this.idAsignacion = idAsignacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaContratación = fechaContratación;
		this.telefono = telefono;
		this.correoElectrónico = correoElectrónico;
	}


	public int getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(int id) {
		this.idEmpleado = id;
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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getFechaContratación() {
		return fechaContratación;
	}


	public void setFechaContratación(Date fechaContratación) {
		this.fechaContratación = fechaContratación;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreoElectrónico() {
		return correoElectrónico;
	}


	public void setCorreoElectrónico(String correoElectrónico) {
		this.correoElectrónico = correoElectrónico;
	}
	
	
    
    
    
}
