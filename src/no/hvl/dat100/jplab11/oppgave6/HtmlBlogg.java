package no.hvl.dat100.jplab11.oppgave6;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n"
			+ "<form><label for = fname\">First Name:</label><br><input type=\"text\" id=\"fname\" name=\"fname><br></form>";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	@Override
	public String toString() {
		String ret = "";
		for(int i = 0; i < m_nesteLedig; i++)
		{
			ret += m_innleggsTabell[i].toHTML();
		}
		return HTMLPREFIX + ret + HTMLPOSTFIX;
		
		
	}
}
