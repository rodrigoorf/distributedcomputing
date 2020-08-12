using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DistanciasCliente
{
    class Program
    {
        static void Main(string[] args)
        {
            localhost.DistanciasServerImplService dsi = new localhost.DistanciasServerImplService();
            String opcao;
            do
            {
                Console.WriteLine("1 - Calcular distância entre duas cidades");
                Console.WriteLine("2 - Calcular distância entre múltiplas cidades");
                Console.WriteLine("3 - Calcular distância máxima");
                Console.WriteLine("0 - Sair");
                Console.WriteLine("\nOpção: ");
                opcao = Console.ReadLine();
                switch (opcao)
                {
                    case "1":
                        Console.WriteLine("Digite a primeira cidade: ");
                        String cidadeOrigem = Console.ReadLine();
                        Console.WriteLine("Digite a segunda cidade: ");
                        String cidadeDestino = Console.ReadLine();
                        String retorno = dsi.calcularDistanciaDuasCidades(cidadeOrigem, cidadeDestino);
                        Console.WriteLine("Resultado: " + retorno + " km");
                        break;
                    case "2":
                        Console.WriteLine("Digite a primeira cidade: ");
                        String origem = Console.ReadLine();
                        List<String> cidades = new List<string>();
                        String leitura = "";
                        Console.WriteLine("Digite a segunda cidade: ");
                        String dest = Console.ReadLine();
                        cidades.Add(dest);
                        while (!leitura.Equals("FIM"))
                        {
                            Console.WriteLine("Digite a próxima cidade ou FIM para parar: ");
                            leitura = Console.ReadLine();
                            if (leitura.Equals("FIM"))
                            {
                                break;
                            }
                            else
                            {
                                cidades.Add(leitura);
                            }
                        }
                        String[] arrayCidades = cidades.ToArray();
                        Console.WriteLine("Resultado: " + dsi.calcularDistanciaMultiplasCidades(origem, arrayCidades) + " km");
                        break;
                    case "3":
                        Console.WriteLine("Digite a cidade de partida: ");
                        String cidade = Console.ReadLine();
                        Console.WriteLine("Digite o raio de distância (em km): ");
                        String raio = Console.ReadLine();
                        int rDistancia;
                        try
                        {
                            rDistancia = Convert.ToInt32(raio);
                        }
                        catch (Exception e)
                        {
                            Console.WriteLine("Opção inválida.");
                            break;
                        }
                        String[] retCidades = dsi.calcularDistanciaMaxima(cidade, rDistancia);
                        Console.WriteLine("Capitais próximas de " + cidade + " em um raio de " + rDistancia + " km:");
                        int cont = 1;
                        foreach (String s in retCidades)
                        {
                            Console.WriteLine(cont + ". " + s);
                            cont++;
                        }
                        break;
                    case "0":
                        Console.WriteLine("Saindo...");
                        break;
                    default:
                        Console.WriteLine("Opção inválida.");
                        break;
                }
            } while (opcao != "0");
        }
    }
}
