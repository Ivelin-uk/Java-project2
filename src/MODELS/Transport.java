package MODELS;

import java.util.Date;

public class Transport {
    private int id;
    private String start_point;
    private String end_point;
    private Date departure_date;
    private Date arrival_date;
    private String cargo_type;
    private double total_weight;
    private int passenger_count;
    private int employ_id;
    private int company_id;
    private double price;
    public Transport(String start_point,
                     String end_point,
                     Date departure_date,
                     Date arrival_date,
                     String cargo_type,
                     double total_weight,
                     int passenger_count,
                     int employ_id,
                     int company_id,
                     double price
    ) {
        this.setStart_point(start_point);
        this.setEnd_point(end_point);
        this.setDeparture_date(departure_date);
        this.setArrival_date(arrival_date);
        this.setCargo_type(cargo_type);
        this.setTotal_weight(total_weight);
        this.setPassenger_count(passenger_count);
        this.setEmploy_id(employ_id);
        this.setCompany_id(company_id);
        this.setPrice(price);
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart_point() {
        return start_point;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }

    public String getEnd_point() {
        return end_point;
    }

    public void setEnd_point(String end_point) {
        this.end_point = end_point;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getCargo_type() {
        return cargo_type;
    }

    public void setCargo_type(String cargo_type) {
        this.cargo_type = cargo_type;
    }

    public double getTotal_weight() {
        return total_weight;
    }

    public void setTotal_weight(double total_weight) {
        this.total_weight = total_weight;
    }

    public int getPassenger_count() {
        return passenger_count;
    }

    public void setPassenger_count(int passenger_count) {
        this.passenger_count = passenger_count;
    }

    public int getEmploy_id() {
        return employ_id;
    }

    public void setEmploy_id(int employ_id) {
        this.employ_id = employ_id;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", start_point='" + start_point + '\'' +
                ", end_point='" + end_point + '\'' +
                ", departure_date=" + departure_date +
                ", arrival_date=" + arrival_date +
                ", cargo_type='" + cargo_type + '\'' +
                ", total_weight=" + total_weight +
                ", passenger_count=" + passenger_count +
                '}';
    }
}

