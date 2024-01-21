package CRUD;

import CRUD.CompanyCRUD;
import DB.RepositoryClient;
import DB.RepositoryCompany;
import DB.RepositoryEmploy;
import DB.RepositoryVehicle;
import MODELS.Client;
import MODELS.Employ;
import MODELS.Vehicle;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleCRUD {
    Scanner scanner;
    RepositoryCompany repositoryCompany;
    RepositoryClient repositoryClient;
    RepositoryEmploy repositoryEmploy;
    RepositoryVehicle repositoryVehicle;
    CompanyCRUD companyCRUD;
    EmployCRUD employCRUD;
    public VehicleCRUD()  throws Exception{
        this.scanner = new Scanner(System.in);
        this.repositoryCompany = new RepositoryCompany();
        this.repositoryClient = new RepositoryClient();
        this.companyCRUD = new CompanyCRUD();
        this.employCRUD = new EmployCRUD();
        this.repositoryEmploy = new RepositoryEmploy();
        this.repositoryVehicle = new RepositoryVehicle();
    }

    public void menu(){
        System.out.println();
        System.out.println("--- Вывеждане, редактиране и изтриване на превозните средства, които са собственост на компанията ---");
        System.out.println("1. Добавяне на превозно средство");
        System.out.println("2. Редактиране на превозно средство");
        System.out.println("3. Изтриване на превозно средство");
        System.out.println("4. Прегрлед на всички превозно средство");
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
                this.insertVehicle();
            }

            if(command == 2){
                this.updateVehicle();
            }

            if(command == 3){
                this.deleteVehicle();
            }

            if(command == 4){
                this.showAllVehicle();
            }

            if(command == 5){
                break;
            }

            this.menu();
            System.out.print("Въведете команда: ");
            command = Integer.parseInt(scanner.nextLine());
        }

    }

    public void insertVehicle() throws Exception{
        try {
            System.out.println("!!!!!!! Добавяне на превозно средство !!!!!!!");
            companyCRUD.showAllCompanies();
            System.out.print("Въведете ИД на компанията: ");
            int company_id = Integer.parseInt(this.scanner.nextLine());

            System.out.print("Въведете ТИП на превозното средство: ");
            String vehicle_type = this.scanner.nextLine();

            employCRUD.showAllEmploy();
            System.out.print("Въведете ИД на работника; ");
            int employ_id =  Integer.parseInt(this.scanner.nextLine());

            System.out.print("Въведете РЕГИСТРАЦИОННЕР НОМЕ превозното средство:");
            String register_number =  this.scanner.nextLine();

            Vehicle vehicle = new Vehicle(company_id, vehicle_type, employ_id, register_number);
            boolean isAdded = repositoryVehicle.insertVehicle(vehicle);

            if (isAdded) {
                System.out.println("УСПЕШНО ДОБАВИХТЕ ПРЕВОРНО СРЕДСТВО!");
            } else {
                System.out.println("ГРЕШКА");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateVehicle() throws Exception{
        try {
            System.out.println("!!!!!!! Редактиране на превозно средство !!!!!!!");
            this.showAllVehicle();
            System.out.print("Въведете ИД на превозно средство: ");
            int id = Integer.parseInt(this.scanner.nextLine());

            System.out.print("Въведете НОВО ИД на компанията: ");
            int company_id = Integer.parseInt(this.scanner.nextLine());

            System.out.print("Въведете НОВ ТИП на превозното средство: ");
            String vehicle_type = this.scanner.nextLine();

            employCRUD.showAllEmploy();
            System.out.print("Въведете НОВО ИД на работника; ");
            int employ_id =  Integer.parseInt(this.scanner.nextLine());

            System.out.print("Въведете НОВ РЕГИСТРАЦИОННЕН НОМЕР на превозното средство:");
            String register_number =  this.scanner.nextLine();

            Vehicle vehicle = new Vehicle(id,company_id, vehicle_type, employ_id, register_number);

            boolean isUpdate = this.repositoryVehicle.updateEmploy(vehicle);
            if (isUpdate) {
                System.out.println("УСПЕШНО ОБНОВИХТЕ ПРЕВОЗНОТО СРЕДСТОВО !");
            } else {
                System.out.println("НЯМА НАМЕРЕНО ПРЕВОЗНО СРЕДСТОВО С ТОВА ИД: " + id);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void deleteVehicle() throws Exception{
        System.out.println("!!!!!!! Изтриване на превозно средство !!!!!!!");
        this.showAllVehicle();
        System.out.print("Въведете ИД на превозно средство: ");
        String client_id = this.scanner.nextLine();

        boolean isDeleted =  this.repositoryVehicle.deleteVehicle(client_id);
        if(isDeleted){
            System.out.println("УСПЕШНО ИЗТРИХТЕ ПРЕВОЗНОТО СРЕДСТОВО !");
        }else {
            System.out.println("НЯМА НАМЕРЕНА ПРЕВОЗНО СРЕДСТОВО С ТОВА ИД: " + client_id);
        }
    }


    public void showAllVehicle() throws Exception{
        ArrayList<Vehicle> employs = repositoryVehicle.getAllVehicles();
        for (int i = 0; i < employs.size(); i++) {
            System.out.println(employs.get(i));
        }
    }
}
