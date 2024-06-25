import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.JsonSyntaxException;
import com.google.gson.Gson;

import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, JsonSyntaxException {

        Scanner leitura = new Scanner(System.in);
        String opcao = "";

        do {
            try {
                System.out.println("Bem vindo ao Conversor de Moedas!");
                System.out.println("Escolha uma moeda para converter: ");
                System.out.println();
                System.out.println("""
                        ARS - Peso argentino
                        
                        BOB - Boliviano boliviano
                        
                        BRL - Real brasileiro
                        
                        CLP - Peso chileno
                        
                        COP - Peso colombiano
                        
                        USD - Dólar americano
                        """);
            String codigoDaMoeda = leitura.nextLine().trim().toUpperCase();

            var chaveApi = "8f5e1fc4a37a7e47ef156d18";

            String taxaDaMoeda = "https://v6.exchangerate-api.com/v6/" + chaveApi + "/latest/" + codigoDaMoeda;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(taxaDaMoeda))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new IOException("Erro na solicitação: " + response.statusCode());
            }

            String json = response.body();

            Gson gson = new Gson();
            ExchangeRates exchangeRates = gson.fromJson(json, ExchangeRates.class);

            if (!"success".equalsIgnoreCase(exchangeRates.result)) {
                throw new IOException("Erro ao obter taxas de câmbio: " + exchangeRates.result);
            }

            String baseCode = exchangeRates.base_code;
            System.out.println("Base Code: " + baseCode);

            System.out.println("Informe o valor a ser convertido: ");
            double quantia;
            try {
                quantia = leitura.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valor inserido inválido. Por favor, insira um número.");
                leitura.nextLine(); // Consumir a nova linha
                continue;
            }
            leitura.nextLine();  // Consumir a nova linha
            System.out.println("Valor inserido: " + quantia);

            System.out.println("""
                        Escolha a moeda para troca:
                        
                        ARS - Peso argentino
                        
                        BOB - Boliviano boliviano
                        
                        BRL - Real brasileiro
                        
                        CLP - Peso chileno
                        
                        COP - Peso colombiano
                        
                        USD - Dólar americano
                        """);
            String moedaSaida = leitura.nextLine().trim().toUpperCase();

            double taxaConversao;
            switch (moedaSaida) {
                case "ARS":
                    taxaConversao = exchangeRates.conversion_rates.ARS;
                    break;
                case "BOB":
                    taxaConversao = exchangeRates.conversion_rates.BOB;
                    break;
                case "BRL":
                    taxaConversao = exchangeRates.conversion_rates.BRL;
                    break;
                case "CLP":
                    taxaConversao = exchangeRates.conversion_rates.CLP;
                    break;
                case "COP":
                    taxaConversao = exchangeRates.conversion_rates.COP;
                    break;
                case "USD":
                    taxaConversao = exchangeRates.conversion_rates.USD;
                    break;
                default:
                    System.out.println("Moeda de saída inválida!");
                    continue;  // Pergunta novamente se a moeda de saída for inválida
            }

            double valorConvertido = quantia * taxaConversao;
            System.out.println("Valor convertido: " + valorConvertido);

        } catch (IOException | InterruptedException e) {
            System.out.println("Insira um codigo de moeda válido!");
        }

            System.out.println("Deseja fazer uma nova conversão? (s/n)");
            opcao = leitura.nextLine().trim().toLowerCase();

        } while (opcao.equals("s"));

        leitura.close();
    }
}
