package nl.kadaster.oca1.wk27.gemeenteApeldoorn;

import ProjectFacilitair.UserInput;
import ProjectFacilitair.Utils;
import nl.kadaster.oca1.wk27.Kermis.*;

public class AKI {
	private Kermis kermis;
	AKI(String kermisNaam) {
		kermis  = new Kermis(kermisNaam + " (in keuring)");
	}
	
	public void keurKermisAttracties() {
		String keurmeesterNaam = "";
		String keurmeesterInput = "";
		
		do {
			printGUI(false);
			System.out.println("De kermis \"" + kermis.getKermisNaam() + "\" moet eerst gekeurd worden:" + System.getProperty("line.separator"));
			if (Configuration.blnAutoPlay) {
				keurmeesterNaam = "Eugène Meulenbelt";
			} else {
				keurmeesterInput = UserInput.getUserInputString(((!keurmeesterInput.isEmpty())? "Ongeldige invoer, uw heeft geen naam ingevoerd. (" + keurmeesterInput + ")\n" : "") + "Beste AKI kermiskeurmeester.\nEnter s.v.p. uw naam?");
				if (!keurmeesterInput.isEmpty()) keurmeesterNaam = keurmeesterInput;
			}
		} while (keurmeesterNaam.equals(""));
		
		char cReportType = 0;
		while (true) {
			if (cReportType == 'o') printGUI(true, 'o');
			if (cReportType == 'k') printGUI(true, 'k');
			if (cReportType == 'v') printGUI(true, 'v');
			if (cReportType == 'd') printGUI(true);
			if (cReportType ==  0 ) printGUI(true);

//			System.out.println(this.kermis.toString());
			keurmeesterInput = UserInput.getUserInputString("Beste " + keurmeesterNaam + ", beste AKI keurmeester,\n\n" 
					+ "Welke kermisattractie wilt u keuren? Kies één van de boven genoemde kermis attracties.\n"
					+ "Rapportage type: (d)etails tonen, electriciteits(v)erbruik tonen, (o)mzet tonen, (k)aartverkoop tonen.\n"
					+ "(Q)uit voor het beëindigen van de kermiskeuring.");
			if (keurmeesterInput.toUpperCase().equals("Q")) break;

			switch (keurmeesterInput) {
			case "1-1":
			case "1-2":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
				keurAttractie(keurmeesterInput);
				break;
			case "o": cReportType = 'o'; break;
			case "k": cReportType = 'k'; break;				
			case "v": cReportType = 'v' ; break;
			case "d": cReportType = 'd' ; break;
			default:
				//nothing to do
			}
//			Utils.debugExit(true);
		}
	}
	private void keurAttractie(String attractieType) {
		boolean keuringsStatus = false;
		
		//zoek de attractie en / of voeg de te testen attractie toe
		Attractie attractie = kermis.getAttraction(attractieType);
		Utils.clearConsole();
		Utils.debugPrintln(Utils.fixedString(80, '='));
		if (attractie != null) {
			System.out.println("Eerder gekeurde attractie gevonden: " + attractie.attractieNaam);
			Utils.debugPrintln(Utils.fixedString(80, '.'));
		} else {
			attractie = KermisConfiguration.getAttractionByType(attractieType);
			kermis.addAttraction(attractieType, attractie);
		}
		
		keuringsStatus = attractie.attractieKaartVerkoop();
		System.out.println("Deze attractie kan nu worden gekeurd...");
		keuringsStatus = attractie.startAttractie();
		//todo: check op resultaten (stroomverbruik, gewicht enz) en return keuringsstatus

		if (keuringsStatus) {
			System.out.println(Utils.fixedString(3, ' ') + "- de attractie is goedgekeurd.");
			kermis.getAdministratieBoekhouder().addAantalVerkochteKaarten(attractie.getLaatsteVerkochteVolwasseneKaartjes());
			kermis.getAdministratieBoekhouder().addAantalVerkochteKaarten(attractie.getLaatsteVerkochteKinderKaartjes());
			kermis.getAdministratieBoekhouder().addOmzetVerkochteKaarten(attractie.getLaatsteOmzetVolwasseneKaartjes());
			kermis.getAdministratieBoekhouder().addOmzetVerkochteKaarten(attractie.getLaatsteOmzetKinderKaartjes());			
		} else 
			System.out.println(Utils.fixedString(3, ' ') + "- de attractie is afgekeurd!");		

		System.out.println("Deze attractie is gekeurd.");

		UserInput.pressAnyKeyToContinue();
		//Utils.debugExit();
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.toString('x'));
		return str.toString();
	}
	public String toString(char cReportType) {
		StringBuilder str = new StringBuilder();
		str.append("De kermis \"" + kermis.getKermisNaam() + "\" wordt gekeurd:" + System.getProperty("line.separator"));
		str.append(System.getProperty("line.separator"));
		str.append("   - Deze kermis heeft " + ((kermis.getAantalKermisAttracties()==0) ? "nog geen" : kermis.getAantalKermisAttracties()) + " attracties;" + System.getProperty("line.separator"));
		str.append(System.getProperty("line.separator"));
		if (cReportType=='x') str.append(this.kermis.toString());
		else str.append(this.kermis.toString(cReportType));
		str.append(System.getProperty("line.separator"));
		return str.toString();
	}
	private void printGUI(boolean printToString) {
		printGUI(printToString, 'x');
	}
	private void printGUI(boolean printToString, char cReportType) {
		Utils.clearConsole();
		Configuration.GUI.printHeader();
		if (printToString) { 
			 if (cReportType=='x')
				 System.out.println(this.toString());
			 else 
				 System.out.println(this.toString(cReportType));
		}
	}
}
