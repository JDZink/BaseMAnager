package baseManager;

import java.util.Arrays;
import java.util.Scanner;

public class Roster {
	Scanner kb = new Scanner(System.in);
	int maxPilots;
	Pilot[] pilots;

	public Roster(int maxPilots, Pilot[] pilots) {
		super();
		this.maxPilots = maxPilots;
		this.pilots = pilots;

	}

	public Roster(int maxPilots) {
		super();
		this.maxPilots = maxPilots;
		this.pilots = new Pilot[maxPilots];

	}

	public Roster(int maxPilots, String[][] pilotRoster) {
		super();
		this.maxPilots = maxPilots;
		this.pilots = new Pilot[maxPilots];
		String[] temp = new String[pilotRoster.length];
		// System.out.println(jets.length);
		for (int i = 0; i < pilotRoster[0].length; i++) {
			for (int j = 0; j < pilotRoster.length; j++) {
				temp[j] = pilotRoster[j][i];
				// System.out.println(temp[j]);
			}
			// for (int k = 0; k < temp.length; k++) {
			// System.out.println("" + temp[k] + " " + k);
			// }
			this.pilots[i] = new Pilot(temp);
		}
	}

	public int getMaxPilots() {
		return maxPilots;
	}

	public void setMaxPilots(int maxPilots) {
		this.maxPilots = maxPilots;
	}

	public Pilot[] getPilots() {
		return pilots;
	}

	public void setPilots(Pilot[] pilots) {
		this.pilots = pilots;
	}
	
	public void addPilot(){
		System.out.println("Please give me the new Pilots information."
				+ "\nPilot Name:");
		String name = kb.nextLine();
		addPilot(new Pilot(name));
			
	}

	public void addPilot(Pilot pilot) {
		for (int i = 0; i < this.pilots.length; i++) {
			if (this.pilots[i] == null) {
				this.pilots[i] = pilot;
				break;
			} else if (i == this.pilots.length - 1) {
				System.out.println("You have no more room on this roster.");
			} else {
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hanger Max Capacity: ");
		builder.append(this.maxPilots);
		builder.append("  Current Pilots: \n");
		for (Pilot i : this.pilots) {
			if (i != null) {
				builder.append(i.toString());
				builder.append("\n");
			}
		}
		return builder.toString();
	}

}

// = new Pilot[10];
