package examen;

public class DVD extends Ficha{
	//Director del DVD
	String director;
	//Año de lanzamiento del DVD
	int año;
	
	/**
	 * Constructor con atributos código y título de la clase padre Ficha
	 * @param codigo
	 * @param titulo
	 */
	public DVD(int codigo, String titulo) {
		super(codigo, titulo);
		
	}

	/*
	 * Constructor con todos los parámetros
	 */
	public DVD(int codigo, String titulo,String genero, String director, int año) {
		super(codigo, titulo,genero);
		this.director = director;
		this.año = año;
	}
/**
 * 
 * @return
 */
	public String getDirector() {
		return director;
	}
/**
 * 
 * @param director
 */
	public void setDirector(String director) {
		this.director = director;
	}
/**
 * 
 * @return
 */
	public int getAño() {
		return año;
	}
/**
 * 
 * @param año
 */
	public void setAño(int año) {
		if(año>0) {
			this.año = año;
		}
	}
/**
 * Añadimos tres días a los días de préstamo
 * @return
 */
	public int diasPrestamo() {
		int result = super.diasPrestamo(getGenero())+3;
		return result;
	}

@Override
public String toString() {
	return  "------------------------------------------------------------------------\n"+super.toString()+ "Director: " + director + "\nAño: " + año+"Días préstamo: "+diasPrestamo();
}
	
	
}
