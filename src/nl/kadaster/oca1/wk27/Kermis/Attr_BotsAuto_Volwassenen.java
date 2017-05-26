package nl.kadaster.oca1.wk27.Kermis;

import java.math.BigDecimal;

import ProjectFacilitair.Utils;

public class Attr_BotsAuto_Volwassenen extends Attr_BotsAuto {
	public Attr_BotsAuto_Volwassenen(String naamAttractie, int minStroomVerbruik, int maxStroomVerbruik, double attractiePrijsVolwassenen, double attractiePrijsKinderen, boolean IsKinderAttractie) {
		super(naamAttractie, minStroomVerbruik, maxStroomVerbruik, attractiePrijsVolwassenen, attractiePrijsKinderen, IsKinderAttractie);
	}
//	public Attr_BotsAuto_Volwassenen(String naamAttractie, int minStroomVerbruik, int maxStroomVerbruik, BigDecimal attractiePrijsVolwassenen, BigDecimal attractiePrijsKinderen, boolean IsKinderAttractie) {
//		super(naamAttractie, Utils.myRandom(minStroomVerbruik, maxStroomVerbruik));
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
