package CRUD;

import DB.*;
import MODELS.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CompanyCRUD {
    Scanner scanner;
    RepositoryCompany repositoryCompany;
    RepositoryClient repositoryClient;
    RepositoryEmploy repositoryEmploy;
    RepositoryTransport repositoryTransport;
    RepositoryVehicle repositoryVehicle;
    public CompanyCRUD()  throws Exception{
        this.scanner = new Scanner(System.in);
        this.repositoryCompany = new RepositoryCompany();
        this.repositoryClient = new RepositoryClient();
        this.repositoryEmploy = new RepositoryEmploy();
        this.repositoryTransport = new RepositoryTransport();
        this.repositoryVehicle = new RepositoryVehicle();
    }

    public void menu(){
        System.out.println();
        System.out.println("--- Въвеждане, редактиране и изтриване на конпания ---");
        System.out.println("1. Добавяне на компания");
        System.out.println("2. Редактиране на компания");
        System.out.println("3. Изтриване на компания");
        System.out.println("4. Преглед на всички компании");
        System.out.println("5. Изход");
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
                    break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void insertCompany() throws Exception{
        try {
            System.out.println("!!!!!!! Добавяне на компания !!!!!!!");

            System.out.print("Въведете ИД на компануята: ");
            String id = this.scanner.nextLine();

            System.out.print("Въведете ИМЕ на компанията: ");
            String company_name = this.scanner.nextLine();

            Company company = new Company(id,company_name);

            boolean isDeleted = repositoryCompany.insertCompany(company);

            if(isDeleted){
                System.out.println("УСПЕШНО ДОБАВИХТЕ КОМПАНИЯТА !");
            }else {
                System.out.println("ГРЕШКА");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateCompany() throws Exception{
        try {
            System.out.println("!!!!!!! Редактиране на компания !!!!!!!");

            this.showAllCompanies();
            System.out.print("Въведете ИД на компанията: ");
            String id = this.scanner.nextLine();

            System.out.print("Въведете НОВО ИМЕ на компанията: ");
            String newName = this.scanner.nextLine();

            Company company = new Company(id, newName);

            boolean isUpdate = this.repositoryCompany.updateCompany(company);

            if (isUpdate) {
                System.out.println("УСПЕШНО ОБНОВИХТЕ КОМПАНИЯТА !");
            } else {
                System.out.println("НЯМА НАМЕРЕНА КОМПАНЯИЯ С ТОВА ИД: " + id);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteCompany() throws Exception{
        System.out.println("!!!!!!! Изтриване на компания !!!!!!!");

        this.showAllCompanies();
        System.out.print("Въведете ИД на компанията: ");
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
        this.showAllCompanies();
        System.out.print("Въведете ИД на компанията: ");
        String id = this.scanner.nextLine();
        return strCurrentCompany(id);
    }
    public String strCurrentCompany(String id) throws Exception{
        String result = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
        result += "\n";
        result += "----ПОДРОБНА ИНФОРМАЦИЯ НА КОМПАНИЯ -----";
        result += "\n";
        Company company = this.repositoryCompany.getCompanyById(id);
        result += company.toString();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        result += "\n";
        result += " -- КЛИЕНТИ НА КОМПАНИЯТА: ";
        result += "\n";

        ArrayList<Client> clients =  this.repositoryClient.getClientsOnCompany(id);
        for (int i = 0; i < clients.size(); i++) {
            result += clients.get(i).toString();
            result += "\n";
        }

        result += "\n";
        result += " -- РАБОТНИЦИ НА КОМПАНИЯТА: ";
        result += "\n";

        ArrayList<Employ> employs =  this.repositoryEmploy.getEmployeesOnCompany(id);
        for (int i = 0; i < employs.size(); i++) {
            result += employs.get(i).toString();
            result += "\n";
        }

        result += "\n";
        result += " -- ТРАНСПОРТИ НА КОМПАНИЯТА:  ";
        result += "\n";

        ArrayList<Transport> transports =  this.repositoryTransport.getAllTransportOnCompany(Integer.parseInt(id));
        for (int i = 0; i < transports.size(); i++) {
            result += transports.get(i).toString();
            result += "\n";
        }

        result += "\n";
        result += " -- ПРОВОРНИ СТРЕДСТВА : ";
        result += "\n";

        ArrayList<Vehicle> vehicles =  this.repositoryVehicle.getVehicleOnCompany(id);
        for (int i = 0; i < vehicles.size(); i++) {
            result += vehicles.get(i).toString();
            result += "\n";
        }

        return result;
    }
}
