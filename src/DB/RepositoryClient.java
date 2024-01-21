package DB;

import MODELS.Client;

import java.sql.*;
import java.util.ArrayList;

public class RepositoryClient extends Repository{
    public RepositoryClient()  throws Exception{
        super();
    }
    public ArrayList<Client> getClientsOnCompany(String company_id) throws Exception {
        ArrayList<Client> companyClients = new ArrayList<>();

        String sql = "SELECT * FROM clients WHERE company_id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, company_id);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            String client_id = rs.getString("id");
            String name_client = rs.getString("name_client");
            String isDebtor = rs.getString("isDebtor");
            String db_company_id = rs.getString("company_id");
            Client companyClient = new Client(client_id, name_client,isDebtor,db_company_id);
            companyClients.add(companyClient);
        }

        return companyClients;
    }

    public ArrayList<Client> getAllClients() throws Exception {
        ArrayList<Client> companyClients = new ArrayList<>();

        String sql = "SELECT * FROM clients";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            String client_id = rs.getString("id");
            String name_client = rs.getString("name_client");
            String isDebtor = rs.getString("isDebtor");
            String company_id = rs.getString("company_id");
            Client companyClient = new Client(client_id, name_client,isDebtor,company_id);
            companyClients.add(companyClient);
        }

        return companyClients;
    }


    public boolean insertClient(Client client) throws Exception
    {
        String sql = "INSERT INTO clients (name_client, company_id) VALUES (?, ?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, client.getName_client());
        pstmt.setString(2, client.getCompany_id());

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteClient(String name_client) throws Exception
    {
        String sql = "DELETE FROM clients WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, name_client);

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean updateClient(Client client) throws Exception
    {
        String sql = "UPDATE clients SET name_client = ? , company_id = ? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, client.getName_client());
        pstmt.setString(2, client.getCompany_id());
        pstmt.setString(3, client.getId());

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
}
