import java.io.IOException;
import java.net.DatagramPacket;

public class Processo {

	public static void main(String[] args) throws IOException, InterruptedException {
		Comunicacao c = new Comunicacao();
		int id = c.getID();
		System.out.println(id);
		boolean isCoordenador = false;
		String cd = who(c);
		if(cd.equals("true")){
			isCoordenador = true;
			System.out.println("Processo " + id + " é o coordenador");
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
					aux = !election(c);
					
				}
			}
		}
	}
	
	public static String who(Comunicacao c) throws IOException{
		System.out.println("Tem algum coordenador aqui?");
		c.enviarMensagemMulticast("WHO");
		try {
			DatagramPacket p = c.receberMensagemUnicast(10000);
			return "Coordenador:" + Integer.toString(p.getPort());
			
		} catch (Exception e){
			System.out.println("Não tem nenhum coordenador aqui!");
			coordinator(c);
			return "true";
		}
	}
	
	public static void aic(Comunicacao c, boolean isCoordinator) throws IOException{
		DatagramPacket p = c.receberMensagemMulticast(0);
		String msg = Comunicacao.getConteudo(p);
		if(msg.equals("WHO")){
			if(isCoordinator){
				String msgEnvio = "AIC";
				c.enviarMensagemUnicast(msgEnvio, p.getPort());
			}
		}	
	}
	
	public static void coordinator(Comunicacao c) throws IOException{
		c.enviarMensagemMulticast("COORDINATOR");
	}
	
	public static boolean election(Comunicacao c) throws IOException{
		System.out.println("Vou iniciar uma eleição!");
		c.enviarMensagemMulticast("ELECTION");
		try {
			c.receberMensagemUnicast(10000);
			//iniciarProcesso(c);
			return false;
		} catch (Exception e){
			System.out.println("Eu sou o novo coordenador!");
			c.enviarMensagemMulticast("COORDINATOR");
			iniciarCoordenador(c);
			return true;
		}
	}
	
	public static void iniciarCoordenador(Comunicacao c){
		ThreadWho tw = new ThreadWho(c);
		ThreadIAA iaa = new ThreadIAA(c);
		tw.start();
		iaa.start();
	}
	
	public static void iniciarProcesso(Comunicacao c) throws IOException{
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

}
