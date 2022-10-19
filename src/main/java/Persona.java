public class Persona {
	private String nombre;
	private String apellido;
	private String codigo;
	private int contadorPersona;
	
	public Persona(String nombre, String apellido)
	{
		this.nombre = nombre;
		this.apellido = apellido;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public int getContadorPersona() {
		return contadorPersona;
	}

	public void setContadorPersona(int contadorPersona) {
		this.contadorPersona = contadorPersona;
	}

	@Override
	public String toString() {
		return "Persona " + contadorPersona + ":\n" 
				+ "Nombre: " + nombre + "\nApellido: " + apellido + "\n" 
				+ "Codigo: " + codigo + "\n";
	}

}
