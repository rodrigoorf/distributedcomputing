import java.io.IOException;
import java.net.DatagramPacket;

public class ThreadElection extends Thread {
	Comunicacao c;
	ThreadAYA aya;
	
	public ThreadElection(Comunicacao c, ThreadAYA aya){
		this.c = c;
		this.aya = aya;
	}
	
	public void run(){
		boolean con = true;
		while(con){
			try {
				DatagramPacket p = c.receberMensagemMulticast(10000);
				String msg = Comunicacao.getConteudo(p);
				if(msg.equals("ELECTION")){
					System.out.println("Recebi uma solicitação de eleição!");
					//aya.interrupt();
					if(c.getID() > p.getPort()){
						c.enviarMensagemUnicast("OK", p.getPort());
						c.enviarMensagemMulticast("ELECTION");
						try {
							p = c.receberMensagemUnicast(10000);
							msg = Comunicacao.getConteudo(p);
							//Thread.sleep(60000);
							iniciarProcesso(c);
							con = false;
						} catch (Exception e){
							System.out.println("Eu sou o novo coordenador!");
							c.enviarMensagemMulticast("COORDINATOR");
							iniciarCoordenador(c);
						}
					} else {
						//Thread.sleep(60000);
						iniciarProcesso(c);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
	
	public void iniciarCoordenador(Comunicacao c){
		ThreadWho tw = new ThreadWho(c);
		ThreadIAA iaa = new ThreadIAA(c);
		tw.start();
		iaa.start();
	}
	
	public void iniciarProcesso(Comunicacao c) throws IOException{
		String cd = who(c);
		if(cd.equals("true")){
			System.out.println("Processo " + c.getID() + " é o coordenador");
			iniciarCoordenador(c);
		} else {
			System.out.println("Já existe um coordenador");
			String[] split = cd.split(":");
			int idCoordenador = Integer.parseInt(split[1]);
			ThreadAYA aya = new ThreadAYA(c, idCoordenador);
			ThreadElection election = new ThreadElection(c, aya);
			aya.start();
			election.start();
			boolean aux = true;
			while(aux){
				if(!aya.isAlive()){
					System.out.println("O coordenador caiu!");
					election(c);
					aux = false;
				}
			}
		}
	}
	
	public String who(Comunicacao c) throws IOException{
		System.out.println("Tem algum coordenador aqui?");
		c.enviarMensagemMulticast("WHO");
		try {
			DatagramPacket p = c.receberMensagemUnicast(10000);
			return "Coordenador:" + Integer.toString(p.getPort());
			
		} catch (Exception e){
			System.out.println("Não tem nenhum coordenador aqui!");
			c.enviarMensagemMulticast("COORDINATOR");
			return "true";
		}
	}
	
	public boolean election(Comunicacao c) throws IOException{
		System.out.println("Vou iniciar uma eleição!");
		c.enviarMensagemMulticast("ELECTION");
		try {
			c.receberMensagemUnicast(10000);
			System.out.println("Não posso ser coordenador :(");
			return false;
		} catch (Exception e){
			System.out.println("Eu sou o novo coordenador!");
			c.enviarMensagemMulticast("COORDINATOR");
			iniciarCoordenador(c);
			return true;
		}
	}
}
