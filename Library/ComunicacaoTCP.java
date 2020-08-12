import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ComunicacaoTCP {
	Socket s;
	ServerSocket ss;
	DataInputStream in;
	DataOutputStream out;
	
	public ComunicacaoTCP(int porta, String verificar) throws UnknownHostException, IOException{ // cliente
		if(verificar.equals("cliente") || verificar.equals("thread")){
			s = new Socket(InetAddress.getLocalHost(), porta);
			in = new DataInputStream(s.getInputStream());
			out = new DataOutputStream(s.getOutputStream());
		}
		if(verificar.equals("servidor")){
			ss = new ServerSocket(porta);
			s = ss.accept();
			in = new DataInputStream(s.getInputStream());
			out = new DataOutputStream(s.getOutputStream());
		}
	}
	
	public void enviarString(String texto, Socket s) throws IOException{
		in = new DataInputStream (s.getInputStream());
		out = new DataOutputStream(s.getOutputStream());
		
		out.writeUTF(texto);
		out.flush();
	}
	
	public String receberString() throws IOException{
		in = new DataInputStream(s.getInputStream());
		return in.readUTF();
	}
	
	public void encerrarConexao(String texto) throws IOException{
		if(texto.equals("cliente") || texto.equals("thread")){
			s.close();
		} else {
			s.close();
			ss.close();
		}
	}
	
	public void aceitar() throws IOException{
		s = ss.accept();
	}
	
}
