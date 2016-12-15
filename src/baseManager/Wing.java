package baseManager;

import java.util.Arrays;
import java.util.Scanner;

public class Wing {
	Scanner kb = new Scanner(System.in);
	int maxRosters, maxHangers;
	Hanger[] hangers;
	Roster[] rosters;

	public Wing(int maxRosters, int maxHangers, Hanger[] hangers, Roster[] rosters) {
		super();
		this.maxRosters = maxRosters;
		this.maxHangers = maxHangers;
		this.hangers = hangers;
		this.rosters = rosters;
	}

	public Wing(int maxRosters, int maxHangers) {
		this.maxRosters = maxRosters;
		this.maxHangers = maxHangers;
		this.hangers = new Hanger[maxHangers];
		this.rosters = new Roster[maxRosters];
	}

	public void assignPilot() {
		System.out.print(
				"Please Tell me the name of the pilot you would like to assign, and the Jet you want to assign them to.\nPilot Name: ");
		String pilot = kb.nextLine();
		System.out.println("Jet Name: ");
		String jet = kb.nextLine();
		assignPilot(jet, pilot);

	}

	public void assignPilot(String jetName, String pilot) {
		int hangerIndex = -1;
		int jetIndex = -1;
		int rosterIndex = -1;
		int pilotIndex = -1;
		for (int h = 0; h < this.hangers.length; h++) {
			if (this.hangers[h] != null) {
				for (int i = 0; i < this.hangers[h].jetsInHanger.length; i++) {
					if (this.hangers[h].jetsInHanger[i] != null
							&& this.hangers[h].jetsInHanger[i].name.toLowerCase().equals(jetName.toLowerCase())) {
						jetIndex = i;
						hangerIndex = h;
					}
				}
			}
		}
		for (int p = 0; p < rosters.length; p++) {
			if (this.rosters[p] != null) {
				for (int i = 0; i < rosters[p].maxPilots; i++) {
					if (rosters[p].pilots[i] != null
							&& rosters[p].pilots[i].name.toLowerCase().equals(pilot.toLowerCase())) {
						pilotIndex = i;
						rosterIndex = p;
					}
				}
			}
		}
		if (hangerIndex > -1 && rosterIndex > -1) {
			hangers[hangerIndex].jetsInHanger[jetIndex].assignedPilot = rosters[rosterIndex].pilots[pilotIndex].name;
			rosters[rosterIndex].pilots[pilotIndex].jetAssigned = hangers[hangerIndex].jetsInHanger[jetIndex].name;

		}
	}

	public int getMaxRosters() {
		return maxRosters;
	}

	public void setMaxRosters(int maxRosters) {
		this.maxRosters = maxRosters;
	}

	public int getMaxHangers() {
		return maxHangers;
	}

	public void setMaxHangers(int maxHangers) {
		this.maxHangers = maxHangers;
	}

	public Hanger[] getHangers() {
		return hangers;
	}

	public void setHangers(Hanger[] hangers) {
		this.hangers = hangers;
	}

	public Roster[] getRosters() {
		return rosters;
	}

	public void setRosters(Roster[] rosters) {
		this.rosters = rosters;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Wing [kb=");
		builder.append(kb);
		builder.append(", maxRosters=");
		builder.append(maxRosters);
		builder.append(", maxHangers=");
		builder.append(maxHangers);
		builder.append(", hangers=");
		builder.append(Arrays.toString(hangers));
		builder.append(", rosters=");
		builder.append(Arrays.toString(rosters));
		builder.append("]");
		return builder.toString();
	}

	public String toString(String pilotsOrJets) {
		StringBuilder builder = new StringBuilder();
		if (pilotsOrJets.toLowerCase().equals("jets")) {
			builder.append("Wing Hangers ");
			builder.append(Arrays.toString(hangers));
		} else if (pilotsOrJets.toLowerCase().equals("pilots")) {
			builder.append("Wing Rosters ");
			builder.append(Arrays.toString(rosters));
		} else
			builder.append("Please select either \"pilots\" or \"jets\".");
		return builder.toString();
	}

	// = new Pilot[maxPilot];
	// = new Hanger[maxHangers];

}
