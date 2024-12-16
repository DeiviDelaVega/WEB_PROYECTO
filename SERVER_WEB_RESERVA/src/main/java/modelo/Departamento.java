package modelo;

public class Departamento{
	private int idDepartamento;
    private String nombre;
    private int capacidad;
    private int nroHabitaciones;
    private String descripcion;
    private String serviciosIncluidos;
    private String disponibilidad;
    private double precioPorNoche;
    private String imagenDepartamento;
    private int vecesReservado;
    
    public Departamento() {
    	idDepartamento = 0;
    	nombre = "";
    	capacidad = 0;
    	nroHabitaciones = 0;
		descripcion = "";
		serviciosIncluidos = "";
		disponibilidad = "";
		precioPorNoche = 0.0;
		vecesReservado = 0;
	}

	public Departamento(int idDepartamento, String nombre, int capacidad, int nroHabitaciones, String descripcion,
			String serviciosIncluidos, String disponibilidad, double precioPorNoche, String imagenDepartamento, int vecesReservado) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.nroHabitaciones = nroHabitaciones;
		this.descripcion = descripcion;
		this.serviciosIncluidos = serviciosIncluidos;
		this.disponibilidad = disponibilidad;
		this.precioPorNoche = precioPorNoche;
		this.imagenDepartamento = imagenDepartamento;
		this.vecesReservado = vecesReservado;
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
	
	public String getImagenDepartamento() {
		return imagenDepartamento;
	}

	public void setImagenDepartamento(String imagenDepartamento) {
		this.imagenDepartamento = imagenDepartamento;
	}

	public int getVecesReservado() {
		return vecesReservado;
	}

	public void setVecesReservado(int vecesReservado) {
		this.vecesReservado = vecesReservado;
	}
}