package MODELS;

import CRUD.EmployCRUD;
import DB.RepositoryCompany;

public class Employ {
    private  int id;
    private String name;
    private int company_id;
    String  company_name;
    private String qualification;
    private String more_people;
    private double salary;
    RepositoryCompany repositoryCompany = new RepositoryCompany();

    public Employ() throws Exception {

    }

    public Employ(String name, int company_id, String qualification, String more_people, double salary) throws Exception {
        this.setName(name);
        this.setCompany_id(company_id);
        this.setQualification(qualification);
        this.setMore_people(more_people);
        this.setSalary(salary);
        this.company_name = repositoryCompany.getCompanyNameById(company_id);

    }

    public Employ(int id, String name, int company_id, String qualification, String more_people, double salary) throws Exception {
        this.setId(id);
        this.setName(name);
        this.setCompany_id(company_id);
        this.setQualification(qualification);
        this.setMore_people(more_people);
        this.setSalary(salary);
        this.company_name = repositoryCompany.getCompanyNameById(company_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception{
        if(name.length() < 3){
            throw  new Exception("Името не може да е под 3 символа дължина. ");
        }
        this.name = name;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getMore_people() {
        return more_people;
    }

    public void setMore_people(String more_people) {
        this.more_people = more_people;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws Exception {
        if(salary < 1000){
            throw new Exception("Заплата не може да бъде под 1000 !");
        }
        this.salary = salary;
    }

    /*
     private  int id;
    private String name;
    private int company_id;
    private String qualification;
    private String more_people;
    private double salary;

     */

    @Override
    public String toString() {
        return "РАБОТНИК { ИД: " + id + " ИМЕ: " + name + " ИМЕ НАКОМПАНИЯТА: " +  company_name +  " КЛАЛИФИКАЦИЯ: " + qualification + " ПОВЕЧЕ ОТ 12 ЧОВЕКА: " + more_people + " ЗАПЛАТА: " + salary + " }";
    }
}
