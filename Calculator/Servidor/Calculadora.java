package Servidor;

import java.rmi.RemoteException;

public class Calculadora implements IClass {

	@Override
	public double executar(Operacao o) throws RemoteException {
		switch(o.getOp()){
			case "+":
				System.out.println(o.num1 + o.num2);
				return o.num1 + o.num2;
			case "-":
				System.out.println(o.num1 - o.num2);
				return o.num1 - o.num2;
			case "*":
				System.out.println(o.num1 * o.num2);
				return o.num1 * o.num2;
			case "/":
				if(o.num2 == 0){
					System.out.println("Divisão por zero");
					return -1;
				}
				System.out.println(o.num1 / o.num2);
				return o.num1 / o.num2;
			default:
				System.out.println("Operação inválida");
				return -1;
		}
	}
	
	
}
