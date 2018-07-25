package CallCenter.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import CallCenter.bin.Customer;
import CallCenter.bin.Enquiry;
import CallCenter.bin.Keyword;
import CallCenter.bin.Users;




public class CommonUtils {
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public Users validateUsers(String uemail, String upassword, String urole){
		Users users = null;
		conn = DButils.getConnection("Call_Center");
		String sql = "select * from users WHERE uemail=? AND upassword=? AND urole=?";
		pst = DButils.getPreparedStatement(sql);
		try{
			
			pst.setString(1, uemail);
			pst.setString(2, upassword);
			pst.setString(3, urole);
			
			
			rs = pst.executeQuery();
			if(rs != null){
				while(rs.next()){
					users = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				}
			}
			
	   	}catch(SQLException e){
			e.printStackTrace();
		}
		DButils.closeResources();
		return users;
	}

	public List<Customer> getAllCustomer(){
		List<Customer> slist = new ArrayList<Customer>();
		String sql = "select * from Customer";
		conn = DButils.getConnection("Call_Center");
		stmt = DButils.getSimpleStatement();
		try{
			Customer st = null;
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					
					st = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5));
				
					
					slist.add(st);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DButils.closeResources();
		
		return slist;
	}
	public List<Enquiry> getAllEnquiry(){
		List<Enquiry> clist = new ArrayList<Enquiry>();
		conn = DButils.getConnection("call_center");
		String sql = "select * from enquiry";
		stmt = DButils.getSimpleStatement();
		Enquiry es = null;
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					es = new Enquiry(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),null,null);
					Customer cust = new Customer();
					cust.setCid(rs.getInt(5));
					Keyword key = new Keyword();
					key.setKid(rs.getInt(6));
					es.setCustomer(cust);
					es.setKeyword(key);
					clist.add(es);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DButils.closeResources();
		
		return clist;
	}
	public Customer getCustomer(int cid){
		Customer cu = null;
		
		String sql = "select c.cid,c.cname,c.cemail,c.cdob,c.cphone from customer c where c.cid="+cid;
		conn = DButils.getConnection("call_center");
		stmt = DButils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					cu = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5));
					
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cu;
	}
	
	public Enquiry getenquiry(int eid){
	Enquiry er = null;
		
		conn = 	DButils.getConnection("call_center");
		String sql = "select e.eid,e.edescription,e.esolution,e.estate,e.cid,e.kid,c.cname,c.cemail,c.cdob,c.cphone,k.kname,k.kdescripstion from enquiry e,customer c,keywords k WHERE e.cid=c.cid  AND e.kid=k.kid  AND e.eid="+eid ;
		stmt = DButils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					er = new Enquiry(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),null,null);
					Customer c = new Customer();
					c.setCid(rs.getInt(5));
				c.setCname(rs.getString(7));
				c.setCemail(rs.getString(8));
				c.setDob(rs.getString(9));
				c.setCphone(rs.getLong(10));
				
					
					Keyword k = new Keyword();

					k.setKid(rs.getInt(6));
					k.setKname(rs.getString(11));
					k.setKdescription(rs.getString(12));
		
				er.setCustomer(c);
					er.setKeyword(k);				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DButils.closeResources();
		
		return er;
	}


}