package Servidor;

import java.io.Serializable;

public class Operacao implements Serializable {
	double num1;
	double num2;
	String op;
	
	public Operacao(double num1, double num2, String op) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.op = op;
	}
	
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
}
