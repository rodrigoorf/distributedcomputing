//IAA
import java.io.IOException;
import java.net.DatagramPacket;

public class ThreadIAA extends Thread {
	Comunicacao c;
	
	public ThreadIAA(Comunicacao c){
		this.c = c;
	}
	
	public void run(){
		while(true){
			try {
				DatagramPacket p = c.receberMensagemUnicast(30000);
				String msg = Comunicacao.getConteudo(p);
				if(msg.equals("AYA")){
					c.enviarMensagemUnicast("IAA", p.getPort());
					System.out.println("Eu estou vivo PARA: " + p.getPort());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
