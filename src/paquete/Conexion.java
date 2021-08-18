package paquete;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
	private Connection BaseDatos = null;
	private String user;
	private String password;
	private String db;
	private String url;
	public Conexion(String user,String password,String db) {
		this.user = user;
		this.password =password;
		this.db = db;
	}
	public void insertar_datos(Persona persona){
			url = "jdbc:postgresql://localhost:5432/"+db;
		try {
	        //Conexion con la base de datos
	        BaseDatos = DriverManager.getConnection(url, user, password);
			Statement consulta = (Statement) BaseDatos.createStatement();//Se crea la consulta
			consulta.executeUpdate("INSERT INTO PERSONA VALUES ('"+persona.getRut()+"','"+
			persona.getNombre()+"','"+persona.getApellidoP()+"','"+persona.getApellidoM()+"',"
			+persona.getEdad()+")");
			consulta.close(); //Cierra Las Conexiones
	        BaseDatos.close();
			System.out.println("Datos Ingresados Exitosamente!");
	    } catch (Exception e) {
	        System.err.println( e.getMessage() );
	    }
	}
	public void mostrar_todos_los_registros(){
		url = "jdbc:postgresql://localhost:5432/"+db;
		try {
	        //Conexion con la base de datos
	        BaseDatos = DriverManager.getConnection(url, user, password);
			Statement consulta = (Statement) BaseDatos.createStatement();//Se crea la consulta
			String sql = "SELECT RUT, NOMBRE, APELLIDOP, APELLIDOM, EDAD FROM PERSONA";
		    ResultSet resultado =  consulta.executeQuery(sql);
			int contador = 1;
			while (resultado.next()){//Recorremos el resultado de la consulta
				String rut = resultado.getString("rut");
				String nombre = resultado.getString("nombre");
				String apellidoP = resultado.getString("apellidop");
				String apellidoM = resultado.getString("apellidom");
				int edad = resultado.getInt("edad");
				System.out.println();
				System.out.println("Persona "+contador);
				System.out.println("Rut: "+rut);
				System.out.println("Nombre: "+nombre);
				System.out.println("Apellido Paterno: "+apellidoP);
				System.out.println("Apellido Materno: "+ apellidoM);
				System.out.println("Edad: "+edad);
				contador++;
			}

			consulta.close(); //Cierra Las Conexiones
	        BaseDatos.close();
	    } catch (Exception e) {
	        System.err.println( e.getMessage() );
	    }
	}
	public boolean searchByRut(String rut_comprobar){
		url = "jdbc:postgresql://localhost:5432/"+db;
		boolean encontrado = false;
		try {
	        //Conexion con la base de datos
	        BaseDatos = DriverManager.getConnection(url, user, password);
			Statement consulta = (Statement) BaseDatos.createStatement();//Se crea la consulta
			String sql = "SELECT RUT, NOMBRE, APELLIDOP, APELLIDOM, EDAD FROM PERSONA";
		    ResultSet resultado =  consulta.executeQuery(sql);
			
			while (resultado.next()){//Recorremos el resultado de la consulta
				String rut = resultado.getString("rut");
				if(rut.equals(rut_comprobar)){
					encontrado = true;
					break;
				}
			}
			consulta.close(); //Cierra Las Conexiones
	        BaseDatos.close();
	    } catch (Exception e) {
	        System.err.println( e.getMessage() );
	    }
		return encontrado;
	}
	public void actualizarDatos(String rut,String nombre, String apellidop,String apellidom,int edad){
		url = "jdbc:postgresql://localhost:5432/"+db;
		try {
	        //Conexion con la base de datos
	        BaseDatos = DriverManager.getConnection(url, user, password);
			Statement consulta = (Statement) BaseDatos.createStatement();//Se crea la consulta
			//ACTUALIZAMOS NOMBRE
			String sql = "UPDATE PERSONA SET NOMBRE = '"+nombre+"' WHERE RUT = '"+rut+"'";
			consulta.executeUpdate(sql);
			
			//Actulalizamos nombre 
			sql = "UPDATE PERSONA SET APELLIDOP = '"+apellidop+"' WHERE RUT = '"+rut+"'";
			consulta.executeUpdate(sql);

			sql = "UPDATE PERSONA SET APELLIDOM = '"+apellidom+"' WHERE RUT = '"+rut+"'";
			consulta.executeUpdate(sql);

			sql = "UPDATE PERSONA SET EDAD = "+edad+"WHERE RUT = '"+rut+"'";
			consulta.executeUpdate(sql);

			System.out.println("Datos Actualizados Exitosamente!");
			consulta.close(); //Cierra Las Conexiones
	        BaseDatos.close();
	    } catch (Exception e) {
	        System.err.println( e.getMessage() );
	    }
	}

	public void delete_persona(String rut){
		url = "jdbc:postgresql://localhost:5432/"+db;
		try {
	        //Conexion con la base de datos
	        BaseDatos = DriverManager.getConnection(url, user, password);
			Statement consulta = (Statement) BaseDatos.createStatement();//Se crea la consulta
			//ACTUALIZAMOS NOMBRE
			String sql = "DELETE FROM PERSONA WHERE RUT = '"+rut+"'";
			consulta.executeUpdate(sql);
			System.out.println("Persona eliminada Exitosamente");
			consulta.close(); //Cierra Las Conexiones
	        BaseDatos.close();
	    } catch (Exception e) {
	        System.err.println( e.getMessage() );
	    }
	}
}
