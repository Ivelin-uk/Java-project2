package DB;

import MODELS.Client;
import MODELS.Employ;
import MODELS.Vehicle;

import java.sql.*;
import java.util.ArrayList;

public class RepositoryVehicle extends Repository{
    public RepositoryVehicle()  throws Exception{
        super();
    }
    public ArrayList<Vehicle> getVehicleOnCompany(String company_id) throws Exception {
        ArrayList<Vehicle> companyVehicle = new ArrayList<Vehicle>();

        String sql = "SELECT * FROM vehicles WHERE company_id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, company_id);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int db_company_id = rs.getInt("company_id");
            String vehicle_type = rs.getString("vehicle_type");
            int employ_id = rs.getInt("employ_id");
            String register_number = rs.getString("register_number");

            Vehicle vehicle = new Vehicle(id, db_company_id,vehicle_type,employ_id,register_number);
            companyVehicle.add(vehicle);
        }

        return companyVehicle;
    }

    public ArrayList<Vehicle> getAllVehicles() throws Exception {
        ArrayList<Vehicle> companyVehicle = new ArrayList<Vehicle>();

        String sql = "SELECT * FROM vehicles";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);


        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int db_company_id = rs.getInt("company_id");
            String vehicle_type = rs.getString("vehicle_type");
            int employ_id = rs.getInt("employ_id");
            String register_number = rs.getString("register_number");

            Vehicle vehicle = new Vehicle(id, db_company_id,vehicle_type,employ_id,register_number);
            companyVehicle.add(vehicle);
        }

        return companyVehicle;
    }

    public boolean insertVehicle(Vehicle vehicle) throws Exception
    {
        String sql = "INSERT INTO vehicles (company_id, vehicle_type,employ_id,register_number) VALUES (?, ?, ?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, vehicle.getCompany_id());
        pstmt.setString(2, vehicle.getVehicle_type());
        pstmt.setInt(3, vehicle.getEmploy_id());
        pstmt.setString(4, vehicle.getRegister_number());


        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteVehicle(String vehicles_id) throws Exception
    {
        String sql = "DELETE FROM vehicles WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, vehicles_id);

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean updateEmploy(Vehicle vehicle) throws Exception
    {
        String sql = "UPDATE vehicles SET company_id = ?, vehicle_type = ?, employ_id = ?, register_number = ? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, vehicle.getCompany_id());
        pstmt.setString(2, vehicle.getVehicle_type());
        pstmt.setInt(3, vehicle.getEmploy_id());
        pstmt.setString(4, vehicle.getRegister_number());
        pstmt.setInt(5, vehicle.getEmploy_id());


        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
}
