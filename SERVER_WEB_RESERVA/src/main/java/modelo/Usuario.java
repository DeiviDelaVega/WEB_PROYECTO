package modelo;

public class Usuario {
	
	private int idUsuario;
	private String nombre;
	private String apellido;
	private String correo;
	private String usuario;
	private String clave;
	private String rol;

	public Usuario(int idUsuario,String nombre, String apellido, String correo, String usuario, String clave, String rol) {
		super();
		
		this.idUsuario=idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.usuario = usuario;
		this.clave = clave;
		this.rol = rol;
	}
	
	
	
	
	public Usuario(String nombre, String apellido, String correo, String usuario, String clave, String rol) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.usuario = usuario;
		this.clave = clave;
		this.rol = rol;
	}




	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
	
}
