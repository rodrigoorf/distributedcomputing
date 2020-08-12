public class Consumidor extends Thread {
	int y;
	Fila f;
	
	public Consumidor(int valor, Fila f){
		this.y = valor;
		this.f = f;
	}
	
	public void run(){
		while(true){
			f.removerPrimeiro(this);
			try {
				sleep(y * 1000);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
