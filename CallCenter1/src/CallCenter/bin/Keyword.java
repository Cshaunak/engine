package CallCenter.bin;

public class Keyword {
 
	private int kid;
	private String kname;
	private String kdescription;
	
	public Keyword(){}
	
	public Keyword(int kid, String kname, String kdescription) {
		super();
		this.kid = kid;
		this.kname = kname;
		this.kdescription = kdescription;
	}

	public int getKid() {
		return kid;
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	public String getKdescription() {
		return kdescription;
	}

	public void setKdescription(String kdescription) {
		this.kdescription = kdescription;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}
	
}
