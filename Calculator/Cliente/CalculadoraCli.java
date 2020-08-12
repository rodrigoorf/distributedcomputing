package Cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Servidor.IClass;
import Servidor.Operacao;

public class CalculadoraCli {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry r = LocateRegistry.getRegistry();
		IClass stub = (IClass)r.lookup("Calculadora");
		Operacao o = new Operacao(2, 2, "+");
		System.out.println(stub.executar(o));
		// C:\Users\Rodrigo\Dropbox\BSI\5° Período (2018.1)\Programação V\Aulas\Aula 05\Calculadora\bin>"c:\Program Files\Java\jdk1.8.0_121\bin"\rmiregistry.exe
	}

}
