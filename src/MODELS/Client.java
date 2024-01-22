package MODELS;
public class Client {
    private String id;
    private String name_client;
    private String company_id;

    public Client() throws Exception{

    }
    public Client(String company_id, String name_client) throws Exception{
        this.setCompany_id(company_id);
        this.setName_client(name_client);
    }

    public Client(String id, String name_client, String company_id) throws Exception {
        this.setId(id);
        this.setName_client(name_client);
        this.setCompany_id(company_id);
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if("".equals(id)){
            throw new Exception("Въведете ИД");
        }
        this.id = id;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) throws Exception {
        if(name_client.length() < 3){
            throw new Exception("Length cannot be less than 3 characters");
        }

        this.name_client = name_client;
    }

    @Override
    public String toString() {
        String r = "--- КЛИЕНТ { ИД: " + id + ", ИМЕ НА КЛИЕНТА: " + name_client + " }";

        return r;
    }
}
