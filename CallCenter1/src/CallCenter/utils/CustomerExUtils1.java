package CallCenter.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CallCenter.bin.Customer;
import CallCenter.bin.Enquiry;

public class CustomerExUtils1 {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public boolean registercustomer(Customer customer) {
		boolean inserted = false;
		try {
			conn = DButils.getConnection("call_center");

			String sql = "insert into customer (cname,cemail,cdob,cphone) values(?,?,?,?)";
			pst = DButils.getPreparedStatement(sql);

			pst.setString(1, customer.getCname());
			pst.setString(2, customer.getCemail());
			pst.setString(3, customer.getDob());
			pst.setLong(4, customer.getCphone());

			int r = pst.executeUpdate();

			if (r > 0) {
				inserted = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DButils.closeResources();
		return inserted;
	}

	public boolean addenquiry(Enquiry enquiry) {
		boolean inserted = false;

		try {
			conn = DButils.getConnection("call_center");

			String sql = "insert into enquiry (cid,kid,edescription,esolution,estate) values(?,?,?,?,?)";
			pst = DButils.getPreparedStatement(sql);

			pst.setInt(1, enquiry.getCustomer().getCid());
			pst.setInt(2, enquiry.getKeyword().getKid());
			pst.setString(3, enquiry.getEdesc());
			pst.setString(4, enquiry.getEsolution());
			pst.setString(5, enquiry.getEstatus());

			int r = pst.executeUpdate();

			if (r > 0) {
				inserted = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DButils.closeResources();
		return inserted;
	}
	public boolean changenquirystatus(Enquiry enquiry) {
		boolean inserted = false;
		try {
			conn = DButils.getConnection("call_center");
			String sql = "update enquiry set estatus=? where eid=?";
			pst = DButils.getPreparedStatement(sql);
			pst.setString(1, enquiry.getEstatus());

			rs = pst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DButils.closeResources();
		return inserted;
	}

	public boolean updatecustomer(Customer customer) throws SQLException {
		boolean inserted = false;

		conn = DButils.getConnection("call_center");
		String sql = "update customer set cname=?,cemail=?,cdob=?,cphone=? where cid=? ";
		pst = DButils.getPreparedStatement(sql);

		pst.setString(1, customer.getCname());
		pst.setString(2, customer.getCemail());
		pst.setString(3, customer.getDob());
		pst.setLong(4, customer.getCphone());
		pst.setInt(5, customer.getCid());

		int rs = pst.executeUpdate();

		if (rs > 0) {
			inserted = true;
		}
		return inserted;

	}
	public boolean updateEnquiry(Enquiry enquiry) throws SQLException {
		boolean inserted = false;

		conn = DButils.getConnection("call_center");
		String sql = "update enquiry set estate=? where eid=? ";
		pst = DButils.getPreparedStatement(sql);

		pst.setString(1, enquiry.getEstatus());
		pst.setInt(2, enquiry.getEid());

		int rs = pst.executeUpdate();

		if (rs > 0) {
			inserted = true;
		}
		return inserted;


}

	
} 