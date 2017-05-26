package nl.kadaster.oca1.wk27.gemeenteApeldoorn;

import ProjectFacilitair.Utils;
import nl.kadaster.oca1.wk27.Kermis.Attr_BotsAuto_Kinderen;
import nl.kadaster.oca1.wk27.Kermis.Attr_BotsAuto_Volwassenen;
import nl.kadaster.oca1.wk27.Kermis.KermisConfiguration;

//import nl.kadaster.oca1.wk27.familie.*;
//import KermisFacilitair.Utils;
//import nl.kadaster.oca1.wk27.Kermis.*;

public class MarktpleinApeldoorn {

	public static void main(String[] args) {
		Utils.blnDebugPrint = false;
		
		Utils.clearConsole();
		Configuration.GUI.printHeader();
		Configuration.setConfiguration(Utils.blnDebugPrint);
		KermisConfiguration.setConfiguration(Utils.blnDebugPrint); 
		Utils.waitSeconds(1);
		
		System.out.println("next to do: overige attracties implementeren zodat deze compileren");
		
		//Kermis keuren
		AKI kermisKeuring = new AKI("Koningsdag kermis op het Apeldoornse marktplein");
		kermisKeuring.keurKermisAttracties();
//		System.out.println(kermisKeuring.toString());
		
		//Kermis opbouwen
//		Attr_BotsAuto_Volwassenen botsV = new Attr_BotsAuto_Volwassenen("Botsauto's voor volwassenen");
//		System.out.println(botsV.toString_stroomVerbruik());
//		Attr_BotsAuto_Kinderen botsK = new Attr_BotsAuto_Kinderen("Botsauto's voor kinderen");
//		System.out.println(botsK.toString_stroomVerbruikAttractie());
		
		
		//Bezoekers toevoegen aan de kermis.
//		Bezoekers b = new Bezoekers();
		
		//Tijdklokje introduceren
		//Deze zorgt voor een loop door de attracties die een willekeurige tijd wachten op bezoekers maar een vaste tijd draaien.
		
		//next is
		
		
		System.out.println("Het kermis programma is beëindigd.");
	}

}
///

