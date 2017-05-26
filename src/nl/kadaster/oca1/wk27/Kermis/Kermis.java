package nl.kadaster.oca1.wk27.Kermis;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import ProjectFacilitair.Utils;

public class Kermis {
	private String kermisNaam = "";
	private HashMap<String, Attractie>  hMKermisAttracties = new HashMap<String, Attractie>();
	private AdministratieBoekhouder administratieBoekhouder = new AdministratieBoekhouder();

	public Kermis(String kermisNaam) {
		this.kermisNaam = kermisNaam;
		KermisConfiguration.setConfiguration(true);
	}
	
	public String getKermisNaam() {
		return this.kermisNaam;
	}
	
	public AdministratieBoekhouder getAdministratieBoekhouder() {
		return administratieBoekhouder;
	}

//	public void setAdministratieBoekhouder(AdministratieBoekhouder administratieBoekhouder) {
//		this.administratieBoekhouder = administratieBoekhouder;
//	}

	public boolean clearAttractions() {
//		for (int i=0; i<hMapAttracties.size() ; i++) {
//			hMKermisAttracties.remove(0);
//		}
		hMKermisAttracties.clear();
		return (hMKermisAttracties.size()==0);
	}

	public int getAantalKermisAttracties() {
		return hMKermisAttracties.size();
	}
	public String addAttraction(String attractieType, Attractie attractie) {
		hMKermisAttracties.put(attractieType, attractie);
		return attractieType;
	}
	public Attractie getAttraction(String attractieType) {
		return hMKermisAttracties.get(attractieType);
	}
//	public String getAttactieNaam(int attractieNr) {
//		return hMapAttracties.get(attractieNr);
//	}


	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		if (hMKermisAttracties.size()!=0) {
			str.append("Deze kermis bestaat uit onderstaande attracties;" + System.getProperty("line.separator"));
			Map <String, Attractie> keys = new TreeMap<String, Attractie>(hMKermisAttracties);

			str.append(Utils.fixedString(80, '=') + System.getProperty("line.separator"));
			
			for (Map.Entry<String, Attractie> map : keys.entrySet()) {
				str.append("*** Attractiekeuze: " + map.getKey() + " (" + map.getValue().attractieNaam + ")\n" + map.getValue());	
			}
			str.append(Utils.fixedString(80, '=') + System.getProperty("line.separator"));
			str.append(System.getProperty("line.separator"));
		}

		str.append(KermisConfiguration.getAttractionByType()).toString();
		str.append(System.getProperty("line.separator"));
		str.append(Utils.fixedString(80, '=') + System.getProperty("line.separator"));
//		str.append(getAdministratieBoekhouder().toString());
//		str.append(System.getProperty("line.separator"));

