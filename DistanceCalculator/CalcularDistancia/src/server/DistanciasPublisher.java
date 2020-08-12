package server;

import javax.xml.ws.Endpoint;

public class DistanciasPublisher {

	public static void main(String[] args) {
		DistanciasServerImpl dis = new DistanciasServerImpl();
		Endpoint.publish("http://localhost:8080/dis", dis);
		System.out.println("Serviço online!");
	}
}
