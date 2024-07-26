package com.Whatsapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Whatsapp.entity.WhatsappUser;

public class WhasappDAO implements WhatsappDAOInterface {

	@Override
	public int createProfileDAO(WhatsappUser wu) {
		int i = 0;
		try {
			// 1.load driver
			Class.forName("com.mysql.jdbc.Driver");
			// 2.Create connection with DB
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/happiestmindsdb", "root", "root");
			// 3.query
			// a.static query can be created using Statement
			// b.Dynamic query can be created using PreapredStatement

			PreparedStatement ps = con.prepareStatement("insert into whatsappuser values (?,?,?,?)");

			ps.setString(1, wu.getName());
			ps.setString(2, wu.getPassword());
			ps.setString(3, wu.getEmail());
			ps.setString(4, wu.getAddress());
			// 4. Execute query
			// insert,delete,update we will use excuteUpate()
			// method has return type is integer which is number of rows affected
			// for select query we use ExecuteQuery() method
			// method of return type of result set
			i = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public WhatsappUser viewProfileDAO(WhatsappUser wu) {
		WhatsappUser w1 = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/happiestmindsdb", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from  whatsappuser where email=?");
			ps.setString(1, wu.getEmail());
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				String name = res.getString(1);
				String password = res.getString(2);
				String eamil = res.getString(3);
				String address = res.getString(4);

				w1 = new WhatsappUser();

				w1.setName(name);
				w1.setPassword(password);
				w1.setEmail(eamil);
				w1.setAddress(address);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return w1;
	}

	@Override
	public List<WhatsappUser> viewAllProfileDAO() {
		WhatsappUser w1 = null;

		List<WhatsappUser> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/happiestmindsdb", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from  whatsappuser");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				String name = res.getString(1);
				String password = res.getString(2);
				String eamil = res.getString(3);
				String address = res.getString(4);

				w1 = new WhatsappUser();

				w1.setName(name);
				w1.setPassword(password);
				w1.setEmail(eamil);
				w1.setAddress(address);

				list.add(w1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
