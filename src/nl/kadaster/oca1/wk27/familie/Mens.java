package nl.kadaster.oca1.wk27.familie;

public abstract class Mens {
	private String voorNaam = "";
	private String achterNaam = "";
	
	Mens(String voorNaam, String achterNaam) {
		this.voorNaam = voorNaam;
		this.achterNaam = achterNaam;
	}
	
	String getVolledigeNaam(){
		String returnValue = new String(this.achterNaam + ", " + this.voorNaam);
		returnValue = (returnValue.equals(", "))? this.toString() :returnValue;
		return returnValue;
	}
	public String getVoorNaam() {
		//Inheritance: Kind / Volwassene maken gebruik deze wederzijdse methods.
		//Er is geen noodzaak voor overriding in de Kind / Volwassene class
		return this.voorNaam;
	}
	public String getAchterNaam() {
		//Inheritance: Kind / Volwassene maken gebruik deze wederzijdse methods.
		//Er is geen noodzaak voor overriding in de Kind / Volwassene class
		return this.achterNaam;
	}
}
