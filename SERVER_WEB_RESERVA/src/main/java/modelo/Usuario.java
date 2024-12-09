package modelo;

public class Usuario {
	

    private String correo;
    private String clave;
    private String rol;
    
    public Usuario( String correo, String clave, String rol) {
        this.correo = correo;
        this.clave = clave;
        this.rol = rol;
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


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}

	
	

	
	
	
}
