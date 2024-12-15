package modelo;

import java.util.Date;

public class Reserva {

	private int idSolicitud;
	private int idCliente;
	private int idDepartamento;
	private Date fechaInicioReserva;
	private Date fechaFinReserva;
	private String metodoPago;
	private double montoTotal;
	private String estadoReserva;


	
	public Reserva() {
		
	}



	public Reserva(int idSolicitud, int idCliente, int idDepartamento, Date fechaInicioReserva, Date fechaFinReserva,
			String metodoPago, double montoTotal, String estadoReserva) {
		super();
		this.idSolicitud = idSolicitud;
		this.idCliente = idCliente;
		this.idDepartamento = idDepartamento;
		this.fechaInicioReserva = fechaInicioReserva;
		this.fechaFinReserva = fechaFinReserva;
		this.metodoPago = metodoPago;
		this.montoTotal = montoTotal;
		this.estadoReserva = estadoReserva;
	}



	public Reserva(int idSolicitud2, Date fechaSolicitud, Date fechaInicioReserva2, Date fechaFinReserva2,
			Double montoTotal2, String estadoReserva2) {
		// TODO Auto-generated constructor stub
	}



	// Getters y Setters
	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	

	public int getIdDepartamento() {
		return idDepartamento;
	}



	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}



	public Date getFechaInicioReserva() {
		return fechaInicioReserva;
	}

	public void setFechaInicioReserva(Date fechaInicioReserva) {
		this.fechaInicioReserva = fechaInicioReserva;
	}

	public Date getFechaFinReserva() {
		return fechaFinReserva;
	}

	public void setFechaFinReserva(Date fechaFinReserva) {
		this.fechaFinReserva = fechaFinReserva;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getEstadoReserva() {
		return estadoReserva;
	}

	public void setEstadoReserva(String estadoReserva) {
		this.estadoReserva = estadoReserva;
	}
	
	

	// toString() para representar el objeto como cadena
	@Override
	public String toString() {
		return "Reserva{" + "idSolicitud=" + idSolicitud 
				+ ", fechaInicioReserva=" + fechaInicioReserva + ", fechaFinReserva=" + fechaFinReserva
				+ ", metodoPago='" + metodoPago + '\'' + ", montoTotal=" + montoTotal + ", estadoReserva='"
				+ estadoReserva + '\'' + '}';
	}
}
