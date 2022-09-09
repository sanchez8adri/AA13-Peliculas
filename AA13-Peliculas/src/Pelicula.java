
public class Pelicula {
	
	private String titulo;
	private long recaudacion;
	
	public Pelicula(String titulo, long recaudacion) {
		this.titulo = titulo;
		this.recaudacion = recaudacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public long getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(long recaudacion) {
		this.recaudacion = recaudacion;
	}

	@Override
	public String toString() {
		return "Título: " +titulo+ " || Recaudación: " +recaudacion +"$";
	}
	
	

}
