package classes;

import abstract_classes.OperaLetteraria;

public class Libro extends OperaLetteraria {
	private String autore;
	private String genere;

	public Libro(int iSBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
		super(iSBN, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "ISBN: " + this.getiSBN() + ", Titolo: " + this.getTitolo() + ", Anno: " + this.getAnnoPubblicazione()
				+ ", Pagine: " + this.getNumeroPagine() + ", Autore: " + this.autore + ", Genere: " + this.genere
				+ " (LIBRO)";
	}

}
