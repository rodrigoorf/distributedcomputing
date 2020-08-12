import java.io.IOException;
import java.net.DatagramPacket;
//AIC
public class ThreadWho extends Thread {
	Comunicacao c;
	public ThreadWho(Comunicacao c){
		this.c = c;
	}
	
	public void run(){
		while(true){
			try {
				DatagramPacket p = c.receberMensagemMulticast(0);
				String msg = Comunicacao.getConteudo(p);
				if(msg.equals("WHO")){
					c.enviarMensagemUnicast("AIC", p.getPort());
					System.out.println("Eu sou o coordenador PARA: " + p.getPort());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
