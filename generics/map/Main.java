package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		String path = "C:\\Users\\giova\\eclipse-workspace\\JavaCompletoUdemy2023\\Listatxt.txt";
		Map<String, Integer> candidatos = new TreeMap<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String leituraArquivo = reader.readLine();

			while (leituraArquivo != null) {
				String fields[] = leituraArquivo.split(",");
				if (candidatos.containsKey(fields[0]) == false) {
					candidatos.put(fields[0], Integer.parseInt(fields[1]));
				} else {
					int votos = candidatos.get(fields[0]);
					votos += Integer.parseInt(fields[1]);
					candidatos.put(fields[0], votos);
				}
				/* System.out.println(fields[0] + " " + fields[1]); */
				leituraArquivo = reader.readLine();

			}
			System.out.println("Total de candidatos: " + candidatos.size());
			
			for (String key : candidatos.keySet()) {
				System.out.println(key + ": " + candidatos.get(key) );
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
