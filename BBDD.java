package Clases;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class BBDD {
	
	//Declaracion de variables
	static Scanner opcion = new Scanner(System.in);
	static SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
	static int accion_general_Int=0;
	static String accion_general_String="";
	static float accion_general_float=0;
	static String error_general="Err:\tElije una opcion valida.";
	static ODB odb;
	static IQuery query=null;
	static Objects<Depart> objectDepart=null;
	static Objects<Emple> objectEmple=null;
	static Emple emples = new Emple();
	static int i=0;
	static int deptNo=0;
	static String dnombre="";
	static String loc="";
	static int EmpNo=0;
	static String Apellido="";
	static String Oficio="";
	static float Comision=0;
	static Depart Dept=null;
	static int datos_temporales_Int;
	static Depart departs =new Depart();
	static int fechas= 0;
	static Date date=null;
	static String nombreDB= "EMPRESA1009.DB";
	static Integer salir;

	public static void main(String[] args) throws ParseException {
		
		//creando fechas
		Date fecha1 = new Date(1990, 11, 17);
		Date fecha2 = new Date(1990, 1, 20);
		Date fecha3 = new Date(1991, 1, 22);
		Date fecha4 = new Date(1990, 3, 2);
		Date fecha5 = new Date(1991, 8, 29);
		Date fecha6 = new Date(1991, 4, 1);
		Date fecha7 = new Date(1991, 07, 9);
		Date fecha8 = new Date(1991, 10, 9);
		Date fecha9 = new Date(1991, 10, 17);
		Date fecha10 = new Date(1991, 8, 8);
		Date fecha11 = new Date(1991, 8, 23);
		Date fecha12 = new Date(1991, 11, 3);
		Date fecha13 = new Date(1991, 11, 3);
		Date fecha14 = new Date(2092, 0, 23);
		
		//Creando objetos de tipo Depart
		Depart dept1= new Depart(10, "CONTABILIDAD", "SEVILLA");
		Depart dept2= new Depart(20, "INVESTIGACION", "MADRID");
		Depart dept3= new Depart(30, "VENTAS", "BARCELONA");
		Depart dept4= new Depart(40, "PRODUCCION", "BILBAO");
		Depart dept5= new Depart(62, "MARKETING", "GUADALAJARA");	
		
		//Creando objetos de tipo Emple
		Emple em1= new Emple(7369, "SANCHEZ", "EMPLEADO", null, fecha1, 1040, dept3);
		Emple em2= new Emple(7499, "ARROYO", "VENDEDOR", null, fecha2, 1500, dept3);
		Emple em3= new Emple(7521, "SALA", "VENDEDOR", null, fecha3, 1625, dept3);
		Emple em4= new Emple(7566, "JIMENEZ", "DIRECTOR", null, fecha4, 2900, dept2);
		Emple em5= new Emple(7654, "MARTIN", "VENDEDOR", null, fecha5, 1600, dept3);
		Emple em6= new Emple(7698, "NEGRO", "DIRECTOR", null, fecha6, 3005, dept3);
		Emple em7= new Emple(7782, "CEREZO", "DIRECTOR", null, fecha7, 2885, dept1);
		Emple em8= new Emple(7788, "GIL", "ANALISTA", null, fecha8, 3000, dept2);
		Emple em9= new Emple(7839, "REY", "PRESIDENTE", null, fecha9, 4100, dept1);
		Emple em10= new Emple(7844, "TOVAR", "VENDEDOR", null, fecha10, 1350, dept3);
		Emple em11= new Emple(7876, "ALONSO", "EMPLEADO", null, fecha11, 1430, dept2);
		Emple em12= new Emple(7900, "JIMENO", "EMPLEADO", null, fecha12, 1335, dept3);
		Emple em13= new Emple(7902, "FERNANDEZ", "ANALISTA", null, fecha13, 3000, dept2);
		Emple em14= new Emple(7934, "MUÑOZ", "EMPLEADO", null, fecha14, 1690, dept1);
		
		odb = ODBFactory.open(nombreDB);//Creando la base de datos
		
		odb.store(dept1); // Almacenamos objetos de tipo Depart
		odb.store(dept2);
		odb.store(dept3);
		odb.store(dept4);
		odb.store(dept5); 
		
		odb.store(em1);
		odb.store(em2);
		odb.store(em3);
		odb.store(em4);
		odb.store(em5);
		odb.store(em6);
		odb.store(em7);
		odb.store(em8); // Almacenamos objetos de tipo Emple
		odb.store(em9);
		odb.store(em10);
		odb.store(em11);
		odb.store(em12);
		odb.store(em13);
		odb.store(em14);
		
		odb.commit();//Commit para confimar la insersion de datos
		odb.close();//Cerrando base de datos
		
		do {
			System.out.println("¿Que quieres hacer?");
			System.out.println("<1>Insertar datos");
			System.out.println("<2>Visualizar datos");
			System.out.println("<3>Modificar datos");
			System.out.println("<4>Eliminar datos");
			System.out.println("<0>Salir");
			accion_general_Int=comprobarValorInt();//Funcion que comprueba si el valor de entrada es de tipo int (linea 413)
			
			switch(accion_general_Int) {
				case 1:{
					insertarDatos();//En el caso de que introduzca 1, insertaremos datos (linea 144)
					break;
				}
				case 2:{
					visualizarDatos();	//En el caso de que introduzca 2, visualizaremos datos (linea 262)
					break;
					
				}case 3:{
					modificarDatos();	//En el caso de que introduzca 3, modificaremo datos (linea 345)
					
					break;					
				}case 4:{
					eliminarDatos();	//En el caso de que introduzca 4, insertaremos datos (linea 380)
					break;
					
				}default:{
					break;					
				}
			}
		}while(accion_general_Int!=0);//En el caso de que introduzca 0, el programa finalizara
		System.out.println("Adios!");
	}
	
	public static void insertarDatos() throws ParseException {
		do {
			System.out.println("Para insertar datos se necesita saber en que objeto/tabla:");
			System.out.println("<1>Tabla Depart");
			System.out.println("<2>Tabla Emple");
			System.out.println("<0>Salir");
			accion_general_Int=comprobarValorInt();
			
			switch(accion_general_Int) {
				case 1:{//En el caso de que introduzca 1, insertaremos datos de tipo Depart
					
					do {
						System.out.println("Insertando datos en Depart:");
						System.out.print("deptNo: ");
						deptNo = comprobarValorInt();
						
						System.out.print("dnombre: ");
						dnombre = comprobarValorString();
						
						System.out.print("loc: ");
						loc = comprobarValorString();
						
						departs=new Depart(deptNo, dnombre, loc);//Creamos un nuevo objeto de tipo Depart
						
						odb.store(departs);//Subimos los nuevos datos a la base de datos
						odb.commit();
						odb.close();
						
						System.out.println("¿Otra vez?");
						System.out.println("<0>Si");
						System.out.println("<1>No");
						accion_general_Int=comprobarValorInt();
						
					}while(accion_general_Int==0);				
					
					break;
					
				}case 2:{//En el caso de que introduzca 2, insertaremos datos de tipo Emple
					do {
						System.out.println("Insertando datos en Emple:");
						
						System.out.print("empNo: ");						
						accion_general_Int=comprobarValorInt();//Funcion que comprueba si el valor de entrada es de tipo int (linea 413)
						
						query=new CriteriaQuery(Emple.class, Where.equal("empNo", accion_general_Int));
						Emple empleadoEmpNo = (Emple) odb.getObjects(query).getFirst();//Buscando un objeto emple con el empNo que haya introducido el usuario					
						EmpNo=empleadoEmpNo.getEmpNo();
						
						if(odb.getObjects(query).size()>=1) {//Si ya existe un objeto de tipo emple con el empNo introducido
							System.out.println("Err:\tYa existe un Empleado con ese empNo.");
							System.out.println("----------------------------------");
							odb.close();
							break;
						}
						

						System.out.print("apellido: ");
						accion_general_String=comprobarValorString();//Funcion que comprueba si el valor de entrada es de tipo String (linea 427)
						
						query=new CriteriaQuery(Emple.class, Where.equal("apellido", accion_general_String));//Buscando un objeto emple con el apellido que haya introducido el usuario
						Emple empleadoApellido = (Emple) odb.getObjects(query).getFirst();						
						Apellido=empleadoApellido.getApellido();
						
						if(odb.getObjects(query).size()>=1) {//Si ya existe un objeto de tipo emple con el apellido introducido
							System.out.println("Err:\tYa existe un Empleado con ese apellido.");
							System.out.println("----------------------------------");
							odb.close();
							break;
						}
						
						System.out.print("oficio: ");
						Oficio=comprobarValorString();					
						
						System.out.print("fechaAlt(yyyy-mm-dd): ");
						date=(Date) format.parse(comprobarValorString());
						
						System.out.print("comision: ");
						Comision = comprobarValorFloat();//Funcion que comprueba si el valor de entrada es de tipo float (linea 459)
						
						System.out.print("depart(Estos son los disponibles): ");
						objectDepart=odb.getObjects(query);
						
						while(objectDepart.hasNext()) {//Mostrando deptNo de los Depart
							Depart departs = objectDepart.next();
							System.out.printf("%d: %d", departs.getDeptNo());							
						}
						
						accion_general_Int=comprobarValorInt();
						query=new CriteriaQuery(Depart.class, Where.equal("deptNo", accion_general_Int));//Buscando un objeto depart con el deptNo que haya introducido el usuario
						Depart Depart = (Depart) odb.getObjects(query).getFirst();						
						
						if(odb.getObjects(query).size()==0) {//Si no existe ningun objeto de tipo depart con el deptNo introducido
							System.out.println("Err:\tNo existe ningun Departamento con ese deptNo.");
							System.out.println("----------------------------------");
							odb.close();
							break;
						}
				
						emples= new Emple(EmpNo, Apellido, Oficio, null, date, Comision, Depart);//Creamos un nuevo objeto de tipo Emple
						odb.store(emples);//Subimos los nuevos datos a la base de datos
						odb.commit();
						odb.close();
						
						System.out.println("¿Otra vez?");
						System.out.println("<0>Si");
						System.out.println("<1>No");
						accion_general_Int=comprobarValorInt();
					
					}while(accion_general_Int==0);
					
					break;
					
				}default:{
					break;			
				}
			}		
		}while(accion_general_Int!=0);		
	}
	
	public static void visualizarDatos() {

		do {

			System.out.println("Para visualizar datos se necesita saber en que objeto/tabla:");
			System.out.println("<1>Tabla Depart");
			System.out.println("<2>Tabla Emple");
			System.out.println("<3>Todas las tablas");
			System.out.println("<0>Salir");
			accion_general_Int=comprobarValorInt();
			
			switch(accion_general_Int) {
				case 1:{					
					odb = ODBFactory.open(nombreDB);//Abriendo base de datos ya creada
					query=new CriteriaQuery(Depart.class);//Creando query general
					objectDepart=odb.getObjects(query);
					
					if(objectDepart.isEmpty()) {//Comprobando si la el objeto no este vacio
						System.out.println("Objeto vacio");
						break;
					}
					
					i = 1;

					while(objectDepart.hasNext()){//Visualizando todos los datos que nos ha devuelto la query
						Depart departs = objectDepart.next();
						System.out.printf("Datos de Depart nº%d: deptNo: %d, dnombre: %s, loc: %s %n",
						i++, departs.getDeptNo(), departs.getDnombre(),
						departs.getLoc());
					 }
					odb.close(); // Cerrar BD 
					System.out.println("----------------------------------");
					
					break;
					
				}case 2:{
					odb = ODBFactory.open(nombreDB);//Abriendo base de datos ya creada
					query=new CriteriaQuery(Emple.class);//Creando query general
					objectEmple=odb.getObjects(query);
					
					if(objectEmple.isEmpty()) {//Comprobando si la el objeto no este vacio
						System.out.println("Objeto vacio");
						break;
					}
					
					i = 1;

					while(objectEmple.hasNext()){//Visualizando todos los datos que nos ha devuelto la query
						Emple emples = objectEmple.next();
						System.out.printf("Datos de Emple nº%d: empNo: %d, apellido: %s, oficio: %s, dir: %s, fechaAlt: %s, comision: %S, dept: %s %n",
						i++, emples.getEmpNo(), emples.getApellido(),
						emples.getOficio(), emples.getDir(), emples.getFechaAlt(), emples.getComision(), emples.getDept());
					 }
					odb.close(); // Cerrar BD 
					System.out.println("----------------------------------");
					
					break;
					
				}case 3:{
					odb = ODBFactory.open(nombreDB);//Abriendo base de datos ya creada
					query=new CriteriaQuery(Emple.class);//Creando query general
					objectEmple=odb.getObjects(query);
					
					if(objectEmple.isEmpty()) {//Comprobando si la el objeto no este vacio
						System.out.println("Objeto vacio");
						break;
					}
					
					i = 1;

					while(objectEmple.hasNext()){//Visualizando todos los datos que nos ha devuelto la query
						Emple emples = objectEmple.next();
						System.out.printf("Datos de Emple nº%d: empNo: %d, apellido: %s, oficio: %s, dir: %s, fechaAlt: %s, comision: %S, dept: %s %n",
						i++, emples.getEmpNo(), emples.getApellido(),
						emples.getOficio(), emples.getDir(), emples.getFechaAlt(), emples.getComision(), emples.getDept());
					 }
					
					System.out.println("----------------------------------");
					
					query=new CriteriaQuery(Depart.class);
					objectDepart=odb.getObjects(query);
					
					if(objectDepart.isEmpty()) {//Comprobando si la el objeto no este vacio
						System.out.println("Objeto vacio");
						break;
					}
					
					i = 1;

					while(objectDepart.hasNext()){//Visualizando todos los datos que nos ha devuelto la query
						Depart departs = objectDepart.next();
						System.out.printf("Datos de Depart nº%d: deptNo: %d, dnombre: %s, loc: %s %n",
						i++, departs.getDeptNo(), departs.getDnombre(),
						departs.getLoc());
					 }
					odb.close();
					
				}default:{
					break;			
				}
			}		
		}while(accion_general_Int!=0);	
	}
	
	public static void modificarDatos() {	

		do {
			System.out.println("Para modificar el salario de un Emple, se necesita saber su apellido(<0> Salir):");		
	
			odb = ODBFactory.open(nombreDB);
			System.out.println("apellido: ");
			accion_general_String=comprobarValorString();
			IQuery query=new CriteriaQuery(Emple.class, Where.equal("apellido", accion_general_String));//Buscando un objeto emple con el apellido que haya introducido el usuario
				
			if(odb.getObjects(query).size()==0) {//Si no existe ningun objeto de tipo emple con el apellido introducido
				System.out.println("Err:\tNo existe ningun empleado con ese apellido.");
				System.out.println("----------------------------------");
				odb.close();
				return;
			}
			
			Emple comisionNuevo = (Emple) odb.getObjects(query).getFirst();
			float comisionViejo =comisionNuevo.getComision();//obteniendo la comision actual
			System.out.print("comision: ");
			accion_general_float=comprobarValorFloat();
			comisionNuevo.setComision(accion_general_float);
			odb.store(comisionNuevo);//Insertando nuevo valor en la base de datos
			odb.commit();
			odb.close();
			
			System.out.println("Se ha modificado el salario: " + "(" + comisionViejo + ") a (" + comisionNuevo.getComision() + ") de " + accion_general_String);
			System.out.println("----------------------------------");
			System.out.println("¿Otra vez?");
			System.out.println("<0>Si");
			System.out.println("<1>No");
			accion_general_Int=comprobarValorInt();
		
		}while(accion_general_Int==0);
	}
	
	public static void eliminarDatos() {
		do {
			System.out.println("Para eliminar un emple se necesita saber el apellido:");
			accion_general_String=comprobarValorString();
			
			odb = ODBFactory.open(nombreDB);
			query = new CriteriaQuery(Emple.class, Where.equal("apellido",accion_general_String));//Buscando un objeto emple con el apellido que haya introducido el usuario
			
			if(odb.getObjects(query).size()==0) {//Si no existe ningun objeto de tipo emple con el apellido introducido
				System.out.println("Err:\tNo existe ningun empleado con ese apellido.");
				System.out.println("----------------------------------");
				odb.close();
				return;
			}
			
			Emple emple = (Emple) odb.getObjects(query).getFirst();//obteniendo 
			
			odb.delete(emple);
			odb.commit();
			odb.close();
			
			System.out.println("Se ha eliminado un elemento: " + accion_general_String);
			System.out.println("----------------------------------");
			
			System.out.println("¿Otra vez?");
			System.out.println("<0>Si");
			System.out.println("<1>No");
			accion_general_Int=comprobarValorInt();
	
		}while(accion_general_Int==0);
		
	}
	
	public static int comprobarValorInt() {
		Scanner opcion = new Scanner(System.in);
		while(!opcion.hasNextInt()) {
			
			opcion.next();
			System.out.println(error_general);
			
		}
		return opcion.nextInt();
	}
	
	public static String comprobarValorString() {
		Scanner opcion = new Scanner(System.in);
		while(!opcion.hasNextLine()) {
				
			opcion.next();
			System.out.println(error_general);
				
		}
		return opcion.nextLine();
	}
	
	public static float comprobarValorFloat(){
		Scanner opcion = new Scanner(System.in);
		while(!opcion.hasNextFloat()) {
			
			opcion.next();
			System.out.println(error_general);
				
		}
		return opcion.nextFloat();
	}
	
	
}



