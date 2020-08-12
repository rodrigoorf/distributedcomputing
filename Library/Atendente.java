import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Atendente extends Thread {
	int porta;
	Biblioteca b = new Biblioteca();
	DatagramPacket pctInicial;
	ComunicacaoUDP udp;
	ComunicacaoTCP tcp;
	ServerSocket ss;
	Socket s;
	DataInputStream in;
	DataOutputStream out;
	String retornoTCP;
	
	public Atendente(DatagramPacket pct) throws SocketException{
		this.porta = pct.getPort();
		udp = new ComunicacaoUDP();
		this.pctInicial = pct;
	}
	
	public Atendente(String msg) throws UnknownHostException, IOException{
		ss = new ServerSocket(8080);
		s = ss.accept();
		in = new DataInputStream(s.getInputStream());
		out = new DataOutputStream(s.getOutputStream());
		this.retornoTCP = msg;
	}
	
	public Atendente(String msg, Socket s) throws UnknownHostException, IOException{
		tcp = new ComunicacaoTCP(8080, "thread");
		this.retornoTCP = msg;
		this.s = s;
	}
	
	public boolean adicionarLivro(String codLivro, String titulo, String anoPublicacao, String codUsrEmpr){
		int cLivro = Integer.parseInt(codLivro);
		int aPublicacao = Integer.parseInt(anoPublicacao);
		int codUsr = Integer.parseInt(codUsrEmpr);
		Livro l = new Livro(cLivro, titulo, aPublicacao);
		if(b.adicionarLivro(l, codUsr)){
			return true;
		}
		return false;
	}
	
	public boolean removerLivro(String livro, int codUsr) throws InterruptedException{
		int codLivro = Integer.parseInt(livro);
		if(b.removerLivro(codLivro, codUsr)){
			return true;
		}
		return false;
	}
	
	public boolean consultarLivros(){
		if(b.consultarLivros()){
			return true;
		}
		return false;
	}
	
	public boolean emprestarLivro(int livro, int usuario) throws InterruptedException{
		if(b.emprestarLivro(livro, usuario)){
			return true;
		}
		return false;
	}
	
	public boolean adicionarUsuario(Usuario u){
		if(b.adicionarUsuario(u)){
			return true;
		}
		return false;
	}
	
	public boolean devolverLivro(int livro) throws InterruptedException{
		if(b.devolverLivro(livro)){
			return true;
		}
		return false;
	}
	
	public void run(){
		if(udp == null){
				String msg = retornoTCP;
				String[] receive = msg.split(",");
				switch(receive[0]){
				case "adicionarLivro":
					if(adicionarLivro(receive[1], receive[2], receive[3], receive[4])){
					try {
							tcp.enviarString("Adicionar livro OK", s);
							break;
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					try {
						tcp.enviarString("Adicionar livro NOK", s);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "removerLivro":
					int codUser = Integer.parseInt(receive[2]);
					try {
						if(removerLivro(receive[1], codUser)){
							try {
								tcp.enviarString("Remover livro OK", s);
								break;
							} catch (UnknownHostException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						tcp.enviarString("Remover livro NOK", s);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "consultarLivros":
					if(consultarLivros()){
						try {
							tcp.enviarString("Consultar livro OK", s);
							break;
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					}
					try {
						tcp.enviarString("Consultar livro NOK", s);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "emprestarLivro":
					int codLivro = Integer.parseInt(receive[1]);
					int codUsuario = Integer.parseInt(receive[2]);
					try {
						if(emprestarLivro(codLivro, codUsuario)){
							try {
								tcp.enviarString("Emprestar livro OK", s);
								break;
							} catch (UnknownHostException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						tcp.enviarString("Emprestar livro NOK", s);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "devolverLivro":
					int codLiv = Integer.parseInt(receive[1]);
					try {
						if(devolverLivro(codLiv)){
							try {
								tcp.enviarString("Devolver livro OK", s);
								break;
							} catch (UnknownHostException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						tcp.enviarString("Devolver livro NOK", s);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "adicionarUsuario":
					int codLogin = Integer.parseInt(receive[2]);
					boolean isAdmin = Boolean.parseBoolean(receive[4]);
					Usuario usr = new Usuario(receive[1], codLogin, receive[3], isAdmin);
					if(adicionarUsuario(usr)){
						try {
							tcp.enviarString("Adicionar usuario OK", s);
							//out.writeUTF("Adicionar usuario OK");
							break;
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					}
					try {
						tcp.enviarString("Adicionar usuario NOK", s);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				default:
					try {
						tcp.enviarString("Opção inválida", s);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
		} else {
			int cont = 0;
			while(true){
				DatagramPacket pct = null;
				String msg;
				if(cont > 0){
					try {
						pct = udp.recebePacket();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					msg = new String(pct.getData(), pct.getOffset(), pct.getLength());
				} else {
					msg = new String(pctInicial.getData(), pctInicial.getOffset(), pctInicial.getLength());
					cont++;
				}
				String[] receive = msg.split(",");
				switch(receive[0]){
				case "adicionarLivro":
					if(adicionarLivro(receive[1], receive[2], receive[3], receive[4])){
						try {
							pct = udp.gerarPacketAtn("Adicionar livro OK", pctInicial.getPort());
							udp.enviarPacket(pct);
							break;
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					try {
						pct = udp.gerarPacketAtn("Adicionar livro NOK", pctInicial.getPort());
						udp.enviarPacket(pct);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "removerLivro":
					int codUser = Integer.parseInt(receive[2]);
					try {
						if(removerLivro(receive[1], codUser)){
							try {
								pct = udp.gerarPacketAtn("Remover livro OK", pctInicial.getPort());
								udp.enviarPacket(pct);
								break;
							} catch (UnknownHostException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						pct = udp.gerarPacketAtn("Remover livro NOK", pctInicial.getPort());
						udp.enviarPacket(pct);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "consultarLivros":
					if(consultarLivros()){
						try {
							pct = udp.gerarPacketAtn("Consultar livro OK", pctInicial.getPort());
							udp.enviarPacket(pct);
							break;
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					}
					try {
						pct = udp.gerarPacketAtn("Consultar livro NOK", pctInicial.getPort());
						udp.enviarPacket(pct);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "emprestarLivro":
					int codLivro = Integer.parseInt(receive[1]);
					int codUsuario = Integer.parseInt(receive[2]);
					try {
						if(emprestarLivro(codLivro, codUsuario)){
							try {
								pct = udp.gerarPacketAtn("Emprestar livro OK", pctInicial.getPort());
								udp.enviarPacket(pct);
								break;
							} catch (UnknownHostException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						pct = udp.gerarPacketAtn("Emprestar livro NOK", pctInicial.getPort());
						udp.enviarPacket(pct);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "devolverLivro":
					int codLiv = Integer.parseInt(receive[1]);
					try {
						if(devolverLivro(codLiv)){
							try {
								pct = udp.gerarPacketAtn("Devolver livro OK", pctInicial.getPort());
								udp.enviarPacket(pct);
								break;
							} catch (UnknownHostException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						pct = udp.gerarPacketAtn("Devolver livro NOK", pctInicial.getPort());
						udp.enviarPacket(pct);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "adicionarUsuario":
					int codLogin = Integer.parseInt(receive[2]);
					boolean isAdmin = Boolean.parseBoolean(receive[4]);
					Usuario usr = new Usuario(receive[1], codLogin, receive[3], isAdmin);
					if(adicionarUsuario(usr)){
						try {
							pct = udp.gerarPacketAtn("Adicionar usuario OK", pctInicial.getPort());
							udp.enviarPacket(pct);
							break;
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					}
					try {
						pct = udp.gerarPacketAtn("Adicionar usuario NOK", pctInicial.getPort());
						udp.enviarPacket(pct);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				default:
					try {
						pct = udp.gerarPacketAtn("Opção inválida", pctInicial.getPort());
						udp.enviarPacket(pct);
						break;
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
}
