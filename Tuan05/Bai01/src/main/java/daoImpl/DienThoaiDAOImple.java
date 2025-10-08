package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import dao.DienThoaiDAO;
import models.DienThoai;

public class DienThoaiDAOImple implements DienThoaiDAO {
    private DataSource dataSource;

    public DienThoaiDAOImple(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<DienThoai> findAll() {
        String sql = "SELECT * FROM dienThoai";
        List<DienThoai> list = new ArrayList<>();
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int maDT = rs.getInt("maDT");
                String tenDT = rs.getString("tenDT");
                int namSanXuat = rs.getInt("namSanXuat");
                String cauHinh = rs.getString("cauHinh");
                int maNCC = rs.getInt("maNCC");
                String hinhAnh = rs.getString("hinhAnh");

                list.add(new DienThoai(maDT, tenDT, namSanXuat, cauHinh, maNCC, hinhAnh));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public DienThoai getById(int id) {
        String sql = "SELECT * FROM dienThoai WHERE maDT=?";
        DienThoai dt = null;
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String tenDT = rs.getString("tenDT");
                    int namSanXuat = rs.getInt("namSanXuat");
                    String cauHinh = rs.getString("cauHinh");
                    int maNCC = rs.getInt("maNCC");
                    String hinhAnh = rs.getString("hinhAnh");

                    dt = new DienThoai(id, tenDT, namSanXuat, cauHinh, maNCC, hinhAnh);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dt;
    }

    @Override
    public void addDienThoai(DienThoai dt) {
        String sql = "INSERT INTO dienThoai(tenDT, namSanXuat, cauHinh, maNCC, hinhAnh) VALUES(?,?,?,?,?)";
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dt.getTenDT());
            ps.setInt(2, dt.getNamSanXuat());
            ps.setString(3, dt.getCauHinh());
            ps.setInt(4, dt.getMaNCC());
            ps.setString(5, dt.getHinhAnh());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(DienThoai dt) {
        String sql = "DELETE FROM dienThoai WHERE maDT=?";
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dt.getMaDT());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM dienThoai";
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<DienThoai> findByName(String tenDT) {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT * FROM dienthoai WHERE tenDT LIKE ?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, "%" + tenDT + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DienThoai dt = new DienThoai();
                dt.setMaDT(rs.getInt("maDT"));
                dt.setTenDT(rs.getString("tenDT"));
                dt.setNamSanXuat(rs.getInt("namSanXuat"));
                dt.setCauHinh(rs.getString("cauHinh"));
                dt.setMaNCC(rs.getInt("maNCC"));
                dt.setHinhAnh(rs.getString("hinhAnh"));

                list.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
