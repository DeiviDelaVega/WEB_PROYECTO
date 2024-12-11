package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import modelo.Empleado;
import modelo.Usuario;

public class DAOEmpleado {

	
	Connection con = DataBase.getConnexion();

public boolean registrarEmpleado(Empleado empleado) throws SQLException {
		
		String sql = "INSERT INTO Empleado(ID_Asignación,Nombre,Apellido,Nro_Documento,Teléfono,Correo_Electrónico)"
				+ " VALUES ( ?, ?, ?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, empleado.getId_Asignacion());
		ps.setString(2, empleado.getNombre());
		ps.setString(3, empleado.getApellido());
		ps.setInt(4, empleado.getNro_Documento());
		ps.setString(5, empleado.getTelefono());
		ps.setString(6, empleado.getCorreo_Electronico());

		if(ps.executeUpdate()>0){
			
            DAOUsuario usuariodao = new DAOUsuario();
			Usuario usuario = new Usuario(empleado.getCorreo_Electronico(), empleado.getClave(),"empleado");
			boolean usuarioRegistrado = usuariodao.registrarUsuario(usuario);
			return usuarioRegistrado;
			}
		return false;
		

	}


public List<Empleado> buscarPorId(int idBuscar) {
    // Establecer la conexión con la BD
    Connection cnx = DataBase.getConnexion();
    // Declarar la lista de Departamento
    List<Empleado> listaEmpleados = new ArrayList<>();
    try {
    	// Preparar la instruccion SQL:
        PreparedStatement ps;
        if (idBuscar == -1) {
            // Buscar todos los departamentos
            ps = cnx.prepareStatement("SELECT * FROM Empleado");
        } else {
            // Buscar por ID
            ps = cnx.prepareStatement("SELECT * FROM Empleado WHERE ID_Empleado LIKE ?");
            // Enviar el valor del parametro SQL
            ps.setString(1, "%" + idBuscar + "%");
        }
        // Ejecuar la instruccion SQL y recoger los resultados		
        ResultSet rs = ps.executeQuery(); // SELECT
        			// ps.executeUpdate(); // INSERT - UPDATE - DELETE
        while (rs.next()) {
        	// Instanciar objeto departamento
            Empleado empleado = new Empleado();
            // Guardar los valores de la fila en el objeto
            empleado.setId_Empleado(rs.getInt("ID_Empleado"));
            empleado.setId_Asignacion(rs.getInt("ID_Asignación"));;
            empleado.setNombre(rs.getString("Nombre"));
            empleado.setApellido(rs.getString("Apellido"));
            empleado.setNro_Documento(rs.getInt("Nro_Documento"));;
            empleado.setFecha_Contratación(rs.getDate("Fecha_Contratación"));
            empleado.setTelefono(rs.getString("Teléfono"));
            empleado.setCorreo_Electronico(rs.getString("Correo_Electrónico"));
			
			// Agregar el departamento a la lista de departamentos
            listaEmpleados.add(empleado);
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
    System.out.println("listaEmpleados "+listaEmpleados);
    // Retornar la lista de departamentos
    return listaEmpleados;
}







}
