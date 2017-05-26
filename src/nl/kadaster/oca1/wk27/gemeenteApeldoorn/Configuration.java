package nl.kadaster.oca1.wk27.gemeenteApeldoorn;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

import ProjectFacilitair.Utils;

import java.math.BigDecimal;

import nl.kadaster.oca1.wk27.Kermis.Attr_BotsAuto_Kinderen;
import nl.kadaster.oca1.wk27.Kermis.Attr_BotsAuto_Volwassenen;
import nl.kadaster.oca1.wk27.Kermis.Attr_Hawaii;
import nl.kadaster.oca1.wk27.Kermis.Attr_LadderKlimmen;
import nl.kadaster.oca1.wk27.Kermis.Attr_Spiegelpaleis;
import nl.kadaster.oca1.wk27.Kermis.Attr_Spin;
import nl.kadaster.oca1.wk27.Kermis.Attr_Spookhuis;
import nl.kadaster.oca1.wk27.Kermis.Attractie;


public class Configuration {
	private static boolean blnPrint = true;
	private static ArrayList<String> gezinsNamen = new ArrayList<String>();
	private static ArrayList<String> ouderVoornamen = new ArrayList<String>();
	private static ArrayList<String> kinderVoornamen = new ArrayList<String>();
	
	public static boolean blnAutoPlay = false;
	public static final int maxAantalBezoekers = 10;
	public static final int maxBudgetPerGezin = 100;
	public static final int maxAantalKermisAttracties = 6;

	public static void setConfiguration(boolean blnPrint) {
		Configuration.blnPrint = blnPrint;
		Configuration.setNamen();
	}
	public static String getNextGezinsNaam() {
		return getNextNaam(gezinsNamen);
	}
	
	public static String[] getNextOuderVoornamen(int aantal) {
		String ouderVoornamen[] = new String[aantal];
		for (int i = 0; i < ouderVoornamen.length; i++) {
			ouderVoornamen[i] = getNextNaam(Configuration.ouderVoornamen);
		}
		return ouderVoornamen;
	}
	
	public static String[] getNextKinderVoornamen(int aantal) {
		String kinderVoornamen[] = new String[aantal];
		for (int i = 0; i < kinderVoornamen.length; i++) {
			kinderVoornamen[i] = getNextNaam(Configuration.kinderVoornamen);
		}
		return kinderVoornamen;
	}
	
	
	
	
	
