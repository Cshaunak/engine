package CallCenter.utils;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CallCenter.bin.Customer;
import CallCenter.bin.Enquiry;
import CallCenter.bin.Keyword;
import CallCenter.bin.Users;

public class CustomerAdminUtils {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public boolean addExecutive(Users users) {
		boolean inserted = false;

		try {
			conn = DButils.getConnection("call_center");

			String sql = "insert into users (uname,uemail,upassword,urole,udob) values(?,?,?,?,?)";
			pst = DButils.getPreparedStatement(sql);

			pst.setString(1, users.getUname());
			pst.setString(2, users.getUemail());
			pst.setString(3, users.getUpassword());
			pst.setString(4, users.getUrole());
			pst.setString(5, users.getUdob());

			int rs = pst.executeUpdate();

			if (rs > 0) {
				inserted = true;
			}

			DButils.closeResources();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return inserted;
	}

	public boolean addKeyword(Keyword keys) {
		boolean inserted = false;

		try {
			conn = DButils.getConnection("call_center");

			String sql = "insert into keywords (kname, kdescripstion) values(?,?)";
			pst = DButils.getPreparedStatement(sql);

			pst.setString(1, keys.getKname());
			pst.setString(2, keys.getKdescription());

			int rs = pst.executeUpdate();

			if (rs > 0) {
				inserted = true;
			}

			DButils.closeResources();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inserted;
	}

	public List<Enquiry> getallenquiry() {
		List<Enquiry> enqList = new ArrayList<Enquiry>();

		conn = DButils.getConnection("call_center");

		String sql = "select e.eid,e.edescription,e.esolution,e.estate,e.cid,e.kid,c.cname,c.cemail,"
				+ "c.cdob,c.cphone,k.kname,k.kdescripstion from enquiry e,customer c,keywords k WHERE e.cid=c.cid "
				+ " AND e.kid=k.kid  AND estate='pending'" ;

		stmt = DButils.getSimpleStatement();
		Enquiry er = null;
		try {
			rs = stmt.executeQuery(sql);

			

			if (rs != null) {
				while (rs.next()) {
					er = new Enquiry(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), null, null);
					Customer cust = new Customer();
					cust.setCid(rs.getInt(5));
					Keyword key = new Keyword();
					key.setKid(rs.getInt(6));
					er.setCustomer(cust);
					er.setKeyword(key);

					enqList.add(er);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DButils.closeResources();

		return enqList;
	}

	public boolean solvenquiry(Enquiry enquiry) {
		boolean inserted = false;
		conn = DButils.getConnection("call_center");

		String sql = "update enquiry set status='solved' ";

		stmt = DButils.getSimpleStatement();
		try {

			rs = pst.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return inserted;
	}
}
