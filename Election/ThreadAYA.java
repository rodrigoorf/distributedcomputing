import java.io.IOException;
import java.net.DatagramPacket;
import java.util.Random;

//AYA
public class ThreadAYA extends Thread {
	Comunicacao c;
	int idCoordenador;
	
	public ThreadAYA(Comunicacao c, int idCoordenador){
		this.c = c;
		this.idCoordenador = idCoordenador;
	}
	
	public void run(){
		boolean con = true;
		while(con){
			Random r = new Random();
			try {
				c.enviarMensagemUnicast("AYA", idCoordenador);
				System.out.println("Coordenador está vivo?");
				DatagramPacket p = c.receberMensagemUnicast(10000);
				String msg = Comunicacao.getConteudo(p);
				if(msg.equals("IAA")){
					System.out.println("Coordenador respondeu");
					int aleatorio = r.nextInt(15-5) + 5;
					System.out.println("Dormirá por " + aleatorio + " segundos");
					Thread.sleep(aleatorio * 1000);
				}
			} catch (IOException e) {
				con = false;
				//iniciar a eleição e encerrar o processo
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
	}
}
