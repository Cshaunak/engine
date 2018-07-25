package CallCenter.bin;


public class Customer {
	private int cid;
	private String cname;
	private String cemail;
	private String dob;
	private long cphone;
	
public Customer()
	{
	    }
	public Customer(int cid,String cname,String cemail,String dob,long cphone){
		this.cid=cid;
		this.cname=cname;
		this.cemail=cemail;
		this.dob=dob;
	this.cphone=cphone;
		
		
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public  String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getCphone() {
		return cphone;
	}
	public void setCphone(long cphone) {
		this.cphone = cphone;
	}

}
