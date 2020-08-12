import java.util.Random;

public class Produtor extends Thread {
	int x;
	Fila f;
	public Produtor(int valor, Fila f){
		this.x = valor;
		this.f = f;
	}
	
	public void run(){
		while(true) {
			Random r = new Random();
			int aleatorio = r.nextInt(1000);
			f.adicionarNumero(aleatorio, this);
			try{
				sleep(x * 1000);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
