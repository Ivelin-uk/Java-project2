package MODELS;

import CRUD.EmployCRUD;

public class Employ {
    //id, name, company_id
    private String id;
    private String name;
    private String company_id;

    private String isDebtor;

    public Employ() throws Exception{

    }

    public Employ(String name,String company_id) throws Exception {
        this.setName(name);
        this.setCompany_id(company_id);
    }
    public Employ(String id, String name, String company_id) throws Exception {
        this.setId(id);
        this.setName(name);
        this.setCompany_id(company_id);
    }

    public String getIsDebtor() {
        return isDebtor;
    }

    public void setIsDebtor(String isDebtor) {
        this.isDebtor = isDebtor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.length() < 3){
            throw new Exception("Дължината на името не може под 3 символа.");
        }
        this.name = name;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    @Override
    public String toString() {
        return "РАБОТНИК - ИД: " + id + " ИМЕ: " + name;
    }
}
