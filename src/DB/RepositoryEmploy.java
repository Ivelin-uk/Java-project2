package DB;

import MODELS.Client;
import MODELS.Employ;

import java.sql.*;
import java.util.ArrayList;

public class RepositoryEmploy extends Repository{
    public RepositoryEmploy()  throws Exception{
        super();
    }
    public ArrayList<Employ> getEmployeesOnCompany(String company_id) throws Exception {
        ArrayList<Employ> companyClients = new ArrayList<Employ>();

        String sql = "SELECT * FROM employees WHERE company_id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, company_id);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int employ_id = rs.getInt("id");
            String name = rs.getString("name");
            int db_company_id = rs.getInt("company_id");
            String qualification = rs.getString("qualification");
            String more_people = rs.getString("more_people");
            double salary = rs.getDouble("salary");

            Employ companyEmploy = new Employ(employ_id,name, db_company_id,qualification,more_people,salary);
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
            int employ_id = rs.getInt("id");
            String name = rs.getString("name");
            int db_company_id = rs.getInt("company_id");
            String qualification = rs.getString("qualification");
            String more_people = rs.getString("more_people");
            double salary = rs.getDouble("salary");

            Employ companyEmploy = new Employ(employ_id,name, db_company_id,qualification,more_people,salary);
            companyClients.add(companyEmploy);
        }

        return companyClients;
    }

//String name, int company_id, String qualification, String more_people, double salary)
    public boolean insertEmploy(Employ employ) throws Exception
    {
        String sql = "INSERT INTO employees (name, company_id,qualification,more_people,salary) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, employ.getName());
        pstmt.setInt(2, employ.getCompany_id());
        pstmt.setString(3, employ.getQualification());
        pstmt.setString(4, employ.getMore_people());
        pstmt.setDouble(5, employ.getSalary());


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
        String sql = "UPDATE employees " +
                "SET name ?,  " +
                    "company_id = ?," +
                    "qualification = ?," +
                    "more_people = ?," +
                    "salary = ? " +
                "WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, employ.getName());
        pstmt.setInt(2, employ.getCompany_id());
        pstmt.setString(3, employ.getQualification());
        pstmt.setString(4, employ.getMore_people());
        pstmt.setDouble(5, employ.getSalary());
        pstmt.setDouble(6, employ.getId());

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
}
