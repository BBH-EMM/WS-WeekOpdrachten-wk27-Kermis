package nl.kadaster.oca1.wk27.Kermis;

//import ProjectFacilitair.Utils;

public class Attr_Spin extends Attractie {
	Attr_Spin(String naamAttractie, int minStroomVerbruik, int maxStroomVerbruik, double attractiePrijsVolwassenen, double attractiePrijsKinderen, boolean IsKinderAttractie) {
		super(naamAttractie, minStroomVerbruik, maxStroomVerbruik, attractiePrijsVolwassenen, attractiePrijsKinderen, IsKinderAttractie);
	}
//	public static final int minStroomVerbruik = 3000;
//	private static final int maxStroomVerbruik = 6000;

//	public Attr_Spin(String naamAttractie) {
//		super.attractieNaam = naamAttractie;
//		super.stroomVerbruik = Utils.myRandom(minStroomVerbruik, maxStroomVerbruik);
//		super.setAantalVrijePlaatsen(Utils.myRandom(10, 20));
//		super.isKinderAttractie = false;
//		
//		attractieKassa.setAttractiePrijsVolwassenen(2.25d);
//	}
//	
//	public String getMinStroomVerbruikAttractie() {
//		return toString_stroomVerbruik(minStroomVerbruik);
//	}
//	public String getMaxStroomVerbruikAttractie() {
//		return toString_stroomVerbruik(maxStroomVerbruik);
//	}
}
