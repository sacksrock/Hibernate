import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Launcher {

	private SessionFactory sf;
	private Session s;
	public Actores[] tabla = null;

	public Launcher() {
		this.sf = new Configuration().configure().buildSessionFactory();
		this.s = sf.openSession();
	}

	public void leerDatosActores() {
		Query q = s.createQuery("select e from Actores e");
		List results = q.list();
		Iterator actoresIterator = results.iterator();
		while (actoresIterator.hasNext()) {
			Actores Act = (Actores) actoresIterator.next();

			System.out.printf("Nombre: " + Act.getNombre());
			System.out.println(" ");
			System.out.println("Fecha De Nacimiento: " + Act.getFNacimiento());
			System.out.println("Nacionalidad: " + Act.getNacionalidad());

		}
	}

	public void leerDatosPeliculas() {
		Query q = s.createQuery("select e from Peliculas e");
		List results = q.list();
		Iterator peliculasIterator = results.iterator();
		while (peliculasIterator.hasNext()) {
			Peliculas Pel = (Peliculas) peliculasIterator.next();

			System.out.printf("Titulo: " + Pel.getTitulo());
			System.out.println(" ");
			System.out.println("Fecha: " + Pel.getFecha());
			System.out.println("Presupouesto: " + Pel.getPresupuesto());

		}
	}

	public void InsertarDatosActores() {
		s.beginTransaction();
		String nombre = null;
		Date fechanac = null;
		String nacionalidad = null;

		Scanner actores = new Scanner(System.in);
		System.out.println("Nombre del actor: ");
		nombre = actores.nextLine();
		System.out.println("Fecha de nacimiento: ");
		String fecha = actores.nextLine();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechanac = format.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Nacionalidad del actor: ");
		nacionalidad = actores.nextLine();

		Actores Actor = new Actores(nombre, fechanac, nacionalidad);
		s.save(Actor);
		s.getTransaction().commit();
		System.out.println("Actores insertadas correctamente");
	}

	public void InsertarDatosPeliculas() {
		s.beginTransaction();
		String titulo = null;
		Date fechapel = null;

		Scanner pelicula = new Scanner(System.in);
		System.out.println("Titulo de la pelicula: ");
		titulo = pelicula.nextLine();
		System.out.println("Fecha de la pelicula:");
		String fecha = pelicula.nextLine();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechapel = format.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Presupuesto de la pelicula: ");
		Double pre = pelicula.nextDouble();

		Peliculas Peliculas = new Peliculas(titulo, fechapel, pre);
		s.save(Peliculas);
		s.getTransaction().commit();
		System.out.println("Peliculas insertadas correctamente");

	}

	public void EliminarDatosPeliculas() {
		s.beginTransaction();
		String titulo = null;

		Scanner peliculas = new Scanner(System.in);
		System.out.println("Nombre de la pelicula: ");
		titulo = peliculas.nextLine();

		Query query = s.createQuery("delete from Peliculas WHERE Titulo ='"+titulo+"'");
		query.executeUpdate();
		s.getTransaction().commit();
		System.out.println("Pelicula Borrada Correctamente");
	}
	public void EliminarDatosActores() {
		s.beginTransaction();
		String nombre = null;

		Scanner actores = new Scanner(System.in);
		System.out.println("Nombre del actor: ");
		nombre = actores.nextLine();

		Query query = s.createQuery("delete from Actores WHERE Nombre ='"+nombre+"'");
		query.executeUpdate();
		s.getTransaction().commit();
		System.out.println("Actor Borrado Correctamente");
	}

	public static void main(String[] args) {
		System.out.println("Elija la opción que desee ejecutar : ");
		System.out.println("1- Leer Datos: ");
		System.out.println("2- Insertar datos: ");
		System.out.println("3- Actualizar datos: ");
		System.out.println("4- Borrar datos: ");
		Launcher t = new Launcher();
		Scanner sc = new Scanner(System.in);

		int respuesta = sc.nextInt();

		if (respuesta == 1) {
			System.out.println("¿Que quieres leer?");
			System.out.println("1- Actores: ");
			System.out.println("2- Peliculas: ");
			Scanner leer = new Scanner(System.in);
			int resp = leer.nextInt();

			if (resp == 1) {
				t.leerDatosActores();
			} else if (resp == 2) {
				t.leerDatosPeliculas();
			}

		} else if (respuesta == 2) {
			System.out.println("¿Que quieres guardar?");
			System.out.println("1- Actores: ");
			System.out.println("2- Peliculas: ");
			Scanner guardar = new Scanner(System.in);
			int resp1 = guardar.nextInt();

			if (resp1 == 1) {
				t.InsertarDatosActores();
			} else if (resp1 == 2) {
				t.InsertarDatosPeliculas();
			}

		} else if (respuesta == 3) {

		} else if (respuesta == 4) {
			System.out.println("¿Que quieres eliminar?");
			System.out.println("1- Actores: ");
			System.out.println("2- Peliculas: ");
			Scanner eliminar = new Scanner(System.in);
			int resp3 = eliminar.nextInt();
			if (resp3 == 1) {
				t.EliminarDatosActores();
			} else if (resp3 == 2) {
				t.EliminarDatosPeliculas();
			}
				
		} else {
			System.out.println("Introduzca un número válido");
		}

	}

}
