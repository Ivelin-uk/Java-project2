package MODELS;

public class Employ {
    //id, name, company_id
    private String id;
    private String name;
    private String company_id;

    public Employ(){

    }
    public Employ(String id, String name, String company_id) {
        this.id = id;
        this.name = name;
        this.company_id = company_id;
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

    public void setName(String name) {
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
        return "Employ{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", company_id='" + company_id + '\'' +
                '}';
    }
}