		//tijdelijke println tijdens debuggen, niet vergeten uit te zetten
		//System.out.println(str.toString());
		return str.toString();
	}
	public String toString(char cReportType) {
		StringBuilder str = new StringBuilder();
		if (hMKermisAttracties.size()!=0) {
			str.append("Deze kermis bestaat uit onderstaande attracties;" + System.getProperty("line.separator"));
			if (cReportType=='o') str.append("(Rapportage: Omzet);");
			if (cReportType=='v') str.append("(Rapportage: Electriciteitsverbruik);");
			if (cReportType=='k') str.append("(Rapportage: Kaartverkoop);");
			str.append(System.getProperty("line.separator"));
			Map <String, Attractie> keys = new TreeMap<String, Attractie>(hMKermisAttracties);
			
			/*Header:*/ {
				str.append(Utils.fixedString(80, '=') + System.getProperty("line.separator"));
				if (cReportType=='o') str.append(Utils.leftpad("Prijs    ", 1+4+30+8+8));
				if (cReportType=='k') str.append(Utils.leftpad("", 1+4+30));
				if (cReportType=='o' || cReportType=='k') str.append(Utils.leftpad("Aantal  ", 6+6));
				if (cReportType=='o') str.append(Utils.leftpad("Omzet   " + System.getProperty("line.separator"), 8+8));
				if (cReportType=='k') str.append(Utils.leftpad("Totaal Kaartverkoop" + System.getProperty("line.separator"), 8+8+6+13));
				if (cReportType=='v') str.append(Utils.leftpad("Stroomverbruik    ", 1+4+30+8+8+8));
				if (cReportType=='v') str.append(Utils.leftpad("Bezoekersaantallen" + System.getProperty("line.separator"), 23));

				/*subHeader:*/ {
					str.append(Utils.rightpad("", 1));
					str.append(Utils.rightpad("Nr", 4));
					str.append(Utils.rightpad("Attractienaam", 30));
					switch (cReportType) {
					case 'o': 
						str.append(Utils.leftpad("Kind", 8));
						str.append(Utils.leftpad("Volw", 8));
						str.append(Utils.leftpad("Kind", 6));
						str.append(Utils.leftpad("Volw", 6));
						str.append(Utils.leftpad("Kind", 8));
						str.append(Utils.leftpad("Volw", 8));
						break;
					case 'v': {
						str.append(Utils.rightpad("  min", 8));
						str.append(Utils.rightpad("  max", 8));
						str.append(Utils.rightpad(" huidig", 8, '.'));
						//break; bij keuze 'v' mogen ook onderstaande headers getoond worden.
					}
					case 'k': {
						str.append(Utils.leftpad("Kind", ((cReportType=='v')? 6: 6)));
						str.append(Utils.leftpad("Volw", ((cReportType=='v')? 5: 6)));
						str.append(Utils.leftpad("Kind+Volw", ((cReportType=='v')? 10: 16+13)));
						break;
					}
					}
				}

				str.append("" + System.getProperty("line.separator"));
				str.append(Utils.fixedString(80, '.') + System.getProperty("line.separator"));
			}
			for (Map.Entry<String, Attractie> map : keys.entrySet()) {
				str.append(Utils.rightpad("", 1));
				str.append(Utils.rightpad(map.getKey(), 4));
				str.append(Utils.rightpad(map.getValue().attractieNaam, 30));
				switch (cReportType) {
				case 'o': {
//					str.append(Utils.leftpad(map.getValue().attractieKassa.getAttractiePrijsKinderen().toString(), 8));
//					str.append(Utils.leftpad(map.getValue().attractieKassa.getAttractiePrijsVolwassenen().toString(), 8));
					str.append(" € " + Utils.leftpad(map.getValue().getAttractiePrijsKinderen().toString(), 5));
					str.append(" € " + Utils.leftpad(map.getValue().getAttractiePrijsVolwassenen().toString(), 5));
					str.append(Utils.leftpad("" + map.getValue().getKaartVerkoopKinderen(), 6));
					str.append(Utils.leftpad("" + map.getValue().getKaartVerkoopVolwassenen(), 6));
					str.append("  € " + Utils.leftpad(map.getValue().getOmzetKinderen().toString(), 5));
					str.append(" € " + Utils.leftpad(map.getValue().getOmzetVolwassenen().toString(), 5));
					break;
				}
				case 'v': {
					str.append(Utils.leftpad(map.getValue().getMinStroomVerbruikAttractie(), 8));
					str.append(Utils.leftpad(map.getValue().getMaxStroomVerbruikAttractie(), 8));
					str.append(Utils.leftpad(map.getValue().getHuidigStroomVerbruikAttractie(), 8));
					//break; bij keuze 'v' mogen ook onderstaande headers getoond worden.
				}
				case 'k': {
					str.append(Utils.leftpad("" + map.getValue().getKaartVerkoopKinderen(), ((cReportType=='v')? 6: 6)));
					str.append(Utils.leftpad("" + map.getValue().getKaartVerkoopVolwassenen(), ((cReportType=='v')? 5: 6)));
					str.append(Utils.leftpad("" + (map.getValue().getKaartVerkoopKinderen() 
							+ map.getValue().getKaartVerkoopVolwassenen()), ((cReportType=='v')? 10: 12+13)));
					break;
				}
				default: break;
				}
				str.append("" + System.getProperty("line.separator"));
			}
//			str.append(System.getProperty("line.separator"));
			str.append(Utils.fixedString(80, '=') + System.getProperty("line.separator"));
		}

//		str.append(KermisConfiguration.getAttractionByType()).toString();
//		str.append(System.getProperty("line.separator"));
		if ("ovk".indexOf(cReportType)>=0) {
			str.append(System.getProperty("line.separator"));
			str.append(getAdministratieBoekhouder().toString());
			str.append(System.getProperty("line.separator"));
			str.append(Utils.fixedString(80, '=') + System.getProperty("line.separator"));
		}
		
		//tijdelijke println tijdens debuggen, niet vergeten uit te zetten
		//System.out.println(str.toString());
		return str.toString();
	}
}
