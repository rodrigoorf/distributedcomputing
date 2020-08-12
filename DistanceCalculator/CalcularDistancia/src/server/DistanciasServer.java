package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface DistanciasServer {
	@WebMethod public String calcularDistanciaDuasCidades(String cidade1, String cidade2);
	@WebMethod public String calcularDistanciaMultiplasCidades(String cidadeOrigem, String[] conjuntoCidades);
	@WebMethod public String[] calcularDistanciaMaxima(String cidadeOrigem, int distanciaMaxima);
}
