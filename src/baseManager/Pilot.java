package baseManager;

public class Pilot {
	String name;
	String certifications;
	int rating;
	String jetAssigned = "none";

	public Pilot(String name, String certifications, int rating, String jetAssigned) {
		this(name, certifications, rating);
		this.jetAssigned = jetAssigned;
	}

	public Pilot(String name,String certifications, int rating) {
		super();
		this.name = name;
		this.certifications = certifications;
		this.rating = rating;
	}
	

	public Pilot(String[] pilot) {
		super();
		this.name = pilot[0];
		this.certifications = pilot[1];
		this.rating = Integer.parseInt(pilot[2]);
	}
	
	

	public Pilot(String name) {
		this(name, "none", 0);
		
	}

	public String getJetAssigned() {
		return jetAssigned;
	}

	public void setJetAssigned(String jetAssigned) {
		this.jetAssigned = jetAssigned;
	}

	public String getCertifications() {
		return certifications;
	}

	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}

	public void addCertification(String certification) {
		this.certifications += certification;
	}

	public void removeCertification(String Certification) {

	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pilot Name: ");
		builder.append(name);
		builder.append("   Certifications: ");
		builder.append(certifications);
		builder.append("   Rating: ");
		builder.append(rating);
		builder.append("   JetAssigned: ");
		builder.append(jetAssigned);
		builder.append("\n");
		return builder.toString();
	}
}
