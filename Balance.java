
	import java.io.*;
	public class Balance{
		
	private Cuenta objCuenta;
	private Clientes objCliente;
	private String cedula="";
	private String nombre="";
	private String numeroCuenta="";
	private String tipo="";
	private double balance=0.0;
	public Balance(){
		
	}

	public Balance(Clientes unCliente,Cuenta unaCuenta){
	objCliente=unCliente;
	objCuenta=unaCuenta;
	}
	public String getCedula(){
		return objCliente.getCedula();
	}
	public String getNombre(){
		return objCliente.getNombre();
	}
	public String getNumeroCuenta(){
		return objCuenta.getNumeroCuenta();
	}
	public String getTipo(){
	return objCuenta.getTipo();
	}
	public double getBalance(){
		
		return objCuenta.getBalance();
	}
	
public void getData() {
	for(int i = 0;i < objCliente.getClienteList().size();i++)
	{
		if(!objCliente.getClienteList().get(i).getEstado().equals("NO")) {
		cedula = objCliente.getClienteList().get(i).getCedula();
		nombre =objCliente.getClienteList().get(i).getNombre();
		}
	}
	
	for(int i = 0;i < objCuenta.getCuentaList().size();i++)
	{
		if(objCuenta.getCuentaList().get(i).getBalance()>=10000 ) {
			if (!objCuenta.getCuentaList().get(i).getCedula().equals(cedula)) return;
		
		
			numeroCuenta= objCuenta.getCuentaList().get(i).getNumeroCuenta();
			 if(objCuenta.getCuentaList().get(i).getTipo().equals("AHORRO")) {
		tipo=objCuenta.getCuentaList().get(i).getTipo();
		balance=objCuenta.getCuentaList().get(i).getBalance();
			 }
		}
	}
	}


	public String toString(){
	getData();
		String resul = "Cedula: "+cedula+"\tNombres: "+nombre+"\tTipo: "+tipo+"\tNumero Cuenta: "+numeroCuenta+"\tBalance: "+balance;
		return resul;
	}
	public void Guarda(){
		
		String Archivo ="Balance.txt";
		
		PrintWriter pWriter =null;
		String datos= cedula+","+nombre+","+numeroCuenta
		+","+tipo+","+balance;
		try{
		File fArchivo = new File(Archivo);
		pWriter = new PrintWriter(new BufferedWriter (new FileWriter(Archivo,true)));
		pWriter.println();
		if(!fArchivo.exists())
		{
			fArchivo.createNewFile();
		}
		else {	
			pWriter.append(datos);
		
		}
		pWriter.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error "+ex);
		}
	}
}
