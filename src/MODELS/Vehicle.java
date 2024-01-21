package MODELS;

public class Vehicle {
    private int id;
    private int company_id;
    private String vehicle_type;
    private int employ_id;
    private String register_number;

    public Vehicle(int company_id, String vehicle_type, int employ_id, String register_number) {
        this.setCompany_id(company_id);
        this.setVehicle_type(vehicle_type);
        this.setEmploy_id(employ_id);
        this.setRegister_number(register_number);
    }
    public Vehicle(int id, int company_id, String vehicle_type, int employ_id, String register_number) {
        this.setId(id);
        this.setCompany_id(company_id);
        this.setVehicle_type(vehicle_type);
        this.setEmploy_id(employ_id);
        this.setRegister_number(register_number);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public int getEmploy_id() {
        return employ_id;
    }

    public void setEmploy_id(int employ_id) {
        this.employ_id = employ_id;
    }

    public String getRegister_number() {
        return register_number;
    }

    public void setRegister_number(String register_number) {
        this.register_number = register_number;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", company_id=" + company_id +
                ", vehicle_type='" + vehicle_type + '\'' +
                ", employ_id=" + employ_id +
                ", register_number='" + register_number + '\'' +
                '}';
    }
}

