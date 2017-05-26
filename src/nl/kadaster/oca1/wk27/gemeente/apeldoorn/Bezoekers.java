package nl.kadaster.oca1.wk27.gemeente.apeldoorn;

import java.util.ArrayList;

import nl.kadaster.oca1.wk27.familie.*;
import nl.kadaster.oca1.wk27.projectfacilitair.Utils;

public class Bezoekers {
	private int aantalBezoekers;
	private ArrayList<Gezin> gezinnen = new ArrayList<Gezin>();
	
	Bezoekers() {
		boolean voldoendeBezoekers = false;
		
		Utils.myIndentPrintln("Alle bezoekers mogen toegelaten worden aan de kermis", 1, true);

		while(aantalBezoekers <= Configuration.maxAantalBezoekers && !voldoendeBezoekers) {
			Gezin nieuwGezin = new Gezin(Configuration.getNextGezinsNaam(), 
					                     Configuration.getNextOuderVoornamen(Utils.myRandom(1, 2)),
					                     Configuration.getNextKinderVoornamen(Utils.myRandom(0, 4)),
					                     false);
//			Utils.debugExit(true);
			
			if (!nieuwGezin.getAchterNaam().equals("")) {
				gezinnen.add(nieuwGezin);
				Utils.myIndentPrintln("Het gezin met de achternaam " + nieuwGezin.getAchterNaam() + " is toegelaten.", 1, true);
				Utils.myIndentPrintln(nieuwGezin.toString(), 0, true);
				Utils.myIndentPrintln("Het gezin heeft € " + nieuwGezin.getGezinsBudget() + " te besteden.", 0, true);
				Utils.myIndentPrintln("", -1, true);
				aantalBezoekers += nieuwGezin.getAantalGezinsleden();
			} else {
				voldoendeBezoekers = true;
				System.out.println("hallo");
			}
			
			
		} 
		Utils.myIndentPrintln("Alle bezoekers zijn op het terein van de kermis. De kermis kan opgestart worden.", -1, true);
	}
}
