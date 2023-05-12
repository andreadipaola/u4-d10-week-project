package abstract_classes;

public abstract class OperaLetteraria {
	private int iSBN;
	private String titolo;
	private int annoPubblicazione;
	private int numeroPagine;

	public OperaLetteraria(int iSBN, String titolo, int annoPubblicazione, int numeroPagine) {
		this.iSBN = iSBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public int getiSBN() {
		return iSBN;
	}

	public void setiSBN(int iSBN) {
		this.iSBN = iSBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

}
