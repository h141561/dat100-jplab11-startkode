package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import java.util.*;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg implements Iterable<Innlegg> {

	protected Innlegg[] m_innleggsTabell;
	protected int m_nesteLedig;

	public Blogg() {
		m_innleggsTabell = new Innlegg[20];
		m_nesteLedig = 0;
	}

	public Blogg(int lengde) {
		m_innleggsTabell = new Innlegg[lengde];
		m_nesteLedig = 0;
	}

	public int getAntall() {
		return m_nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return m_innleggsTabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for(int i = 0; i < m_nesteLedig ; i++)
		{
			System.out.printf("m_innleggsTabell[%d] er %d og innlegg.id() er %d \n",i, m_innleggsTabell[i].getId(), innlegg.getId());
			if(m_innleggsTabell[i].getId() == innlegg.getId())
			{
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return (finnInnlegg(innlegg) != -1);
	}

	public boolean ledigPlass() {
		return (m_nesteLedig < m_innleggsTabell.length);
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if(!ledigPlass())
		{
			System.out.println("Har ikkje plass til fleire innlegg");
			return false;
		}
		else if(finnes(innlegg))
		{
			System.out.println("Duplikat, Innlegg ikkje lagt til");
			return false;
		}
		else
		{
			System.out.println("legger til no");
			m_innleggsTabell[m_nesteLedig] = innlegg;
			++m_nesteLedig;
			return true;
		}
		//System.out.println("Kom Gjennom heile leggTil() noko er riv ruskande gale");
		
		//return false;
	}
	
	public String toString() {
		String ret = Integer.toString(m_nesteLedig) + "\n";
		for(int i = 0; i < m_nesteLedig; i++)
		{
			ret += m_innleggsTabell[i].toString();
		}
		return ret;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] ny = new Innlegg[m_innleggsTabell.length * 2];
		for(int i = 0; i < m_nesteLedig ; i++)
		{
			ny[i] = m_innleggsTabell[i];
		}
		m_innleggsTabell = ny;
		ny = null;
		
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
		if(pos > -1)
		{
			m_innleggsTabell[pos] = null;
			while(true)
			{
				if(pos < m_nesteLedig && (pos < ((m_innleggsTabell.length) - 1)))
				{
					m_innleggsTabell[pos] = m_innleggsTabell[++pos];
				}
				else {
					break;
				}
			}
			--m_nesteLedig;
			return true;
		}
		return false;
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}

	@Override
	public Iterator<Innlegg> iterator() 
	{
		return new Iterator<Innlegg>() 
		{
			private int pos = 0;
			public boolean hasNext()
			{
				return m_nesteLedig > pos;
			}
			public Innlegg next()
			{
				return m_innleggsTabell[pos++];
			}
		};
	}
}




