package CRUD;

import DB.RepositoryClient;
import DB.RepositoryCompany;
import DB.RepositoryEmploy;
import MODELS.Client;
import MODELS.Company;
import MODELS.Employ;

import java.util.ArrayList;
import java.util.Scanner;

public class CompanyCRUD {
    Scanner scanner;
    RepositoryCompany repositoryCompany;
    RepositoryClient repositoryClient;
    RepositoryEmploy repositoryEmploy;
    public CompanyCRUD()  throws Exception{
        this.scanner = new Scanner(System.in);
        this.repositoryCompany = new RepositoryCompany();
        this.repositoryClient = new RepositoryClient();
        this.repositoryEmploy = new RepositoryEmploy();
    }

    public void menu(){
        System.out.println();
        System.out.println("--- Въвеждане, редактиране и изтриване на конпания ---");
        System.out.println("1. Добавяне на компания");
        System.out.println("2. Редактиране на компания");
        System.out.println("3. Изтриване на компания");
        System.out.println("4. Преглед на всички компании");
        System.out.println("5. Подробна информация на компания");
        System.out.println("6. Изход");
        System.out.println();
    }

    public void start() throws Exception{

        while (true) {
            try {
                this.menu();
                System.out.print("Въведете команда: ");
                int command = Integer.parseInt(scanner.nextLine());

                if(command == 1){
                    this.insertCompany();
                }

                if(command == 2){
                    this.updateCompany();
                }

                if(command == 3){
                    this.deleteCompany();
                }

                if(command == 4){
                    this.showAllCompanies();
                }

                if(command == 5){
                    System.out.println(fullInfoCompany());
                }

                if(command == 6){
                    break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

    public void insertCompany() throws Exception{
        System.out.println("!!!!!!! Добавяне на компания !!!!!!!");
        System.out.print("НОМЕР НА КОМПАНИЯТА: ");
        String id = this.scanner.nextLine();
        System.out.print("ИМЕ НА КОМПАНИЯТА НА КОМПАНИЯТА: ");
        String company_name = this.scanner.nextLine();

        Company company = new Company(id,company_name);
        boolean isDeleted = repositoryCompany.insertCompany(company);

        if(isDeleted){
            System.out.println("УСПЕШНО ДОБАВИХТЕ КОМПАНИЯТА !");
        }else {
            System.out.println("НЯМА НАМЕРЕНА КОМПАНИЯ С ТОВА ИД: " + id);
        }
    }

    public void updateCompany() throws Exception{
        System.out.println("!!!!!!! Редактиране на компания !!!!!!!");
        this.showAllCompanies();
        System.out.print("Въведете id на компанията: ");
        String id = this.scanner.nextLine();
        System.out.println("Ново име на компанията: ");
        String newName = this.scanner.nextLine();

        Company company = new Company(id,newName);
        boolean isUpdate =  this.repositoryCompany.updateCompany(company);
        if(isUpdate){
            System.out.println("УСПЕШНО ОБНОВИХТЕ КОМПАНИЯТА !");
        }else {
            System.out.println("НЯМА НАМЕРЕНА КОМПАНЯИЯ С ТОВА ИД: " + id);
        }
    }

    public void deleteCompany() throws Exception{
        System.out.println("!!!!!!! Изтриване на компания !!!!!!!");
        this.showAllCompanies();
        System.out.print("Въведете id на компанията: ");
        String id = this.scanner.nextLine();

        boolean isDeleted =  this.repositoryCompany.deleteCompany(id);
        if(isDeleted){
            System.out.println("УСПЕШНО ИЗТРИХТЕ КОМПАНИЯТА !");
        }else {
            System.out.println("НЯМА НАМЕРЕНА КОМПАНИЯ С ТОВА ИД: " + id);
        }
    }

    public void showAllCompanies() throws Exception{
        System.out.println("!!!!!!! Преглед на всички компании !!!!!!!");
        ArrayList<Company> companies = repositoryCompany.getAllCompanies();
        for (int i = 0; i < companies.size(); i++) {
            System.out.println(companies.get(i));
        }
    }

    public String fullInfoCompany() throws Exception{
        System.out.println("!!!!!!! Подробна информация на компания !!!!!!!");
        this.showAllCompanies();
        System.out.print("Въведете id на компанията: ");
        String id = this.scanner.nextLine();

        Company company = this.repositoryCompany.getCompanyById(id);
        String result = "ИМЕ НА КОМПАНИЯТА: " + company.getCompany_name() + " ИД: " + company.getId();
        result += "\n";
        result += " -- КЛИЕНТИ НА КОМПАНИЯТА: ";
        result += "\n";

        ArrayList<Client> clients =  this.repositoryClient.getClientsOnCompany(id);
        for (int i = 0; i < clients.size(); i++) {
            result += "   - ID: " + clients.get(i).getId() + " NAME: " + clients.get(i).getName_client();
            result += "\n";
        }

        result += "\n";
        result += " -- РАБОТНИЦИ НА КОМПАНИЯТА: ";
        result += "\n";

        ArrayList<Employ> employs =  this.repositoryEmploy.getEmploiesOnCompany(id);
        for (int i = 0; i < employs.size(); i++) {
            result += "   - ID: " + employs.get(i).getId() + " NAME: " + employs.get(i).getName();
            result += "\n";
        }

        return result;
    }
}
