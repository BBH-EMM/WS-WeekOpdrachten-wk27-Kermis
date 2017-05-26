package nl.kadaster.oca1.wk27.familie;

import ProjectFacilitair.Utils;
import nl.kadaster.oca1.wk27.gemeenteApeldoorn.Configuration;

//import KermisFacilitair.*;

public class Gezin {
	private String achterNaam = "";
	private double budget = 0.00d;
	
	Mens ouders[];
	Mens kinderen[];
	
	public Gezin(String achterNaam, String ouderVoornamen[], String kinderVoornamen[], boolean blnPrint) {
		this.setAchterNaam(achterNaam);
		this.budget = Configuration.Budget.substractFromBudget( (double) Utils.myRandom(0, Configuration.maxBudgetPerGezin*100)/100.00);

		if (!achterNaam.equals("")) {
			Utils.myIndentPrintln("Het gezin met achternaam " + getAchterNaam() + " wordt samengesteld.", 1, blnPrint);

			ouders  = new Volwassene[ouderVoornamen.length];
			for (int i=0 ; i<ouders.length ; i++) {
				ouders[i] = new Volwassene(ouderVoornamen[i], achterNaam);
				Utils.myIndentPrintln("Ouder " + (i+1) + " met voornaam " + ouders[i].getVoorNaam() + " wordt toegevoegd aan het gezin (" + ouders[i].getVolledigeNaam() + ").", 0, blnPrint);
			}

			kinderen  = new Kind[kinderVoornamen.length];
			for (int i=0 ; i<kinderen.length ; i++) {
				kinderen[i] = new Kind(kinderVoornamen[i], achterNaam, ouders);
				Utils.myIndentPrintln("Kind " + (i+1) + " met voornaam " + kinderen[i].getVoorNaam() + " wordt toegevoegd aan het gezin (" + kinderen[i].getVolledigeNaam() + ").", 0, blnPrint);
			}
			Utils.myIndentPrintln("Het gezin met achternaam " + getAchterNaam() + " is samengesteld.", -1, blnPrint);
		}
	}

	private void setAchterNaam(String achterNaam) {
		this.achterNaam = achterNaam;
	}
	public String getAchterNaam() {
		return this.achterNaam;
	}

	public int getAantalGezinsleden() {
		return ouders.length + kinderen.length;
	}

	public double getGezinsBudget() {
		return this.budget;
	}
	
	@Override
	public String toString() {
		//Dit is een toepassing van overriding
		StringBuilder tmpString = new StringBuilder();
		tmpString.append("Het gezin " + this.getAchterNaam() + " bestaat uit; ");
		tmpString.append((this.ouders.length > 0) ? "(" + this.ouders.length + " ouders) " : "");
		tmpString.append((this.kinderen.length > 0) ? "(" + this.kinderen.length + " kinderen) " : "");
		
		for (Mens v: this.ouders) tmpString.append(System.lineSeparator() + Utils.fixedString(Utils.getCurrentIndentationLevel(), ' ') + "   - Een ouder is: " + v.getVolledigeNaam());
		for (Mens k: this.kinderen) tmpString.append(System.lineSeparator() + Utils.fixedString(Utils.getCurrentIndentationLevel(), ' ') + "     - Een kind is : " + k.getVolledigeNaam());

//		Utils.myIndentPrintln(tmpString.toString(), 1, true);
		return tmpString.toString();		
	}
}
