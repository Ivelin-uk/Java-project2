package DB;

import MODELS.Company;

import java.sql.*;
import java.util.ArrayList;

public class RepositoryCompany extends  Repository{
    public RepositoryCompany() throws Exception{
        super();
    }

    public Company getCompanyById(String company_id) throws Exception{
        String sql = "SELECT * FROM companies WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, company_id);

        ResultSet resultSet = pstmt.executeQuery();

        Company company = new Company();
        if (resultSet.next()) {

            String id = resultSet.getString("id");
            String name = resultSet.getString("company_name");
            company.setCompany_name(name);
            company.setId(id);
        }

        return company;
    }

    public String getCompanyNameById(int company_id) throws Exception{
        String sql = "SELECT company_name FROM companies WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, company_id);

        ResultSet resultSet = pstmt.executeQuery();
        String company_name = "";
        if (resultSet.next()) {
            company_name = resultSet.getString("company_name");
        }
        return company_name;
    }
    public ArrayList<Company> getAllCompanies() throws Exception
    {
        Statement stmt = this.conn.createStatement();
        String sql = "SELECT * FROM companies";
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Company> companies = new ArrayList<Company>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("company_name");

            Company company = new Company(id,name);
            companies.add(company);
        }

        return companies;
    }
    public boolean insertCompany(Company company) throws Exception
    {
        String sql = "INSERT INTO companies (id, company_name) VALUES (?, ?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, company.getId());
        pstmt.setString(2, company.getCompany_name());

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteCompany(String id) throws Exception
    {
        String sql = "DELETE FROM companies WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, id);

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean updateCompany(Company company) throws Exception
    {
        String sql = "UPDATE companies SET company_name = ? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, company.getCompany_name());
        pstmt.setString(2, company.getId());

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Company> getAllCompaniesOrderByName() throws Exception
    {
        Statement stmt = this.conn.createStatement();
        String sql = "SELECT * FROM companies ORDER BY company_name";
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Company> companies = new ArrayList<Company>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("company_name");

            Company company = new Company(id,name);
            companies.add(company);
        }

        return companies;
    }
}
