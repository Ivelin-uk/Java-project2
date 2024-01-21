package CRUD;

import DB.RepositoryClient;
import DB.RepositoryCompany;
import DB.RepositoryEmploy;
import DB.RepositoryTransport;
import MODELS.Company;
import MODELS.Employ;
import MODELS.Transport;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TransportCRUD {
    Scanner scanner;
    RepositoryCompany repositoryCompany;
    RepositoryClient repositoryClient;
    RepositoryTransport repositoryTransport;
    RepositoryEmploy repositoryEmploy;
    EmployCRUD employCRUD;
    CompanyCRUD companyCRUD;
    ClientCRUD clientCRUD;
    public TransportCRUD()  throws Exception{
        this.scanner = new Scanner(System.in);
        this.repositoryCompany = new RepositoryCompany();
        this.repositoryClient = new RepositoryClient();
        this.repositoryTransport = new RepositoryTransport();
        this.repositoryEmploy = new RepositoryEmploy();
        this.employCRUD = new EmployCRUD();
        this.companyCRUD = new CompanyCRUD();
        this.clientCRUD = new ClientCRUD();
    }

    public void menu(){
        System.out.println("-------------------------------------");
        System.out.println("!!!!!!! Добавяне на транспорт !!!!!!!");
        System.out.println("1. Добавяне на транспорт");
        System.out.println("2. Изтриване на транспорт");
        System.out.println("3. Преглед на всички транспорти");
        System.out.println("4. Изход");
        System.out.println("-------------------------------------");
    }

    public void start() throws Exception{
        this.menu();
        System.out.print("Въведете команда: ");

        int command = Integer.parseInt(scanner.nextLine());
        while (true) {
            if(command == 1){
                this.insertTransport();
            }

            if(command == 2){
                this.deleteTransport();
            }

            if(command == 3){
                this.showAllTransports();
            }

            if(command == 4){
                break;
            }

            this.menu();
            System.out.print("Въведете команда: ");
            command = Integer.parseInt(scanner.nextLine());
        }
    }
    public void insertTransport() throws Exception{
        try {
            System.out.println("!!!!!!! Добавяне на транспорт !!!!!!!");
            clientCRUD.showAllClient();
            System.out.print("Въведе ИД на клента: ");
            int client_id = Integer.parseInt(scanner.nextLine());

            System.out.print("Цена: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Плати: [yes/on]: ");
            String payment_info = scanner.nextLine();
            int payment;
            if(payment_info.equals("yes")){
                payment = 1;
            }else{
                payment = 0;
            }

            System.out.print("Въведете начална точка:");
            String start_point = scanner.nextLine();

            System.out.print("Въведете крайна точка: ");
            String end_point = scanner.nextLine();

            System.out.print("Въведете дата на отпътуване (във формат dd.MM.yyyy): ");
            String dep_date_str = scanner.nextLine();

            Date departure_date = new SimpleDateFormat("dd.MM.yyyy").parse(dep_date_str);

            System.out.print("Въведете дата на пристигане (във формат dd.MM.yyyy): ");
            String arr_date_str = scanner.nextLine();

            Date arrival_date = new SimpleDateFormat("dd.MM.yyyy").parse(arr_date_str);

            System.out.print("Въведете вид на товара: ");
            String cargo_type = scanner.nextLine();

            System.out.print("Въведете общо тегло: ");
            double total_weight = scanner.nextDouble();

            System.out.print("Въведете брой пътници: ");
            int passenger_count = scanner.nextInt();

            this.employCRUD.showAllEmploy();
            System.out.print("Избере ИД на работника :");
            int employee_id = scanner.nextInt();

            this.companyCRUD.showAllCompanies();
            System.out.print("Избере ИД на компанията :");
            int company_id = scanner.nextInt();

            Transport transport = new Transport(
                    start_point,
                    end_point,
                    departure_date,
                    arrival_date,
                    cargo_type,
                    total_weight,
                    passenger_count,
                    employee_id,
                    company_id,
                    price,
                    client_id,
                    payment
            );

            boolean isAdded = repositoryTransport.insertTransport(transport);
            System.out.println(isAdded);
            if(isAdded){
                System.out.println("УСПЕШНО ДОБАВИХТЕ ТРАНСПОРТ !");
            }else {
                System.out.println("ГРЕШКА ПРИ ДОБАВЯНЕ");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteTransport() throws Exception{
        System.out.println("!!!!!!! Изтриване на транспорт !!!!!!!");
        this.showAllTransports();
        System.out.print("Въведете ИД на танспорта: ");
        String id = this.scanner.nextLine();
        boolean isDeleted =  this.repositoryTransport.deleteTransport(id);
        if(isDeleted){
            System.out.println("УСПЕШНО ИЗТРИХТЕ ТРАНСПОРТ !");
        }else {
            System.out.println("НЯМА НАМЕРЕНА ТРАНСПОРТ С ТОВА ИД: " + id);
        }

    }

    public void showAllTransports() throws Exception{
        System.out.println("!!!!!!! Преглед на вички транспорти !!!!!!!");
        ArrayList<Transport> transports = repositoryTransport.getAllTransport();
        for (int i = 0; i < transports.size(); i++) {
            System.out.println(transports.get(i));
        }
    }
}
