package examen;

public class Libro extends Ficha {
	//Autor del libro
	String autor;
	//Editorial del libro
	String editorial;

	/**
	 * Constructor con parámetros código y título de la clase padre que es Ficha
	 * 
	 * @param codigo
	 * @param titulo
	 */
	public Libro(int codigo, String titulo) {
		super(codigo, titulo);

	}

	/*
	 * Constructor con todos los parámetros de la clase libro
	 */
	public Libro(int codigo, String titulo,String genero, String autor, String editorial) {
		super(codigo, titulo,genero);
		this.autor = autor;
		this.editorial = editorial;
	}

	//Geters y setters de los atributios de la clase Libro
	
	/**
	 * 
	 * @return
	 */
	public String getAutor() {
		return autor;
	}
/**
 * 
 * @param autor
 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * 
	 * @return
	 */
	public String getEditorial() {
		return editorial;
	}
/**
 * 
 * @param editorial
 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

@Override
public String toString() {
	//Ficha ficha =new Ficha();
	return "------------------------------------------------------------------------\n"+ super.toString() +"Autor: "+ autor + "\nEditorial: " + editorial+"\nDías préstamo: "+super.diasPrestamo(getGenero());
}

}