///////// Weekopdracht
//2017-05-19 per mail
//{
//Je gaat een programma maken dat de omzet van een Kermis bijhoudt.
//De Kermis heeft een zestal attracties, die zijn allemaal subclasse van een klasse Attractie.
//Zodra het programma start kan er een getal worden ingegeven, 1 voor botsauto's, 2 voor spin, 3 voor spiegelpaleis, 4 voor spookhuis, 5 voor hawaii, 6 voor ladderklimmen.
//botsauto		- 1
//spin			- 2
//spiegelpaleis	- 3
//spookhuis		- 4
//hawaii		- 5
//ladderklimmen	- 6
//
//MAKKELIJK: Zorg dat het bovenstaande stabiel werkt en dat iedere keer dat het getal wordt ingegeven er getoond wordt welke attractie draait.
//	
//MIDDEL: Botsauto's kosten 2.50, Spin 2.25, Spiegelpaleis 2.75, spookhuis 3.20, hawaii 2.90 en ladderklimmen 5.00. Houdt bij hoeveel omzet elke attractie draait, en hoeveel de omzet van de hele attractieafdeling is. 
//Ook willen we weten hoe vaak er kaartjes per attractie zijn gekocht, en natuurlijk voor de attracties in het totaal.
//Met de invoer van de letter "o" zien we de omzet. Met de invoer van de letter "k" zien we het aantal kaartjes.
//Denk na in welke class gegevens opgeslagen moeten worden en maak hiervoor onderscheid tussen het gebruik van instance variabelen en class variabelen. 
//	
//MOEILIJK: Maak een Klasse erbij, te weten Voedselkraampjes, Met de getallen 11 voor oliebollenkraam a 4.00 per consumptie, 22 voor frietkraam a 3.45 per consumptie, 33 voor mueslikraam a 9.00 per consumptie en 44 voor shoarmatent a 5.15 per consumptie.
//11 voor oliebollenkraam 		a 4.00 per consumptie
//22 voor frietkraam 			a 3.45 per consumptie
//33 voor mueslikraam 			a 9.00 per consumptie
//44 voor shoarmatent 			a 5.15 per consumptie.
//
//Zorg dat je de omzet en het aantal aankopen overzichtelijk maakt.
//Gebruik encapsulation voor het aanpassen van de class variabelen.
//	
//Belangrijk: 
//Het is belangrijker dat je een logisch werkend programma maakt, dan dat je een kermis oplevert hoe een kermis hoort te zijn.
//Mocht een uitdaging niet lukken om te realiseren, dan heb je 3 mislukte pogingen gemaild.
//
//De weekopdracht wordt ingeleverd voor Maandag 23 Januari om 9.30 uur bij de beide email-adressen:
//	Cor.Faber@gmail.com
//	JasperHolshuijsen@gmail.com
//
//LET WEL:
//Hetgeen dat je mailt is een link naar je repository !!!
//De code moet op je repository op GitHub staan.
//
//
//}
//
//Weekopdracht 2 - Kermis
//Je gaat een programma maken dat de omzet van een Kermis bijhoudt.
//De Kermis heeft een zestal attracties, die zijn allemaal subclasse van een klasse Attractie.
//Zodra het programma start kan er een getal worden ingegeven, 1 voor botsauto's, 2 voor spin, 3 voor spiegelpaleis, 4 voor spookhuis, 5 voor hawaii, 6 voor ladderklimmen.
//botsauto		- 1
//spin			- 2
//spiegelpaleis	- 3
//spookhuis		- 4
//hawaii		- 5
//ladderklimmen	- 6
//
//MAKKELIJK: Zorg dat het bovenstaande stabiel werkt en dat iedere keer dat het getal wordt ingegeven er getoond wordt welke attractie draait.
//
//MIDDEL: Botsauto's kosten 2.50, Spin 2.25, Spiegelpaleis 2.75, spookhuis 3.20, hawaii 2.90 en ladderklimmen 5.00. Houdt bij hoeveel omzet elke attractie draait, en hoeveel de omzet van de hele attractieafdeling is. 
//Ook willen we weten hoe vaak er kaartjes per attractie zijn gekocht, en natuurlijk voor de attracties in het totaal.
//Met de invoer van de letter "o" zien we de omzet. Met de invoer van de letter "k" zien we het aantal kaartjes.
//Denk na in welke class gegevens opgeslagen moeten worden en maak hiervoor onderscheid tussen het gebruik van instance variabelen en class variabelen. 
//
//MOEILIJK: Maak een Klasse erbij, te weten Voedselkraampjes, Met de getallen 11 voor oliebollenkraam a 4.00 per consumptie, 22 voor frietkraam a 3.45 per consumptie, 33 voor mueslikraam a 9.00 per consumptie en 44 voor shoarmatent a 5.15 per consumptie.
//11 voor oliebollenkraam 		a 4.00 per consumptie
//22 voor frietkraam 			a 3.45 per consumptie
//33 voor mueslikraam 			a 9.00 per consumptie
//44 voor shoarmatent 			a 5.15 per consumptie.
//
//Zorg dat je de omzet en het aantal aankopen overzichtelijk maakt.
//Gebruik encapsulation voor het aanpassen van de class variabelen.
//
//Belangrijk: 
//Het is belangrijker dat je een logisch werkend programma maakt, dan dat je een kermis oplevert hoe een kermis hoort te zijn.
//Mocht een uitdaging niet lukken om te realiseren, dan heb je 3 mislukte pogingen gemaild.
//
//De weekopdracht wordt ingeleverd voor Vrijdag 26 Mei om 9.30 uur bij de beide email-adressen:
//Cor.Faber@gmail.com
//JasperHolshuijsen@gmail.com
//
//LET WEL:
//Hetgeen dat je mailt is een link naar je repository !!!
//De code moet op je repository op GitHub staan.
//
//Je gaat een programma maken dat de omzet van een Kermis bijhoudt.
//De Kermis heeft een zestal attracties, die zijn allemaal subclasse van een klasse Attractie.
//Zodra het programma start kan er een getal worden ingegeven, 1 voor botsauto's, 2 voor spin, 3 voor spiegelpaleis, 4 voor spookhuis, 5 voor hawaii, 6 voor ladderklimmen.
//botsauto		- 1
//spin			- 2
//spiegelpaleis	- 3
//spookhuis		- 4
//hawaii		- 5
//ladderklimmen	- 6
//
//MAKKELIJK: Zorg dat het bovenstaande stabiel werkt en dat iedere keer dat het getal wordt ingegeven er getoond wordt welke attractie draait.
//Er moet overriding in staan!

//MIDDEL: Botsauto's kosten 2.50, Spin 2.25, Spiegelpaleis 2.75, spookhuis 3.20, hawaii 2.90 en ladderklimmen 5.00. Houdt bij hoeveel omzet elke attractie draait, en hoeveel de omzet van de hele attractieafdeling is. 
//Ook willen we weten hoe vaak er kaartjes per attractie zijn gekocht, en natuurlijk voor de attracties in het totaal.
//Met de invoer van de letter "o" zien we de omzet. Met de invoer van de letter "k" zien we het aantal kaartjes.
//Denk na in welke class gegevens opgeslagen moeten worden en maak hiervoor onderscheid tussen het gebruik van instance variabelen en class variabelen. 

//MOEILIJK: Maak een Klasse erbij, te weten Voedselkraampjes, Met de getallen 11 voor oliebollenkraam a 4.00 per consumptie, 22 voor frietkraam a 3.45 per consumptie, 33 voor mueslikraam a 9.00 per consumptie en 44 voor shoarmatent a 5.15 per consumptie.
//Zorg dat je de omzet en het aantal aankopen overzichtelijk maakt.
//Gebruik encapsulation voor het aanpassen van de class variabelen.
//
//&
//
//Verzin  een programma voor week 3
//Gebruikmakend van alle behandelde onderwerpen
//vb Levend stratego, tour de france (random voor etappe uitslagen, ploegen etc)