import CRUD.ClientCRUD;
import CRUD.CompanyCRUD;
import CRUD.EmployCRUD;
import CRUD.TransportCRUD;
import DB.RepositoryCompany;
import MODELS.Company;
import STATISTIC.Statistic;

import java.util.ArrayList;
import java.util.Scanner;
public class ControllerStatistic {
    Scanner scanner = new Scanner(System.in);

    CompanyCRUD companyCRUD;
    RepositoryCompany repositoryCompany;
    public ControllerStatistic() throws Exception{
        this.repositoryCompany = new RepositoryCompany();
        this.companyCRUD = new CompanyCRUD();
    }
    public void menu(){
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("------------------------- КОМПАНИЯ МЕНЮ (ститистика) ---------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("1. Извади подробна информация за компания!");
        System.out.println("2. Сортиране");
        System.out.println("3. Изход");
        System.out.print("Въведете команда от 1 до 2: ");
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
                this.sort();
            }

            if(command == 3){
                break;
            }
        }
    }

    public void sort() throws Exception{
        System.out.println("-------Сортиране---------");
        System.out.println("1. Компаниите по име");
        System.out.println("2. Компаниите по приходи");
        System.out.println("3. Служителите по квалификация");
        System.out.println("4. Служителите по заплата");
        System.out.println("5. За превозите по дестинация");
        System.out.print("Избери: ");
        int com = scanner.nextInt();

        if(com == 1){
            System.out.println("Test");
            ArrayList<Company> companies =  repositoryCompany.getAllCompaniesOrderByName();
            System.out.println(companies);
        }
        if(com == 2){

        }
    }
}
