package nl.kadaster.oca1.wk27.kermis;

import java.math.BigDecimal;

import nl.kadaster.oca1.wk27.projectfacilitair.Utils;

public abstract class Attractie extends Adm_AttractieKassa {
	//bewust publieke variabelen zodat de subclasse op deze manier de naam kan zetten
	public String attractieNaam = "";
	//public Adm_AttractieKassa attractieKassa = new Adm_AttractieKassa();
	
	private int       minStroomVerbruik = 0;
	private int       maxStroomVerbruik = 0;
	private int          stroomVerbruik = 0;
	private boolean   isKinderAttractie = false;
	private int      maxAantalBezoekers = 0;
	private int aantalVerkochteVolwasseneKaartjes = 0;
	private int aantalVerkochteKinderKaartjes     = 0;

	private int laatsteVerkochteVolwasseneKaartjes = 0;
	private int laatsteVerkochteKinderKaartjes     = 0;

	public BigDecimal getLaatsteOmzetVolwasseneKaartjes() {
		return new BigDecimal(getLaatsteVerkochteVolwasseneKaartjes()).multiply(getAttractiePrijsVolwassenen());
	}

	public BigDecimal getLaatsteOmzetKinderKaartjes() {
		return new BigDecimal(getLaatsteVerkochteKinderKaartjes()).multiply(getAttractiePrijsKinderen());
	}
	private int     aantalVrijePlaatsen = 0;

	private BigDecimal totaalOmzetAttracties = BigDecimal.valueOf(0);
	
	private boolean attractieIsGestart = false;
	
	static {
		// ga deze gebruiken
//		System.out.println("static Initializer");
	}
	{
		//gebruik ook deze
//		System.out.println("Initializer");
	}
	Attractie(String naamAttractie, int minStroomVerbruik, int maxStroomVerbruik, double attractiePrijsVolwassenen, double attractiePrijsKinderen, boolean IsKinderAttractie) {
//		System.out.println("constructor");
		this.attractieNaam = naamAttractie;
		this.minStroomVerbruik = minStroomVerbruik;
		this.maxStroomVerbruik = maxStroomVerbruik;
//		attractieKassa.setAttractiePrijsKinderen(attractiePrijsKinderen);
//		attractieKassa.setAttractiePrijsVolwassenen(attractiePrijsVolwassenen);
		setAttractiePrijsKinderen(attractiePrijsKinderen);
		setAttractiePrijsVolwassenen(attractiePrijsVolwassenen);
		this.isKinderAttractie = IsKinderAttractie;		

		this.stroomVerbruik = Utils.myRandom(minStroomVerbruik, maxStroomVerbruik);
		
		this.setAantalVrijePlaatsen(Utils.myRandom(10, 20));
	}
	
