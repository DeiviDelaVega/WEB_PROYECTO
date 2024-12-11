package modelo;

public class Cliente {

	private int	id_Cliente;
	private String nombre;
	private String apellido;
	private int nro_Documento;
	private String direccion;
	private String telefono;
    private String correo;
    private String clave;
	public Cliente(int id_Cliente, String nombre, String apellido, int nro_Documento, String direccion, String telefono,
			String correo, String clave) {
		super();
		this.id_Cliente = id_Cliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nro_Documento = nro_Documento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.clave = clave;
	}
	public Cliente(String nombre, String apellido, int nro_Documento, String direccion, String telefono, String correo,
			String clave) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nro_Documento = nro_Documento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.clave = clave;
	}
	
	
	
	public Cliente() {
		
	}
	
	
	
	public int getId_Cliente() {
		return id_Cliente;
	}
	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}		
	
	
    
    
    
}
