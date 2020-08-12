import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) throws IOException, InterruptedException {
		//UDP
		ComunicacaoUDP udp = new ComunicacaoUDP(8080);
		DatagramPacket pkt = udp.recebePacket();
		Atendente a = new Atendente(pkt);
		a.start();
		
		//TCP
		/*ComunicacaoTCP tcp = new ComunicacaoTCP(8080, "servidor");
		String retorno = tcp.receberString();
		Atendente a = new Atendente(retorno);
		a.start();
		/*ServerSocket ss = new ServerSocket(8080);
		Socket s = ss.accept();
		DataInputStream in = new DataInputStream(s.getInputStream());
		while(true){
			String ret = in.readUTF();
			Atendente a = new Atendente(ret, s);
			a.start();
		}*/
	}

}
