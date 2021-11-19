package no.hvl.dat100.jplab11.oppgave2;



import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Tekst extends Innlegg {
	public Tekst () {
		
	}
	
	public Tekst(int id, String bruker, String dato, String tekst) {
		super(id,bruker,dato);
		m_tekst = tekst;
	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		super(id,bruker,dato,likes);
		m_tekst = tekst;
	}


	public void setTekst(String tekst) {
		m_tekst = tekst;
	}

	public String getUrl()
	{
		return null;
	}
	
	@Override
	public String toString() {
		String ret = "";
		if((this instanceof Tekst) && !(this instanceof Bilde))
			ret += "TEKST\n";
		ret += super.toString() + m_tekst + "\n"; 
		return ret;
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		String ret = super.toHTML();
		return ret;
	}
}
