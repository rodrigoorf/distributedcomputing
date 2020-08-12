package Servidor;
import java.rmi.*;

public interface IClass extends Remote {
	public double executar(Operacao o) throws RemoteException;
}
