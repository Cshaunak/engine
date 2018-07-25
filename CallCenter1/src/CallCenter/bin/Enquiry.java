package CallCenter.bin;

public class Enquiry {
	private int eid;
	private String edesc;
	private String esolution;
	private String estatus;
	private Customer customer;
	private Keyword keyword;
	
	public Enquiry(){}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEdesc() {
		return edesc;
	}

	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}

	public String getEsolution() {
		return esolution;
	}

	public void setEsolution(String esolution) {
		this.esolution = esolution;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Keyword getKeyword() {
		return keyword;
	}

	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}

	public Enquiry(int eid, String edesc, String esolution, String estatus, Customer customer, Keyword keyword) {
		super();
		this.eid = eid;
		this.edesc = edesc;
		this.esolution = esolution;
		this.estatus = estatus;
		this.customer = customer;
		this.keyword = keyword;
	}
	
}
