import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ComunicacaoUDP {
	DatagramSocket s;
	String conteudoUltimoPacket;
	
	public ComunicacaoUDP(int porta) throws SocketException{
		s = new DatagramSocket(porta);
	}
	
	public ComunicacaoUDP() throws SocketException{ // para threads
		s = new DatagramSocket();
	}
	
	public void estabelecerComunicacao(InetAddress endereco, int porta){
		//TODO 
	}
	
	public DatagramPacket gerarPacketCli(String msg) throws UnknownHostException{
		DatagramPacket pkt = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getLocalHost(), 8080);
		return pkt;
	}
	
	public DatagramPacket gerarPacketSrv(String msg) throws UnknownHostException{
		DatagramPacket pkt = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getLocalHost(), 9898);
		return pkt;
	}
	
	public DatagramPacket gerarPacketAtn(String msg, int porta) throws UnknownHostException{
		DatagramPacket pkt = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getLocalHost(), porta);
		return pkt;
	}
	
	public DatagramPacket enviarReceberPacketAtn(String msg, int porta) throws IOException{
		DatagramPacket pkt = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getLocalHost(), porta);
		s.send(pkt);
		pkt = new DatagramPacket(new byte[1024], 1024);
		s.receive(pkt);
		conteudoUltimoPacket = new String(pkt.getData(), pkt.getOffset(), pkt.getLength());
		return pkt;
	}
	
	public void enviarPacket(DatagramPacket pkt) throws IOException{
		s.send(pkt);
	}
	
	public DatagramPacket recebePacket() throws IOException{
		DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
		s.receive(p);
		conteudoUltimoPacket = new String(p.getData(), p.getOffset(), p.getLength());
		return p;
	}
	
	public void encerrarConexao(){
		s.close();
	}
	
	
}
