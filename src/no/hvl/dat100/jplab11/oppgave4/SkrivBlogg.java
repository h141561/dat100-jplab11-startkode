package no.hvl.dat100.jplab11.oppgave4;
import no.hvl.dat100.jplab11.oppgave2.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		
		String output = "";
		String outputs = "";
		for(Innlegg i : samling)
		{
			
			output = 
				"{\n\t<id>" + i.getId() + "</id>\n" +
				"\t<namn>" + i.getBruker() + "</namn>\n" +
				"\t<dato>" + i.getDato() + "</dato>\n";
				if(i instanceof Tekst)
				{
					output += ("\t<tekst>" + i.getText() + "</tekst>\n");
					output += ("\t<type>" + "TEKST" + "</type>\n");
				}
				if(i instanceof Bilde)
				{
					output += ("\t<bilde>" + i.getUrl() + "</bilde>\n");
					output += ("\t<type>" + "BILDE" + "</type>\n");
				}
				
				output += "}\n";
				System.out.print(output);
				outputs += output;
		}
		
		File file = new File(mappe + filnavn);
		try
		{
			FileWriter of = new FileWriter(file);
			of.write(outputs);
			of.close();
		}catch(IOException ex) {
			
			
		}catch(Exception ex) {
			System.out.print("Alt er tapt\n");
			return false;
		}
		
		return true;
	}
}
