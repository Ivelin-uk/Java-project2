package CRUD;

import CRUD.CompanyCRUD;
import DB.RepositoryClient;
import DB.RepositoryCompany;
import DB.RepositoryEmploy;
import MODELS.Client;
import MODELS.Employ;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployCRUD {
    Scanner scanner;
    RepositoryCompany repositoryCompany;
    RepositoryClient repositoryClient;
    RepositoryEmploy repositoryEmploy;
    CompanyCRUD companyCRUD;
    public EmployCRUD()  throws Exception{
        this.scanner = new Scanner(System.in);
        this.repositoryCompany = new RepositoryCompany();
        this.repositoryClient = new RepositoryClient();
        this.companyCRUD = new CompanyCRUD();
        this.repositoryEmploy = new RepositoryEmploy();
    }

    public void menu(){
        System.out.println();
        System.out.println("--- Въвеждане, редактиране и изтриване на клиентите на транспортната компания ---");
        System.out.println("1. Добавяне на работник");
        System.out.println("2. Редактиране на работник");
        System.out.println("3. Изтриване на работник");
        System.out.println("4. Прегрлед на всички работник");
        System.out.println("5. Изход");
        System.out.println();
    }
    //command 1
    public void start() throws Exception{
        this.menu();
        System.out.print("Въведете команда: ");

        int command = Integer.parseInt(scanner.nextLine());
        while (true) {
            if(command == 1){
                this.insertEmploy();
            }

            if(command == 2){
                this.updateEmploy();
            }

            if(command == 3){
                this.deleteEmploy();
            }

            if(command == 4){
                this.showAllEmploy();
            }

            if(command == 5){
                break;
            }

            this.menu();
            System.out.print("Въведете команда: ");
            command = Integer.parseInt(scanner.nextLine());
        }

    }

    public void insertEmploy() throws Exception{
        try {
            System.out.println("!!!!!!! Добавяне на работник !!!!!!!");
            companyCRUD.showAllCompanies();
            System.out.print("Въведете ИД на компанията: ");
            String company_id = this.scanner.nextLine();
            System.out.print("Име на работник: ");
            String company_name = this.scanner.nextLine();

            Client client = new Client(company_id, company_name);

            boolean isAdded = repositoryClient.insertClient(client);

            if (isAdded) {
                System.out.println("УСПЕШНО ДОБАВИХТЕ РАБОТНИК !");
            } else {
                System.out.println("НЯМА НАМЕРЕН КОМПАНЯИЯ С ТОВА ИД: " + company_id);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateEmploy() throws Exception{
        System.out.println("!!!!!!! Редактиране на работник !!!!!!!");
        this.showAllEmploy();
        System.out.print("Въведете ИД на работник: ");
        String employ_id =  this.scanner.nextLine();

        System.out.print("Въведете ново ИД на работник: ");
        String company_id =  this.scanner.nextLine();

        System.out.print("Въведете ново ИМЕ на работник: ");
        String new_client_name =  this.scanner.nextLine();

        Employ employ = new Employ();
        employ.setId(employ_id);
        employ.setCompany_id(company_id);
        employ.setName(new_client_name);


        boolean isUpdate =  this.repositoryEmploy.updateClient(employ);
        if(isUpdate){
            System.out.println("УСПЕШНО ОБНОВИХТЕ РАБОТНИК !");
        }else {
            System.out.println("НЯМА НАМЕРЕН РАБОТНИК С ТОВА ИД: " + employ_id);
        }

    }


    public void deleteEmploy() throws Exception{
        System.out.println("!!!!!!! Изтриване на компания !!!!!!!");
        this.showAllEmploy();
        System.out.print("Въведете ИД на клиента: ");
        String client_id = this.scanner.nextLine();

        boolean isDeleted =  this.repositoryEmploy.deleteEmploy(client_id);
        if(isDeleted){
            System.out.println("УСПЕШНО ИЗТРИХТЕ РАБОТНИК !");
        }else {
            System.out.println("НЯМА НАМЕРЕНА РАБОТНИК С ТОВА ИД: " + client_id);
        }
    }


    public void showAllEmploy() throws Exception{
        ArrayList<Employ> clients = repositoryEmploy.getEmployAllClients();
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(clients.get(i));
        }
    }
}
