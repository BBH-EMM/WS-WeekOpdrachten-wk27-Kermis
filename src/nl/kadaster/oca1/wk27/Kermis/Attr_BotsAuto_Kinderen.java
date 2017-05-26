package nl.kadaster.oca1.wk27.kermis;

import nl.kadaster.oca1.wk27.projectfacilitair.Utils;

public class Attr_BotsAuto_Kinderen extends Attr_BotsAuto{
	public Attr_BotsAuto_Kinderen(String naamAttractie, int minStroomVerbruik, int maxStroomVerbruik, double attractiePrijsVolwassenen, double attractiePrijsKinderen, boolean IsKinderAttractie) {
		super(naamAttractie, minStroomVerbruik, maxStroomVerbruik, attractiePrijsVolwassenen, attractiePrijsKinderen, IsKinderAttractie);
	}
//	private static final int maxStroomVerbruik = 4000;
//
//	public Attr_BotsAuto_Kinderen(String naamAttractie) {
//		super(naamAttractie, Utils.myRandom(minStroomVerbruik, maxStroomVerbruik));
//		super.setAantalVrijePlaatsen(Utils.myRandom(10, 20));
//		super.isKinderAttractie = true;
//	}
//
//	public String getMinStroomVerbruikAttractie() {
//		return toString_stroomVerbruik(minStroomVerbruik);
//	}
//	public String getMaxStroomVerbruikAttractie() {
//		return toString_stroomVerbruik(maxStroomVerbruik);
//	}
}
