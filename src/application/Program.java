package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Program {

	public static void main(String[] args) {

		File list = new File("C:\\projeto-java\\play-with-set\\election\\list\\votos.txt");
		Map<String, Integer> map = new HashMap<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(list))){
			
			String line = br.readLine();
			while (line != null) {
				String[] vect = line.split(",");
				String name = vect[0];
				Integer value = Integer.parseInt(vect[1]);
				if (map.containsKey(name)) {
					int plusVote = map.get(name);
					map.put(name, value + plusVote);
					
				}
				else {
					map.put(name, value);
				}
				
				line = br.readLine();
				
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		for (String s : map.keySet()) {
			System.out.println(s + " " + map.get(s));
		}

	}

}
