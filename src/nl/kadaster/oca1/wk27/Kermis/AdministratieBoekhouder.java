package nl.kadaster.oca1.wk27.Kermis;

import java.math.BigDecimal;

import ProjectFacilitair.Utils;

public class AdministratieBoekhouder {
	private                      String naam = "Boekhouder van de Kermis";
	private       int aantalVerkochteKaarten = 0;
	private BigDecimal omzetVerkochteKaarten = new BigDecimal(0d);

	public AdministratieBoekhouder() {
		// TODO Auto-generated constructor stub
	}
	
	private String getNaam() {
		return this.naam;
	}
		
	public int getAantalVerkochteKaarten() {
		return aantalVerkochteKaarten;
	}

	public void setAantalVerkochteKaarten(int aantalVerkochteKaarten) {
		this.aantalVerkochteKaarten = aantalVerkochteKaarten;
	}

	public void addAantalVerkochteKaarten(int aantalVerkochteKaarten) {
		this.aantalVerkochteKaarten += aantalVerkochteKaarten;
	}

	public BigDecimal getOmzetVerkochteKaarten() {
		return omzetVerkochteKaarten;
	}

	public void setOmzetVerkochteKaarten(BigDecimal omzetVerkochteKaarten) {
		this.omzetVerkochteKaarten = omzetVerkochteKaarten;
	}

	public void addOmzetVerkochteKaarten(BigDecimal omzetVerkochteKaarten) {
		this.omzetVerkochteKaarten = this.omzetVerkochteKaarten.add(omzetVerkochteKaarten);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("De " + getNaam() + " heeft onderstaande gegevens bijgehouden" + System.getProperty("line.separator"));
		sb.append(Utils.rightpad(Utils.fixedString(3, ' ') + "- Het totaal aantal verkochte kaarten van de kermis is: ", 70) + Utils.leftpad("" + getAantalVerkochteKaarten(), 10) + System.getProperty("line.separator"));
		sb.append(Utils.rightpad(Utils.fixedString(3, ' ') + "- De totale omzet van de kermis is: ", 70) + Utils.leftpad("€ " + getOmzetVerkochteKaarten(), 10) + System.getProperty("line.separator"));
		//System.out.println(sb.toString());
		return sb.toString();
	}
}


