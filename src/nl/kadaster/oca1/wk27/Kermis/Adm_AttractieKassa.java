package nl.kadaster.oca1.wk27.Kermis;

import java.math.BigDecimal;

import ProjectFacilitair.Utils;

public class Adm_AttractieKassa {
	private BigDecimal attractiePrijsVolwassenen = BigDecimal.valueOf(0);
	private BigDecimal attractiePrijsKinderen = BigDecimal.valueOf(0);

	private int verkochtAantalKaartenVolwassenen = 0;
	private int verkochtAantalKaartenKinderen = 0;
	
	private BigDecimal omzetVolwassenen = BigDecimal.valueOf(0);
	private BigDecimal omzetKinderen = BigDecimal.valueOf(0);
	
	public void setAttractiePrijsVolwassenen(double prijs) {
		attractiePrijsVolwassenen = new BigDecimal(prijs);
	}
	public BigDecimal getAttractiePrijsVolwassenen() {
		return attractiePrijsVolwassenen.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public void setAttractiePrijsKinderen(double prijs) {
		attractiePrijsKinderen = new BigDecimal(prijs);
	}
	public BigDecimal getAttractiePrijsKinderen() {
		return attractiePrijsKinderen.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal kaartVerkoopVolwassenen(int aantal) {
		return kaartVerkoop(aantal, false);
	}
	public BigDecimal kaartVerkoopKinderen(int aantal) {
		return kaartVerkoop(aantal, true);
	}
	private BigDecimal kaartVerkoop(int aantal, boolean blnKinderKaartjes) {
		BigDecimal bd = new BigDecimal(0);
		if (aantal<=0) return BigDecimal.valueOf(0);
		
		if (!blnKinderKaartjes) {
			verkochtAantalKaartenVolwassenen += aantal;
			bd = new BigDecimal(aantal).multiply(attractiePrijsVolwassenen);
			//bd = new BigDecimal(verkochtAantalKaartenVolwassenen).multiply(attractiePrijsVolwassenen);
		} else {
			verkochtAantalKaartenKinderen += aantal;
			bd = new BigDecimal(aantal).multiply(attractiePrijsKinderen);
			//bd = new BigDecimal(verkochtAantalKaartenKinderen).multiply(attractiePrijsKinderen);
		}
		
//		Utils.debugPrintln(Utils.fixedString(80, '.'));
		Utils.debugPrint(Utils.rightpad("Omzet vóór deze kaartverkoop (" + ((!blnKinderKaartjes)?"volwassenen":"kinderen") + " á € " + ((!blnKinderKaartjes)?getAttractiePrijsVolwassenen():getAttractiePrijsKinderen()) + "):", 70));
		Utils.debugPrintln(Utils.leftpad(" € " + ((!blnKinderKaartjes)?getOmzetVolwassenen():getOmzetKinderen()), 10));
		Utils.debugPrint(Utils.rightpad("Aantal verkochte kaartjes (" + ((!blnKinderKaartjes)?"volwassenen":"kinderen") + ") : ", 70)); 
		Utils.debugPrintln(Utils.leftpad("" + aantal, 10)); 
		Utils.debugPrint(Utils.rightpad("Omzet voor deze kaartjes (" + ((!blnKinderKaartjes)?"volwassenen":"kinderen") + " á € " + ((!blnKinderKaartjes)?getAttractiePrijsVolwassenen():getAttractiePrijsKinderen()) + "):", 70));
		Utils.debugPrintln(Utils.leftpad("€ " + bd.setScale(2, BigDecimal.ROUND_HALF_UP), 10));
//		Utils.debugPrintln("");

		if (!blnKinderKaartjes) {
			omzetVolwassenen = omzetVolwassenen.add(bd);
//			verkochtAantalKaartenVolwassenen += aantal;
		} else {
			omzetKinderen = omzetKinderen.add(bd);
//			verkochtAantalKaartenKinderen += aantal;
		}
		
		Utils.debugPrint(Utils.rightpad("Omzet na deze kaartverkoop (" + ((!blnKinderKaartjes)?"volwassenen":"kinderen") + " á € " + ((!blnKinderKaartjes)?getAttractiePrijsVolwassenen():getAttractiePrijsKinderen()) + "): ", 70));
		Utils.debugPrintln(Utils.leftpad("€ " + ((!blnKinderKaartjes)?getOmzetVolwassenen():getOmzetKinderen()), 10));
		Utils.debugPrintln(Utils.fixedString(80, '='));
		
//		return new BigDecimal(aantal).multiply(((blnKinderKaartjes)?AttractiePrijsVolwassenen:AttractiePrijsKinderen));
		return bd;		
	}

	public BigDecimal getOmzetVolwassenen() {
		return omzetVolwassenen.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public BigDecimal getOmzetKinderen() {
		return omzetKinderen.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public int getKaartVerkoopVolwassenen() {
		return verkochtAantalKaartenVolwassenen;
	}
	public int getKaartVerkoopKinderen() {
		return verkochtAantalKaartenKinderen;
	}

	public BigDecimal getTotaalOmzet() {
		BigDecimal tot = new BigDecimal(0);
		tot = tot.add(omzetVolwassenen);
		tot = tot.add(omzetKinderen);
		return tot.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public int getTotaalKaartVerkoop() {
		return verkochtAantalKaartenVolwassenen + verkochtAantalKaartenKinderen;
	}
	public int getTotaalKaartVerkoopVolwassenen() {
		return verkochtAantalKaartenVolwassenen;
	}
	public int getTotaalKaartVerkoopKinderen() {
		return verkochtAantalKaartenKinderen;
	}
}
