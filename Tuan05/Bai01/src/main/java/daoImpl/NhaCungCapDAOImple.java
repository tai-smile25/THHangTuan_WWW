package daoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.NhaCungCapDAO;
import models.NhaCungCap;

public class NhaCungCapDAOImple implements NhaCungCapDAO {
	private DataSource dataSource;
	
	public NhaCungCapDAOImple(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<NhaCungCap> findAll() {
	    String sql = "SELECT * FROM nhacungcap";
	    List<NhaCungCap> list = new ArrayList<>();

	    try (Connection con = this.dataSource.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            int maNCC = rs.getInt("maNCC"); 
	            
	            list.add(new NhaCungCap(maNCC));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}

}
