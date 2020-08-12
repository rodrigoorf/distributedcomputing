import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws IOException, InterruptedException {
		//UDP
		ComunicacaoUDP udp = new ComunicacaoUDP(9898);
		DatagramPacket pkt = udp.gerarPacketCli("adicionarUsuario,admin,1,admin,true"); // adicionar usuário
		udp.enviarPacket(pkt);
		DatagramPacket recebe = udp.recebePacket();
		System.out.println(udp.conteudoUltimoPacket);
		int portaPadrao = recebe.getPort();
		recebe = udp.enviarReceberPacketAtn("adicionarLivro,1,Pequeno Príncipe,2018,1", portaPadrao); // adicionar livro
		System.out.println(udp.conteudoUltimoPacket);
		recebe = udp.enviarReceberPacketAtn("consultarLivros,", portaPadrao); // consultar livro
		System.out.println(udp.conteudoUltimoPacket);
		recebe = udp.enviarReceberPacketAtn("adicionarUsuario,teste,2,teste,false", portaPadrao); // add usuário
		System.out.println(udp.conteudoUltimoPacket);
		recebe = udp.enviarReceberPacketAtn("emprestarLivro,1,2", portaPadrao); // emprestar livro
		System.out.println(udp.conteudoUltimoPacket);
		recebe = udp.enviarReceberPacketAtn("consultarLivros,", portaPadrao); // consultar livro
		System.out.println(udp.conteudoUltimoPacket);
		recebe = udp.enviarReceberPacketAtn("devolverLivro,1", portaPadrao); // devolver livro
		System.out.println(udp.conteudoUltimoPacket);
		recebe = udp.enviarReceberPacketAtn("consultarLivros,", portaPadrao); // consultar livro
		System.out.println(udp.conteudoUltimoPacket);
		recebe = udp.enviarReceberPacketAtn("removerLivro,1,1", portaPadrao); // consultar livro
		System.out.println(udp.conteudoUltimoPacket);
		recebe = udp.enviarReceberPacketAtn("consultarLivros,", portaPadrao); // consultar livro
		System.out.println(udp.conteudoUltimoPacket);
		udp.encerrarConexao();
		
		//TCP
		/*Socket s = new Socket(InetAddress.getByName("localhost"), 8080);
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		out.writeUTF("adicionarUsuario,admin,1,admin,true");
		out.flush();
		DataInputStream in = new DataInputStream(s.getInputStream());
		String retorno = in.readUTF();
		System.out.println(retorno);
		out.writeUTF("consultarLivros,");
		out.flush();
		retorno = in.readUTF();
		System.out.println(retorno);*/
	}

}
