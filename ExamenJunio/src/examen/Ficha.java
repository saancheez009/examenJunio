package examen;

import java.util.Objects;


public class Ficha implements Comparable{
//Enumerado con los valores de genero
	enum Genero {
		Ciencia, Historia, Literatura
	}

	// Código del recurso
	protected int codigo;
	// Título del recurso
	protected String titulo;
	// El géro por defecto tiene el valor historia
	protected Genero genero = Genero.Historia;

	/**
	 * Constructor con código y título
	 * 
	 * @param codigo
	 * @param titulo
	 */
	public Ficha(int codigo, String titulo) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
	}

	/**
	 * 
	 * @param codigo
	 * @param titulo
	 * @param genero
	 */
	public Ficha(int codigo, String titulo, String genero) {
		super();
		if (codigo > 0) {
			this.codigo = codigo;
		}
		this.titulo = titulo;
		comprobarGenero(genero); // Recibimos el genero como cadena y llamamos a la funcion que comprueba el
							// género
	}

	/**
	 * 
	 * @return
	 */
	public int getCodigo() {

		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		if (codigo > 0) {
			this.codigo = codigo;
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * 
	 * @return
	 */
	public String getGenero() {
		return String.valueOf(genero);
	}

	/**
	 * 
	 * @param genero
	 */
	public void setGenero(String genero) {
		comprobarGenero(genero);
	}

	@Override
	public String toString() {
		return  "------------------------------------------------------------------------\n"+ "Código: " + codigo + "\nTítulo: " + titulo + "\nGénero: " + genero+"\n";
	}

	@Override
	// Dos fichas de la biblioteca son iguales si tienen el mismo código y el mismo
	// título.
	public boolean equals(Object obj) {
		boolean res = false;
		Ficha ficha = (Ficha) obj;
		if (codigo == ficha.codigo && titulo.equals(ficha.titulo)) {
			res = true;
		}
		return res;
	}
/*
 * Comprobamos si el genero introducido es correcto
 */
	public void comprobarGenero(String genero) {
		switch (genero) {
		case "Literatura", "Lengua", "Historia":
			this.genero = Genero.valueOf(genero);
		break;
		default:
			genero = "Historia";
		}
	}

	/**
	 * Devuelve 2 si su género es Literatura, 5 si es Historia y 10 si es Ciencia.
	 * @param genero
	 * @return
	 */
	public int diasPrestamo(String genero) {
		int res = 0;
		if (genero.equalsIgnoreCase("Literatura")) {
			res=2;
			
		} else if(genero.equalsIgnoreCase("Historia")) {
			res=5;
		}else if (genero.equalsIgnoreCase("Ciencia")){
			res=10;
		}
		return res;
	}

	@Override
	public int compareTo(Object o) {
		int res=0;
		Ficha ficha = (Ficha) o;
		//Si el codigo es igual, se ordena por el titulo
		if(this.codigo==ficha.codigo) {
		res=this.titulo.compareTo(ficha.titulo);
			
		}else {
			res=-1;
		}
		return res;
	}
}
