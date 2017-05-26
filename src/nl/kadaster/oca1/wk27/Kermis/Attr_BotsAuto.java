package nl.kadaster.oca1.wk27.Kermis;

public abstract class Attr_BotsAuto extends Attractie{

	Attr_BotsAuto(String naamAttractie, int minStroomVerbruik, int maxStroomVerbruik, double attractiePrijsVolwassenen, double attractiePrijsKinderen, boolean IsKinderAttractie) {
		super(naamAttractie, minStroomVerbruik, maxStroomVerbruik, attractiePrijsVolwassenen, attractiePrijsKinderen, IsKinderAttractie);
	}
//	public Attr_BotsAuto(String naamAttractie, int stroomVerbruik) {
//		super.attractieNaam = naamAttractie;
//		super.stroomVerbruik = stroomVerbruik;
//		
//		attractieKassa.setAttractiePrijsVolwassenen(2.50d);
//		attractieKassa.setAttractiePrijsKinderen(1.25d);
//	}
}
