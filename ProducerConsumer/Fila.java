import java.util.ArrayList;

public class Fila {
	ArrayList<Integer> fila = new ArrayList<Integer>(10);
	
	public synchronized void adicionarNumero(int numero, Produtor p){
		while (!status()){
			try {
				System.out.println(p.getName() + " aguardando liberação");
				wait();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		fila.add(numero);
		System.out.println(p.getName() + " produziu " + numero);
		notify();
	}
	
	public synchronized void removerPrimeiro(Consumidor c) {
		while(!statusCons()){
			try {
				System.out.println(c.getName() + " aguardando novos números");
				wait();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
			System.out.println(c.getName() + " removeu " + fila.get(0));
			fila.remove(0);
			notify();
	}
	
	public boolean status() {
		if (fila.size() <= 9) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean statusCons(){
		if (fila.size() > 0){
			return true;
		} else {
			return false;
		}
	}
}
