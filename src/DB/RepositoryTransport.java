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
        String sql = "INSERT INTO transport (start_point, end_point, departure_date, arrival_date, " +
                "cargo_type, total_weight, passenger_count, employ_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, transport.getStart_point());
        pstmt.setString(2, transport.getEnd_point());
        pstmt.setDate(3, new java.sql.Date(transport.getDeparture_date().getTime()));
        pstmt.setDate(4, new java.sql.Date(transport.getArrival_date().getTime()));
        pstmt.setString(5, transport.getCargo_type());
        pstmt.setDouble(6, transport.getTotal_weight());
        pstmt.setInt(7, transport.getPassenger_count());
        pstmt.setInt(8, transport.getEmploy_id());

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
}
