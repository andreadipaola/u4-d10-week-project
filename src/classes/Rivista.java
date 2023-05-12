package classes;

import abstract_classes.OperaLetteraria;
import enum_type.Periodicita;

public class Rivista extends OperaLetteraria {
	private Periodicita periodicita;

	public Rivista(int iSBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
		super(iSBN, titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "ISBN: " + this.getiSBN() + ", Titolo: " + this.getTitolo() + ", Anno: " + this.getAnnoPubblicazione()
				+ ", Pagine: " + this.getNumeroPagine() + ", Periodicità: " + this.periodicita + " (RIVISTA)";
	}

}
