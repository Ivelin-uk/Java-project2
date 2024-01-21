package DB;

import MODELS.Client;
import MODELS.Employ;

import java.sql.*;
import java.util.ArrayList;

public class RepositoryEmploy extends Repository{
    public RepositoryEmploy()  throws Exception{
        super();
    }
    public ArrayList<Employ> getEmploiesOnCompany(String company_id) throws Exception {
        ArrayList<Employ> companyClients = new ArrayList<Employ>();

        String sql = "SELECT * FROM employees WHERE company_id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, company_id);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            String employ_id = rs.getString("id");
            String name = rs.getString("name");
            String db_company_id = rs.getString("company_id");
            Employ companyEmploy = new Employ(employ_id, name,db_company_id);
            companyClients.add(companyEmploy);
        }

        return companyClients;
    }

    public ArrayList<Employ> getAllEmploys() throws Exception {
        ArrayList<Employ> companyClients = new ArrayList<Employ>();

        String sql = "SELECT * FROM employees";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            String employ_id = rs.getString("id");
            String name = rs.getString("name");
            String db_company_id = rs.getString("company_id");
            Employ companyEmploy = new Employ(employ_id, name,db_company_id);
            companyClients.add(companyEmploy);
        }

        return companyClients;
    }


    public boolean insertEmploy(Employ employ) throws Exception
    {
        String sql = "INSERT INTO employees (name, company_id) VALUES (?, ?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, employ.getName());
        pstmt.setString(2, employ.getCompany_id());

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteEmploy(String employ_id) throws Exception
    {
        String sql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, employ_id);

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean updateEmploy(Employ employ) throws Exception
    {
        String sql = "UPDATE employees SET name = ? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, employ.getName());
        pstmt.setString(3, employ.getId());

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
}
