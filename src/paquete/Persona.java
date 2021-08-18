package paquete;

public class Persona {
	private String rut;
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private int edad;
	
	public Persona(String rut, String nombre, String apellidoP, String apellidoM, int edad) {
		this.rut = rut;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.edad = edad;
	}
	public String getRut(){
		return this.rut;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setApellidoP(String apellido){
		this.apellidoP = apellido;
	}
	public String getApellidoP(){
		return this.apellidoP;
	}
	public void setApellidoM(String apellido){
		this.apellidoM = apellido;
	}
	public String getApellidoM(){
		return this.apellidoM;
	}
	public void setEdad(int edad){
		this.edad = edad;
	}
	public int getEdad(){
		return this.edad;
	}
}
