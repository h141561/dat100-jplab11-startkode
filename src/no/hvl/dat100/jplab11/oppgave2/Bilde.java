package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;

public class Bilde extends Tekst {

	private String m_url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		m_url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		m_url = url;
	}
	
	public String getUrl() {
			return m_url;
	}

	public void setUrl(String url) {
		m_url = url;
	}

	@Override
	public String toString() {
		String ret = "";
		if(this instanceof Bilde)
			ret += "BILDE\n";
		return ret + super.toString() + m_url +"\n";
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		return super.toHTML() + "<img src=\"" + m_url +"\" height=600 width =600></iframe>";	
	}
}
