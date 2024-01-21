package DB;

import MODELS.Company;
import MODELS.Transport;

import java.sql.*;
import java.util.ArrayList;

public class RepositoryTransport extends Repository{
    public RepositoryTransport() throws Exception{
       super();
    }
    public boolean insertTransport(Transport transport) throws Exception
    {
        String sql = "INSERT INTO transports (start_point, end_point, departure_date, arrival_date, " +
                "cargo_type, total_weight, passenger_count, employ_id,company_id,price) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, transport.getStart_point());
        pstmt.setString(2, transport.getEnd_point());
        pstmt.setDate(3, new java.sql.Date(transport.getDeparture_date().getTime()));
        pstmt.setDate(4, new java.sql.Date(transport.getArrival_date().getTime()));
        pstmt.setString(5, transport.getCargo_type());
        pstmt.setDouble(6, transport.getTotal_weight());
        pstmt.setInt(7, transport.getPassenger_count());
        pstmt.setInt(8, transport.getEmploy_id());
        pstmt.setInt(9, transport.getCompany_id());
        pstmt.setDouble(10, transport.getPrice());

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteTransport(String id) throws Exception
    {
        String sql = "DELETE FROM transports WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, id);

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Transport> getAllTransport(int companyId) throws Exception {
        ArrayList<Transport>  transports = new ArrayList<Transport>();

        String sql = "SELECT * FROM transports WHERE company_id = ?";
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setInt(1, companyId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Transport transport = new Transport(
                            rs.getString("start_point"),
                            rs.getString("end_point"),
                            rs.getDate("departure_date"),
                            rs.getDate("arrival_date"),
                            rs.getString("cargo_type"),
                            rs.getDouble("total_weight"),
                            rs.getInt("passenger_count"),
                            rs.getInt("employ_id"),
                            rs.getInt("company_id"),
                            rs.getDouble("price")
                    );
                    transports.add(transport);
                }
            }
        }

        return transports;
    }

    public ArrayList<Transport> getAllTransport() throws Exception {
        ArrayList<Transport>  transports = new ArrayList<Transport>();

        String sql = "SELECT * FROM transports";
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Transport transport = new Transport(
                            rs.getString("start_point"),
                            rs.getString("end_point"),
                            rs.getDate("departure_date"),
                            rs.getDate("arrival_date"),
                            rs.getString("cargo_type"),
                            rs.getDouble("total_weight"),
                            rs.getInt("passenger_count"),
                            rs.getInt("employ_id"),
                            rs.getInt("company_id"),
                            rs.getDouble("price")
                    );
                    transports.add(transport);
                }
            }
        }

        return transports;
    }
}