	// private methods
	private static String getNextNaam(ArrayList<String> sourceArray) {
		String waarde = "";
		if (0 < sourceArray.size()) {
			int i = Utils.myRandom(0, sourceArray.size()-1);
			waarde = sourceArray.get(i);
			//System.out.println("Waarde " + waarde + " opgehaald uit random positie " + i + ".");
			sourceArray.remove(i);
			return waarde;
		} else {
			return "";
		}
	}
	private static void setNamen() {
		Configuration.setGezinsNamen();
		Configuration.setOudersVoornamen();
		Configuration.setKinderenVoornamen();
		Configuration.Budget.addToBudget(new BigDecimal(1000d));
	}
	private static void setGezinsNamen() {
		while (true) {
			if (!Configuration.addGezinsNaam("Meulenbelt")) break;
			if (!Configuration.addGezinsNaam("De Jong")) break;
			if (!Configuration.addGezinsNaam("Bos")) break;
			if (!Configuration.addGezinsNaam("Snel")) break;
			if (!Configuration.addGezinsNaam("Wagner")) break;
			break;
		}
	}
	private static void setOudersVoornamen() {
		while (true) {
			if (!Configuration.addOuderVoornaam("Eugène")) break;
			if (!Configuration.addOuderVoornaam("Anneke")) break;
			if (!Configuration.addOuderVoornaam("Claudia")) break;
			if (!Configuration.addOuderVoornaam("Menno")) break;
			if (!Configuration.addOuderVoornaam("Mark")) break;
			if (!Configuration.addOuderVoornaam("Daan")) break;
			if (!Configuration.addOuderVoornaam("Seyit")) break;
			if (!Configuration.addOuderVoornaam("Jasper")) break;
			break;
		}
	}
	private static void setKinderenVoornamen() {
		while (true) {
			if (!Configuration.addKinderVoornaam("Marnix")) break;
			if (!Configuration.addKinderVoornaam("Dären-Joe")) break;
			if (!Configuration.addKinderVoornaam("Keano")) break;
			if (!Configuration.addKinderVoornaam("Jantje")) break;
			if (!Configuration.addKinderVoornaam("Pietje")) break;
			if (!Configuration.addKinderVoornaam("Paultje")) break;
			if (!Configuration.addKinderVoornaam("Greetje")) break;
			if (!Configuration.addKinderVoornaam("Wimpie")) break;
			if (!Configuration.addKinderVoornaam("Keesje")) break;
			if (!Configuration.addKinderVoornaam("Harrytje")) break;
			if (!Configuration.addKinderVoornaam("Henkie")) break;
			if (!Configuration.addKinderVoornaam("Gertie")) break;
			if (!Configuration.addKinderVoornaam("Sjakie")) break;
			if (!Configuration.addKinderVoornaam("Sloompie")) break;
			if (!Configuration.addKinderVoornaam("Snellie")) break;
			if (!Configuration.addKinderVoornaam("Sampie")) break;
			if (!Configuration.addKinderVoornaam("Collintje")) break;
			if (!Configuration.addKinderVoornaam("Erikje")) break;
			if (!Configuration.addKinderVoornaam("Harrietje")) break;
			if (!Configuration.addKinderVoornaam("Sjaantje")) break;
			if (!Configuration.addKinderVoornaam("Leonietje")) break;
			if (!Configuration.addKinderVoornaam("Simoontje")) break;
			if (!Configuration.addKinderVoornaam("Alietje")) break;
			if (!Configuration.addKinderVoornaam("Antonie")) break;
			if (!Configuration.addKinderVoornaam("Antontje")) break;
			if (!Configuration.addKinderVoornaam("Gerrie")) break;
			break;
		}
	}

	private static boolean addGezinsNaam(String familieNaam) {
		return Configuration.addNaam(gezinsNamen, "Gezinsnaam: ", familieNaam);
	}
	private static boolean addOuderVoornaam(String voornaam) {
		return Configuration.addNaam(ouderVoornamen, "Oudernaam: ", voornaam);
	}
	private static boolean addKinderVoornaam(String voornaam) {
		return Configuration.addNaam(kinderVoornamen, "Kindernaam: ", voornaam);
	}
	private static boolean addNaam(ArrayList<String> myArrayList, String mensType, String naam) {
		int i = Utils.myRandom(0, myArrayList.size());
		Utils.myIndentPrintln(mensType + " " + naam + " wordt aangemaakt.", 1, blnPrint);
		myArrayList.add(i, naam);
		Utils.myIndentPrintln(mensType + ": " + myArrayList.get(i), 0, blnPrint);
		Utils.myIndentPrintln(mensType + " " + naam + " is aangemaakt.", -1, blnPrint);
		return true;
	}

	
	
	
	
	
	//public subClass
	public static class GUI {
		public static void printHeader() {
			System.out.println("Gemeente Apeldoorn gaat een kermis organiseren.");
			System.out.println("   De gemeente heeft onderstaande spelregels.");
			System.out.println("      - de kermis kan maar één keer gehouden worden.");
			System.out.println("      - de kermis mag maar 15 minuten duren.");
			System.out.println("      - de inwoners van Apeldoorn hebben maar 1000 euro te besteden.");
			System.out.println();
			System.out.println("      - de kermis kan maar uit 6 attracties bestaan (ivm gewicht).");
			System.out.println();
			System.out.println("   De boekhouder van de kermis wil graag de omzet bijhouden.");
			System.out.println();
			System.out.println(Utils.fixedString(80, '-'));
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
	
	public static class Budget {
		private static BigDecimal budget = new BigDecimal(0d);
		
		public static void addToBudget(BigDecimal amount) {
			Budget.budget.add(amount);
		}
		public static double substractFromBudget(double amount) {
			Budget.budget.subtract(new BigDecimal(amount));
			return amount;
		}
		public static double getBudget() {
			return Budget.budget.doubleValue();
		}
	}
}
