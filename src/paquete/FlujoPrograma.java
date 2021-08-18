package paquete;
import java.util.Scanner;
public class FlujoPrograma {
	
	public FlujoPrograma() {
		menu();
	}
	
	private void menu() {
		boolean continuar = true;
		while(continuar){
		Scanner entrada = new Scanner(System.in);
		System.out.println("-------Programa---Crud---Persona");
		System.out.println("1.-Insertar una Persona");
		System.out.println("2.-Mostrar Todas Las personas registradas");
		System.out.println("3.-Actualizar Datos de la persona");
		System.out.println("4.-Eliminar una persona");
		System.out.print("Opcion: ");
		int opcion = entrada.nextInt();
		
		switch(opcion){
			case 1:{
				System.out.println("Ingrese los datos de la persona que quiere registrar");
				System.out.print("Ingrese rut: ");
				Scanner entrada2 = new Scanner(System.in);
				String rut = entrada2.nextLine();
				System.out.println("Ingrese Nombre: ");
				String nombre = entrada2.nextLine();
				System.out.println("Ingrese apellido Paterno: ");
				String apellidoP = entrada2.nextLine();
				System.out.println("Ingrese apellido Materno");
				String apellidoM = entrada2.nextLine();
				Scanner entrada3 = new Scanner(System.in);
				System.out.println("Ingrese edad: ");
				int edad = entrada3.nextInt();

				Persona persona = new Persona(rut,nombre,apellidoP,apellidoM,edad);
				Conexion conexion = new Conexion("postgres","Cruzadicto2409.","db_java");
				conexion.insertar_datos(persona);
				break;
			}
			case 2:{
				Conexion conexion2 = new Conexion("postgres","Cruzadicto2409.","db_java");
				conexion2.mostrar_todos_los_registros();
				break;
			}
			case 3:{
				System.out.print("Ingrese rut de la persona con formato (xx.xxx.xxx-x): ");
				Conexion conexion = new Conexion("postgres","Cruzadicto2409.","db_java");
				Scanner entrada2 = new Scanner(System.in);
				String rut = entrada2.nextLine();
	
				if(conexion.searchByRut(rut)){
					System.out.println("Ingrese Nombre: ");
					String nombre = entrada2.nextLine();
					System.out.println("Ingrese apellido Paterno: ");
					String apellidoP = entrada2.nextLine();
					System.out.println("Ingrese apellido Materno");
					String apellidoM = entrada2.nextLine();
					Scanner entrada3 = new Scanner(System.in);
					System.out.println("Ingrese edad: ");
					int edad = entrada3.nextInt();

					conexion.actualizarDatos(rut,nombre,apellidoP,apellidoM,edad);
				}else{
					System.out.println("OH no, al parecer no existe la persona o el formato es incorrecto");
				}
			}
			case 4:{
				
				Conexion conexion = new Conexion("postgres","Cruzadicto2409.","db_java");
				System.out.println("Personas Registradas en nuestra base de datos");
				conexion.mostrar_todos_los_registros();//Mostramos Registros para buscar la persona
				Scanner entrada2 = new Scanner(System.in);
				System.out.print("Ingrese rut de la persona a eliminar con formato (xx.xxx.xxx-x): ");
				String rut = entrada2.nextLine();
				if (conexion.searchByRut(rut)){
					conexion.delete_persona(rut);
				}else{
					System.out.println("OH no, al parecer no existe la persona o el formato es incorrecto");
				}
				break;
			}
		}
		System.out.println("Desea Continuar? SI = 1 || N0 = 0");
		int opcion_final = entrada.nextInt();
		if (opcion_final != 1){
			continuar = false;
		}
		
		}
	}


}
