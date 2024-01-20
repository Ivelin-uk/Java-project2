package CRUD;

import CRUD.CompanyCRUD;
import DB.RepositoryClient;
import DB.RepositoryCompany;
import MODELS.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientCRUD {
    Scanner scanner;
    RepositoryCompany repositoryCompany;
    RepositoryClient repositoryClient;
    CompanyCRUD companyCRUD;
    public ClientCRUD()  throws Exception{
        this.scanner = new Scanner(System.in);
        this.repositoryCompany = new RepositoryCompany();
        this.repositoryClient = new RepositoryClient();
        this.companyCRUD = new CompanyCRUD();
    }

    public void menu(){
        System.out.println();
        System.out.println("--- Въвеждане, редактиране и изтриване на клиентите на транспортната компания ---");
        System.out.println("1. Добавяне на клиент");
        System.out.println("2. Редактиране на клиент");
        System.out.println("3. Изтриване на клиент");
        System.out.println("4. Прегрлед на всички клиенти");
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
                this.insertClient();
            }

            if(command == 2){
                this.updateClient();
            }

            if(command == 3){
                this.deleteClient();
            }

            if(command == 4){
                this.showAllClient();
            }

            if(command == 5){
                break;
            }

            this.menu();
            System.out.print("Въведете команда: ");
            command = Integer.parseInt(scanner.nextLine());
        }

    }

    public void insertClient() throws Exception{
        try {
            System.out.println("!!!!!!! Добавяне на клиент !!!!!!!");
            companyCRUD.showAllCompanies();
            System.out.print("Въведете ИД на компанията: ");
            String company_id = this.scanner.nextLine();
            System.out.print("Име на клиента: ");
            String company_name = this.scanner.nextLine();

            Client client = new Client(company_id, company_name);

            boolean isAdded = repositoryClient.insertClient(client);

            if (isAdded) {
                System.out.println("УСПЕШНО ДОБАВИХТЕ КЛИЕНТ !");
            } else {
                System.out.println("НЯМА НАМЕРЕН КОМПАНЯИЯ С ТОВА ИД: " + company_id);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateClient() throws Exception{
        System.out.println("!!!!!!! Редактиране на клиент !!!!!!!");
        this.showAllClient();
        System.out.print("Въведете ИД на клиента: ");
        String client_id =  this.scanner.nextLine();

        System.out.print("Въведете ново ИД на компанията: ");
        String company_id =  this.scanner.nextLine();

        System.out.print("Въведете ново ИМЕ на клиента: ");
        String new_client_name =  this.scanner.nextLine();

        Client client = new Client();
        client.setId(client_id);
        client.setCompany_id(company_id);
        client.setName_client(new_client_name);


        boolean isUpdate =  this.repositoryClient.updateClient(client);
        if(isUpdate){
            System.out.println("УСПЕШНО ОБНОВИХТЕ КЛИЕНТА !");
        }else {
            System.out.println("НЯМА НАМЕРЕН КЛИЕНТА С ТОВА ИД: " + client_id);
        }

    }


    public void deleteClient() throws Exception{
        System.out.println("!!!!!!! Изтриване на клиент !!!!!!!");
        this.showAllClient();
        System.out.print("Въведете ИД на клиента: ");
        String client_id = this.scanner.nextLine();

        boolean isDeleted =  this.repositoryClient.deleteClient(client_id);
        if(isDeleted){
            System.out.println("УСПЕШНО ИЗТРИХТЕ КЛИЕНТА !");
        }else {
            System.out.println("НЯМА НАМЕРЕНА КЛИЕНТ С ТОВА ИД: " + client_id);
        }
    }


    public void showAllClient() throws Exception{
        ArrayList<Client> clients = repositoryClient.getClientsAllClients();
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(clients.get(i));
        }
    }
}
