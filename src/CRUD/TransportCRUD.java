package CRUD;

import DB.RepositoryClient;
import DB.RepositoryCompany;
import DB.RepositoryTransport;
import MODELS.Company;
import MODELS.Employ;
import MODELS.Transport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TransportCRUD {
    Scanner scanner;
    RepositoryCompany repositoryCompany;
    RepositoryClient repositoryClient;
    RepositoryTransport repositoryTransport;
    public TransportCRUD()  throws Exception{
        this.scanner = new Scanner(System.in);
        this.repositoryCompany = new RepositoryCompany();
        this.repositoryClient = new RepositoryClient();
        this.repositoryTransport = new RepositoryTransport();
    }

    public void menu(){
        System.out.println("-------------------------------------");
        System.out.println("!!!!!!! Добавяне на транспорт !!!!!!!");
        System.out.println("-------------------------------------");
    }

    public void start() throws Exception{
        this.menu();
        this.insertTransport();
    }
    public void insertTransport() throws Exception{

        try {
            System.out.print("Въведете начална точка:");
            String start_point = scanner.nextLine();

            System.out.print("Enter ending point: ");
            String end_point = scanner.nextLine();

            System.out.print("Enter departure date (in the format dd.MM.yyyy): ");
            String dep_date_str = scanner.nextLine();

            Date departure_date = new SimpleDateFormat("dd.MM.yyyy").parse(dep_date_str);

            System.out.print("Enter arrival date (in the format dd.MM.yyyy): ");
            String arr_date_str = scanner.nextLine();

            Date arrival_date = new SimpleDateFormat("dd.MM.yyyy").parse(arr_date_str);

            System.out.print("Enter cargo type: ");
            String cargo_type = scanner.nextLine();

            System.out.print("Enter total weight: ");
            double total_weight = scanner.nextDouble();

            System.out.print("Enter passenger count: ");
            int passenger_count = scanner.nextInt();

            System.out.println("Избере ИТ кой");
            System.out.print("Enter employee ID: ");
            int employee_id = scanner.nextInt();

            Transport transport = new Transport(
                    start_point,
                    end_point,
                    departure_date,
                    arrival_date,
                    cargo_type,
                    total_weight,
                    passenger_count,
                    employee_id
            );

            boolean isAdded = repositoryTransport.insertTransport(transport);

            if(isAdded){
                System.out.println("УСПЕШНО ДОБАВИХТЕ КЛИЕНТ !");
            }else {
                System.out.println("ГРЕШКА ПРИ ДОБАВЯНЕ");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
