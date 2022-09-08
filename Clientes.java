import java.util.*;
import java.io.*;
public class Clientes{
	
private String cedula="";
private String nombre="";
private String estado="";
private String fechaNacimineto="";
private String estadoCivil="";
private ArrayList<Clientes> clientelist ;
private BufferedReader bReader;

public Clientes(){
}
public Clientes(String p_cedula,String p_nombre,String p_estado,String p_fechanacimiento,String p_estadocivil){
cedula=p_cedula;
nombre=p_nombre;
estado=p_estado;
fechaNacimineto=p_fechanacimiento;
estadoCivil=p_estadocivil;
}
public ArrayList<Clientes> getClienteList(){
	return clientelist;
}
public String getCedula(){
	return cedula;
}
public String getNombre(){
	return nombre;
}
public String getEstado(){
	return estado;
}
public String getFechaN(){
	return fechaNacimineto;
}
public String getEstadoCivil(){
	return estadoCivil;
}
public void Leer(){
	
	try{
		
String Archivo="Clientes.txt";
bReader = new BufferedReader(new FileReader(Archivo));
clientelist= new ArrayList<Clientes>();
String linea = null;
while((linea = bReader.readLine())!=null){
String[] datos = linea.split("\\|");
cedula = datos[0];	
nombre = datos[1];
estado = datos[2];
fechaNacimineto = datos[3];
estadoCivil = datos[4];

clientelist.add(new Clientes(cedula,nombre,estado,fechaNacimineto,estadoCivil));
}

}
	catch(Exception ex)
	{
		System.out.println("IOException"+ex);
	}
}

public String toString(){
	String resul= "Cedula: "+cedula+"\tNombre y Apellido: "+nombre
	+"\tEstado: "+estado+"\tFecha Nacimiento: "+fechaNacimineto+"\tEstado Civil: "+estadoCivil;
	return resul;
}

public void mostrar(){
		for(Clientes p: clientelist){
	System.out.println(p);
		}
}	


}
