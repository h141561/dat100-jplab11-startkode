package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;


public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		
		Blogg ret = new Blogg(20);

		try(BufferedReader in = new BufferedReader(new FileReader(mappe + filnavn)))
		{
			
			String block = "";
			String linje = "";
			Innlegg tmp;
			while((linje = in.readLine()) != null)
			{
				block += linje;
				if(linje.contains("}"))
				{
					InnleggFraaBlokk(block, filnavn);	
					block = "";
				}
			}
		}
		catch(IOException e)
		{
		
			
		}
		catch(Exception e)
		{
			
		}
		return new Blogg();
	}
	private static Innlegg InnleggFraaBlokk(String blokk, String filnavn) 
	{
		System.out.println(blokk);
		int id = Integer.parseInt(getVal(blokk, "id"));
		System.out.println(id);
		String navn = getVal(blokk, "namn");
		System.out.println(navn);
		String dato = getVal(blokk, "dato");
		String tekst = getVal(blokk, "tekst");
		String bileteUrl = getVal(blokk, "bilde");
		System.out.println("las in Blokk");
		if(id < 0 || navn == "" || dato == "")
		{
			System.out.printf("noko gjekk gale med å lese frå fil : \n\t%s\nStenger..\n",filnavn);
		}
		if(getVal(blokk, "type") == TEKST)
		{
			return new Tekst(id, navn, dato, tekst);
		}
		if(getVal(blokk, "type") == BILDE)
		{
			return new Bilde(id, navn, dato, tekst, bileteUrl);
		}
		return null;
	}
	private static String getVal(String blokk, String key)
	{
		int fpos = blokk.indexOf("<" + key + ">") + key.length() + 2;
		int lpos = blokk.indexOf("</" + key + ">");
		
		if(fpos == -1 || lpos == -1)
			return "";
		else
			return blokk.substring(fpos, lpos);
	}
}




