package baseManager;

import java.util.Scanner;

public class BaseManager implements Menu {
	String choice;
	static BaseManager bm = new BaseManager();
	Wing wing1;
	static InitialData id = new InitialData();

	
	public static void main(String[] args) {
		 bm.wing1 = new Wing(2, 2);
		 bm.wing1.rosters[0] = new Roster(15, id.PILOTS);
		 bm.wing1.hangers[0] = new Hanger(15, id.JETS, bm.wing1);
		 
		String[] menuChoices = {"Base Management Menu", "List Fleet", "View Fastest Jet",
				"View Jet With Longest Range", "Add Jet", "Remove Jet", "List Pilots", "Hire Pilot", "Assign Pilot", "Quit"};
		
		while (true) {
			bm.listMenu(menuChoices, 8);
			bm.choice = bm.getSelection();
			System.out.println(bm.choice);
			bm.executeSelection(bm.choice);
		}
	}

	@Override
	public String getSelection() {
		String input = new String();
		Scanner kb = new Scanner(System.in);
		input = kb.nextLine();
		return input;
	}

	@Override
	public void makeSelection(String Choice) {

	}

	@Override
	public void executeSelection(String choice) {
		try {
			switch (Integer.parseInt(choice)) {
			case 1:
				// list fleet
				bm.listFleet(wing1);
				break;
			case 2:
				// view fastest jet
				System.out.println(bm.wing1.hangers[0].findFastest().toString());
				break;
			case 3:
				// View jet with longest range
				System.out.println(bm.wing1.hangers[0].findLongestRange().toString());
				break;
			case 4:
				bm.wing1.hangers[0].buildNewJet();
				// add new jet
				break;
			case 5:
				// Remove a jet jet
				bm.wing1.hangers[0].removeJet();
				break;
			case 6:
				//List Pilots
				bm.listPilots(wing1);
				break;
			case 7:
				//assign a pilot
				bm.wing1.rosters[0].addPilot();
				break;
			case 8:
				//assign a pilot
				bm.wing1.assignPilot();
				break;
			case 9:
				System.exit(0);
			default:
				System.out.println("Please make a valid selection.");

			}
		} catch (NumberFormatException e) {
			System.out.println("Please make a valid selection.");
		}
	}

	public void listPilots(Wing wing) {
		System.out.println("\n The current pilots for your Wing are: \n");
		System.out.println(wing.toString("pilots"));
	}
	
	public void listFleet(Wing wing) {
			System.out.println("\n The current fleet for your Wing is: \n");
			System.out.println(wing.toString("jets"));
	}
	

	@Override
	public String[] createMenu(String... args) {
		String[] option = args;
		return option;
	}

	// @Override
	// public String[] CreateMenu() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
