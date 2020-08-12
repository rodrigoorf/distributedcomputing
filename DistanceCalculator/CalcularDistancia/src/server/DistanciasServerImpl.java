package server;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.jws.WebService;

@WebService(endpointInterface = "server.DistanciasServer")
public class DistanciasServerImpl implements DistanciasServer {

	@Override
	public String calcularDistanciaDuasCidades(String cidade1, String cidade2) {
		Map<String, String> distancias = getDistancias();
		String resultado = distancias.get(cidade1 + ":" + cidade2);
		if(resultado == null){
			resultado = distancias.get(cidade2 + ":" + cidade1);
			if(resultado == null){
				return "Uma ou mais cidades são inválidas";
			}
		}
		return resultado;
	}

	@Override
	public String calcularDistanciaMultiplasCidades(String cidadeOrigem, String[] conjuntoCidades) {
		Map<String, String> distancias = getDistancias();
		int distancia = 0;
		String resultado;
		for(int i = 0; i < conjuntoCidades.length; i++){
			if(i == 0){
				resultado = distancias.get(cidadeOrigem + ":" + conjuntoCidades[i]);
			} else {
				resultado = distancias.get(conjuntoCidades[i - 1] + ":" + conjuntoCidades[i]);
			}
			if(resultado == null){
				if(i == 0){
					resultado = distancias.get(conjuntoCidades[i] + ":" + cidadeOrigem);
				} else {
					resultado = distancias.get(conjuntoCidades[i] + ":" + conjuntoCidades[i - 1]);
				}
				if(resultado == null){
					return "Uma ou mais cidades são inválidas";
				}
			}
			int acc = Integer.parseInt(resultado);
			distancia += acc;
		}
		return Integer.toString(distancia);
	}

	@Override
	public String[] calcularDistanciaMaxima(String cidadeOrigem, int distanciaMaxima) {
		Map<String, String> distancias = getDistancias();
		Set<String> chaves = distancias.keySet();
		ArrayList<String> cidades = new ArrayList<String>();
		for(String chave : chaves){
			if(chave.contains(cidadeOrigem)){
				int km = Integer.parseInt(distancias.get(chave));
				if(km < distanciaMaxima){
					String[] cidade = chave.split(":");
					if(cidade[0].equals(cidadeOrigem) && cidade[1].equals(cidadeOrigem)){
						
					} else {
						if(cidade[0].equals(cidadeOrigem)){
							cidades.add(cidade[1]);
						} else {
							cidades.add(cidade[0]);
						}
					}
				}
			}
		}
		if(cidades.size() == 0){
			String[] retorno = {"Não há capitais próximas com este raio de distância ou uma cidade inválida foi informada"};
			return retorno;
		}
		String[] vetorCidades = new String[cidades.size()];
		vetorCidades = cidades.toArray(vetorCidades);
		return vetorCidades;
	}
	
	public Map<String, String> getDistancias(){
		LeitorCSV csv = new LeitorCSV();
		return csv.lerCSV("C:\\Users\\Rodrigo\\Documents\\Capitais3.csv");
	}

}
