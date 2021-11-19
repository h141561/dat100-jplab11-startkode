package no.hvl.dat100.jplab11.oppgave1;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave2.Bilde;

public abstract class Innlegg {
	
	private int m_id;
	private int m_likes;
	private String m_brukar;
	private String m_dato;
	protected String m_tekst;
	
	public Innlegg() {
		
	}
	
	public Innlegg(int id, String bruker, String dato) {
		this.m_id = id;
		this.m_brukar = bruker;
		this.m_dato = dato;
		this.m_likes = 0;
	}

	public Innlegg(int id, String bruker, String dato, int likes) {
		this.m_id = id;
		this.m_brukar = bruker;
		this.m_dato = dato;
		this.m_likes = likes;
	}
	
	public String getBruker() {
		return this.m_brukar;
	}

	public void setBruker(String bruker) {
		this.m_brukar = bruker;
	}

	public String getDato() {
		return this.m_dato;		
	}

	public void setDato(String dato) {
		this.m_dato = dato;
	}

	public int getId() {
		return this.m_id;
	}

	public int getLikes() {
		return this.m_likes;

	}
	
	public void doLike () {
		this.m_likes++;
	}
	
	public String getTekst() {
		return m_tekst;
	}
	public String getText() {
		return getTekst();
	}
	public abstract String getUrl();
	
	public boolean erLik(Innlegg innlegg) {
		return m_id == innlegg.getId();
	}
	
	@Override
	public String toString() {
		String ret = 
				Integer.toString(m_id) +
				"\n" +
				m_brukar +
				"\n" +
				m_dato +
				"\n" +
				m_likes +
				"\n";
		return ret;
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		String ret = "";
		int tabs = 3;
		String tabbar = "\t";
		tabbar.repeat(tabs);

		
		ret =
			tabbar + "<h2>" + this.getBruker() + "@" + this.getDato() + " [" + this.getLikes() + "]</h2>\n" + 
			tabbar + "<p>" + this.getText() + "</p>\n" ;
		return ret;
		
	}
}