	public void setAantalVrijePlaatsen(int maxAantalVrijePlaatsen) {
		maxAantalBezoekers = maxAantalVrijePlaatsen;
		aantalVrijePlaatsen = maxAantalBezoekers;
	}
	public int getMaxAantalBezoekers() {
		return maxAantalBezoekers;
	}
	public int getAantalBezoekersDezeRonde() {
		Utils.debugPrintln(String.valueOf(maxAantalBezoekers));
		Utils.debugPrintln(String.valueOf(aantalVrijePlaatsen));
		return maxAantalBezoekers-aantalVrijePlaatsen;
	}
	public BigDecimal getOmzetDezeRonde() {
		BigDecimal bd1 = new BigDecimal(0d);
		BigDecimal bd2 = new BigDecimal(0d);
		Utils.debugPrintln(String.valueOf(aantalVerkochteVolwasseneKaartjes));
		Utils.debugPrintln(String.valueOf(aantalVerkochteKinderKaartjes));
		Utils.debugPrintln(String.valueOf(aantalVrijePlaatsen));
		
		bd1 = new BigDecimal(aantalVerkochteKinderKaartjes).multiply(getAttractiePrijsKinderen());
		bd2 = new BigDecimal(aantalVerkochteVolwasseneKaartjes).multiply(getAttractiePrijsVolwassenen());
		
		Utils.debugPrintln(String.valueOf(bd1.toString()));
		Utils.debugPrintln(String.valueOf(bd2.toString()));

		return bd1.add(bd2).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public boolean startAttractie() {
		System.out.println(Utils.fixedString(3, ' ') + "- de kaartcontroleur loopt langs de bezoekers.....");
		System.out.println(Utils.fixedString(6, ' ') + "- alle " + getAantalBezoekersDezeRonde() + " kaartjes worden opgehaald.");
		aantalVrijePlaatsen = maxAantalBezoekers;
		aantalVerkochteVolwasseneKaartjes=0;
		aantalVerkochteKinderKaartjes=0;
		System.out.println(Utils.fixedString(6, ' ') + "- alle kaartjes zijn opgehaald.");
		System.out.println(Utils.fixedString(3, ' ') + "- de attractie wordt gestart.....");
		attractieIsGestart = true;
		this.draaienMaar();
		attractieIsGestart = false;
		System.out.println(Utils.fixedString(3, ' ') + "- de attractie is gestopt.");
		return (aantalVrijePlaatsen==maxAantalBezoekers);
	}

	public boolean attractieKaartVerkoop() {
		int aantalKaartjes;

		System.out.println("Voor deze attractie kan de kaartverkoop starten...");
		aantalKaartjes = Utils.myRandom(0, aantalVrijePlaatsen);
		if (!isKinderAttractie) { 
			kaartVerkoopVolwassenen(aantalKaartjes);
			aantalVrijePlaatsen -= aantalKaartjes;
			aantalVerkochteVolwasseneKaartjes += aantalKaartjes; 
			setLaatsteVerkochteVolwasseneKaartjes(aantalKaartjes);
		}

		aantalKaartjes = Utils.myRandom(0, aantalVrijePlaatsen);
		kaartVerkoopKinderen(aantalKaartjes);
		aantalVrijePlaatsen -= aantalKaartjes;
		aantalVerkochteKinderKaartjes += aantalKaartjes; 
		setLaatsteVerkochteKinderKaartjes(aantalKaartjes);
		
		Utils.debugPrintln("Class Attractie: " + super.toString() + "\n(volw:" + aantalVerkochteVolwasseneKaartjes + " + kind:" + aantalVerkochteKinderKaartjes);
		
		System.out.print(this.toString());
		System.out.println("Voor deze attractie is de kaartverkoop beëindigd.");
		System.out.println();
		
		return true;
	}

	public String toString_stroomVerbruikAttractie() {
		return "Stroomverbruik van de attractie \"" + attractieNaam + "\" is " + toString_stroomVerbruik(stroomVerbruik) + ".";
	}
	public String toString_stroomVerbruik(int stroomVerbruik) {
//		return String.format("%.3f", (float)stroomVerbruik) + " kW";
		return stroomVerbruik + " kW";
	}
	public String getMinStroomVerbruikAttractie() {
		return toString_stroomVerbruik(minStroomVerbruik);
	}
	public String getMaxStroomVerbruikAttractie() {
		return toString_stroomVerbruik(maxStroomVerbruik);
	}
	public String getHuidigStroomVerbruikAttractie() {
		return toString_stroomVerbruik(stroomVerbruik);
	}
	
	public int getLaatsteVerkochteVolwasseneKaartjes() {
		return laatsteVerkochteVolwasseneKaartjes;
	}

	public void setLaatsteVerkochteVolwasseneKaartjes(int laatsteVerkochteVolwasseneKaartjes) {
		this.laatsteVerkochteVolwasseneKaartjes = laatsteVerkochteVolwasseneKaartjes;
	}

	public int getLaatsteVerkochteKinderKaartjes() {
		return laatsteVerkochteKinderKaartjes;
	}

	public void setLaatsteVerkochteKinderKaartjes(int laatsteVerkochteKinderKaartjes) {
		this.laatsteVerkochteKinderKaartjes = laatsteVerkochteKinderKaartjes;
	}

	public void draaienMaar(){
		System.out.println(Utils.fixedString(6, ' ') + "- Mensen, mensen komt dat zien, komt dat kijken, draaien maar, spoelen maar, tollen maar, botsen maar!");
	}
//	@Override
//	public abstract String toString();
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Deze attractie heet \"" + this.attractieNaam + "\"." + System.getProperty("line.separator"));
		//str.append(System.getProperty("line.separator"));
		str.append("   - Deze attractie kan maximaal " + getMaxAantalBezoekers() + " personen vervoeren." + System.getProperty("line.separator"));
		str.append("   - Deze attractie heeft een stroomverbruik tussen " + getMinStroomVerbruikAttractie() + " en " + getMaxStroomVerbruikAttractie() + "." + System.getProperty("line.separator"));
		str.append("   - Deze attractie heeft een huidig stroomverbruik van " + toString_stroomVerbruik(stroomVerbruik) + System.getProperty("line.separator"));
		str.append("   - Deze attractie wordt nu getest met " + (getLaatsteVerkochteVolwasseneKaartjes()+getLaatsteVerkochteKinderKaartjes()) + " bezoeker" + (((getLaatsteVerkochteVolwasseneKaartjes()+getLaatsteVerkochteKinderKaartjes())==1)?"":"s") + ". Er " + (((getMaxAantalBezoekers()-getLaatsteVerkochteVolwasseneKaartjes()+getLaatsteVerkochteKinderKaartjes())==1)?"is":"zijn") + " nog " + aantalVrijePlaatsen + " plaat" + ((aantalVrijePlaatsen==1)?"s":"sen") + " vrij." + System.getProperty("line.separator"));
		str.append("   - De prijzen voor deze attractie zijn € " + getAttractiePrijsKinderen().toString() + " voor kinderen en € " + getAttractiePrijsVolwassenen().setScale(2).toString() + " voor volwassenen." + System.getProperty("line.separator"));
//		str.append("   - Deze attractie heeft met deze " + aantalVerkochteKaartjes + " bezoeker" + ((aantalVerkochteKaartjes==1)?"":"s") + " een omzet van € " + attractieKassa.getTotaalOmzet() + "." + System.getProperty("line.separator"));
		str.append("   - Deze attractie heeft met deze " + (getLaatsteVerkochteVolwasseneKaartjes()+getLaatsteVerkochteKinderKaartjes()) + " bezoeker" + (((getLaatsteVerkochteVolwasseneKaartjes()+getLaatsteVerkochteKinderKaartjes())==1)?"":"s") + " een omzet van € " + getLaatsteOmzetVolwasseneKaartjes().add(getLaatsteOmzetKinderKaartjes()) + "." + System.getProperty("line.separator"));
		str.append(System.getProperty("line.separator"));
		
		//System.out.println(str.toString());
		return str.toString();
	}

}
