import CRUD.ClientCRUD;
import CRUD.CompanyCRUD;
import CRUD.EmployCRUD;
import CRUD.TransportCRUD;
import STATISTIC.Statistic;

import java.util.Scanner;
public class ControllerStatistic {
    Scanner scanner = new Scanner(System.in);

    public void menu(){
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("------------------------- КОМПАНИЯ МЕНЮ(ститистика) ---------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("1. Извади подробна информация за компания!");

        System.out.println("2. Изход");
        System.out.print("Въведете команда от 1 до 2: ");
    }
    public void ControllerMenu() throws Exception{

        while (true){
            this.menu();
            int command = Integer.parseInt(scanner.nextLine());

            if(command == 1 ){
                Statistic statistic = new Statistic();
                statistic.companyFillInfo();
            }

            if(command == 2){
                break;
            }
        }
    }
}
