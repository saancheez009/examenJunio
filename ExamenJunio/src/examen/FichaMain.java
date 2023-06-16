package examen;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class FichaMain {

	static TreeSet<Ficha> coleccionFichas = new TreeSet<Ficha>();
	//Opcion introducida por el usuario
	static int opcion;
	static Scanner sc = new Scanner(System.in);
	//Código del recurso
	static int codigo;
	//Título del recurso
	static String titulo;
	//Tipo del recurso, si es libro o DVD
	static String tipo;
	//Autor del libro
	static String autor;
	//Editorial del libro
	static String editorial;
	//Director del DVD
	static String director;
	//Año del DVD
	static int año;
	//Género del recurso
	static String genero;
	
	static Ficha ficha = null;

	public static void main(String[] args) {
		//Leemos el fichero
		leerFichero();
		//Damos la bienvenida al sistema
		System.out.println("¡Bienvenid@!");
		do {
			//Mostramos el menú
			menu();
			//Leemos la opción
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				//Añadimos la ficha
				añadirFicha();
				break;
			case 2:
				
				for (Ficha fichas : coleccionFichas) {
					System.out.println(fichas.toString());
					System.out.println();
				}
				break;
			case 3:
				//Modificamos la ficha y el dato deseado
				modificarFicha();
				break;
			case 4:
				//Eliminamos la ficha
				eliminarFicha();
				break;
			case 5:
				//Guardamos la ficha en la colección
				guardarFicha(coleccionFichas);
				break;
			case 0:
				//Slimos del sistema
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción incorrecta");
			}
		} while (opcion != 0);

	}

	public static void menu() {
		//Mostramos el menú para que el usuario pueda elegir las distintas opciones
		System.out.println("Por favor seleccione una opción ");
		System.out.println("1. Añadir ficha");
		System.out.println("2. Listar ficha");
		System.out.println("3. Modificar ficha");
		System.out.println("4. Eliminar ficha");
		System.out.println("5. Guardar ficha");
		System.out.println("0. Salir del sistema!");
	}

	public static void añadirFicha() {

		System.out.println("Por favor el código y el título del recurso");
		codigo = sc.nextInt();
		sc.nextLine();
		titulo = sc.nextLine();
		Ficha ficha = new Ficha(codigo, titulo);
		// Comprobamos si el recurso existe en la coleccion para poder añadirlo
		if (coleccionFichas.contains(ficha)) {
			System.out.println("Ya existe el recurso");
		} else {
			System.out.println("Introduzca el género del recurso");
			genero = sc.nextLine();
			System.out.println("Por favor introduzca si el recurso es 'Libro' o 'DVD' ");
			tipo = sc.nextLine();

			if (tipo.equalsIgnoreCase("Libro")) {
				System.out.println("Por favor introduzca  el autor y la editorial del libro");
				autor = sc.nextLine();
				editorial = sc.nextLine();

				ficha = new Libro(codigo, titulo, genero, autor, editorial);
				coleccionFichas.add(ficha);
				// Añadimos a ficha los valores correspondientes de libro
			} else {
				System.out.println("Introduzca el director y el año del dvd");
				director = sc.nextLine();
				año = sc.nextInt();
				sc.nextLine();
				ficha = new DVD(codigo, titulo, genero, director, año);
				coleccionFichas.add(ficha);
				// Añadimos a ficha los valores correspondientes de DVD
			}
		}
	}

	public static void eliminarFicha() {
		System.out.println("Por favor introduzca el código y el titulo del recurso a eliminar");
		codigo = sc.nextInt();
		sc.nextLine();
		titulo = sc.nextLine();
		Ficha ficha = new Ficha(codigo, titulo);
		if (coleccionFichas.remove(ficha)) {
			// Y mostrará un mensaje de eliminado correctamente
			System.out.println("Ficha eliminada correctamente");
			// En caso contrario
		} else {
			// Mostrará un mensaje de que no se encuentra
			System.out.println("No se ha podido eliminar la ficha, compruebe que la ficha se encuentre en el listado");
		}

	}

	public static void modificarFicha() {
		int opcion;
		System.out.println("Por favor introduzca el código y el titulo del recurso a modificar");
		codigo = sc.nextInt();
		sc.nextLine();
		titulo = sc.nextLine();
		// Comprobamos si el recurso existe en la coleccion para poder modificarlo
		Ficha ficha = new Ficha(codigo, titulo);
		if (coleccionFichas.contains(ficha)) {
			for (Ficha i : coleccionFichas) {
				if (i.equals(ficha)) {
					do {
						System.out.println("Por favor seleccione una de estas opciones:");
						System.out.println("1. Modificar género");
						System.out.println("2. Modificar autor");
						System.out.println("3. Modificar editorial");
						System.out.println("4. Modificar director");
						System.out.println("5. Modificar año");
						System.out.println("6. Volver a menú");
						opcion = sc.nextInt();
						sc.nextLine();
						switch (opcion) {
						case 1:
							System.out.println("Introduzca el nuevo género");
							genero = sc.nextLine();
							sc.nextLine();
							((Ficha) i).setGenero(genero);
							//modificamos el genero 
							break;
						case 2:

							if (i instanceof Libro) {
								System.out.println("Introduzca el nombre del autor");
								autor = sc.nextLine();
								((Libro) i).setAutor(autor);
								//modificamos el autor del libro
							} else {
								System.out.println("No se puede modificar ya que el recurso no es un libro");
							}
							break;
						case 3:
							if (i instanceof Libro) {
								System.out.println("Introduzca el nombre de la editorial");
								editorial = sc.nextLine();
								((Libro) i).setEditorial(editorial);
								//modificamos la editorial del libro
							} else {
								System.out.println("No se puede modificar ya que el recurso no es un libro");
							}
							break;

						case 4:
							if (i instanceof DVD) {
								System.out.println("Introduzca el nombre del director");
								director = sc.nextLine();
								((DVD) i).setDirector(director);
								//mpdificamos el director del dvd
							} else {
								System.out.println("No se puede modificar ya que el recurso no es un DVD");
							}
							break;
						case 5:
							if (i instanceof DVD) {
								System.out.println("Introduzca el año");
								año = sc.nextInt();
								((DVD) i).getAño();
								//Modificamos el año del dvd
							} else {
								System.out.println("No se puede modificar ya que el recurso no es un DVD");
							}
							break;

						}
					} while (opcion != 6);
					break;
				}

			}

		} else {
			System.out.println("El recurso con el código y título introducido no existe");
		}

	}

	public static void guardarFicha(TreeSet<Ficha>coleccionFichas) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("src\\examen\\fichas.txt"));
			//Recorremos la coleccion
			for (Ficha ficha : coleccionFichas) {
				String cadena = ficha.getCodigo() + ";" +ficha.getTitulo() + ";" + ficha.getGenero() + ";";
				//Si es libro, guardamos los datos correspondientes en ese orden;
				
				if (ficha instanceof Libro) {
					cadena = "Libro" + ";" + cadena + ((Libro) ficha).getAutor()+";"+((Libro) ficha).getEditorial();
					//Si es dvd guardamos los datos correspondiemtes en ese orden
				} else if (ficha instanceof DVD) {
					cadena = "DVD" + ";" + cadena
							+ (((DVD) ficha).getDirector() + ";" + ((DVD) ficha).getAño());
				} else {
					cadena = "Ficha" + ";" + cadena;
				}
				bw.write(cadena);
				bw.newLine();
			}
			bw.flush();
			
	} catch (IOException e) {
		System.out.println("No se encuentra el fichero");
		System.out.println(e.getMessage());
	}
	}
	public static TreeSet<Ficha> leerFichero() {

			try {
				String linea = "";
				String fich[];
				//Creamos un scanner para leer el fichero
				Scanner sc = new Scanner(new FileReader("src\\examen\\fichas.txt"));
				
				while (sc.hasNextLine()) {
					linea = sc.nextLine();
					fich = linea.split(";");
					if (fich[0].equals("Libro")) {
						ficha = new Libro(Integer.parseInt(fich[1]),
								fich[2], fich[3], fich[4],
								fich[5]);
					} else if (fich[0].equals("DVD")) {
						ficha = new DVD(Integer.parseInt(fich[1]),
								fich[2], fich[3], fich[4],
								Integer.parseInt(fich[5]));

					} else {
						ficha = new Ficha(Integer.parseInt(fich[1]),fich[2],
								fich[3]);
					}
					coleccionFichas.add(ficha);
				}
			} catch (FileNotFoundException ficha) {
				System.out.println("No se ha encontrado el archivo");
				System.out.println(ficha.getMessage());
			}

			return coleccionFichas;
		}
	
}
