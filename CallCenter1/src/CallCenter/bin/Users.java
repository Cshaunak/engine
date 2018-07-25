package CallCenter.bin;


public class Users {
private int uid;
private String uname;
private String uemail;
private String upassword;
private String urole;
private String udob;
public Users(int uid, String uname, String uemail, String upassword, String urole, String udob) {
	super();
	this.uid = uid;
	this.uname = uname;
	this.uemail = uemail;
	this.upassword = upassword;
	this.urole = urole;
	this.udob = udob;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUemail() {
	return uemail;
}
public void setUemail(String uemail) {
	this.uemail = uemail;
}
public String getUpassword() {
	return upassword;
}
public void setUpassword(String upassword) {
	this.upassword = upassword;
}
public String getUrole() {
	return urole;
}
public void setUrole(String urole) {
	this.urole = urole;
}
public String getUdob() {
	return udob;
}
public void setUdob(String udob) {
	this.udob = udob;
}


}