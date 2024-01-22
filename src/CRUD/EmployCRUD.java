package CRUD;

import CRUD.CompanyCRUD;
import DB.RepositoryClient;
import DB.RepositoryCompany;
import DB.RepositoryEmploy;
import MODELS.Client;
import MODELS.Employ;

import java.sql.SQLOutput;
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
        System.out.println("--- Въвеждане, редактиране и изтриване на работниците на транспортната компания ---");
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
                System.out.println("D");
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
            int company_id = Integer.parseInt(this.scanner.nextLine());

            System.out.print("Въведете ИМЕ на работник: ");
            String name = this.scanner.nextLine();

            System.out.print("Въведете КЛАЛИФИКАЦИЯ на работник: ");
            String qualification = this.scanner.nextLine();

            System.out.print("Превоз над 12 пътника [да/не]: ");
            String more_people = this.scanner.nextLine();
            int more;
            if(more_people.equals("да")){
                more = 1;
            }else{
                more = 0;
            }

            System.out.print("Заплата: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Employ employ = new Employ(name,company_id,qualification,more_people,salary);

            boolean isAdded = repositoryEmploy.insertEmploy(employ);

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
        try {
            System.out.println("!!!!!!! Редактиране на работник !!!!!!!");
            this.showAllEmploy();
            System.out.print("Въведете ИД на работник: ");
            int employ_id = Integer.parseInt(this.scanner.nextLine());

            companyCRUD.showAllCompanies();
            System.out.print("Въведете НОВО ИД на компанията: ");
            int company_id = Integer.parseInt(this.scanner.nextLine());

            System.out.print("Въведете НОВО ИМЕ на работник: ");
            String name = this.scanner.nextLine();

            System.out.print("Въведете НОВА КЛАЛИФИКАЦИЯ на работник: ");
            String qualification = this.scanner.nextLine();

            System.out.print("Превоз над 12 пътника [yes/ne]: ");
            String more_people = this.scanner.nextLine();

            System.out.print("НОВА Заплата: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Employ employ = new Employ(employ_id,name,company_id,qualification,more_people,salary);

            boolean isUpdate = this.repositoryEmploy.updateEmploy(employ);

            if (isUpdate) {
                System.out.println("УСПЕШНО ОБНОВИХТЕ РАБОТНИК !");
            } else {
                System.out.println("НЯМА НАМЕРЕН РАБОТНИК С ТОВА ИД: " + employ_id);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
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
        System.out.println("!!!!!!! Преглед на всички рабтници !!!!!!!");
        ArrayList<Employ> employs = repositoryEmploy.getAllEmploys();
        for (int i = 0; i < employs.size(); i++) {
            System.out.println(employs.get(i));
        }
    }
}
