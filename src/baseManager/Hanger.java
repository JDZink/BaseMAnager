package baseManager;

import java.util.Scanner;

public class Hanger {
	int maxJets;
	Jet[] jetsInHanger;
	Scanner kb = new Scanner(System.in);

	public Hanger(int maxJets, Jet[] jets) {
		super();
		this.maxJets = maxJets;
		this.jetsInHanger = jets;
	}
	public Hanger(Jet[] jets) {
		super();
		this.maxJets = jets.length;
		this.jetsInHanger = jets;
	}

	public Hanger(int maxJets, String[][] jets, Wing wing) {
		super();
		this.maxJets = maxJets;
		this.jetsInHanger = new Jet[maxJets];
		String[] temp = new String[jets.length];
		// System.out.println(jets.length);
		String pilotName, jetName;
		for (int i = 0; i < jets[0].length; i++) {
			for (int j = 0; j < jets.length; j++) {
				if (j != 2) {
					temp[j] = jets[j][i];
				} else {
					int maxIndex = 0, index;
					for (int g = 0; g < wing.rosters[0].pilots.length; g++) {
						if (wing.rosters[0].pilots[g] != null) {
							maxIndex = g;
						} else {
							break;
						}
					}
					index = (int) (Math.random() * maxIndex);

					temp[j] = wing.rosters[0].pilots[index].name;
					wing.rosters[0].pilots[index].setJetAssigned(temp[0]);

				}
				// System.out.println(temp[j]);
			}
			this.jetsInHanger[i] = new Jet(temp);
		}
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hanger Max Capacity: ");
		builder.append(this.maxJets);
		builder.append("  Current Jets: \n");
		for (Jet i : this.jetsInHanger) {
			if (i != null) {
				builder.append(i.toString());
				builder.append("\n");
			}
		}
		return builder.toString();
	}

	public Jet findFastest() {
		int index = -1;
		double speed = -1.0;
		for (int i = 0; i < jetsInHanger.length; i++) {
			if (jetsInHanger[i] != null && jetsInHanger[i].getSpeedMACH() > speed) {
				speed = jetsInHanger[i].getSpeedMACH();
				index = i;
			}
		}
		return jetsInHanger[index];
	}

	public Jet findLongestRange() {
		int index = -1;
		double range = -1.0;
		for (int i = 0; i < jetsInHanger.length; i++) {
			if (jetsInHanger[i] != null && jetsInHanger[i].getRange() > range) {
				range = jetsInHanger[i].getRange();
				index = i;
			}
		}
		return jetsInHanger[index];
	}

	public void buildNewJet() {
		String[] newJetData = new String[6];
		Jet newJet;
		System.out.println("Please enter your new Jet Data.");
		// name, model, assignedPilot, speedMPH, price, range
		System.out.print("Name: ");
		newJetData[0] = kb.nextLine();
		System.out.print("\nModel: ");
		newJetData[1] = kb.nextLine();
		System.out.print("\nAssigned Pilot: ");
		newJetData[2] = kb.nextLine();
		System.out.print("\nSpeedMPH: ");
		newJetData[3] = kb.nextLine();
		System.out.print("\nPrice: ");
		newJetData[4] = kb.nextLine();
		System.out.print("\n Range: ");
		newJetData[5] = kb.nextLine();
		newJet = new Jet(newJetData);
		addJet(newJet);

	}

	public int getMaxJets() {
		return maxJets;
	}

	public void setMaxJets(int maxJets) {
		this.maxJets = maxJets;
	}

	public Jet[] getJets() {
		return jetsInHanger;
	}

	public void setJets(Jet[] jets) {
		this.jetsInHanger = jets;
	}

	public void addJet(Jet jet) {
		for (int i = 0; i < this.jetsInHanger.length; i++) {
			if (this.jetsInHanger[i] == null) {
				this.jetsInHanger[i] = jet;
				break;
			} else if (i == this.jetsInHanger.length - 1) {
				System.out.println("You have no more room in this Hanger.");
			} else {
			}
		}
	}

	public void removeJet() {
		System.out.println("What is the NAME of the jet you would like to remove?");
		String jetName = kb.nextLine().toLowerCase();
		removeJet(jetName);

	}

	public void removeJet(String jetName) {
		for (int i = 0; i < this.maxJets; i++) {
			if (this.jetsInHanger[i] != null) {
				if (this.jetsInHanger[i].name.toLowerCase().equals(jetName)) {
					this.jetsInHanger[i] = null;
					for (int l = i; l < this.maxJets; l++) {
						if (this.jetsInHanger[l + 1] != null) {
							this.jetsInHanger[l] = this.jetsInHanger[l + 1];
						} else {
							// out.print("delete duplicate");
							this.jetsInHanger[l] = null;
							break;
						}
					}
					System.out.println(jetName + " has been removed from the hanger.");
				} else if (i == this.maxJets - 1) {
					System.out.println("Could not find that Jet in the Hanger. Please check the name and try again.");
				}
			}
		}
	}
}
