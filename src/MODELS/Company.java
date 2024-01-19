package MODELS;

import java.util.ArrayList;
import java.util.List;

public class Company {
    //id, company_name
    private String id;
    private String company_name;
    private ArrayList<Employ> employs = new ArrayList<Employ>();
    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<Transport> trasports = new ArrayList<Transport>();

    public Company(){

    }

    public Company(String id, String company_name) throws Exception{
        this.setId(id);
        this.setCompany_name(company_name);
    }

    public Company(String id, String company_name, ArrayList<Employ> employs, ArrayList<Client> clients, ArrayList<Transport> trasports) throws Exception {
        this.setId(id);
        this.setCompany_name(company_name);
        this.setEmploys(employs);
        this.setClients(clients);
        this.setTrasports(trasports);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) throws Exception {
        if(company_name.length() < 3){
            throw new Exception("Името на компанията трябва да е над 3 символа дължина !");
        }
        this.company_name = company_name;
    }

    public ArrayList<Employ> getEmploys() {
        return employs;
    }

    public void setEmploys(ArrayList<Employ> employs) {
        this.employs = employs;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Transport> getTrasports() {
        return trasports;
    }

    public void setTrasports(ArrayList<Transport> trasports) {
        this.trasports = trasports;
    }


    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", company_name='" + company_name + '\'' +
                '}';
    }
}
