import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopPeliculas {

	public static void main(String[] args) throws IOException {
		
		List<Pelicula> listaPeliculas = new ArrayList<>();
		List<String> listaPeliculas11to20 = new ArrayList<>();
		
		File top11to20 = new File("Peliculas_11_20.txt");
		Scanner sn = new Scanner(top11to20);
		
		File top20 = new File("top20_mejores_peliculas.txt");
		
		listaPeliculas.add(new Pelicula("Titanic", 2201647264L));
		listaPeliculas.add(new Pelicula("Avatar", 2847397339L));
		listaPeliculas.add(new Pelicula("Star Wars: Episode VII - The Force Awakens", 2069521700));
		listaPeliculas.add(new Pelicula("Spider-Man: No Way Home", 1910675428));
		listaPeliculas.add(new Pelicula("Jurassic World", 1671537444));
		listaPeliculas.add(new Pelicula("Avengers: Endgame", 2797501328L));
		listaPeliculas.add(new Pelicula("Avengers: Infinity War", 2048359754));
		listaPeliculas.add(new Pelicula("The Lion King	", 1663250487));
		listaPeliculas.add(new Pelicula("Furious 7", 1515341399));
		listaPeliculas.add(new Pelicula("The Avengers", 1518815515));
		
		while(sn.hasNext()) {
			listaPeliculas11to20.add(sn.nextLine());
		}
		
		for(String pelicula: listaPeliculas11to20) {
			
			String[] s = pelicula.split(",");
			listaPeliculas.add(new Pelicula(s[0], Long.parseLong(s[1])));

		}
	
		for(int i = 2; i < listaPeliculas.size(); i++) {
			for(int j = 0; j < listaPeliculas.size()-1; j++) {
				if(listaPeliculas.get(j).getRecaudacion() < listaPeliculas.get(j+1).getRecaudacion()) {
					Pelicula aux = listaPeliculas.get(j);
		            listaPeliculas.set(j, listaPeliculas.get(j+1));
		            listaPeliculas.set(j+1, aux);
				}
			}
		}
		
		FileWriter fw = new FileWriter(top20);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Pelicula pelicula : listaPeliculas) {
			bw.write(pelicula.toString()+"\n");
		}
		
		bw.close();
		fw.close();
		sn.close();
		
		crearJenkins();
		
		System.out.println("Lista ordenada y actualizada con éxito!");
		
	}
	
	public static void crearJenkins() throws IOException {
		
		
		FileWriter fw = new FileWriter(new File("Jenkinsfile"));
		BufferedWriter bw = new BufferedWriter(fw);
		
		StringBuilder Jenkins = new StringBuilder();
        Jenkins.append("import java.time.LocalDate\r\n");
        Jenkins.append("pipeline{\r\n");
        Jenkins.append("agent any \r\n");
        Jenkins.append("stages{ \r\n");
        Jenkins.append("stage('Main'){ \r\n");
        Jenkins.append("steps{ \r\n");
        Jenkins.append("script{ \r\n");
        Jenkins.append("def fecha = LocalDate.now() \r\n");
        Jenkins.append("def texto = 'Hola Mundo! EL día de hoy es ' + fecha.getDayOfWeek() + '.' \r\n");
        Jenkins.append("def texto2 = 'Este curso me hizo programar mas de lo que me hubiese gustado ' \r\n");
        Jenkins.append("println texto \r\n");
        Jenkins.append("println texto2 \r\n");
        Jenkins.append("} \r\n");
        Jenkins.append("} \r\n");
        Jenkins.append("} \r\n");
        Jenkins.append("} \r\n");
        Jenkins.append("} \r\n");

        bw.write(Jenkins.toString());
		bw.close();
		fw.close();
	}

}
