package server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LeitorCSV {

  @SuppressWarnings("finally")
public Map<String, String> lerCSV(String arquivoCSV) {

    BufferedReader br = null;
    String linha = "";
    String csvDivisor = ",";
    Map<String, String> distancias = new HashMap<String, String>();
    try {

        br = new BufferedReader(new FileReader(arquivoCSV));
        while ((linha = br.readLine()) != null) {

            String[] splitter = linha.split(csvDivisor);
            distancias.put(splitter[0], splitter[1]);
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return distancias;
    }
  }

}
