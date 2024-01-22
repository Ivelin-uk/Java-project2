import CRUD.ClientCRUD;
import CRUD.CompanyCRUD;
import CRUD.EmployCRUD;
import CRUD.TransportCRUD;
import DB.RepositoryCompany;
import DB.RepositoryEmploy;
import MODELS.Company;
import MODELS.Employ;
import STATISTIC.Statistic;

import java.util.ArrayList;
import java.util.Scanner;
public class ControllerStatistic {
    Scanner scanner = new Scanner(System.in);

    CompanyCRUD companyCRUD;
    RepositoryCompany repositoryCompany;

    RepositoryEmploy repositoryEmploy;

    public ControllerStatistic() throws Exception{
        this.repositoryCompany = new RepositoryCompany();

        this.companyCRUD = new CompanyCRUD();

        this.repositoryEmploy = new RepositoryEmploy();
    }
    public void menu(){
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("------------------------- КОМПАНИЯ МЕНЮ (ститистика) ---------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("1. Извади подробна информация за компания!");
        System.out.println("2. Сортиране");
        System.out.println("3. Изход");
        System.out.print("Въведете команда от 1 до 3: ");
    }
    public void ControllerMenu() throws Exception{

        while (true){
            this.menu();
            int command = Integer.parseInt(scanner.nextLine());
            if(command == 1 ){
                companyCRUD.showAllCompanies();
                System.out.print("Въведете ИД на компания: ");
                String id = scanner.nextLine();
                String content = companyCRUD.strCurrentCompany(id);;
                System.out.println(content);

                System.out.print("Запиши в файл: [yes/no]: ");
                String write = scanner.nextLine();
                if(write.equals("yes")){
                    Statistic statistic = new Statistic();
                    statistic.createFileCompanyFillInfo(id);
                }
            }

            if(command == 2){
                System.out.println("-------Сортиране---------");
                System.out.println("1. Компаниите по име");
                System.out.println("2. Компаниите по приходи");
                System.out.println("3. Служителите по квалификация");
                System.out.println("4. Служителите по заплата");

                System.out.print("Избери: ");
                int com = Integer.parseInt(scanner.nextLine());
                if(com == 1){
                    System.out.println("-------- Компаниите подредени по имена ---------");
                    ArrayList<Company> companies =  repositoryCompany.getAllCompaniesOrderByName();
                    String printResult = "";
                    for (int i = 0; i < companies.size() ; i++) {
                        System.out.println(companies.get(i));
                        printResult += companies.get(i);
                        printResult += "\n";
                    }

                    System.out.print("Запиши в файл: [yes/no]: ");
                    String write = scanner.nextLine();
                    if(write.equals("yes")){
                        Statistic statistic = new Statistic();
                        statistic.createFileSort(printResult);
                    }
                }

                if(com == 2){
                    System.out.println("-------- Компаниите по приходи ---------");
                    ArrayList<Company> companies =  repositoryCompany.getAllCompaniesOrderMoney();
                    String printResult = "";
                    for (int i = 0; i < companies.size() ; i++) {
                        String row = companies.get(i) + " ПРИХОДИ: " + companies.get(i).getMoney();
                        System.out.println(row);
                        printResult += "\n";
                    }

                    System.out.print("Запиши в файл: [yes/no]: ");
                    String write = scanner.nextLine();
                    if(write.equals("yes")) {
                        Statistic statistic = new Statistic();
                        statistic.createFileSort(printResult);
                    }
                }

                if(com == 3){
                    System.out.println("-------- Служителите по квалификация ---------");
                    ArrayList<Employ> employs =  repositoryEmploy.orderByEmployeesByQA();
                    String printResult = "";
                    for (int i = 0; i < employs.size() ; i++) {
                        System.out.println(employs.get(i));
                        printResult += "\n";
                    }

                    System.out.print("Запиши в файл: [yes/no]: ");
                    String write = scanner.nextLine();
                    if(write.equals("yes")) {
                        Statistic statistic = new Statistic();
                        statistic.createFileSort(printResult);
                    }

                }

                if(com == 4){
                    System.out.println("-------- Служителите по заплата ---------");
                    ArrayList<Employ> employs =  repositoryEmploy.orderByEmployeesBySalary();
                    String printResult = "";
                    for (int i = 0; i < employs.size() ; i++) {
                        System.out.println(employs.get(i));
                        printResult += "\n";
                    }

                    System.out.print("Запиши в файл: [yes/no]: ");
                    String write = scanner.nextLine();
                    if(write.equals("yes")) {
                        Statistic statistic = new Statistic();
                        statistic.createFileSort(printResult);
                    }
                }
            }

            if(command == 3){
                break;
            }
        }
    }
}
