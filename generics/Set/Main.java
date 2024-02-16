package Set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		String path = "C:\\Users\\giova\\eclipse-workspace\\JavaCompletoUdemy2023\\Listatxt.txt";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			Set<User> users = new HashSet<>();
			
			String linhas;
			while((linhas = reader.readLine()) != null) {
				String fields[] = linhas.split(" ");
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
				LocalDateTime dateTime = LocalDateTime.parse(fields[2], formatter);
				User user = new User(fields[1], dateTime);
				if(!users.contains(user)) {
					users.add(user);
					System.out.println(user);
				}
			}
			
			
		} catch (IOException e) {
			System.out.println("Erro de leitura");
			e.printStackTrace();
		}

	}

}
