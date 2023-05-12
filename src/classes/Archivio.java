package classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import enum_type.Periodicita;

public class Archivio {
	private static File file = new File("archivio.txt");

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Libro> libri = new ArrayList<>();
	static ArrayList<Rivista> riviste = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		ArrayList<String> archivio = new ArrayList<String>(FileUtils.readLines(file, "UTF-8"));
//		ArrayList<String> archivio = new ArrayList<String>();
		boolean isRunning = true;

		do {
			System.out.println("-------------------------- Andrea's Bookstore --------------------------");
			System.out.println(" 1 MOSTRA ARCHIVIO");
			System.out.println(" 2 AGGIUNGI UN OPERA");
			System.out.println(" 3 RIMUOVI UN OPERA (fornisci l'isbn dell'opera che vuoi rimuovere)");
			System.out.println(" 4 CERCA OPERA (fornisci l'ISBN dell'opera che vuoi cercare)");
			System.out.println(" 5 CERCA OPERA (fornisci l'anno dell'opera che vuoi cercare)");
			System.out.println(" 6 CERCA OPERA (fornisci l'anno dell'opera che vuoi cercare)");
			System.out.println(" 0 USCITA");
			System.out.println("------------------------------------------------------------------------");
			System.out.print("Seleziona una voce: ");
			try {
				int selezione = Integer.parseInt(scanner.nextLine());
				System.out.println("========================================================================");
				System.out.println();
				switch (selezione) {
				case (1):
					leggiDaArchivio(file);
					break;
				case (2):
					System.out.println("---------------------------- Aggiungi Opera ----------------------------");
					System.out.println(" 1 AGGIUNGI LIBRO");
					System.out.println(" 2 AGGIUNGI RIVISTA");
					System.out.println("------------------------------------------------------------------------");
					System.out.print("Seleziona una voce: ");
					int selezioneTipo = Integer.parseInt(scanner.nextLine());
					if (selezioneTipo == 1) {
						aggiungiLibro();
					} else if (selezioneTipo == 2) {
						aggiungiRivista();
					} else {
						System.out.println("ATTENZIONE! Inserisci una voce valida");
					}
					break;
				case (3):
					System.out.println("------- RIMUOVI OPERA -------");
					System.out.println("Digita il codice ISBN dell'opera da rimuovere:");
					long isbnRimuovi = Long.parseLong(scanner.nextLine());
					archivio.removeIf(linea -> linea.contains(Long.toString(isbnRimuovi)));
					FileUtils.writeLines(file, archivio);
					break;
				case (4):
					System.out.println("------- CERCA OPERA (ISBN) -------");
					System.out.println("Digita il codice ISBN dell'opera da cercare:");
					long cercaIsbn = Long.parseLong(scanner.nextLine());
					archivio.stream().filter((b) -> b.contains(Long.toString(cercaIsbn)))
							.forEach((o) -> System.out.println(o));
					break;
				case (5):
					System.out.println("------- CERCA OPERA (ANNO DI PUBBLICAZIONE) -------");
					System.out.println("Digita l'anno dell'opera da cercare:");
					int cercaAnno = Integer.parseInt(scanner.nextLine());
					archivio.stream().filter((b) -> b.contains(Integer.toString(cercaAnno)))
							.forEach((o) -> System.out.println(o));
					break;
				case (6):
					System.out.println("------- CERCA OPERA (AUTORE) -------");
					System.out.println("Digita l'autore dell'opera da cercare:");
					String cercaAutore = scanner.nextLine();
					archivio.stream().filter((b) -> b.contains(cercaAutore)).forEach((o) -> System.out.println(o));
					break;

				case (0):
					System.out.println("Uscita avvenuta con successo!");
					System.exit(0);
				default:
					System.out.println("ATTENZIONE! Inserisci una voce valida");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("ERRORE IRREVERSIBILE: hai inserito una voce errata!!!");
			}

			System.out.println("Vuoi tornare al menu principale? (y/n)");
			String input = scanner.nextLine();
			isRunning = input.equalsIgnoreCase("y");

		} while (isRunning);

	}
	// -----------------------------------------------------------------------------

	public static void aggiungiLibro() {
		System.out.println("- Inserisci ISBN: ");
		int isbn = Integer.parseInt(scanner.nextLine());
		System.out.println("- Inserisci titolo: ");
		String titolo = scanner.nextLine();
		System.out.println("- Inserisci anno di pubblicazione: ");
		int annoPubblicazione = Integer.parseInt(scanner.nextLine());
		System.out.println("- Inserisci numero pagine: ");
		int numeroPagine = Integer.parseInt(scanner.nextLine());
		System.out.println("- Inserisci autore: ");
		String autore = scanner.nextLine();
		System.out.println("- Inserisci genere: ");
		String genere = scanner.nextLine();

		Libro libro = new Libro(isbn, titolo, annoPubblicazione, numeroPagine, autore, genere);

		libri.add(libro);

		String libroAgg = libro.toString();
		try {
			salvaInArchivio(file, libroAgg + System.lineSeparator(), true);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Libro aggiunto correttamente!");

	}

	// -----------------------------------------------------------------------------

	public static void aggiungiRivista() {
		System.out.println("- Inserisci ISBN: ");
		int isbn = Integer.parseInt(scanner.nextLine());
		System.out.println("Inserisci titolo: ");
		String titolo = scanner.nextLine();
		System.out.println("Inserisci anno di pubblicazione: ");
		int annoPubblicazione = Integer.parseInt(scanner.nextLine());
		System.out.println("Inserisci numero pagine: ");
		int numeroPagine = Integer.parseInt(scanner.nextLine());
		System.out.println("1 - settimanale");
		System.out.println("2 - mensile");
		System.out.println("3 - semestrale");
		System.out.println("Inserisci periodicità: ");
		int selezione = Integer.parseInt(scanner.nextLine());
		Periodicita periodicita = null;
		switch (selezione) {
		case (1):
			periodicita = Periodicita.SETTIMANALE;
			break;
		case (2):
			periodicita = Periodicita.MENSILE;
			break;
		case (3):
			periodicita = Periodicita.SEMESTRALE;
			break;
		}

		Rivista rivista = new Rivista(isbn, titolo, annoPubblicazione, numeroPagine, periodicita);

		riviste.add(rivista);
		String rivistaAgg = rivista.toString();
		try {
			salvaInArchivio(file, rivistaAgg + System.lineSeparator(), true);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Rivista aggiunta correttamente!");
	}

	// -----------------------------------------------------------------------------

	public static void salvaInArchivio(File f, String s, boolean append) throws IOException {
		FileUtils.writeStringToFile(f, s, "UTF-8", append);
	}

	// -----------------------------------------------------------------------------

	public static void leggiDaArchivio(File f) throws IOException {
		if (file.exists()) {
			System.out.printf("L'archivio della biblioteca contiente i seguenti testi: %n");
			System.out.println(FileUtils.readFileToString(f, "UTF-8"));

		} else {
			System.out.println("ATTENZIONE! File non trovato");
		}
	}

}
