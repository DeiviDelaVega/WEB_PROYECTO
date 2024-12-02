package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import data.DataBase;

public class Departamento{
	private int idDepartamento;
    private String nombre;
    private int capacidad;
    private int nroHabitaciones;
    private String descripcion;
    private String serviciosIncluidos;
    private String disponibilidad;
    private double precioPorNoche;
	
    public Departamento() {
    	idDepartamento = 0;
    	nombre = "";
    	capacidad = 0;
    	nroHabitaciones = 0;
		descripcion = "";
		serviciosIncluidos = "";
		disponibilidad = "";
		precioPorNoche = 0.0;
	}
    
    public Departamento(int idDepartamento, String nombre, int capacidad, int nroHabitaciones, String descripcion,
			String serviciosIncluidos, String disponibilidad, double precioPorNoche) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.nroHabitaciones = nroHabitaciones;
		this.descripcion = descripcion;
		this.serviciosIncluidos = serviciosIncluidos;
		this.disponibilidad = disponibilidad;
		this.precioPorNoche = precioPorNoche;
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
	
	// Método de Acceso a Datos
	public List<Departamento> buscarPorId(int idBuscar) {
        // Establecer la conexión con la BD
        Connection cnx = DataBase.getConnexion();
        // Declarar la lista de Departamento
        List<Departamento> listaDepartamentos = new ArrayList<>();
        try {
        	// Preparar la instruccion SQL:
            PreparedStatement ps;
            if (idBuscar == -1) {
                // Buscar todos los departamentos
                ps = cnx.prepareStatement("SELECT * FROM Departamento");
            } else {
                // Buscar por ID
                ps = cnx.prepareStatement("SELECT * FROM Departamento WHERE ID_Departamento LIKE ?");
                // Enviar el valor del parametro SQL
                ps.setString(1, "%" + idBuscar + "%");
            }
            // Ejecuar la instruccion SQL y recoger los resultados		
            ResultSet rs = ps.executeQuery(); // SELECT
            			// ps.executeUpdate(); // INSERT - UPDATE - DELETE
            while (rs.next()) {
            	// Instanciar objeto departamento
                Departamento departamento = new Departamento();
                // Guardar los valores de la fila en el objeto
                departamento.setIdDepartamento(rs.getInt("ID_Departamento"));
				departamento.setNombre(rs.getString("Nombre"));
				departamento.setCapacidad(rs.getInt("capacidad"));
				departamento.setNroHabitaciones(rs.getInt("Número_Habitaciones"));
				departamento.setDescripcion(rs.getString("Descripción"));
				departamento.setServiciosIncluidos(rs.getString("Servicios_Incluidos"));
				departamento.setDisponibilidad(rs.getString("Disponibilidad"));
				departamento.setPrecioPorNoche(rs.getDouble("Precio_Por_Noche"));
				// Agregar el departamento a la lista de departamentos
                listaDepartamentos.add(departamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión con la BD (importante para evitar fugas de recursos)
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // Retornar la lista de departamentos
        return listaDepartamentos;
    }
}