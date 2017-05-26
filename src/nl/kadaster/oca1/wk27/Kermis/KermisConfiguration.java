package nl.kadaster.oca1.wk27.kermis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import nl.kadaster.oca1.wk27.projectfacilitair.Utils;

public final class KermisConfiguration {
	private static boolean blnPrint = true;
	private static Map<String, String> hMKermisAttractieTypes = new HashMap<String, String>();

	public static void setConfiguration(boolean blnPrint) {
		KermisConfiguration.blnPrint = blnPrint;
		KermisConfiguration.setAttractieTypes();
	}

	private static boolean setAttractieTypes() {
		KermisConfiguration.hMKermisAttractieTypes.clear();
		
		KermisConfiguration.hMKermisAttractieTypes.put("1-1", "Botsauto's voor volwassenen");		
		KermisConfiguration.hMKermisAttractieTypes.put("1-2", "Botsauto's voor kinderen");		
		KermisConfiguration.hMKermisAttractieTypes.put("2"  , "Spin");		
		KermisConfiguration.hMKermisAttractieTypes.put("3"  , "Spiegelpaleis");		
		KermisConfiguration.hMKermisAttractieTypes.put("4"  , "Spookhuis");		
		KermisConfiguration.hMKermisAttractieTypes.put("5"  , "Hawaii");		
		KermisConfiguration.hMKermisAttractieTypes.put("6"  , "Ladderklimmen");
		
		return true;
	}
	public static String getAttractionByType() {
		StringBuilder str = new StringBuilder();
		str.append("Deze kermis kan opgebouwd worden uit onderstaande attracties;" + System.getProperty("line.separator"));
//		for (SortedSet<String> keys : new TreeSet<String>(hMKermisAttractieTypes.keySet())) {
//			
//		}
		for (Map.Entry<String, String> map : getAttractionsSortByKey().entrySet()) {
			str.append(Utils.fixedString(3, ' ') + "Attractiekeuze: " + map.getKey() + "\t attractietype: " + map.getValue() + System.getProperty("line.separator"));	
		}
		return str.toString();
	}
	public static Attractie getAttractionByType(String typeNo, String naamAttractie, int minStroomVerbruik, int maxStroomVerbruik, double attractiePrijsVolwassenen, double attractiePrijsKinderen, boolean IsKinderAttractie) {
		switch (typeNo) {
		case "1-1": return new Attr_BotsAuto_Volwassenen(naamAttractie, minStroomVerbruik, maxStroomVerbruik, attractiePrijsVolwassenen, attractiePrijsKinderen, IsKinderAttractie);
		case "1-2": return new Attr_BotsAuto_Kinderen   (naamAttractie, minStroomVerbruik, maxStroomVerbruik, attractiePrijsVolwassenen, attractiePrijsKinderen, IsKinderAttractie);
		case "2"  : return new Attr_Spin                (naamAttractie, minStroomVerbruik, maxStroomVerbruik, attractiePrijsVolwassenen, attractiePrijsKinderen, IsKinderAttractie);
		case "3"  : return new Attr_Spiegelpaleis       (naamAttractie, minStroomVerbruik, maxStroomVerbruik, attractiePrijsVolwassenen, attractiePrijsKinderen, IsKinderAttractie);
		case "4"  : return new Attr_Spookhuis           (naamAttractie, minStroomVerbruik, maxStroomVerbruik, attractiePrijsVolwassenen, attractiePrijsKinderen, IsKinderAttractie);
		case "5"  : return new Attr_Hawaii              (naamAttractie, minStroomVerbruik, maxStroomVerbruik, attractiePrijsVolwassenen, attractiePrijsKinderen, IsKinderAttractie);
		case "6"  : return new Attr_LadderKlimmen       (naamAttractie, minStroomVerbruik, maxStroomVerbruik, attractiePrijsVolwassenen, attractiePrijsKinderen, IsKinderAttractie);
		default: return null;
		}
	}
	public static Attractie getAttractionByType(String typeNo) {
		switch (typeNo) {
		//                                   "naam attractie"               Stroomverbruik  attractieprijs KinderAttractie 
		//                                                                  min   max       volw    kind
		case "1-1": 
		return new Attr_BotsAuto_Volwassenen("Botsauto's voor volwassenen", 3000, 6000,      2.50d, 2.50d, false);
		case "1-2": 
		      return new Attr_BotsAuto_Kinderen("Botsauto's voor kinderen", 1500, 2000,      1.25d, 1.25d, true);
		case "2"  : 
											   return new Attr_Spin("Spin", 2000, 4000,      2.25d, 2.25d, false);
		case "3"  : 
		                     return new Attr_Spiegelpaleis("Spiegelpaleis",  500, 1000,      2.75d, 2.75d, false);
		case "4"  : 
		                             return new Attr_Spookhuis("Spookhuis", 1500, 3000,      3.20d, 3.20d, false);
		case "5"  : 
		                                   return new Attr_Hawaii("Hawaii", 4000, 6000,      2.90d, 2.90d, false);
		case "6"  : 
		                    return new Attr_LadderKlimmen("Ladder klimmen",  100,  500,      5.00d, 5.00d, false);
		default: return null;
		}
	}
	
	
	
	//////////private methods
	private static Map<String, String> getAttractionsSortByKey() {
		Map <String, String> keys = new TreeMap<String, String>(hMKermisAttractieTypes);
		return keys;		
	}
}
