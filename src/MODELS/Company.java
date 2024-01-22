package MODELS;

import java.util.ArrayList;
import java.util.List;

public class Company {
    //id, company_name
    private String id;
    private String company_name;
    private Double money;

    public Company(){

    }

    public Company(String id, String company_name) throws Exception{
        this.setId(id);
        this.setCompany_name(company_name);
    }

    public Company(String id, String company_name, double money) throws Exception {
        this.setId(id);
        this.setCompany_name(company_name);
        this.setMoney(money);
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return  "КОМПАНИЯ - ИД: " + id + " ИМЕ: " + company_name;
    }
}
