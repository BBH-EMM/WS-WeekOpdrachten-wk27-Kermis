package nl.kadaster.oca1.wk27.Kermis;

import ProjectFacilitair.Utils;

public class Attr_Hawaii extends Attractie {
	public Attr_Hawaii(String naamAttractie, int minStroomVerbruik, int maxStroomVerbruik, double attractiePrijsVolwassenen, double attractiePrijsKinderen, boolean IsKinderAttractie) {
		super(naamAttractie, minStroomVerbruik, maxStroomVerbruik, attractiePrijsVolwassenen, attractiePrijsKinderen, IsKinderAttractie);
	}
//	public static final int minStroomVerbruik = 3000;
//	private static final int maxStroomVerbruik = 6000;
//
//	public Attr_Hawaii(String naamAttractie) {
//		super.attractieNaam = naamAttractie;
//		super.stroomVerbruik = Utils.myRandom(minStroomVerbruik, maxStroomVerbruik);
//		super.setAantalVrijePlaatsen(Utils.myRandom(10, 20));
//		super.isKinderAttractie = false;
//	}
//	
//	public String getMinStroomVerbruikAttractie() {
//		return toString_stroomVerbruik(minStroomVerbruik);
//	}
//	public String getMaxStroomVerbruikAttractie() {
//		return toString_stroomVerbruik(maxStroomVerbruik);
//	}
}
