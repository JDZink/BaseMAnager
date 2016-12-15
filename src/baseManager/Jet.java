package baseManager;

public class Jet {
	String name, model, assignedPilot;
	double speedMPH, speedMACH, price, range;

	public Jet(String name, String model, String assignedPilot, double speedMPH, double price, double range) {
		super();
		this.name = name;
		this.model = model;
		this.assignedPilot = assignedPilot;
		this.speedMPH = speedMPH;
		this.speedMACH = speedMPH / 761.21;
		this.price = price;
		this.range = range;
	}

	public Jet(String name, String model, String assignedPilot, String speedMPH, String speedMACH, String price, String range) {
		this(name, model, assignedPilot, speedMPH, price, range);

	}

	public Jet(String name, String model, String assignedPilot, String speedMPH, String price, String range) {
		super();
//		try {
			this.name = name;
			this.model = model;
			this.assignedPilot = assignedPilot;
			this.speedMPH = Double.parseDouble(speedMPH);
			this.speedMACH = Double.parseDouble(speedMPH) / 761.21;
			this.price = Double.parseDouble(price);
			this.range = Integer.parseInt(range);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage() + "\n Could not create Jet.");
//
//		}
	}


	public Jet(String[] jet) {
//		try {
			this.name = jet[0];
			this.model = jet[1];
			this.assignedPilot = jet[2];
			this.speedMPH = Double.parseDouble(jet[3]);
			this.speedMACH = Double.parseDouble(jet[3]) / 761.21;
			this.price = Double.parseDouble(jet[4]);
			this.range = Integer.parseInt(jet[5]);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage() + "\n Could not create Jet.");
//		} catch (NullPointerException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage() + "\n Could not create Jet.");
//		}
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAssignedPilot() {
		return assignedPilot;
	}

	public void setAssignedPilot(String assignedPilot) {
		this.assignedPilot = assignedPilot;
	}

	public double getSpeedMPH() {
		return speedMPH;
	}

	public void setSpeedMPH(double speedMPH) {
		this.speedMPH = speedMPH;
	}

	public double getSpeedMACH() {
		return speedMACH;
	}

	public void setSpeedMACH(double speedMACH) {
		this.speedMACH = speedMACH;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public void fly() {

	}

	public void wreck() {

	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder("");
		try {
			builder.append("Jet Name: ");
			builder.append(String.format("%s", name));
			builder.append("\t\tJet Model: ");
			builder.append(model);
			builder.append("\t\tSpeedMPH: ");
			builder.append(speedMPH);
			builder.append("\t\tSpeed MACH: ");
			builder.append(String.format("%.4f", speedMACH));
			builder.append("\nPrice: ");
			builder.append(String.format("%.2f", price));
			builder.append("\t\tRange: ");
			builder.append(range);
			builder.append("\t\tAssigned Pilot: ");
			builder.append(String.format("%s \n", assignedPilot));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return builder.toString();
	}

}
