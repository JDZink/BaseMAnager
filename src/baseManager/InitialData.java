package baseManager;

public class InitialData {
	
	String[] pilotNames = {"Abra", "Cadabra", "Ala", "Kazam"}; 
	String[] pilotRatings = {"1", "2", "3", "4"};
	String[] pilotCertifications = {"", "", "", ""};
	String[][]PILOTS = {pilotNames,pilotCertifications, pilotRatings };
	
	String[] jetModels = {"f14", "f16", "f18", "f21"," ffff"};
	String[] jetNames = {"Fox1", "Golf 4", "Tango 9", "88 Mike","Jeffery"};
	String[] assignedPilot = {"Abra", "No pilot Asigned", "No pilot Asigned", "No pilot Asigned", "No pilot Asigned"};
	String[] jetRanges = {"5000", "50","5000", "50", "88000"}; 
	String[] jetPrices = {"5000000", "50","5000", "50", "88000"}; 
	String[] jetMPH = {"1800", "50","5000", "50", "88000"};
	String[][] JETS = {jetNames, jetModels, assignedPilot, jetMPH, jetPrices, jetRanges};

	String[] baseMenu = {"Base Management Menu", "List Fleet", "View Fastest Jet", "View Jet With Longest Range"};

}
