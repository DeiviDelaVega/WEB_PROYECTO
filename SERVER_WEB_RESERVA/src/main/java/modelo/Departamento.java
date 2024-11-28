package modelo;

import java.io.Serializable;

public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idDepartamento;
    private String nombre;
    private int capacidad;
    private int nroHabitaciones;
    private String descripcion;
    private String serviciosIncluidos;
    private String disponibilidad;
    private double precioPorNoche;
    private byte[] imagenHabitacion; // Usar byte[] para almacenar la imagen como datos binarios
	
    public Departamento(int idDepartamento, String nombre, int capacidad, int nroHabitaciones, String descripcion,
			String serviciosIncluidos, String disponibilidad, double precioPorNoche, byte[] imagenHabitacion) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.nroHabitaciones = nroHabitaciones;
		this.descripcion = descripcion;
		this.serviciosIncluidos = serviciosIncluidos;
		this.disponibilidad = disponibilidad;
		this.precioPorNoche = precioPorNoche;
		this.imagenHabitacion = imagenHabitacion;
	}

	public Departamento(String nombre, int capacidad, int nroHabitaciones, String descripcion,
			String serviciosIncluidos, String disponibilidad, double precioPorNoche, byte[] imagenHabitacion) {
		super();
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.nroHabitaciones = nroHabitaciones;
		this.descripcion = descripcion;
		this.serviciosIncluidos = serviciosIncluidos;
		this.disponibilidad = disponibilidad;
		this.precioPorNoche = precioPorNoche;
		this.imagenHabitacion = imagenHabitacion;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getNroHabitaciones() {
		return nroHabitaciones;
	}

	public void setNroHabitaciones(int nroHabitaciones) {
		this.nroHabitaciones = nroHabitaciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getServiciosIncluidos() {
		return serviciosIncluidos;
	}

	public void setServiciosIncluidos(String serviciosIncluidos) {
		this.serviciosIncluidos = serviciosIncluidos;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public double getPrecioPorNoche() {
		return precioPorNoche;
	}

	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}

	public byte[] getImagenHabitacion() {
		return imagenHabitacion;
	}

	public void setImagenHabitacion(byte[] imagenHabitacion) {
		this.imagenHabitacion = imagenHabitacion;
	}
}