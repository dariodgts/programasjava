import java.util.*;
import java.io.*;
public class Cuenta{

private String cedula="";
private String numeroCuenta="";
private String tipo="";
private double balance=0.0;
private ArrayList<Cuenta> cuentalist;
private BufferedReader bReader;

public Cuenta(){
}
public Cuenta(String p_cedula,String p_numeroCuenta,String p_tipo,double p_balance){

cedula=p_cedula;
numeroCuenta=p_numeroCuenta;
tipo=p_tipo;
balance=p_balance;

}

public String getCedula(){
return cedula;
}
public String getNumeroCuenta(){
return numeroCuenta;
}
public String getTipo(){
return tipo;
}
public double getBalance(){
return balance;
}
public ArrayList<Cuenta> getCuentaList()
{
	return cuentalist;
}
public void Leer(){
	
	try{
String Archivo="Cuenta.txt";
bReader = new BufferedReader(new FileReader(Archivo));
cuentalist = new ArrayList<Cuenta>();
String linea = null;
while((linea = bReader.readLine())!=null){
String[] datos = linea.split("\\|");
cedula = datos[0];	
numeroCuenta = datos[1];
tipo = datos[2];
balance = Double.parseDouble(datos[3]);

cuentalist.add(new Cuenta(cedula,numeroCuenta,tipo,balance));
}

}
	catch(Exception ex)
	{
		System.out.println("IOException"+ex);
	}
}
public String toString(){
String resul="IDentificador: "+cedula+"\tNumero Cuenta: "+numeroCuenta+"\tTipo Cuenta: "+tipo+"\tBalance: "+balance;
return resul;

}

public void mostrar(){
		for(Cuenta p: cuentalist){
	System.out.println(p);
}
}
}